package com.seabattleremake;

import android.graphics.Point;
import android.util.Log;

public class Setting {
    Storage storage;

    String currentShip = "NONE";

    public Setting(Storage storage) {
        this.storage = storage;
        generateEnemyField();
        Log.i("MY_TAG", String.valueOf(storage.enemyShips));
    }

    protected boolean setPlayerShip(Point startCoordinate, int rotate) {
        if (isAvailablePlayer(currentShip, startCoordinate, rotate) && storage.isShipAvailable(currentShip)) {
            storage.addPlayerShip(currentShip, startCoordinate, rotate);
            storage.shipsCount(currentShip);
            return true;
        } else {
            return false;
        }
    }

    protected void setCurrentShip(String type) {
        if (storage.isShipAvailable(type)) {
            currentShip = type;
        } else {
            currentShip = "NONE";
        }
    }

    protected void setEnemyShip(String type, Point startCoordinate, int rotate) {
        storage.addEnemyShip(type, startCoordinate, rotate);
    }

    private void generateEnemyField() {
        int minesRemaining = 2;
        int lightsRemaining = 2;
        int mediumsRemaining = 3;
        int heaviesRemaining = 2;
        int carriagesRemaining = 1;

        Point randomCoordinate;
        int randomRotate;

        while (minesRemaining > 0) {
            randomCoordinate = getRandomCoordinate();
            randomRotate = getRandomRotate();
            if (isAvailableEnemy("MINE", randomCoordinate, randomRotate)) {
                setEnemyShip("MINE", randomCoordinate, randomRotate);
                minesRemaining --;
            }
        }

        while (lightsRemaining > 0) {
            randomCoordinate = getRandomCoordinate();
            randomRotate = getRandomRotate();
            if (isAvailableEnemy("LIGHT", randomCoordinate, randomRotate)) {
                setEnemyShip("LIGHT", randomCoordinate, randomRotate);
                lightsRemaining --;
            }
        }

        while (mediumsRemaining > 0) {
            randomCoordinate = getRandomCoordinate();
            randomRotate = getRandomRotate();
            if (isAvailableEnemy("MEDIUM", randomCoordinate, randomRotate)) {
                setEnemyShip("MEDIUM", randomCoordinate, randomRotate);
                mediumsRemaining --;
            }
        }

        while (heaviesRemaining > 0) {
            randomCoordinate = getRandomCoordinate();
            randomRotate = getRandomRotate();
            if (isAvailableEnemy("HEAVY", randomCoordinate, randomRotate)) {
                setEnemyShip("HEAVY", randomCoordinate, randomRotate);
                heaviesRemaining --;
            }
        }

        while (carriagesRemaining > 0) {
            randomCoordinate = getRandomCoordinate();
            randomRotate = getRandomRotate();
            if (isAvailableEnemy("CARRIAGE", randomCoordinate, randomRotate)) {
                setEnemyShip("CARRIAGE", randomCoordinate, randomRotate);
                carriagesRemaining --;
            }
        }
    }

    private Point getRandomCoordinate() {
        return new Point((int) (Math.random() * 10) + 1, (int) (Math.random() * 10) + 1);
    }

    private int getRandomRotate() {
        return (int) (Math.random() * 10) % 4;
    }

    private boolean isAvailablePlayer(String type, Point startCoordinate, int rotate) {
        if (storage.playerShips != null) {
            if (isInField(type, startCoordinate, rotate)) {
                Ship currShip = getShip(type, startCoordinate, rotate);
                for (Point currCoord: currShip.coordinates) {
                    for (Ship ship: storage.playerShips) {
                        for (Point shipCoord: ship.coordinates) {
                            if (shipCoord.equals(currCoord)) {
                                return false;
                            }
                        }
                    }
                }
                return true;
            } else {
                return false;
            }
        } else {
            return true;
        }
    }

