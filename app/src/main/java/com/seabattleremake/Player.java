package com.seabattleremake;

import android.graphics.Point;

public class Player {
    Field field;
    boolean turnSkip = false;
    
    public Player(Field field) {
        this.field = field;
    }

    protected int shoot(Player player, Point coordinate) {
        return player.field.shot(coordinate);
    }

    protected void setShip(String type, Point coordinate, int rotate) {
        if (this.field.isAvailable(type, coordinate, rotate)){
            this.field.setShip(type, coordinate, rotate);
        }
    }

    protected Field getField() {
        return this.field;
    }
}
