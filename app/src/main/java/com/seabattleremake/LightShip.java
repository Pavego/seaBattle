package com.seabattleremake;

import android.graphics.Point;

public class LightShip extends Ship {
    final String type = "LIGHT";

    public LightShip(Point startCoordinate) {
        super(startCoordinate, 0);
    }
}
