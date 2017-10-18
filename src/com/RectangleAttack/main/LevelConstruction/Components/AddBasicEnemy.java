package com.RectangleAttack.main.LevelConstruction.Components;

import com.RectangleAttack.main.Engine.Handler;
import com.RectangleAttack.main.Object.Enemy.BasicEnemy;
import com.RectangleAttack.main.Object.ID;
import com.RectangleAttack.main.Object.UI.EnemyHUD;

import java.util.Random;


public class AddBasicEnemy implements Runnable{
 private Handler handler;
    private EnemyHUD enemyHUD;
    private int amount;


    public AddBasicEnemy(Handler handler, EnemyHUD enemyHUD, int amount){
        this.handler = handler;
        this.enemyHUD = enemyHUD;
        this.amount = amount;
    }

    @Override
    public void run(){
        Random r = new Random();
        for(int i = 0; i < amount; i++){
            handler.addObject(new BasicEnemy(r.nextInt(900), r.nextInt(800), ID.BasicEnemy, handler, enemyHUD));
        }
    }
}
