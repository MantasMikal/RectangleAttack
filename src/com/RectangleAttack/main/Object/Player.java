//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.RectangleAttack.main.Object;

import com.RectangleAttack.main.Engine.Handler;
import com.RectangleAttack.main.Game;
import com.RectangleAttack.main.Object.UI.HUD;

import java.awt.*;

public class Player extends GameObject{
    private Handler handler;
    //private BufferedImage player_image;

    public Player(int x, int y, ID id, Handler handler){
        super((float) x, (float) y, id);
        this.handler = handler;
        //SpriteSheet s = new SpriteSheet(Game.sprite_sheet);
        //player_image = s.grabImage(1, 1, 128, 128);

    }

    public void tick(){

        //JEI JUDA (A)
            /*if(handler.getObject(ID.Player).getVelX() > 0 && handler.getObject(ID.Player).getVelY() == 0){
                handler.addObject(new PlayerBullet((int) this.x + 5, (int) this.y + 5, ID.Playerbullet,
                        bulletSpeed, 0, handler));
                bulletShootingSpeed = 0;

                //JEI JUDA (A)
            } else if(handler.getObject(ID.Player).getVelX() < 0 && handler.getObject(ID.Player).getVelY() == 0){
                handler.addObject(new PlayerBullet((int) this.x + 5, (int) this.y + 5, ID.Playerbullet, bulletSpeed
                        * -1, 0, handler));
                bulletShootingSpeed = 0;

                //JEI JUDA (W)
            } else if(handler.getObject(ID.Player).getVelY() > 0 && handler.getObject(ID.Player).getVelX() == 0){
                handler.addObject(new PlayerBullet((int) this.x + 5, (int) this.y + 5, ID.Playerbullet, 0,
                        bulletSpeed, handler));
                bulletShootingSpeed = 0;

                //JEI JUDA (S)
            } else if(handler.getObject(ID.Player).getVelY() < 0 && handler.getObject(ID.Player).getVelX() == 0){
                handler.addObject(new PlayerBullet((int) this.x + 5, (int) this.y + 5, ID.Playerbullet, 0,
                        bulletSpeed * -1, handler));
                bulletShootingSpeed = 0;

                //JEI JUDA (S+D)
            } else if(handler.getObject(ID.Player).getVelY() > 0 && handler.getObject(ID.Player).getVelX() > 0){
                handler.addObject(new PlayerBullet((int) this.x + 5, (int) this.y + 5, ID.Playerbullet,
                        bulletSpeed, bulletSpeed, handler));
                bulletShootingSpeed = 0;

                //JEI JUDA (W+A)
            } else if(handler.getObject(ID.Player).getVelY() < 0 && handler.getObject(ID.Player).getVelX() < 0){
                handler.addObject(new PlayerBullet((int) this.x + 5, (int) this.y + 5, ID.Playerbullet, bulletSpeed
                        * -1, bulletSpeed * -1, handler));
                bulletShootingSpeed = 0;

                //JEI JUDA(W+D)
            } else if(handler.getObject(ID.Player).getVelY() < 0 && handler.getObject(ID.Player).getVelX() > 0){
                handler.addObject(new PlayerBullet((int) this.x + 5, (int) this.y + 5, ID.Playerbullet,
                        bulletSpeed, bulletSpeed * -1, handler));
                bulletShootingSpeed = 0;

                //JEI JUDA(S+A)
            } else if(handler.getObject(ID.Player).getVelY() > 0 && handler.getObject(ID.Player).getVelX() < 0){
                handler.addObject(new PlayerBullet((int) this.x + 5, (int) this.y + 5, ID.Playerbullet, bulletSpeed
                        * -1, bulletSpeed, handler));
                bulletShootingSpeed = 0;
            }
            //JEI StoVI VIETOJE
            else if(handler.getObject(ID.Player).getVelX() == 0 && handler.getObject(ID.Player).getVelY() == 0){
                System.out.println("STANDING");
            }
*/
        this.y += this.velY * HUD.PLAYER_SPEED;
        this.x += this.velX * HUD.PLAYER_SPEED;
        this.x = Game.clamp(this.x, 0.0F, 1012.0F); //NELEIDZIA ISEIT UZ WINDOW
        this.y = Game.clamp(this.y, 0.0F, 734.0F);
        this.collision();

    }

    private void collision(){
        for(int i = 0; i < this.handler.objects.size(); ++i){
            GameObject tmpObj = this.handler.objects.get(i);
            if((tmpObj.getId() == ID.BasicEnemy || tmpObj.getId() == ID.FastEnemy || tmpObj.getId() == ID
                    .Intelegentenemy) && this.getBounds().intersects(tmpObj.getBounds())){
                HUD.HEALTH -= 2;

            }

            if((tmpObj.getId() == ID.BossEnemy) && this.getBounds().intersects
                    (tmpObj.getBounds())){
                --HUD.HEALTH;
            }

            if((tmpObj.getId() == ID.Bullets && this.getBounds().intersects
                    (tmpObj.getBounds()))){
                tmpObj.isDead = true;
                --HUD.HEALTH;
            }

        }

    }
    public void render(Graphics g){
        g.setColor(Color.black);
        g.fillRect((int) this.x, (int) this.y, 20, 20);
        //g.drawImage(player_image, (int)x, (int)y, null);
    }

    public Rectangle getBounds(){
        return new Rectangle((int) this.x, (int) this.y, 18, 18);
    }

}
