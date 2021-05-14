package com.seabattleremake;

import android.graphics.Point;

public class MineShip extends Ship {
    final String type = "MINE";

    public MineShip(Point startCoordinate) {
        super(startCoordinate, 0);
    }
}
