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
import com.RectangleAttack.main.Object.UI.EnemyHUD;
import com.RectangleAttack.main.Object.UI.HUD;

import java.awt.*;
import java.awt.image.BufferedImage;

public class FastEnemy extends GameObject{

    private Handler handler;
    private EnemyHUD enemyHUD;
    private BufferedImage player_image;
    private float health = 1;

    public FastEnemy(int x, int y, ID id, Handler handler, EnemyHUD enemyHUD){
        super((float) x, (float) y, id);
        this.handler = handler;
        this.enemyHUD = enemyHUD;
        this.velX += 10.0F;
        this.velY += 10.0F;

        SpriteSheet s = new SpriteSheet(Game.sprite_sheet);

        player_image = s.grabImage(1, 2, 16, 16);

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
        this.collision();

    }

    private void collision(){
        for(int i = 0; i < this.handler.objects.size(); ++i){
            GameObject tmpObj = this.handler.objects.get(i);
            if((tmpObj.getId() == ID.Playerbullet) && this.getBounds().intersects(tmpObj.getBounds())){
                tmpObj.setDead(true);
                health -= HUD.DAMAGE;
                enemyHUD.setHealth(health);
                if(health <= 0){
                    isDead = true;
                    HUD.COINS += 2;
                }
            }
        }
    }

    public void render(Graphics g){
        g.drawImage(player_image, (int) x, (int) y, null);
        // g.setColor(Color.red);
        // g.fillRect((int) this.x, (int) this.y, 16, 10);
    }

    public Rectangle getBounds(){
        return new Rectangle((int) this.x, (int) this.y, 16, 16);
    }
}
