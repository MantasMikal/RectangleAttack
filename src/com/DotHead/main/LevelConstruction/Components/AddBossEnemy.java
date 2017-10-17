package com.DotHead.main.LevelConstruction.Components;

import com.DotHead.main.Engine.Handler;
import com.DotHead.main.Object.Enemy.BossEnemy;
import com.DotHead.main.Object.ID;
import com.DotHead.main.Object.UI.EnemyHUD;

public class AddBossEnemy implements Runnable{
    private float health;
    private int shootingSpeed;
    private Handler handler;
    private EnemyHUD enemyHUD;
    private int amount;



    public AddBossEnemy(Handler handler, EnemyHUD enemyHUD, float health, int shootingSpeed){
        this.handler = handler;
        this.enemyHUD = enemyHUD;
        this.amount = 1;
        this.health = health;
        this.shootingSpeed = shootingSpeed;
    }

    @Override
    public void run(){
        for(int i = 0; i < amount; i++){
            handler.addObject(new BossEnemy(1200, 350, ID.BossEnemy, handler, enemyHUD, health, this.shootingSpeed));
        }
    }
}