package com.seabattleremake;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        Player player = new Player(new Field());
        Player bot = new Player(new Field());

        Game game = new Game(player, bot);

        Render playerField = findViewById(R.id.player_field);
        playerField.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                playerField.performClick(event.getX(), event.getY());
                playerField.invalidate();
                return false;
            }
        });
    }
}
