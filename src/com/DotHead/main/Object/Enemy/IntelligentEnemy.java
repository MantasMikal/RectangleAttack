//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.DotHead.main.Object.Enemy;

import com.DotHead.main.Engine.Handler;
import com.DotHead.main.Engine.SpriteSheet;
import com.DotHead.main.Game;
import com.DotHead.main.Object.GameObject;
import com.DotHead.main.Object.ID;
import com.DotHead.main.Object.UI.EnemyHUD;
import com.DotHead.main.Object.UI.HUD;

import java.awt.*;
import java.awt.image.BufferedImage;

public class IntelligentEnemy extends GameObject{
    private BufferedImage player_image;
    private Handler handler;
    private GameObject player;
    private EnemyHUD enemyHUD;
    private float health = 10;

    public IntelligentEnemy(int x, int y, ID id, Handler handler, EnemyHUD enemyHUD){
        super((float) x, (float) y, id);
        this.handler = handler;
        this.enemyHUD = enemyHUD;

        SpriteSheet s = new SpriteSheet(Game.sprite_sheet);

        player_image = s.grabImage(1, 4, 48, 48);

        for(int i = 0; i < handler.objects.size(); ++i){
            if(handler.objects.get(i).getId() == ID.Player){
                this.player = handler.objects.get(i);
            }
        }

    }

    public Rectangle getBounds(){
        return new Rectangle((int) this.x, (int) this.y, 48, 48);
    }

    public void tick(){
        this.x += this.velX;
        this.y += this.velY;

        float diffX = this.x - this.player.getX() - 8.0F;
        float diffY = this.y - this.player.getY() - 8.0F;
        float distance = (float) Math.sqrt((double) ((this.x - this.player.getX()) * (this.x - this.player.getX())
                + (this.y - this.player.getY()) * (this.y - this.player.getY())));

        this.velX = (-1.0F / distance * diffX) * 1.2f;
        this.velY = (-1.0F / distance * diffY) * 1.2f;
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
                if(health <= 1){
                    isDead = true;
                    HUD.COINS += 3;
                }
            }
        }
    }

    public void render(Graphics g){
        g.drawImage(player_image, (int) x, (int) y, null);
        //g.setColor(Color.pink);
        // g.fillRect((int) this.x, (int) this.y, 64, 64);
    }
}
