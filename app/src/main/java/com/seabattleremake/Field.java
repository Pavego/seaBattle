package com.seabattleremake;

import android.graphics.Point;

import java.util.ArrayList;

import com.seabattleremake.Ship;
import static com.seabattleremake.Ship.tLight;
import static com.seabattleremake.Ship.tMed;
import static com.seabattleremake.Ship.tHeavy;
import static com.seabattleremake.Ship.tCarrier;
import static com.seabattleremake.Ship.tMine;

public class Field {
    ArrayList<Ship> ships;
    public Field () {

    }

    protected boolean isAvailable(String type, Point startCoordinate, int rotate) {
        switch (type) {
            case tMed:
                if (rotate == 0) {
                    startCoordinate.x += 1;
                } else if (rotate == 1) {
                    startCoordinate.y += 1;
                } else if (rotate == 2) {
                    startCoordinate.x -= 1;
                } else if (rotate == 3) {
                    startCoordinate.y -= 1;
                }
                break;

            case tHeavy:
                if (rotate == 0) {
                    startCoordinate.x += 2;
                } else if (rotate == 1) {
                    startCoordinate.y += 2;
                } else if (rotate == 2) {
                    startCoordinate.x -= 2;
                } else if (rotate == 3) {
                    startCoordinate.y -= 2;
                }
                break;
            
            case tCarrier:
                if (rotate == 0) {
                    startCoordinate.x += 3;
                } else if (rotate == 1) {
                    startCoordinate.y += 3;
                } else if (rotate == 2) {
                    startCoordinate.x -= 3;
                } else if (rotate == 3) {
                    startCoordinate.y -= 3;
                }
                break;

            default:
                break;
        }
        return (startCoordinate.x < 10 && startCoordinate.x >= 0) && (startCoordinate.y < 10 && startCoordinate.y >= 0);
    }

    protected void setShip(String type, Point startCoordinate, int rotate) {
        this.ships.add(new Ship(type, startCoordinate, rotate));
    }
}
