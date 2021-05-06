package com.seabattleremake;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import static com.seabattleremake.Ship.tCarrier;
import static com.seabattleremake.Ship.tHeavy;
import static com.seabattleremake.Ship.tMed;
import static com.seabattleremake.Ship.tLight;
import static com.seabattleremake.Ship.tMine;

public class shipSettingRender extends View {
    Paint paint = new Paint();

    int width;
    int height;


    int widthOffset;
    int heightOffset;

    int carriagesRemaining = 1;
    int heaviesRemaining = 2;
    int mediumsRemaining = 3;
    int lightsRemaining = 2;
    int minesRemaining = 2;

    String currentShip = "NONE";

    public shipSettingRender(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public shipSettingRender(Context context) {
        this(context, null);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setTextSize(96);

        drawShipCounts(canvas);
    }

    protected void drawShipCounts(Canvas canvas) {
        canvas.drawLine(0, (int) (heightOffset / 4), width, (int) (heightOffset / 4), paint);
        canvas.drawLine(0, (int) (heightOffset / 4) * 6, width, (int) (heightOffset / 4) * 6, paint);
        canvas.drawLine(0, (int) (heightOffset / 4) * 12, width, (int) (heightOffset / 4) * 12, paint);
        canvas.drawLine(0, (int) (heightOffset / 4) * 18, width, (int) (heightOffset / 4) * 18, paint);
        canvas.drawLine(0, (int) (heightOffset / 4) * 23, width, (int) (heightOffset / 4) * 23, paint);
        canvas.drawLine(0, height - (int) (heightOffset / 4), width, height - (int) (heightOffset / 4), paint);

        switch (getCurrentShip()) {
            case tCarrier:
                paint.setColor(Color.BLUE);
                canvas.drawText("Авианосцы: " + carriagesRemaining, widthOffset, heightOffset, paint);
                paint.setColor(Color.BLACK);
                canvas.drawText("Тяжёлые: " + heaviesRemaining, widthOffset, heightOffset + (int) (height / 5), paint);
                canvas.drawText("Средние: " + mediumsRemaining, widthOffset, heightOffset + (int) (2 * height / 5), paint);
                canvas.drawText("Лёгкие: " + lightsRemaining, widthOffset, heightOffset + (int) (3 * height / 5), paint);
                canvas.drawText("Мины: " + minesRemaining, widthOffset, heightOffset + (int) (4 * height / 5), paint);
                break;
            case tHeavy:
                canvas.drawText("Авианосцы: " + carriagesRemaining, widthOffset, heightOffset, paint);
                paint.setColor(Color.BLUE);
                canvas.drawText("Тяжёлые: " + heaviesRemaining, widthOffset, heightOffset + (int) (height / 5), paint);
                paint.setColor(Color.BLACK);
                canvas.drawText("Средние: " + mediumsRemaining, widthOffset, heightOffset + (int) (2 * height / 5), paint);
                canvas.drawText("Лёгкие: " + lightsRemaining, widthOffset, heightOffset + (int) (3 * height / 5), paint);
                canvas.drawText("Мины: " + minesRemaining, widthOffset, heightOffset + (int) (4 * height / 5), paint);
                break;
            case tMed:
                canvas.drawText("Авианосцы: " + carriagesRemaining, widthOffset, heightOffset, paint);
                canvas.drawText("Тяжёлые: " + heaviesRemaining, widthOffset, heightOffset + (int) (height / 5), paint);
                paint.setColor(Color.BLUE);
                canvas.drawText("Средние: " + mediumsRemaining, widthOffset, heightOffset + (int) (2 * height / 5), paint);
                paint.setColor(Color.BLACK);
                canvas.drawText("Лёгкие: " + lightsRemaining, widthOffset, heightOffset + (int) (3 * height / 5), paint);
                canvas.drawText("Мины: " + minesRemaining, widthOffset, heightOffset + (int) (4 * height / 5), paint);
                break;
            case tLight:
                canvas.drawText("Авианосцы: " + carriagesRemaining, widthOffset, heightOffset, paint);
                canvas.drawText("Тяжёлые: " + heaviesRemaining, widthOffset, heightOffset + (int) (height / 5), paint);
                canvas.drawText("Средние: " + mediumsRemaining, widthOffset, heightOffset + (int) (2 * height / 5), paint);
                paint.setColor(Color.BLUE);
                canvas.drawText("Лёгкие: " + lightsRemaining, widthOffset, heightOffset + (int) (3 * height / 5), paint);
                paint.setColor(Color.BLACK);
                canvas.drawText("Мины: " + minesRemaining, widthOffset, heightOffset + (int) (4 * height / 5), paint);
                break;
            case tMine:
                canvas.drawText("Авианосцы: " + carriagesRemaining, widthOffset, heightOffset, paint);
                canvas.drawText("Тяжёлые: " + heaviesRemaining, widthOffset, heightOffset + (int) (height / 5), paint);
                canvas.drawText("Средние: " + mediumsRemaining, widthOffset, heightOffset + (int) (2 * height / 5), paint);
                canvas.drawText("Лёгкие: " + lightsRemaining, widthOffset, heightOffset + (int) (3 * height / 5), paint);
                paint.setColor(Color.BLUE);
                canvas.drawText("Мины: " + minesRemaining, widthOffset, heightOffset + (int) (4 * height / 5), paint);
                paint.setColor(Color.BLACK);
                break;
            default:
                canvas.drawText("Авианосцы: " + carriagesRemaining, widthOffset, heightOffset, paint);
                canvas.drawText("Тяжёлые: " + heaviesRemaining, widthOffset, heightOffset + (int) (height / 5), paint);
                canvas.drawText("Средние: " + mediumsRemaining, widthOffset, heightOffset + (int) (2 * height / 5), paint);
                canvas.drawText("Лёгкие: " + lightsRemaining, widthOffset, heightOffset + (int) (3 * height / 5), paint);
                canvas.drawText("Мины: " + minesRemaining, widthOffset, heightOffset + (int) (4 * height / 5), paint);
                break;
        }
    }

    @Override
    public boolean performClick() {
        super.performClick();
        return true;
    }

    protected void performClick(float x, float y) {
        if (y >= (int) (heightOffset / 4)  && y < (int) (heightOffset / 4) * 6) {
            setCurrentShip(tCarrier);
            shipCount(tCarrier);
        } else if (y >= (int) (heightOffset / 6) * 2 && y < (int) (heightOffset / 4) * 12) {
            setCurrentShip(tHeavy);
            shipCount(tHeavy);
        } else if (y >= (int) (heightOffset / 12) * 3 && y < (int) (heightOffset / 4) * 18){
            setCurrentShip(tMed);
            shipCount(tMed);
        } else if (y >= (int) (heightOffset / 18) * 4 && y < (int) (heightOffset / 4) * 23) {
            setCurrentShip(tLight);
            shipCount(tLight);
        } else if (y >= (int) (heightOffset / 23) * 5 && y < height - (int) (heightOffset / 4)) {
            setCurrentShip(tMine);
            shipCount(tMine);
        } else {
            setCurrentShip("NONE");
        }
    }

    protected void setCurrentShip(String shipType) {
        currentShip = shipType;
    }

    protected String getCurrentShip() {
        return currentShip;
    }

    protected void updateDimensions() {
        width = getWidth();
        height = getHeight();

        widthOffset = width / 10;
        heightOffset = height / 7;
    }

    protected void shipCount(String shipType) {
        switch (shipType){
            case tCarrier:
                carriagesRemaining -= 1;
                break;

            case tHeavy:
                heaviesRemaining -= 1;
                break;

            case tMed:
                mediumsRemaining -= 1;
                break;

            case tLight:
                lightsRemaining -= 1;
                break;

            case tMine:
                minesRemaining -= 1;
                break;

            default:
                break;
        }
    }

    protected boolean isShipsReady() {
        return carriagesRemaining < 1 && minesRemaining < 1 && lightsRemaining < 1 && mediumsRemaining < 1 && heaviesRemaining < 1;
    }
}
