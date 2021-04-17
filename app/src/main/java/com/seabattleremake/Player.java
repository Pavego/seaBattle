package com.seabattleremake;

import android.graphics.Point;

public class Player {
    Field field;
    
    public Player(Field field) {
        this.field = field;
    }

    protected int shoot(Player player, Point coordinate) {
        return player.field.shot(coordinate);
    }

    protected void setShip(String type, Point coordinate, int rotate) {
        if (this.field.isAvailable(type, coordinate, rotate)){
            field.setShip(type, coordinate, rotate);
        }
    }

    protected int botShoot(Player player) {
        return player.field.shot((new Point((int)(Math.random() * 10), (int)(Math.random() * 10))));
    }

    protected void botSetShip(String type, Point coordinate, int rotate) {

    }
}
