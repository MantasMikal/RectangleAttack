package com.DotHead.main.Object.UI;

import java.awt.*;

public class EnemyHUD{

    private float health;

    public float getHealth(){
        return health;
    }

    public void setHealth(float health){
        this.health = health;
        if(health <= 0) this.health = 0;
    }

    public void tick(){

    }

    public void render(Graphics g){
        g.setColor(Color.green);
        g.fillRect(800, 20, (int) health * 3, 10);
        g.setColor(Color.black);
        g.drawString("HP left: " + (int) health, 800, 10);
    }
}
