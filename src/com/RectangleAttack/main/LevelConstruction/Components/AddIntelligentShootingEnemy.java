package com.RectangleAttack.main.LevelConstruction.Components;

import com.RectangleAttack.main.Engine.Handler;
import com.RectangleAttack.main.Object.Enemy.IntelligentShootingEnemy;
import com.RectangleAttack.main.Object.ID;
import com.RectangleAttack.main.Object.UI.EnemyHUD;

import java.util.Random;


public class AddIntelligentShootingEnemy implements Runnable{
    private Handler handler;
    private EnemyHUD enemyHUD;
    private int amount;


    public AddIntelligentShootingEnemy(Handler handler, EnemyHUD enemyHUD, int amount){
        this.handler = handler;
        this.enemyHUD = enemyHUD;
        this.amount = amount;
    }

    @Override
    public void run(){
        Random r = new Random();
        for(int i = 0; i < amount; i++){
            handler.addObject(new IntelligentShootingEnemy(r.nextInt(900), r.nextInt(800), ID.InteligentShootingEnemy, handler, enemyHUD));
        }
    }
}