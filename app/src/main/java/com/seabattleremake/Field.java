package com.seabattleremake;

import android.graphics.Point;

import java.util.ArrayList;

import com.seabattleremake.Ship;
import static com.seabattleremake.Ship.tCarrier;
import static com.seabattleremake.Ship.tHeavy;
import static com.seabattleremake.Ship.tMed;
import static com.seabattleremake.Ship.tLight;
import static com.seabattleremake.Ship.tMine;

public class Field {
    ArrayList<Ship> ships = new ArrayList<>();
    ArrayList<Point> misses = new ArrayList<>();
    ArrayList<Point> hits = new ArrayList<>();
    ArrayList<Point> mines = new ArrayList<>();

    public Field() {

    }

    protected boolean isAvailable(String type, Point startCoordinate, int rotate) {
        Point endCoordinate = getEndCoordinate(type, startCoordinate, rotate);
        
        if ((endCoordinate.x < 10 && endCoordinate.x >= 0) && (endCoordinate.y < 10 && endCoordinate.y >= 0)) {
            return !isCrossing(startCoordinate, endCoordinate, rotate);
        }
        return false;
    }

    protected Point getEndCoordinate(String type, Point startCoordinate, int rotate) {
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
        return startCoordinate;
    }

    protected boolean isCrossing(Point startCoordinate, Point endCoordinate, int rotate) {
        if (ships.size() > 0) {
            switch (rotate) {
                case 0:
                    for (int i = 0; i < endCoordinate.x - startCoordinate.x + 1; i++) {
                        startCoordinate.x += i;
                        for (Ship ship : ships) {
                            for (Point shCoord : ship.coords) {
                                if (shCoord.equals(startCoordinate)) {
                                    return true;
                                }
                            }
                        }
                    }
                    return false;

                case 1:
                    for (int i = 0; i < endCoordinate.y - startCoordinate.y + 1; i++) {
                        startCoordinate.y += i;
                        for (Ship ship : ships) {
                            for (Point shCoord : ship.coords) {
                                if (shCoord.equals(startCoordinate)) {
                                    return true;
                                }
                            }
                        }
                    }
                    return false;

                case 2:
                    for (int i = 0; i < startCoordinate.x - endCoordinate.x + 1; i++) {
                        startCoordinate.x -= i;
                        for (Ship ship : ships) {
                            for (Point shCoord : ship.coords) {
                                if (shCoord.equals(startCoordinate)) {
                                    return true;
                                }
                            }
                        }
                    }
                    return false;

                case 3:
                    for (int i = 0; i < startCoordinate.y - endCoordinate.x + 1; i++) {
                        startCoordinate.y -= i;
                        for (Ship ship : ships) {
                            for (Point shCoord : ship.coords) {
                                if (shCoord.equals(startCoordinate)) {
                                    return true;
                                }
                            }
                        }
                    }
                    return false;

                default:
                    break;
            }
        }
        return false;
    }

    protected void setShip(String type, Point startCoordinate, int rotate) {
        this.ships.add(new Ship(type, startCoordinate, rotate));
    }

    // 0 - miss, 1 - hit, 2 - mine, 3 - already shot
    protected int shot(Point coordinate) {
        if (!isShooted(coordinate)){
            for (Ship ship: ships) {
                for (Point shCoord: ship.coords) {
                    if (shCoord.equals(coordinate)) {
                        if (ship.type.equals(tMine)) {
                            this.mines.add(coordinate);
                            return 2;
                        } else {
                            this.hits.add(coordinate);
                            return 1;
                        }
                    }
                }
            }
            this.misses.add(coordinate);
            return 0;
        } else {
            return 3;
        }
        
    }

    protected boolean isShooted(Point coordinate) {
        for (Point miss: misses) {
            if (coordinate.equals(miss)) {
                return true;
            }
        }
        for (Point hit: hits) {
            if (coordinate.equals(hit)) {
                return true;
            }
        }
        for (Point mine: mines) {
            if (coordinate.equals(mine)) {
                return true;
            }
        }
        return false;
    }
}
