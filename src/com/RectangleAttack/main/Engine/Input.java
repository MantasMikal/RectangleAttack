//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.RectangleAttack.main.Engine;

import com.RectangleAttack.main.Game;
import com.RectangleAttack.main.Object.GameObject;
import com.RectangleAttack.main.Object.ID;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Input extends KeyAdapter{
    private Handler handler;
    private boolean[] keyDown = new boolean[4];

    public Input(Handler handler){
        this.handler = handler;
        this.keyDown[0] = false;
        this.keyDown[1] = false;
        this.keyDown[2] = false;
        this.keyDown[3] = false;
    }

    public void keyPressed(KeyEvent e){
        float key = (float) e.getKeyCode();
        GameObject tempObj = handler.getObject(ID.Player);
        if(tempObj.getId() == ID.Player){ //Jei mygtukas paspaustas, velX/velY + arba -, todel kubelis juda.
            //S
            if(key == 87.0F){
                tempObj.setVelY(-5);
                this.keyDown[0] = true;
            }
            //W
            if(key == 83.0F){
                tempObj.setVelY(5);
                this.keyDown[1] = true;
            }
            //D
            if(key == 68.0F){
                tempObj.setVelX(5);
                this.keyDown[2] = true;
            }
            //A
            if(key == 65.0F){
                tempObj.setVelX(-5);
                this.keyDown[3] = true;
            }
        }
        //PAUSE
        if(Game.gameState == Game.STATE.Game){
            if(key == KeyEvent.VK_P){
                Game.paused = !Game.paused;
            }
        }

    }

    public void keyReleased(KeyEvent e){
        float key = (float) e.getKeyCode();
        GameObject tempObj = handler.getObject(ID.Player);
        if(tempObj.getId() == ID.Player){
            if(key == 87.0F){
                this.keyDown[0] = false;
            }

            if(key == 83.0F){
                this.keyDown[1] = false;
            }

            if(key == 68.0F){
                this.keyDown[2] = false;
            }

            if(key == 65.0F){
                this.keyDown[3] = false;
            }

            if(!this.keyDown[0] && !this.keyDown[1]){           ///Kad nestriginetu spaudinejant i skirtingas puses
                tempObj.setVelY(0);
            }

            if(!this.keyDown[2] && !this.keyDown[3]){
                tempObj.setVelX(0);
            }
        }

    }
}
