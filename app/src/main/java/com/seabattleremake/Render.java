package com.seabattleremake;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class Render extends View {
    Field field = null;
    Paint paint = new Paint();

    int height;
    int width ;

    int widthOffset;
    int heightOffset;

    public Render(Context context,  AttributeSet attrs) {
        super(context, attrs);
    }

    public Render(Context context) {
        this(context, null);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setTextSize(72);
        paint.setStrokeWidth(10);
        if (field != null) {
            drawHorizontalLines(canvas);
            drawVerticalLines(canvas);

            drawLetters(canvas);
            drawNumbers(canvas);
        }
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
        for (int w = (int) (widthOffset * 1.15); w <= width; w += (width - widthOffset) / 10){
            if (letter == 1049) {
                letter += 1;
            }
            canvas.drawText(String.valueOf((char) letter), w, (float) (heightOffset * 0.7), paint);
            letter += 1;
        }
    }

    protected void drawNumbers(Canvas canvas) {
        int num = 1;
        for (int h = (int) (heightOffset * 1.7); h <= height; h += (height - heightOffset) / 10) {
            canvas.drawText(String.valueOf(num), 0, h, paint);
            num += 1;
        }
    }

    protected void setField(Player player) {
        field = player.getField();

        this.height = getHeight();
        this.width = getWidth();

        heightOffset = height / 10;
        widthOffset = width / 10;
        Log.i("MY_TAG", "Height: " + String.valueOf(height));
        Log.i("MY_TAG", "Height offset: " + String.valueOf(heightOffset));
        Log.i("MY_TAG", "Width: " + String.valueOf(width));
        Log.i("MY_TAG", "Width offset: " + String.valueOf(widthOffset));
    }

    @Override
    public boolean performClick() {
        super.performClick();
        return true;
    }

    protected void performClick(float x, float y) {

    }
}
