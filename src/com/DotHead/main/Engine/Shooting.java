package com.DotHead.main.Engine;

import com.DotHead.main.Game;
import com.DotHead.main.Object.ID;
import com.DotHead.main.Object.PlayerBullet;
import com.DotHead.main.Object.UI.HUD;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Shooting extends MouseAdapter implements KeyListener{
    public static int TELEPORT_LOAD_COUNTER = 0;
    private float mx = 0; //Paspaudimo vietai gauti
    private float my = 0;
    private int shootingSpeed = 0;
    private Handler handler;

    public Shooting(Handler handler){
        this.handler = handler;
    }

    public void tick(){
        shootingSpeed++;
        TELEPORT_LOAD_COUNTER++;
        TELEPORT_LOAD_COUNTER = (int) Game.clamp(TELEPORT_LOAD_COUNTER, 0, HUD.TELEPORT_LOAD_TIME); //Neleidziam per
        // daug padidet
    }

    @Override
    public void mouseMoved(MouseEvent e){
        super.mouseMoved(e);
        mx = e.getX();
        my = e.getY();
    }

    @Override
    public void mousePressed(MouseEvent e){
        shoot(); //SAUNAM!
    }

    @Override
    public void keyTyped(KeyEvent e){

    }

    @Override
    public void keyPressed(KeyEvent e){
        if(e.getKeyCode() == KeyEvent.VK_SPACE){
            if(TELEPORT_LOAD_COUNTER >= HUD.TELEPORT_LOAD_TIME){
                handler.getObject(ID.Player).setX((int) mx);
                handler.getObject(ID.Player).setY((int) my);
                TELEPORT_LOAD_COUNTER = 0;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e){

    }

    private void shoot(){
        if(Game.gameState == Game.STATE.Game){
            if(shootingSpeed >= HUD.SHOOTING_SPEED){

                //Algoritmas pataikyti i vieta kur yra pele.. ////
                float playerX = handler.getObject(ID.Player).getX();////
                float playerY = handler.getObject(ID.Player).getY();////
                ////
                float diffX = playerX - this.mx;                    ////
                float diffY = playerY - this.my;                    ////
                ////
                float distance = (float) Math.sqrt((double) ((playerX - this.mx) * (playerX - this.mx)
                        + (playerY - this.my) * (playerY - this.my)));////

                handler.addObject(new PlayerBullet(playerX + 7, playerY + 7, ID.Playerbullet, -1 / distance * diffX *
                        HUD.BULLET_SPEED, -1 / distance * diffY * HUD.BULLET_SPEED)); //Paleidziam kulka

                shootingSpeed = 0; //Atnaujinam
            }
        }
    }

}
