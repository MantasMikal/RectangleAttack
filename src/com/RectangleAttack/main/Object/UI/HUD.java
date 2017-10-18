//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.RectangleAttack.main.Object.UI;

import com.RectangleAttack.main.Engine.Shooting;
import com.RectangleAttack.main.Game;
import com.RectangleAttack.main.LevelConstruction.Levels;

import java.awt.*;
import java.math.BigDecimal;

public class HUD{

    public static int MAX_HEALTH = 100;
    public static int HEALTH = 100;
    public static int SCORE = 0;
    public static int LEVEL = 1;
    public static int COINS = 0;
    public static float BULLET_SPEED = 8;
    public static float SHOOTING_SPEED = 10;
    public static float DAMAGE = 1;
    public static float PLAYER_SPEED = 0.3F;
    public static float TELEPORT_LOAD_TIME = 500;

    public HUD(){
    }

    private static BigDecimal round(float d, int decimalPlace){
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd;
    }

    public static void reset(){
        MAX_HEALTH = 100;
        HEALTH = 100;
        COINS = 0;
        BULLET_SPEED = 8;
        SHOOTING_SPEED = 10;
        DAMAGE = 1;
        PLAYER_SPEED = 0.3F;
        TELEPORT_LOAD_TIME = 500;
        Levels.TIME = 0;
    }

    public void tick(){

        ++SCORE;
        TELEPORT_LOAD_TIME = Game.clamp(TELEPORT_LOAD_TIME, 0, 500);

    }

    public void render(Graphics g){

        Font font = new Font("HUD font", 4, 14);
        g.setFont(font);
        g.setColor(Color.white);
        g.fillRect(15, 15, 200, 20);
        g.setColor(Color.black);
        //g.setColor(new Color(255 / (HEALTH / 27 + 1), (int) ((double) HEALTH * 2.55D), 0, 255));
        g.drawString("Health", 10, 12);
        g.fillRect(10, 15, HEALTH, 20);
        g.drawRect(10, 15, MAX_HEALTH, 20); //HEALTHBAR SIZE

        g.drawString("Teleport", 10, 52);
        g.drawRect(10, 55, (int) TELEPORT_LOAD_TIME / 2, 20);
        g.fillRect(10, 55, Shooting.TELEPORT_LOAD_COUNTER / 2, 20);

        g.drawString("Level: " + LEVEL, 10, 95);
        g.drawString("Coins: " + COINS, 10, 110);
        g.drawString("Bullet Speed: " + round(BULLET_SPEED, 2), 10, 125);
        g.drawString("Shooting Speed: " + round(SHOOTING_SPEED, 2), 10, 140);
        g.drawString("Damage: " + round(DAMAGE, 2), 10, 155);
        g.drawString("Player Speed: " + round(PLAYER_SPEED, 2), 10, 170);
        g.drawString("Teleport Load: " + Shooting.TELEPORT_LOAD_COUNTER + "/" + TELEPORT_LOAD_TIME, 10, 185);
    }
}
