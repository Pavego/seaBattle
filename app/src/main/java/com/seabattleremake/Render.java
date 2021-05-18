package com.seabattleremake;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class Render extends View {
    Paint paint = new Paint();

    int width;
    int height;

    int widthOffset;
    int heightOffset;

    int fieldWidth;
    int fieldHeight;


    Storage storage;

    boolean isGameStarted = false;

    int shipToHighlight = 5;

    public Render(Context context, AttributeSet attrs) {
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
        paint.setColor(Color.BLACK);

        drawPlayerField(canvas);
        if (!isGameStarted) {
            drawSettingField(canvas);
        } else {
            drawEnemyField(canvas);
        }
//        test
//        drawEnemyField(canvas);
    }

    @Override
    public boolean performClick() {
        return super.performClick();
    }

    protected void drawPlayerField(Canvas canvas) {
        drawPlayerLines(canvas);
        drawPlayerNums(canvas);
        drawPlayerLetters(canvas);

        drawPlayerShips(canvas);

        drawPlayerShots(canvas);
    }

    protected void drawEnemyField(Canvas canvas) {
        drawEnemyLines(canvas);
        drawEnemyNums(canvas);
        drawEnemyLetters(canvas);

        drawEnemyShips(canvas);

        drawEnemyShots(canvas);
    }

    protected void drawSettingField(Canvas canvas) {
        paint.setColor(Color.BLACK);
        canvas.drawText("Доступно для установки", 9 * (int) (width / 16), heightOffset, paint);
        paint.setTextSize(96);
        switch (shipToHighlight){
            case 5:
                canvas.drawText("Авианосцев: " + storage.shipsToSet[4], 9 * (int) (width / 16), (int) (heightOffset * 3), paint);
                canvas.drawText("Тяжёлых: " + storage.shipsToSet[3], 9 * (int) (width / 16), (int) (heightOffset * 4.75), paint);
                canvas.drawText("Средних: " + storage.shipsToSet[2], 9 * (int) (width / 16), (int) (heightOffset * 6.5), paint);
                canvas.drawText("Лёгких: " + storage.shipsToSet[1], 9 * (int) (width / 16), (int) (heightOffset * 8.25), paint);
                canvas.drawText("Мин: " + storage.shipsToSet[0], 9 * (int) (width / 16), (int) (heightOffset * 10), paint);
                break;
            case 4:
                paint.setColor(Color.BLUE);
                canvas.drawText("Авианосцев: " + storage.shipsToSet[4], 9 * (int) (width / 16), (int) (heightOffset * 3), paint);
                paint.setColor(Color.BLACK);
                canvas.drawText("Тяжёлых: " + storage.shipsToSet[3], 9 * (int) (width / 16), (int) (heightOffset * 4.75), paint);
                canvas.drawText("Средних: " + storage.shipsToSet[2], 9 * (int) (width / 16), (int) (heightOffset * 6.5), paint);
                canvas.drawText("Лёгких: " + storage.shipsToSet[1], 9 * (int) (width / 16), (int) (heightOffset * 8.25), paint);
                canvas.drawText("Мин: " + storage.shipsToSet[0], 9 * (int) (width / 16), (int) (heightOffset * 10), paint);
                break;
            case 3:
                canvas.drawText("Авианосцев: " + storage.shipsToSet[4], 9 * (int) (width / 16), (int) (heightOffset * 3), paint);
                paint.setColor(Color.BLUE);
                canvas.drawText("Тяжёлых: " + storage.shipsToSet[3], 9 * (int) (width / 16), (int) (heightOffset * 4.75), paint);
                paint.setColor(Color.BLACK);
                canvas.drawText("Средних: " + storage.shipsToSet[2], 9 * (int) (width / 16), (int) (heightOffset * 6.5), paint);
                canvas.drawText("Лёгких: " + storage.shipsToSet[1], 9 * (int) (width / 16), (int) (heightOffset * 8.25), paint);
                canvas.drawText("Мин: " + storage.shipsToSet[0], 9 * (int) (width / 16), (int) (heightOffset * 10), paint);
                break;
            case 2:
                canvas.drawText("Авианосцев: " + storage.shipsToSet[4], 9 * (int) (width / 16), (int) (heightOffset * 3), paint);
                canvas.drawText("Тяжёлых: " + storage.shipsToSet[3], 9 * (int) (width / 16), (int) (heightOffset * 4.75), paint);
                paint.setColor(Color.BLUE);
                canvas.drawText("Средних: " + storage.shipsToSet[2], 9 * (int) (width / 16), (int) (heightOffset * 6.5), paint);
                paint.setColor(Color.BLACK);
                canvas.drawText("Лёгких: " + storage.shipsToSet[1], 9 * (int) (width / 16), (int) (heightOffset * 8.25), paint);
                canvas.drawText("Мин: " + storage.shipsToSet[0], 9 * (int) (width / 16), (int) (heightOffset * 10), paint);
                break;
            case 1:
                canvas.drawText("Авианосцев: " + storage.shipsToSet[4], 9 * (int) (width / 16), (int) (heightOffset * 3), paint);
                canvas.drawText("Тяжёлых: " + storage.shipsToSet[3], 9 * (int) (width / 16), (int) (heightOffset * 4.75), paint);
                canvas.drawText("Средних: " + storage.shipsToSet[2], 9 * (int) (width / 16), (int) (heightOffset * 6.5), paint);
                paint.setColor(Color.BLUE);
                canvas.drawText("Лёгких: " + storage.shipsToSet[1], 9 * (int) (width / 16), (int) (heightOffset * 8.25), paint);
                paint.setColor(Color.BLACK);
                canvas.drawText("Мин: " + storage.shipsToSet[0], 9 * (int) (width / 16), (int) (heightOffset * 10), paint);
                break;
            case 0:
                canvas.drawText("Авианосцев: " + storage.shipsToSet[4], 9 * (int) (width / 16), (int) (heightOffset * 3), paint);
                canvas.drawText("Тяжёлых: " + storage.shipsToSet[3], 9 * (int) (width / 16), (int) (heightOffset * 4.75), paint);
                canvas.drawText("Средних: " + storage.shipsToSet[2], 9 * (int) (width / 16), (int) (heightOffset * 6.5), paint);
                canvas.drawText("Лёгких: " + storage.shipsToSet[1], 9 * (int) (width / 16), (int) (heightOffset * 8.25), paint);
                paint.setColor(Color.BLUE);
                canvas.drawText("Мин: " + storage.shipsToSet[0], 9 * (int) (width / 16), (int) (heightOffset * 10), paint);
                paint.setColor(Color.BLACK);
                break;
            default:
                break;
        }

        canvas.drawLine(9 * (int) (width / 16), (int) (heightOffset * 1.6), width, (int) (heightOffset * 1.6), paint);
        canvas.drawLine(9 * (int) (width / 16), (int) (heightOffset * 3.3), width, (int) (heightOffset * 3.3), paint);
        canvas.drawLine(9 * (int) (width / 16), (int) (heightOffset * 5), width, (int) (heightOffset * 5), paint);
        canvas.drawLine(9 * (int) (width / 16), (int) (heightOffset * 6.75), width, (int) (heightOffset * 6.75), paint);
        canvas.drawLine(9 * (int) (width / 16), (int) (heightOffset * 8.5), width, (int) (heightOffset * 8.5), paint);
        canvas.drawLine(9 * (int) (width / 16), (int) (heightOffset * 10.25), width, (int) (heightOffset * 10.25), paint);


    }

    protected void drawPlayerLines(Canvas canvas) {
//        horizontal
        paint.setColor(Color.BLACK);
        for (int h = heightOffset; h < fieldHeight; h += (fieldHeight - heightOffset) / 10) {
            canvas.drawLine(widthOffset, h, fieldWidth, h, paint);
        }
//        vertical
        for (int w = widthOffset; w < fieldWidth; w += (fieldWidth - widthOffset) / 10) {
            canvas.drawLine(w, heightOffset, w, fieldHeight - 3, paint);
        }
    }

    protected void drawEnemyLines(Canvas canvas) {
//        horizontal
        paint.setColor(Color.BLACK);
        for (int h = heightOffset; h < fieldHeight; h += (fieldHeight - heightOffset) / 10) {
            canvas.drawLine(9 * (int) (width / 16) + widthOffset, h, width - 3, h, paint);
        }
//        vertical
        for (int w = 9 * (int) (width / 16) + widthOffset; w < width; w += (fieldWidth - widthOffset) / 10) {
            canvas.drawLine(w, heightOffset, w, fieldHeight - 3, paint);
        }
    }

    protected void drawPlayerNums(Canvas canvas) {
        int num = 1;
        for (int h = (int) (heightOffset * 1.8); h < fieldHeight; h += (fieldHeight - heightOffset) / 10) {
            canvas.drawText(String.valueOf(num), 0, h, paint);
            num += 1;
        }
    }

    protected void drawEnemyNums(Canvas canvas) {
        int num = 1;
        for (int h = (int) (heightOffset * 1.8); h < fieldHeight; h += (fieldHeight - heightOffset) / 10) {
            canvas.drawText(String.valueOf(num), 9 * (int) (width / 16), h, paint);
            num += 1;
        }
    }

    protected void drawPlayerLetters(Canvas canvas) {
        int letter = 1040;
        for (int w = (int) (widthOffset * 1.15); w < fieldWidth; w += (fieldWidth - widthOffset) / 10) {
            if (letter == 1049) {
                letter += 1;
            }
            canvas.drawText(String.valueOf((char) letter), w, (float) (heightOffset * 0.7), paint);
            letter += 1;
        }
    }

    protected void drawEnemyLetters(Canvas canvas) {
        int letter = 1040;
        for (int w = (int) (9 * (width / 16)) + (int) (widthOffset * 1.15); w < width; w += (fieldWidth - widthOffset) / 10) {
            if (letter == 1049) {
                letter += 1;
            }
            canvas.drawText(String.valueOf((char) letter), w, (float) (heightOffset * 0.7), paint);
            letter += 1;
        }
    }

    protected void drawPlayerShips(Canvas canvas) {
        paint.setColor(Color.BLUE);
        for (Ship ship: storage.playerShips) {
            for (Point coordinate: ship.coordinates) {
                Point size = getPlayerPixelCoordinate(coordinate);

                if (ship instanceof MineShip) {
                    paint.setColor(0xfff8860b);
                } else if (ship instanceof LightShip) {
                    paint.setColor(0xff00db30);
                } else if (ship instanceof MediumShip) {
                    paint.setColor(0xff00d5ff);
                } else if (ship instanceof HeavyShip) {
                    paint.setColor(0xff476fff);
                } else if (ship instanceof CarriageShip) {
                    paint.setColor(0xff8400ff);
                }
                canvas.drawRect(size.x + 10, size.y + 10,
                        size.x + (int) ((fieldWidth - widthOffset) / 10) - 10,
                        size.y + (int) ((fieldHeight - heightOffset) / 10) - 10, paint);
            }
        }
    }

    protected void drawEnemyShips(Canvas canvas) {
        paint.setColor(Color.RED);
        for (Ship ship: storage.enemyShips) {
            for (Point coordinate: ship.coordinates) {
                Point size = getEnemyPixelCoordinate(coordinate);

                if (ship instanceof MineShip) {
                    paint.setColor(0xfff8860b);
                } else if (ship instanceof LightShip) {
                    paint.setColor(0xff00db30);
                } else if (ship instanceof MediumShip) {
                    paint.setColor(0xff00d5ff);
                } else if (ship instanceof HeavyShip) {
                    paint.setColor(0xff476fff);
                } else if (ship instanceof CarriageShip) {
                    paint.setColor(0xff8400ff);
                }
                canvas.drawRect(size.x + 10, size.y + 10,
                        size.x + (int) ((fieldWidth - widthOffset) / 10) - 10,
                        size.y + (int) ((fieldHeight - heightOffset) / 10) - 10, paint);

            }
        }
    }

    protected void drawPlayerShots(Canvas canvas) {
        drawPlayerHits(canvas);
        drawPlayerMisses(canvas);
        drawPlayerMines(canvas);
    }

    protected void drawEnemyShots(Canvas canvas) {
        drawEnemyHits(canvas);
        drawEnemyMisses(canvas);
        drawEnemyMines(canvas);
    }

    protected void drawPlayerHits(Canvas canvas) {

    }

    protected void drawEnemyHits(Canvas canvas) {

    }

    protected void drawPlayerMisses(Canvas canvas) {

    }

    protected void drawEnemyMisses(Canvas canvas) {

    }

    protected void drawPlayerMines(Canvas canvas) {

    }

    protected void drawEnemyMines(Canvas canvas) {

    }

    protected void setStorage(Storage storage) {
        this.storage = storage;
    }

    protected void setSize() {
        width = getWidth();
        height = getHeight();

        widthOffset = (int) (width / 20);
        heightOffset = (int) (height / 11);

        fieldWidth = (int) ((width / 16) * 7);
        fieldHeight = height;
    }

    protected Point getPlayerCellCoordinate(float x, float y) {
        return new Point((int) ((x - widthOffset) / ((fieldWidth - widthOffset) / 10)),
                (int) ((y - heightOffset) / ((fieldHeight - heightOffset) / 10)));
    }

    protected Point getEnemyCellCoordinate(float x, float y) {
        return new Point((int) ((x - 9 * (int) (width / 16)) / ((fieldWidth - widthOffset) / 10)),
                (int) ((y - heightOffset) / ((fieldHeight - heightOffset) / 10)));
    }

    private Point getPlayerPixelCoordinate(Point coordinate) {
        return new Point(coordinate.x * ((fieldWidth - widthOffset) / 10) + widthOffset,
                coordinate.y * ((fieldHeight - heightOffset) / 10) + heightOffset);
    }

    private Point getEnemyPixelCoordinate(Point coordinate) {
        return new Point(coordinate.x * ((fieldWidth - widthOffset) / 10) + (9 * (int) (width / 16) + widthOffset),
                coordinate.y * ((fieldHeight - heightOffset) / 10) + heightOffset);
    }

    private void setShipToHighlight(int num) {
        shipToHighlight = num;
    }

    protected String getCurrentShip(float y) {
        if (y > (heightOffset * 1.6) && y < (heightOffset * 3.3)) {
            setShipToHighlight(4);
            return "CARRIAGE";
        } else if (y > (heightOffset * 3.3) && y < (heightOffset * 5)) {
            setShipToHighlight(3);
            return "HEAVY";
        } else if (y > (heightOffset * 5) && y < (heightOffset * 6.75)) {
            setShipToHighlight(2);
            return "MEDIUM";
        } else if (y > (heightOffset * 6.75) && y < (heightOffset * 8.5)) {
            setShipToHighlight(1);
            return "LIGHT";
        } else if (y > (heightOffset * 8.5) && y < (heightOffset * 10.25)) {
            setShipToHighlight(0);
            return "MINE";
        } else {
            setShipToHighlight(5);
            return "NONE";
        }
    }

    public void performClick(float x, float y) {

    }
}
