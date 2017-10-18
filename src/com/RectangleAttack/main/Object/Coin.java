package com.RectangleAttack.main.Object;

import com.RectangleAttack.main.Engine.Handler;
import com.RectangleAttack.main.Object.UI.HUD;

import java.awt.*;

public class Coin extends GameObject{
    private Handler handler;

    public Coin(float x, float y, ID id, Handler handler){
        super(x, y, id);
        this.handler = handler;
    }

    @Override
    public void tick(){

        this.collision();

    }

    private void collision(){
        for(int i = 0; i < handler.objects.size(); ++i){
            if((handler.objects.get(i).getId() == ID.Player) && this.getBounds().intersects(handler.objects.get
                    (i).getBounds())){
                HUD.COINS++;
                isDead = true;
            }
        }
    }

    @Override
    public void render(Graphics g){
        g.setColor(Color.yellow);
        g.fillRoundRect((int) this.x, (int) this.y, 10, 10, 10, 10);
        g.setColor(Color.black);
        g.drawRoundRect((int) this.x, (int) this.y, 10, 10, 10, 10);
    }

    @Override
    public Rectangle getBounds(){
        return new Rectangle((int) this.x, (int) this.y, 10, 10);  //Kaip returnint roundRectangle?
    }
}
