//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.RectangleAttack.main.Object.Enemy;

import com.RectangleAttack.main.Engine.Handler;
import com.RectangleAttack.main.Engine.SpriteSheet;
import com.RectangleAttack.main.Game;
import com.RectangleAttack.main.Object.GameObject;
import com.RectangleAttack.main.Object.ID;

import java.awt.*;
import java.awt.image.BufferedImage;

class EnemyBullet extends GameObject{

    private Handler handler;
    private BufferedImage player_image;

    EnemyBullet(int x, int y, ID id, Handler handler, float bulletVelX, float bulletVelY){
        super((float) x, (float) y, id);
        this.handler = handler;
        this.velX += bulletVelX;
        this.velY += bulletVelY;

        SpriteSheet s = new SpriteSheet(Game.sprite_sheet);

        player_image = s.grabImage(2, 2, 8, 8);
    }

    public void tick(){
        this.x += this.velX;
        this.y += this.velY;
        this.collision();

        if(this.x <= 0.0F || this.x >= 1006.0F){
            this.isDead = true;
        }

        if(this.y <= 0.0F || this.y >= 728.0F){
            this.isDead = true;
        }
    }

    private void collision(){
        for(int i = 0; i < handler.objects.size(); i++){
            GameObject tmpObj = this.handler.objects.get(i);
            if((tmpObj.getId() == ID.Playerbullet) && this.getBounds().intersects(tmpObj.getBounds())){
                this.isDead = true;
                tmpObj.setDead(true);
            }
        }
    }

    public void render(Graphics g){
        g.drawImage(player_image, (int) x, (int) y, null);
        // g.setColor(Color.black);
        // g.fillRect((int) this.x, (int) this.y, 5, 5);
    }

    public Rectangle getBounds(){
        return new Rectangle((int) this.x, (int) this.y, 5, 5);
    }
}
