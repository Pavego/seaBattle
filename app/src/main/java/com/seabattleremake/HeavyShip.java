package com.seabattleremake;

import android.graphics.Point;

public class HeavyShip extends Ship {
    public HeavyShip(Point startCoordinate, int rotate) {
        super(startCoordinate, rotate);
    }

    protected void getCoordinates(Point startCoordinate, int rotate) {
        switch (rotate) {
            case 0:
                for (int i = 0; i < 3; i++) {
                    coordinates.add(new Point(startCoordinate.x, startCoordinate.y - i));
                }
                break;
            case 1:
                for (int i = 0; i < 3; i++) {
                    coordinates.add(new Point(startCoordinate.x + i, startCoordinate.y));
                }
                break;
            case 2:
                for (int i = 0; i < 3; i++) {
                    coordinates.add(new Point(startCoordinate.x, startCoordinate.y + i));
                }
                break;
            case 3:
                for (int i = 0; i < 3; i++) {
                    coordinates.add(new Point(startCoordinate.x - i, startCoordinate.y));
                }
                break;
            default:
                break;
        }
    }
}
