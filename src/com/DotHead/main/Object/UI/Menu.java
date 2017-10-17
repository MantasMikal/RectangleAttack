package com.DotHead.main.Object.UI;

import com.DotHead.main.Engine.Handler;
import com.DotHead.main.Game.STATE;
import com.DotHead.main.Object.ID;
import com.DotHead.main.Object.Particle;
import com.DotHead.main.Object.Player;

import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.MouseEvent;

import static com.DotHead.main.Game.gameState;

public class Menu extends MouseInputAdapter{
    private Handler handler;

    public Menu(Handler handler){
        this.handler = handler;
        for(int i = 0; i < 20; i++){
            this.handler.addObject(new Particle(1 + (int) (Math.random() * 1000.0D), 1 + (int) (Math.random() *
                    1000.0D), ID.Particle));
        }

    }

    public void mousePressed(MouseEvent e){
        int mx = e.getX();
        int my = e.getY();
        if(gameState == STATE.Menu){
            if(this.mouseOver(mx, my, 350, 100, 300, 50)){
                gameState = STATE.Game;
                handler.removeObjects();
                this.handler.addObject(new Player(510, 400, ID.Player, handler)); // <-- PLAYERIS
            }

            if(this.mouseOver(mx, my, 350, 200, 300, 50)){
                gameState = STATE.Help;
            }

            if(this.mouseOver(mx, my, 350, 300, 300, 50)){
                gameState = STATE.GameOver;
            }
        }

        if(gameState == STATE.GameOver){
            if(this.mouseOver(mx, my, 350, 600, 300, 50)){
                /////////////////
                HUD.HEALTH = 100;
                HUD.LEVEL = 0;
                HUD.SCORE = 0;
                gameState = STATE.Game;
                handler.removeObjects();
                this.handler.addObject(new Player(510, 400, ID.Player, handler)); // <-- PLAYERIS
                gameState = STATE.Game;

            }
        }

    }

    public void mouseReleased(MouseEvent e){
    }

    private boolean mouseOver(int mx, int my, int x, int y, int width, int height){
        return (mx > x && my < x + width) && (my > y && my < y + height);
    }

    public void tick(){

    }

    public void render(Graphics g){
        Font font;
        if(gameState == STATE.Menu){
            font = new Font("arial", 1, 50);
            Font font1 = new Font("arial", 1, 30);
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, 1024, 768);
            g.setFont(font);
            g.setColor(Color.black);
            g.drawString("MENIU", 420, 45);
            g.setFont(font1);
            g.setColor(Color.black);
            g.drawString("PLEI", 470, 135);
            g.setFont(font1);
            g.setColor(Color.black);
            g.drawString("HALP", 465, 235);
            g.setFont(font1);
            g.setColor(Color.black);
            g.drawString("BAI BAI", 450, 335);
            g.setColor(Color.black);
            g.drawRect(350, 100, 300, 50);
            g.setColor(Color.black);
            g.drawRect(350, 200, 300, 50);
            g.setColor(Color.black);
            g.drawRect(350, 300, 300, 50);
        } else if(gameState == STATE.Help){
            font = new Font("arial", 1, 50);
            new Font("arial", 1, 30);
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, 1024, 768);
            g.setFont(font);
            g.setColor(Color.black);
            g.drawString("NO HALP FO YA", 420, 45);
        } else if(gameState == STATE.GameOver){

            font = new Font("arial", 1, 70);

            g.setColor(Color.WHITE);
            g.fillRect(0, 0, 1024, 768);
            g.setFont(font);
            g.setColor(Color.black);
            g.drawString("GAME OVER", 290, 205);

            font = new Font("arial", 1, 20);
            g.setFont(font);
            g.drawString("Score: " + HUD.SCORE, 350, 250);
            g.drawString("Level: " + HUD.LEVEL, 350, 280);

            font = new Font("arial", 1, 50);
            g.setFont(font);
            g.drawString("Again?", 425, 642);
            g.setColor(Color.black);
            g.drawRect(350, 600, 300, 54);

        }

    }
}
