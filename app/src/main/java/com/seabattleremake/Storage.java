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

    protected void addPlayerHit(Point coordinate) {
        playerHits.add(coordinate);
    }

    protected void addEnemyHit(Point coordinate) {
        enemyHits.add(coordinate);
    }

    protected void addPlayerMiss(Point coordinate) {
        playerMisses.add(coordinate);
    }

    protected void addEnemyMiss(Point coordinate) {
        enemyMisses.add(coordinate);
    }

    protected void addPlayerMine(Point coordinate) {
        playerMines.add(coordinate);
    }

    protected void addEnemyMine(Point coordinate) {
        enemyMines.add(coordinate);
    }

    protected void changePlayerSkip() {
        isPlayerSkip = !isPlayerSkip;
    }

    protected void changeEnemySkip() {
        isEnemySkip = !isEnemySkip;
    }
}
