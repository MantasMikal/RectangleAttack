//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.RectangleAttack.main.Object;

import java.awt.*;
import java.util.Random;

public class Particle extends GameObject{
    private Random r = new Random();

    public Particle(int x, int y, ID id){
       super((float) x, (float) y, id);
        this.velX += 10.0F;
        this.velY += 10.0F;
    }

    public void tick(){
        this.x += this.velX;
        this.y += this.velY;
        if(this.x <= 0.0F || this.x >= 1006.0F){
            this.velX = -this.velX;
        }

        if(this.y <= 0.0F || this.y >= 728.0F){
            this.velY = -this.velY;
        }
    }

    public void render(Graphics g){
        g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
        g.fillRect((int) this.x, (int) this.y, 20, 20);
    }

    public Rectangle getBounds(){
        return new Rectangle((int) this.x, (int) this.y, 20, 20);
    }
}
