package com.seabattleremake;

import android.graphics.Point;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Storage {
    ArrayList<Ship> playerShips = new ArrayList<>();
    ArrayList<Ship> enemyShips = new ArrayList<>();

    ArrayList<Point> playerHits = new ArrayList<>();
    ArrayList<Point> enemyHits = new ArrayList<>();

    ArrayList<Point> playerMisses = new ArrayList<>();
    ArrayList<Point> enemyMisses = new ArrayList<>();

    ArrayList<Point> playerMines = new ArrayList<>();
    ArrayList<Point> enemyMines = new ArrayList<>();

    boolean isPlayerSkip = false;
    boolean isEnemySkip = false;

    int[] shipsToSet = new int[] {2, 2, 3, 2, 1};

    int playerPoints = 0;
    int enemyPoints = 0;

    int winner = 0;

    public Storage() {
        isPlayerSkip = false;
        isEnemySkip = false;
    }

    protected void addPlayerShip(@NotNull String type, Point startCoordinate, int rotate) {
        switch (type) {
            case "MINE":
                playerShips.add(new MineShip(startCoordinate));
                break;
            case "LIGHT":
                playerShips.add(new LightShip(startCoordinate));
                break;
            case "MEDIUM":
                playerShips.add(new MediumShip(startCoordinate, rotate));
                break;
            case "HEAVY":
                playerShips.add(new HeavyShip(startCoordinate, rotate));
                break;
            case "CARRIAGE":
                playerShips.add(new CarriageShip(startCoordinate, rotate));
                break;
            default:
                break;
        }
    }

    protected void addEnemyShip(@NotNull String type, Point startCoordinate, int rotate) {
        switch (type) {
            case "MINE":
                enemyShips.add(new MineShip(startCoordinate));
                break;
            case "LIGHT":
                enemyShips.add(new LightShip(startCoordinate));
                break;
            case "MEDIUM":
                enemyShips.add(new MediumShip(startCoordinate, rotate));
                break;
            case "HEAVY":
                enemyShips.add(new HeavyShip(startCoordinate, rotate));
                break;
            case "CARRIAGE":
                enemyShips.add(new CarriageShip(startCoordinate, rotate));
                break;
            default:
                break;
        }
    }

    protected boolean addPlayerHit(Point coordinate) {
        coordinate.x -= 1;
        for (Point coord: playerHits) {
            if (coordinate.equals(coord)) {
                return false;
            }
        }

        for (Point coord: playerMines) {
            if (coordinate.equals(coord)) {
                return false;
            }
        }

        for (Point coord: playerMisses) {
            if (coordinate.equals(coord)) {
                return false;
            }
        }

        for (Ship ship: enemyShips) {
            for (Point coordSh: ship.coordinates) {
                if (coordinate.equals(coordSh)) {
                    if (ship instanceof MineShip) {
                        playerMines.add(coordinate);
                        isPlayerSkip = true;
                    } else {
                        playerHits.add(coordinate);
                    }
                    enemyPoints -= 1;
                    return true;
                }
            }
        }

        playerMisses.add(coordinate);
        return true;
    }

    protected boolean addEnemyHit() {
        Point coordinate = new Point((int) (Math.random() * 10), (int) (Math.random() * 10));
        for (Point coord: enemyHits) {
            if (coordinate.equals(coord)) {
                return false;
            }
        }

        for (Point coord: enemyMines) {
            if (coordinate.equals(coord)) {
                return false;
            }
        }

        for (Point coord: enemyMisses) {
            if (coordinate.equals(coord)) {
                return false;
            }
        }

        for (Ship ship: playerShips) {
            for (Point coordSh: ship.coordinates) {
                if (coordinate.equals(coordSh)) {
                    if (ship instanceof MineShip) {
                        enemyMines.add(coordinate);
                        isEnemySkip = true;
                    } else {
                        enemyHits.add(coordinate);
                    }
                    playerPoints -= 1;
                    return true;
                }
            }
        }

        enemyMisses.add(coordinate);
        return true;
    }

    protected void shipsCount(String type) {
        switch (type) {
            case "CARRIAGE":
                if (shipsToSet[4] > 0) {
                    shipsToSet[4] -= 1;
                }
                break;
            case "HEAVY":
                if (shipsToSet[3] > 0) {
                    shipsToSet[3] -= 1;
                }
                break;
            case "MEDIUM":
                if (shipsToSet[2] > 0) {
                    shipsToSet[2] -= 1;
                }
                break;
            case "LIGHT":
                if (shipsToSet[1] > 0) {
                    shipsToSet[1] -= 1;
                }
                break;
            case "MINE":
                if (shipsToSet[0] > 0) {
                    shipsToSet[0] -= 1;
                }
                break;
            default:
                break;
        }
    }

    protected boolean isShipAvailable(String type) {
        switch (type) {
            case "CARRIAGE":
                return shipsToSet[4] > 0;
            case "HEAVY":
                return shipsToSet[3] > 0;
            case "MEDIUM":
                return shipsToSet[2] > 0;
            case "LIGHT":
                return shipsToSet[1] > 0;
            case "MINE":
                return shipsToSet[0] > 0;
            default:
                return false;
        }
    }

    protected boolean isPlayerReady() {
        for (int ship: shipsToSet) {
            if (ship > 0) {
                return false;
            }
        }
        setPoints();
        return true;
    }

    private void setPoints() {
        playerPoints = 20;
        enemyPoints = 20;
    }

    protected void setWinner() {
        if (playerPoints == 0) {
//            enemy wins
            winner = 2;
        } else if (enemyPoints == 0) {
//            player wins
            winner = 1;
        } else {
            winner = 0;
        }
    }
}
