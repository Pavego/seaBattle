package com.seabattleremake;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {
    Storage storage = new Storage();
    Setting settings =  new Setting(storage);
    Render render;

    TextView rotateText;

    int rotate = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        rotateText = findViewById(R.id.rotateText);

        render = findViewById(R.id.Render);
        render.setStorage(storage);

        render.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (render.isGameStarted) {
                    if (event.getX() > (int) (9 * (render.width / 16)) + render.widthOffset) {
                        render.performClick(event.getX(), event.getY());
                    }
                } else {
                    if (event.getX() > (int) (9 * (render.width / 16))) {
                        settings.setCurrentShip(render.getCurrentShip(event.getY()));
                    } else if (event.getX() < (int) (7 * (render.width / 16))) {
                        if (settings.setPlayerShip(render.getPlayerCellCoordinate(event.getX(), event.getY()), rotate)) {
//                            Setting finished
                            if (storage.isPlayerReady()) {
                                hideRotateMenu();
                                render.isGameStarted = true;
                            }
                        }
                    }
                }
                render.invalidate();
                return false;
            }
        });
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        render.setSize();
        render.invalidate();
    }

    public void changeRotateRight(View v) {
        rotate = (rotate + 1) % 4;
        updateRotateText();
    }

    public void changeRotateLeft(View v) {
        rotate = rotate - 1;
        if (rotate < 0) {
            rotate = 3;
        }
        updateRotateText();
    }

    public void restart(View v) {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

    private void updateRotateText() {
        switch (rotate) {
            case 0:
                rotateText.setText("↑");
                break;
            case 1:
                rotateText.setText("→");
                break;
            case 2:
                rotateText.setText("↓");
                break;
            case 3:
                rotateText.setText("←");
                break;
        }
    }

    private void hideRotateMenu(){
        Button rotateLeft = findViewById(R.id.rotateButtonLeft);
        Button rotateRight = findViewById(R.id.rotateButtonRight);

        rotateText.setVisibility(View.GONE);
        rotateLeft.setVisibility(View.GONE);
        rotateRight.setVisibility(View.GONE);
    }
}
