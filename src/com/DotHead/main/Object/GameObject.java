//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.DotHead.main.Object;

import java.awt.*;

public abstract class GameObject{
    protected float x;
    protected float y;
    protected float velX;
    protected float velY;
    protected boolean isDead = false;
    private ID id;


    private int spawnRate;
    private int amount;

    public GameObject(float x, float y, ID id){
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public boolean isDead(){
        return isDead;
    }

    public void setDead(boolean dead){
        isDead = dead;
    }

    public abstract void tick();

    public abstract void render(Graphics var1);

    public abstract Rectangle getBounds();

    public boolean equals(Object o){
        if(this == o){
            return true;
        } else if(o != null && this.getClass() == o.getClass()){
            GameObject object = (GameObject) o;
            return this.id == object.id;
        } else{
            return false;
        }
    }

    public int hashCode(){
        return 0;
    }

    public float getY(){
        return this.y;
    }

    public void setY(int y){
        this.y = (float) y;
    }

    public float getX(){
        return this.x;
    }

    public void setX(int x){
        this.x = (float) x;
    }

    public ID getId(){
        return this.id;
    }

    public void setId(ID id){
        this.id = id;
    }

    public float getVelX(){
        return this.velX;
    }

    public void setVelX(int velX){
        this.velX = (float) velX;
    }

    public float getVelY(){
        return this.velY;
    }

    public void setVelY(int velY){
        this.velY = (float) velY;
    }
}

