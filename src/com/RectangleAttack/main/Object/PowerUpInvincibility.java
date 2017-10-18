package com.RectangleAttack.main.Object;

import java.awt.*;

public class PowerUpInvincibility extends GameObject{ //NEBAIGTA
    public PowerUpInvincibility(float x, float y, ID id){
        super(x, y, id);
    }

    @Override
    public void tick(){

    }

    @Override
    public void render(Graphics g){
        g.setColor(Color.blue);
        g.fillRect((int)x, (int)y, 20, 20);
    }

    @Override
    public Rectangle getBounds(){
        return new Rectangle((int) this.x, (int) this.y, 20, 20);

    }
}
