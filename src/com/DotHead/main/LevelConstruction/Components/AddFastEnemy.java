package com.DotHead.main.LevelConstruction.Components;

import com.DotHead.main.Engine.Handler;
import com.DotHead.main.Object.Enemy.FastEnemy;
import com.DotHead.main.Object.ID;
import com.DotHead.main.Object.UI.EnemyHUD;

import java.util.Random;


public class AddFastEnemy implements Runnable{
    private Handler handler;
    private EnemyHUD enemyHUD;
    private int amount;


    public AddFastEnemy(Handler handler, EnemyHUD enemyHUD, int amount){
        this.handler = handler;
        this.enemyHUD = enemyHUD;
        this.amount = amount;
    }

    @Override
    public void run(){
        Random r = new Random();
        for(int i = 0; i < amount; i++){
            handler.addObject(new FastEnemy(r.nextInt(900), r.nextInt(800), ID.FastEnemy, handler, enemyHUD));
        }
    }
}