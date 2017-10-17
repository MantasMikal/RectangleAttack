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

public class BossEnemy extends GameObject{
    private BufferedImage player_image;
    private Handler handler;
    private EnemyHUD enemyHUD;
    private int timer = 0;
    private float health;
    private int shootingSpeed;

    public BossEnemy(int x, int y, ID id, Handler handler, EnemyHUD enemyHUD, float health, int shootingSpeed){
        super((float) x, (float) y, id);
        this.health = health;
        this.handler = handler;
        this.enemyHUD = enemyHUD;
        this.velX += -5.0F;
        this.velY += 4.0F;
        this.shootingSpeed = shootingSpeed;

        SpriteSheet s = new SpriteSheet(Game.sprite_sheet);

        player_image = s.grabImage(1, 1, 128, 128);
    }

    public void tick(){
        timer++;
        this.x += this.velX;
        this.y += this.velY;
        if(this.x <= 900.0F){
            this.velX = 0.0F;
        }

        if(this.y <= 0.0F || this.y >= 625.0F){
            this.velY = -this.velY;
        }

        if(timer == shootingSpeed){
            this.handler.addObject(new EnemyBullet((int) this.x, (int) this.y + 50, ID.Bullets, this.handler,
                    -5.0F, (float) (-3 + (int) (Math.random() * 7.0D))));
            this.timer = 0;
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
                    HUD.COINS += 10;
                }
            }
        }
    }

    public void render(Graphics g){
        g.drawImage(player_image, (int) x, (int) y, null);
        //g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
        //g.fillRect((int) this.x, (int) this.y, 100, 100);
    }

    public Rectangle getBounds(){
        return new Rectangle((int) this.x, (int) this.y, 128, 128);
    }
}
