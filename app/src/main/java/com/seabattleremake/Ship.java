package com.seabattleremake;

import android.graphics.Point;

import java.util.ArrayList;

public class Ship {
    protected static final String tLight = "LIGHT";
    protected static final String tMed = "MEDIUM";
    protected static final String tHeavy = "HEAVY";
    protected static final String tCarrier = "CARRIER";
    protected static final String tMine = "MINE";

    boolean isLife = true;
    String type;
    ArrayList<Point> coords = new ArrayList<>();

    public Ship(String type, Point startCoordinate, int rotate) {
        this.type = type;
        getCoords(startCoordinate, rotate);
    }

    protected void getCoords(Point startCoordinate, int rotate) {
        switch (type) {
            case tLight:
            case tMine:
                coords.add(startCoordinate);
                break;

            case tMed:
                if (rotate == 0) {
                    for (int i = 0; i < 2; i++) {
                        coords.add(new Point(startCoordinate.x + i, startCoordinate.y));
                    }
                } else if (rotate == 1) {
                    for (int i = 0; i < 2; i++) {
                        coords.add(new Point(startCoordinate.x, startCoordinate.y + i));
                    }
                } else if (rotate == 2) {
                    for (int i = 0; i < 2; i++) {
                        coords.add(new Point(startCoordinate.x - i, startCoordinate.y));
                    }
                } else if (rotate == 3) {
                    for (int i = 0; i < 2; i++) {
                        coords.add(new Point(startCoordinate.x, startCoordinate.y - i));
                    }
                }
                break;
                
            case tHeavy:
                if (rotate == 0) {
                    for (int i = 0; i < 3; i++) {
                        coords.add(new Point(startCoordinate.x + i, startCoordinate.y));
                    }
                } else if (rotate == 1) {
                    for (int i = 0; i < 3; i++) {
                        coords.add(new Point(startCoordinate.x, startCoordinate.y + i));
                    }
                } else if (rotate == 2) {
                    for (int i = 0; i < 3; i++) {
                        coords.add(new Point(startCoordinate.x - i, startCoordinate.y));
                    }
                } else if (rotate == 3) {
                    for (int i = 0; i < 3; i++) {
                        coords.add(new Point(startCoordinate.x, startCoordinate.y - i));
                    }
                }
                break;

            case tCarrier:
                if (rotate == 0) {
                    for (int i = 0; i < 4; i++) {
                        coords.add(new Point(startCoordinate.x + i, startCoordinate.y));
                    }
                } else if (rotate == 1) {
                    for (int i = 0; i < 4; i++) {
                        coords.add(new Point(startCoordinate.x, startCoordinate.y + i));
                    }
                } else if (rotate == 2) {
                    for (int i = 0; i < 4; i++) {
                        coords.add(new Point(startCoordinate.x - i, startCoordinate.y));
                    }
                } else if (rotate == 3) {
                    for (int i = 0; i < 4; i++) {
                        coords.add(new Point(startCoordinate.x, startCoordinate.y - i));
                    }
                }
                break;
        } 
    }
}