    private boolean isAvailableEnemy(String type, Point startCoordinate, int rotate) {
        if (storage.enemyShips != null) {
            if (isInField(type, startCoordinate, rotate)) {
                Ship currShip = getShip(type, startCoordinate, rotate);
                for (Point currCoord: currShip.coordinates) {
                    for (Ship ship: storage.enemyShips) {
                        for (Point shipCoord: ship.coordinates) {
                            if (shipCoord.equals(currCoord)) {
                                return false;
                            }
                        }
                    }
                }
                return true;
            } else {
                return false;
            }
        } else {
            return true;
        }
    }
    
    private boolean isInField(String type, Point startCoordinate, int rotate) {
        switch (type) {
            case "MINE":
            case "LIGHT":
                return (0 <= startCoordinate.x && startCoordinate.x <= 9 && 0 <= startCoordinate.y && startCoordinate.y <= 9);
            case "MEDIUM":
                switch (rotate) {
                    case 0:
                        return (0 <= startCoordinate.x && startCoordinate.x <= 9 && 0 <= startCoordinate.y - 1 && startCoordinate.y - 1 <= 9);
                    case 1:
                        return (0 <= startCoordinate.x + 1 && startCoordinate.x + 1 <= 9 && 0 <= startCoordinate.y && startCoordinate.y <= 9);
                    case 2:
                        return (0 <= startCoordinate.x && startCoordinate.x <= 9 && 0 <= startCoordinate.y + 1 && startCoordinate.y + 1 <= 9);
                    case 3:
                        return (0 <= startCoordinate.x - 1 && startCoordinate.x - 1 <= 9 && 0 <= startCoordinate.y && startCoordinate.y <= 9);
                    default:
                        return false;
                }
            case "HEAVY":
                switch (rotate) {
                    case 0:
                        return (0 <= startCoordinate.x && startCoordinate.x <= 9 && 0 <= startCoordinate.y - 2 && startCoordinate.y - 2 <= 9);
                    case 1:
                        return (0 <= startCoordinate.x + 2 && startCoordinate.x + 2 <= 9 && 0 <= startCoordinate.y && startCoordinate.y <= 9);
                    case 2:
                        return (0 <= startCoordinate.x && startCoordinate.x <= 9 && 0 <= startCoordinate.y + 2 && startCoordinate.y + 2 <= 9);
                    case 3:
                        return (0 <= startCoordinate.x - 2 && startCoordinate.x - 2 <= 9 && 0 <= startCoordinate.y && startCoordinate.y <= 9);
                    default:
                        return false;
                }
            case "CARRIAGE":
                switch (rotate) {
                    case 0:
                        return (0 <= startCoordinate.x && startCoordinate.x <= 9 && 0 <= startCoordinate.y - 3 && startCoordinate.y - 3 <= 9);
                    case 1:
                        return (0 <= startCoordinate.x + 3 && startCoordinate.x + 3 <= 9 && 0 <= startCoordinate.y && startCoordinate.y <= 9);
                    case 2:
                        return (0 <= startCoordinate.x && startCoordinate.x <= 9 && 0 <= startCoordinate.y + 3 && startCoordinate.y + 3 <= 9);
                    case 3:
                        return (0 <= startCoordinate.x - 3 && startCoordinate.x - 3 <= 9 && 0 <= startCoordinate.y && startCoordinate.y <= 9);
                    default:
                        return false;
                }
            default:
                return false;
        }
    }

    private Ship getShip(String type, Point startCoordinate, int rotate) {
        switch (type) {
            case "MINE":
                return new MineShip(startCoordinate);
            case "LIGHT":
                return new LightShip(startCoordinate);
            case "MEDIUM":
                return new MediumShip(startCoordinate, rotate);
            case "HEAVY":
                return new HeavyShip(startCoordinate, rotate);
            case "CARRIAGE":
                return new CarriageShip(startCoordinate, rotate);
            default:
                return null;
        }
    }
}
