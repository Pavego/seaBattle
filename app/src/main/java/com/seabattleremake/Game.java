package com.seabattleremake;

import android.graphics.Point;

import static com.seabattleremake.Ship.tCarrier;
import static com.seabattleremake.Ship.tHeavy;
import static com.seabattleremake.Ship.tLight;
import static com.seabattleremake.Ship.tMed;
import static com.seabattleremake.Ship.tMine;

public class Game {
    boolean isFieldReady;
    Player player;
    Player bot;

    public Game(Player player, Player bot) {
        this.player = player;
        this.bot = bot;
        
        isFieldReady = false;
//        GenerateField(bot);
    }
    
    protected void GenerateField(Player player) {
        int carriers = 0;
        int heavies = 0;
        int mediums = 0;
        int lights = 0;
        int mines = 0;

        while (carriers != 1) {
            Point randomCoordinate = getRandomCoordinate();
            int randomRotate = getRandomRotate();

            if (player.field.isAvailable(tCarrier, randomCoordinate, randomRotate)){
                player.field.setShip(tCarrier, randomCoordinate, randomRotate);
                carriers += 1;
            }
        }

        while (heavies != 2) {
            Point randomCoordinate = getRandomCoordinate();
            int randomRotate = getRandomRotate();

            if (player.field.isAvailable(tHeavy, randomCoordinate, randomRotate)){
                player.field.setShip(tHeavy, randomCoordinate, randomRotate);
                heavies += 1;
            }
        }

        while (mediums != 3) {
            Point randomCoordinate = getRandomCoordinate();
            int randomRotate = getRandomRotate();

            if (player.field.isAvailable(tMed, randomCoordinate, randomRotate)){
                player.field.setShip(tMed, randomCoordinate, randomRotate);
                mediums += 1;
            }
        }

        while (lights != 2) {
            Point randomCoordinate = getRandomCoordinate();
            int randomRotate = getRandomRotate();

            if (player.field.isAvailable(tLight, randomCoordinate, randomRotate)){
                player.field.setShip(tLight, randomCoordinate, randomRotate);
                lights += 1;
            }
        }

        while (mines != 2) {
            Point randomCoordinate = getRandomCoordinate();
            int randomRotate = getRandomRotate();

            if (player.field.isAvailable(tMine, randomCoordinate, randomRotate)){
                player.field.setShip(tMine, randomCoordinate, randomRotate);
                mines += 1;
            }
        }
    }

    protected Point getRandomCoordinate() {
        return new Point((int)(Math.random() * 10), (int)(Math.random() * 10));
    }

    protected int getRandomRotate() {
        return (int)((Math.random() * 10) % 4);
    }
}
