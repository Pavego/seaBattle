package com.seabattleremake;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class Render extends View {
    Paint paint = new Paint();

    int height = getHeight();
    int width = getWidth();

    int widthOffset = (int) (width * 0.10);
    int heightOffset = (int) (height * 0.10);

    public Render(Context context,  @Nullable AttributeSet attrs) {
        super(context, attrs);

        paint.setTextSize(96);
        paint.setStrokeWidth(4);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        drawHorizontalLines(canvas);
        drawVerticalLines(canvas);

        drawLetters(canvas);
        drawNumbers(canvas);
    }

    protected void drawHorizontalLines(Canvas canvas) {
        for (int h = heightOffset; h <= height; h += (height - heightOffset) / 10){
            canvas.drawLine(widthOffset, h, width, h, paint);
        }
    }

    protected void drawVerticalLines(Canvas canvas) {
        for (int w = widthOffset; w <= width; w += (width - widthOffset) / 10){
            canvas.drawLine(w, heightOffset, w, height, paint);
        }
    }

    protected void drawLetters(Canvas canvas) {
        int letter = 1040;
        for (int w = 0; w <= width; w += (width - widthOffset) / 10){
            if (letter == 1049) {
                letter += 1;
            }
            canvas.drawText(String.valueOf((char) letter), w, heightOffset, paint);
            letter += 1;
        }
    }

    protected void drawNumbers(Canvas canvas) {
        int num = 1;
        for (int h = 0; h <= height; h += (height - heightOffset) / 10) {
            canvas.drawText(String.valueOf(num), 0, h, paint);
            num += 1;
        }
    }

    @Override
    public boolean performClick() {
        super.performClick();
        return true;
    }

    protected void performClick(float x, float y) {

    }
}
