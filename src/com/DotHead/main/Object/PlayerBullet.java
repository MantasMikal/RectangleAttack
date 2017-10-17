package com.DotHead.main.Object;

import java.awt.*;

public class PlayerBullet extends GameObject{

    private float velX = 0;
    private float velY = 0;

    public PlayerBullet(float x, float y, ID id, float velX, float velY){
        super(x, y, id);
        this.velX = velX;
        this.velY = velY;
    }

    @Override
    public void tick(){
        this.x += velX;
        this.y += velY;
        if(this.x <= 0.0F || this.x >= 1006.0F){
            this.isDead = true;
        }

        if(this.y <= 0.0F || this.y >= 728.0F){
            this.isDead = true;
        }
    }

    @Override
    public void render(Graphics g){
        g.setColor(Color.black);
        g.drawRect((int) this.x, (int) this.y, 5, 5);

    }

    @Override
    public Rectangle getBounds(){
        return new Rectangle((int) this.x, (int) this.y, 5, 5);
    }
}

