package com.seabattleremake;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.lang.invoke.ConstantCallSite;

public class GameActivity extends AppCompatActivity {
    boolean isGameStarted = false;

    int currentRotate = 0;

    ConstraintLayout botFieldLayout;
    ConstraintLayout shipSettingLayout;

    shipSettingRender shipSettingRender;

    fieldRender playerField;
    fieldRender botField;

    Player player;
    Player bot;

    TextView rotateText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Game game = new Game(player, bot);
        
        player = new Player(new Field());
        bot = new Player(new Field());
        
        botField = findViewById(R.id.bot_field);
        playerField = findViewById(R.id.player_field);

        shipSettingRender = findViewById(R.id.ship_setting);

        botFieldLayout = findViewById(R.id.bot_field_layout);
        shipSettingLayout = findViewById(R.id.ship_setting_layout);

        rotateText = findViewById(R.id.rotate_text);
        
        playerField.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                playerField.performClick(event.getX(), event.getY());
                playerField.invalidate();
                return false;
            }
        });
        
        botField.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                botField.performClick(event.getX(), event.getY());
                botField.invalidate();
                return false;
            }
        });

        shipSettingRender.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                shipSettingRender.performClick(event.getX(), event.getY());
                isGameStarted = shipSettingRender.isShipsReady();
                shipSettingRender.invalidate();
                if (isGameStarted) {
                    hideFieldSetting(shipSettingLayout);
                    showBotField(botFieldLayout);
                }
                return false;
            }
        });
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        playerField.setField(player);
        playerField.invalidate();

        shipSettingRender.updateDimensions();
        shipSettingRender.invalidate();
    }
    
    protected void hideFieldSetting(ConstraintLayout v) {
        v.setVisibility(View.GONE);
    }

    protected void showBotField(ConstraintLayout v) {
        botField.setField(bot, playerField.width, playerField.height);
        botField.invalidate();
        v.setVisibility(View.VISIBLE);
    }

    public void changeRotateRight(View v) {
        currentRotate = (currentRotate + 1) % 4;
        setRotateText();

    }

    public void changeRotateLeft(View view) {
        currentRotate = (currentRotate - 1) % 4;
        setRotateText();
    }

    protected void setRotateText() {
        switch (currentRotate) {
            case 0:
                rotateText.setText("↑");
                break;
            case 1:
            case -3:
                rotateText.setText("→");
                break;
            case 2:
            case -2:
                rotateText.setText("↓");
                break;
            case 3:
            case -1:
                rotateText.setText("←");
                break;
            default:
                break;
        }
    }
}
