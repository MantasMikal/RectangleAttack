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

public class IntelligentShootingEnemy extends GameObject{
    private BufferedImage player_image;
    private Handler handler;
    private GameObject player;
    private EnemyHUD enemyHUD;
    private int timer = 100;
    private float health = 15;

    public IntelligentShootingEnemy(int x, int y, ID id, Handler handler, EnemyHUD enemyHUD){
        super((float) x, (float) y, id);
        this.handler = handler;
        this.enemyHUD = enemyHUD;

        for(int i = 0; i < handler.objects.size(); ++i){
            if(handler.objects.get(i).getId() == ID.Player){
                this.player = handler.objects.get(i);
            }
        }

        SpriteSheet s = new SpriteSheet(Game.sprite_sheet);

        player_image = s.grabImage(1, 3, 32, 32);

    }

    public Rectangle getBounds(){
        return new Rectangle((int) this.x, (int) this.y, 30, 30);
    }

    public void tick(){

        this.x += this.velX;
        this.y += this.velY;

        float diffX = this.x - this.player.getX() - 8.0F;
        float diffY = this.y - this.player.getY() - 8.0F;

        float distance = (float) Math.sqrt((double) ((this.x - this.player.getX()) * (this.x - this.player.getX())
                + (this.y - this.player.getY()) * (this.y - this.player.getY())));

        this.velX = -1.0F / distance * diffX;
        this.velY = -1.0F / distance * diffY;

        if(this.x <= 0.0F || this.x >= 1006.0F){
            this.velX = -this.velX;
        }

        if(this.y <= 0.0F || this.y >= 728.0F){
            this.velY = -this.velY;
        }

        --this.timer;
        if(this.timer == 0){
            this.handler.addObject(new EnemyBullet((int) this.x + 15, (int) this.y + 15, ID.Bullets, this.handler,
                    -1.0F / distance * diffX * 5.0F, -1.0F / distance * diffY * 5.0F));
            this.timer = 100;
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

                if(this.health <= 1){
                    isDead = true;
                    HUD.COINS += 5;
                }
            }
        }
    }

    public void render(Graphics g){
        g.drawImage(player_image, (int) x, (int) y, null);
        //g.setColor(Color.orange);
        // g.fillRect((int) this.x, (int) this.y, 32, 32);
    }
}
