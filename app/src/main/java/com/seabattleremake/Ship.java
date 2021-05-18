package com.seabattleremake;

import android.graphics.Point;

import java.util.ArrayList;

public class Ship {
    ArrayList<Point> coordinates = new ArrayList<>();

    public Ship(Point startCoordinate, int rotate) {
        getCoordinates(startCoordinate, rotate);
    }

    protected void getCoordinates(Point startCoordinate, int rotate) {
        coordinates.add(startCoordinate);
    }
}
