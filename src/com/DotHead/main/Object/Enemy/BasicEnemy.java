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
import java.util.Random;

public class BasicEnemy extends GameObject{
    private BufferedImage player_image;
    private EnemyHUD enemyHUD;
    private Handler handler;
    private float health = 10;
    Random r = new Random();

    public BasicEnemy(int x, int y, ID id, Handler handler, EnemyHUD enemyHUD){
        super((float) x, (float) y, id);
        this.handler = handler;
        this.velX += 2.0F+ (r.nextInt(5 - -5) + -5);
        this.velY += 2.0F + (r.nextInt(5 - -5) + -5);
        this.enemyHUD = enemyHUD;

        SpriteSheet s = new SpriteSheet(Game.sprite_sheet);

        player_image = s.grabImage(2, 1, 16, 16);
    }

    public void tick(){
        this.x += this.velX ;
        this.y += this.velY ;

        if(this.x <= (int) 0.0 || this.x >= (int) 1005.0){
            this.velX = -this.velX;

            velX = Game.clamp(velX, -10, 10);
        }

        if(this.y <= (int)0.0 || this.y >= (int) 728.0F){
            this.velY = -this.velY;
            velY = Game.clamp(velY, -10, 10);
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
                    HUD.COINS += 1;
                }
            }
        }

    }

    public void render(Graphics g){
        g.drawImage(player_image, (int) x, (int) y, null);
        // g.setColor(Color.red);
        //g.fillRect((int) this.x, (int) this.y, 17, 17);
    }

    public Rectangle getBounds(){
        return new Rectangle((int) this.x, (int) this.y, 16, 16);
    }

}
