package com.DotHead.main.Object.UI;

import com.DotHead.main.Engine.Shooting;
import com.DotHead.main.Game;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Shop extends MouseAdapter{

    //SHOP UPGRADES COSTS
    private int healthUpgradeCost = 5;
    private int shootingSpeedUpgradeCost = 5;
    private int refillHPCost = 3;
    private int bulletSpeedUpgradeCost = 5;
    private int bulletDamageUpgradeCost = 5;
    private int playerSpeedUpgradeCost = 5;
    private int teleportUpgradeCost = 5;

    public Shop(){
        //HUD.COINS = 100; //HACK ON LOL
    }

    public void mousePressed(MouseEvent e){
        int mx = e.getX();
        int my = e.getY();

        if(Game.gameState == Game.STATE.Shop){
            System.out.println("SHOP STATE");

            //HEALTHUPGRADE
            if(mouseOver(mx, my, 320, 204, 20, 20)){
                if(HUD.COINS >= healthUpgradeCost){
                    HUD.HEALTH += 10;
                    HUD.MAX_HEALTH += 10;
                    HUD.COINS -= healthUpgradeCost;
                }

                //BULLET SPEED UPGRADE
            } else if(mouseOver(mx, my, 320, 234, 20, 20)){
                if(HUD.COINS >= bulletSpeedUpgradeCost){
                    HUD.BULLET_SPEED += (float) 0.1D;
                    HUD.COINS -= bulletSpeedUpgradeCost;
                }
                //SHOOTING SPEED UPGRADE
            } else if(mouseOver(mx, my, 320, 264, 20, 20)){
                if(HUD.COINS >= shootingSpeedUpgradeCost){
                    HUD.SHOOTING_SPEED -= (float) 0.2;
                    HUD.COINS -= shootingSpeedUpgradeCost;
                }
                //DAMAGE UPGRADE
            } else if(mouseOver(mx, my, 320, 294, 20, 20)){
                if(HUD.COINS >= bulletDamageUpgradeCost){
                    HUD.DAMAGE += (float) 0.2;
                    HUD.COINS -= bulletDamageUpgradeCost;
                }
                //PLAYER SPEED
            } else if(mouseOver(mx, my, 320, 324, 20, 20)){
                if(HUD.COINS >= playerSpeedUpgradeCost){
                    HUD.PLAYER_SPEED += (float) 0.1;
                    HUD.COINS -= playerSpeedUpgradeCost;
                }
            } else if(mouseOver(mx, my, 320, 354, 20, 20)){
                System.out.println("KLOL");
                if(HUD.COINS >= teleportUpgradeCost){
                    HUD.TELEPORT_LOAD_TIME -= 20;
                    Shooting.TELEPORT_LOAD_COUNTER -= 20;
                    HUD.COINS -= teleportUpgradeCost;
                }
            }else if(mouseOver(mx, my, 320, 384, 20, 20)){
                if(HUD.COINS >= refillHPCost){
                    HUD.HEALTH = HUD.MAX_HEALTH;
                    HUD.COINS -= refillHPCost;
                }
            }

            //CONTINUE
            else if(mouseOver(mx, my, 350, 600, 360, 54)){
                Game.gameState = Game.STATE.Game;
                Game.paused = false;
            }

        }
    }

    public void mouseReleased(MouseEvent e){

    }

    private boolean mouseOver(int mx, int my, int x, int y, int width, int height){

        if(mx > x && mx < x + width){ //NEKEISTI
            return my > y && my < y + height;
        } else return false;
        //return (mx > x && my < x + width) && (my > y && my < y + height);
    }

    public void tick(){
        if(Game.gameState == Game.STATE.Shop) Game.paused = true;
    }

    public void render(Graphics g){

        Font font;

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 1024, 768);
        g.setColor(Color.black);

        font = new Font("Shop font", 4, 14);
        g.setFont(font);


        g.drawString("HEALTH UPGRADE         COST:  " + healthUpgradeCost, 80, 220);
        g.drawRect(320, 204, 20, 20);
        g.drawString("BULLET SPEED             COST:  " + healthUpgradeCost, 80, 250);
        g.drawRect(320, 234, 20, 20);
        g.drawString("SHOOTING SPEED         COST:  " + healthUpgradeCost, 80, 280);
        g.drawRect(320, 264, 20, 20);
        g.drawString("BULLET DAMAGE          COST:  " + bulletDamageUpgradeCost, 80, 310);
        g.drawRect(320, 294, 20, 20);
        g.drawString("PLAYER SPEED           COST:  " + playerSpeedUpgradeCost, 80, 340);
        g.drawRect(320, 324, 20, 20);
        g.drawString("TELEPORT LOAD TIME     COST:  " + teleportUpgradeCost, 80, 370);
        g.drawRect(320, 354, 20, 20);
        g.drawString("REFILL HP              COST" + refillHPCost, 80, 400);
        g.drawRect(320, 384, 20, 20);

        font = new Font("Arial", 1, 50);
        g.setFont(font);
        g.drawString("Continue", 425, 642);
        g.drawRect(350, 600, 360, 54);

    }
}
