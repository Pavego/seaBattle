package com.seabattleremake;

import android.graphics.Point;

public class MediumShip extends Ship {
    public MediumShip(Point startCoordinate, int rotate) {
        super(startCoordinate, rotate);
    }

    protected void getCoordinates(Point startCoordinate, int rotate) {
        switch (rotate) {
            case 0:
                for (int i = 0; i < 2; i++) {
                    coordinates.add(new Point(startCoordinate.x, startCoordinate.y - i));
                }
                break;
            case 1:
                for (int i = 0; i < 2; i++) {
                    coordinates.add(new Point(startCoordinate.x + i, startCoordinate.y));
                }
                break;
            case 2:
                for (int i = 0; i < 2; i++) {
                    coordinates.add(new Point(startCoordinate.x, startCoordinate.y + i));
                }
                break;
            case 3:
                for (int i = 0; i < 2; i++) {
                    coordinates.add(new Point(startCoordinate.x - i, startCoordinate.y));
                }
                break;
            default:
                break;
        }
    }
}
