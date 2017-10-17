//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//
/*
package com.DotHead.main.Events;

import com.DotHead.main.Engine.Handler;
import com.DotHead.main.Game;
import com.DotHead.main.Object.Coin;
import com.DotHead.main.Object.Enemy.*;
import com.DotHead.main.Object.GameObject;
import com.DotHead.main.Object.ID;
import com.DotHead.main.Object.Player;
import com.DotHead.main.Object.UI.EnemyHUD;
import com.DotHead.main.Object.UI.HUD;

import java.awt.*;
import java.util.Random;

public class Levels{
    private Handler handler;
    private HUD hud;
    private EnemyHUD enemyHUD;

    private int scoreCount;
    private int coinSpawnTimer = 0;
    private int basicnEmySpawnTimer;
    private int fastEnemySpawnTimer;
    private int intelligentEnemySpawnTimer;
    private int intelligentShootingEnemySpawnTimer;
    private int bossEnemySpawnTimmer;
    boolean transition = false;





    Random r = new Random();

    public Levels(Handler handler, HUD hud, EnemyHUD enemyHUD){
        this.handler = handler;
        this.hud = hud;
        this.enemyHUD = enemyHUD;
    }

    public void tick(){
        this.scoreCounter();
        coinSpawnTimer++;
        basicnEmySpawnTimer++;
        fastEnemySpawnTimer++;
        intelligentEnemySpawnTimer++;
        intelligentShootingEnemySpawnTimer++;
        bossEnemySpawnTimmer++;


        if(HUD.LEVEL == 1) {
            this.spawnCoin(50);
            this.spawnEnemy(50, ID.BasicEnemy);

        }
        if(HUD.LEVEL == 2) {
            if(HUD.SCORE == 1000){
                handler.removeObjects();
                Game.gameState = Game.STATE.Shop;
                spawnPlayer();
            }
            this.spawnCoin(50);
            this.spawnEnemy(90, ID.FastEnemy);
            this.spawnEnemy(50, ID.BasicEnemy);
            handler.addObject(new FastEnemy(r.nextInt(900), r.nextInt(900), ID.FastEnemy, handler, enemyHUD));
            handler.addObject(new FastEnemy(r.nextInt(900), r.nextInt(900), ID.FastEnemy, handler, enemyHUD));
            handler.addObject(new FastEnemy(r.nextInt(900), r.nextInt(900), ID.FastEnemy, handler, enemyHUD));
            handler.addObject(new FastEnemy(r.nextInt(900), r.nextInt(900), ID.FastEnemy, handler, enemyHUD));
            handler.addObject(new FastEnemy(r.nextInt(900), r.nextInt(900), ID.FastEnemy, handler, enemyHUD));
            handler.addObject(new FastEnemy(r.nextInt(900), r.nextInt(900), ID.FastEnemy, handler, enemyHUD));
            handler.addObject(new FastEnemy(r.nextInt(900), r.nextInt(900), ID.FastEnemy, handler, enemyHUD));
            handler.addObject(new FastEnemy(r.nextInt(900), r.nextInt(900), ID.FastEnemy, handler, enemyHUD));

        }
        if(HUD.LEVEL == 3) {
            if(HUD.SCORE == 2000){
                handler.removeObjects();
                Game.gameState = Game.STATE.Shop;
                spawnPlayer();

            this.spawnCoin(50);
            this.spawnEnemy(90, ID.FastEnemy);
            this.spawnEnemy(50, ID.BasicEnemy);
            handler.addObject(new FastEnemy(r.nextInt(900), r.nextInt(900), ID.FastEnemy, handler, enemyHUD));
            handler.addObject(new FastEnemy(r.nextInt(900), r.nextInt(900), ID.FastEnemy, handler, enemyHUD));
            handler.addObject(new FastEnemy(r.nextInt(900), r.nextInt(900), ID.FastEnemy, handler, enemyHUD));
            handler.addObject(new FastEnemy(r.nextInt(900), r.nextInt(900), ID.FastEnemy, handler, enemyHUD));
            handler.addObject(new FastEnemy(r.nextInt(900), r.nextInt(900), ID.FastEnemy, handler, enemyHUD));
            handler.addObject(new FastEnemy(r.nextInt(900), r.nextInt(900), ID.FastEnemy, handler, enemyHUD));
            handler.addObject(new FastEnemy(r.nextInt(900), r.nextInt(900), ID.FastEnemy, handler, enemyHUD));
            handler.addObject(new FastEnemy(r.nextInt(900), r.nextInt(900), ID.FastEnemy, handler, enemyHUD));
        }}
        if(HUD.LEVEL == 4) {

            if(HUD.SCORE == 3000){
                handler.removeObjects();
                Game.gameState = Game.STATE.Shop;
                spawnPlayer();
            }
            this.spawnCoin(50);
            this.spawnEnemy(90, ID.FastEnemy);
            this.spawnEnemy(50, ID.BasicEnemy);
            handler.addObject(new FastEnemy(r.nextInt(900), r.nextInt(900), ID.FastEnemy, handler, enemyHUD));
            handler.addObject(new FastEnemy(r.nextInt(900), r.nextInt(900), ID.FastEnemy, handler, enemyHUD));
            handler.addObject(new FastEnemy(r.nextInt(900), r.nextInt(900), ID.FastEnemy, handler, enemyHUD));
            handler.addObject(new FastEnemy(r.nextInt(900), r.nextInt(900), ID.FastEnemy, handler, enemyHUD));
            handler.addObject(new FastEnemy(r.nextInt(900), r.nextInt(900), ID.FastEnemy, handler, enemyHUD));
            handler.addObject(new FastEnemy(r.nextInt(900), r.nextInt(900), ID.FastEnemy, handler, enemyHUD));
            handler.addObject(new FastEnemy(r.nextInt(900), r.nextInt(900), ID.FastEnemy, handler, enemyHUD));
            handler.addObject(new FastEnemy(r.nextInt(900), r.nextInt(900), ID.FastEnemy, handler, enemyHUD));

            handler.addObject(new IntelligentEnemy(r.nextInt(900), r.nextInt(900), ID.Intelegentenemy, handler,
            enemyHUD));
            handler.addObject(new IntelligentEnemy(r.nextInt(900), r.nextInt(900), ID.Intelegentenemy, handler,
            enemyHUD));
        }
        if(HUD.LEVEL == 5) {

            if(HUD.SCORE == 4000){
                handler.removeObjects();
                Game.gameState = Game.STATE.Shop;
                spawnPlayer();
            }
            this.spawnCoin(50);
            this.spawnEnemy(90, ID.FastEnemy);
            this.spawnEnemy(50, ID.BasicEnemy);
            handler.addObject(new FastEnemy(r.nextInt(900), r.nextInt(900), ID.FastEnemy, handler, enemyHUD));
            handler.addObject(new FastEnemy(r.nextInt(900), r.nextInt(900), ID.FastEnemy, handler, enemyHUD));
            handler.addObject(new FastEnemy(r.nextInt(900), r.nextInt(900), ID.FastEnemy, handler, enemyHUD));
            handler.addObject(new FastEnemy(r.nextInt(900), r.nextInt(900), ID.FastEnemy, handler, enemyHUD));
            handler.addObject(new FastEnemy(r.nextInt(900), r.nextInt(900), ID.FastEnemy, handler, enemyHUD));
            handler.addObject(new FastEnemy(r.nextInt(900), r.nextInt(900), ID.FastEnemy, handler, enemyHUD));
            handler.addObject(new FastEnemy(r.nextInt(900), r.nextInt(900), ID.FastEnemy, handler, enemyHUD));
            handler.addObject(new FastEnemy(r.nextInt(900), r.nextInt(900), ID.FastEnemy, handler, enemyHUD));

            handler.addObject(new IntelligentEnemy(r.nextInt(900), r.nextInt(900), ID.Intelegentenemy, handler,
            enemyHUD));
            handler.addObject(new IntelligentEnemy(r.nextInt(900), r.nextInt(900), ID.Intelegentenemy, handler,
            enemyHUD));

            handler.addObject(new IntelligentShootingEnemy(r.nextInt(900), r.nextInt(900), ID
            .InteligentShootingEnemy, handler, enemyHUD));
            handler.addObject(new IntelligentShootingEnemy(r.nextInt(900), r.nextInt(900), ID
            .InteligentShootingEnemy, handler, enemyHUD));

        }
        if(HUD.LEVEL == 6) {

            if(HUD.SCORE == 4000){
                handler.removeObjects();
                Game.gameState = Game.STATE.Shop;
                spawnPlayer();
            }
            handler.addObject(new BossEnemy(1200, 350, ID.BasicEnemy, handler, enemyHUD));

        }
        if(HUD.LEVEL == 1) {

        }
        if(HUD.LEVEL == 1) {

        }
        if(HUD.LEVEL == 1) {

        }
        if(HUD.LEVEL == 1) {

        }
        if(HUD.LEVEL == 1) {

        }
        if(HUD.LEVEL == 1) {

        }
        if(HUD.LEVEL == 1) {

        }
        if(HUD.LEVEL == 1) {

        }
        if(HUD.LEVEL == 1) {

        }
        if(HUD.LEVEL == 1) {

        }
        if(HUD.LEVEL == 1) {

        }
        if(HUD.LEVEL == 1) {

        }
        if(HUD.LEVEL == 1) {

        }
        if(HUD.LEVEL == 1) {

        }
        if(HUD.LEVEL == 1) {

        }
        if(HUD.LEVEL == 1) {

        }
        if(HUD.LEVEL == 1) {

        }
        if(HUD.LEVEL == 1) {

        }
        if(HUD.LEVEL == 1) {

        }
        if(HUD.LEVEL == 1) {

        }



    }

    public void render(Graphics g){

    }

    private void scoreCounter(){
        scoreCount++;
        if(scoreCount == 1000) {
            HUD.LEVEL++;
            scoreCount = 0;
        }
    }

    private void spawnCoin(int TIME) {
        if(coinSpawnTimer == TIME){
            handler.addObject(new Coin(r.nextInt(900), r.nextInt(900), ID.Coin, handler));
            coinSpawnTimer = 0;
        }
    }

    private void spawnEnemy(int TIME, ID enemyID) {

            if(enemyID == ID.BasicEnemy && basicnEmySpawnTimer == TIME ){
                handler.addObject(new BasicEnemy(r.nextInt(900), r.nextInt(900), ID.BasicEnemy, handler, enemyHUD));
                basicnEmySpawnTimer = 0;
            }else if(enemyID == ID.FastEnemy && fastEnemySpawnTimer == TIME){
                handler.addObject(new FastEnemy(r.nextInt(900), r.nextInt(900), ID.FastEnemy, handler, enemyHUD));
                fastEnemySpawnTimer = 0;
            }else if(enemyID == ID.Intelegentenemy && intelligentEnemySpawnTimer == TIME) {
                handler.addObject(new IntelligentEnemy(r.nextInt(900), r.nextInt(900), ID.Intelegentenemy, handler,
                enemyHUD));
                intelligentEnemySpawnTimer = 0;
            }else if(enemyID == ID.InteligentShootingEnemy && intelligentShootingEnemySpawnTimer == TIME) {
                handler.addObject(new IntelligentShootingEnemy(r.nextInt(900), r.nextInt(900), ID
                .InteligentShootingEnemy, handler, enemyHUD));
                intelligentShootingEnemySpawnTimer = 0;
            }else if(enemyID == ID.BossEnemy && bossEnemySpawnTimmer == TIME){
                handler.addObject(new BossEnemy(1200, 350, ID.BasicEnemy, handler, enemyHUD));
                bossEnemySpawnTimmer = 0;
            }
        }

    private void spawnPlayer(){
        handler.addObject(new Player(500, 450, ID.Player, handler));
    }


}

*/

package com.DotHead.main.LevelConstruction;

import com.DotHead.main.Engine.Handler;
import com.DotHead.main.Events.EventHandler;
import com.DotHead.main.LevelConstruction.Components.*;
import com.DotHead.main.Object.Coin;
import com.DotHead.main.Object.ID;
import com.DotHead.main.Object.UI.EnemyHUD;
import com.DotHead.main.Object.UI.HUD;

import java.util.Random;

public class Levels{
    public static int TIME = 0;
    private Handler handler;
    private EnemyHUD enemyHUD;
    private EventHandler eventHandler;
    private int coinSpawnTimer;

    public Levels(Handler handler, EnemyHUD enemyHUD, EventHandler eventHandler){
        this.handler = handler;
        this.enemyHUD = enemyHUD;
        this.eventHandler = eventHandler;

    }

    public void tick(){
        eventHandler.excecuteAtions(TIME);
        TIME++;
        coinSpawnTimer++;
        spawnCoin(75);

        ///LEVELS
        if(TIME == 1){
            HUD.LEVEL = 1;
            eventHandler.addAction(10, new AddBasicEnemy(handler, enemyHUD, 5));
        }
        if(TIME == 1000){
            eventHandler.addAction(1001, new EnterShop(handler, 2));
            eventHandler.addAction(1010, new AddBasicEnemy(handler, enemyHUD, 10));
            eventHandler.addAction(1100, new AddFastEnemy(handler, enemyHUD, 5));
        }
        if(TIME == 2000){
            eventHandler.addAction(2001, new EnterShop(handler, 3));
            eventHandler.addAction(2010, new AddBasicEnemy(handler, enemyHUD, 10));
            eventHandler.addAction(2100, new AddFastEnemy(handler, enemyHUD, 5));
            eventHandler.addAction(2200, new AddIntelligentEnemy(handler, enemyHUD, 2));
        }
        if(TIME == 3000){
            eventHandler.addAction(3001, new EnterShop(handler, 4));
            eventHandler.addAction(3010, new AddBasicEnemy(handler, enemyHUD, 10));
            eventHandler.addAction(3100, new AddFastEnemy(handler, enemyHUD, 5));
            eventHandler.addAction(3200, new AddIntelligentEnemy(handler, enemyHUD, 2));
            eventHandler.addAction(3300, new AddIntelligentShootingEnemy(handler, enemyHUD, 1));
        }
        if(TIME == 4000){
            eventHandler.addAction(4001, new EnterShop(handler, 5));
            eventHandler.addAction(4005, new AddBossEnemy(handler, enemyHUD, 20, 5));
        }
        if(TIME == 5000){
            eventHandler.addAction(5001, new EnterShop(handler, 6));
            eventHandler.addAction(5010, new AddBasicEnemy(handler, enemyHUD, 15));
            eventHandler.addAction(5100, new AddFastEnemy(handler, enemyHUD, 7));
            eventHandler.addAction(5200, new AddIntelligentEnemy(handler, enemyHUD, 4));
            eventHandler.addAction(5300, new AddIntelligentShootingEnemy(handler, enemyHUD, 3));
        }
        if(TIME == 6000){
            eventHandler.addAction(6001, new EnterShop(handler, 7));
            eventHandler.addAction(6010, new AddBasicEnemy(handler, enemyHUD, 17));
            eventHandler.addAction(6100, new AddFastEnemy(handler, enemyHUD, 8));
            eventHandler.addAction(6200, new AddIntelligentEnemy(handler, enemyHUD, 5));
            eventHandler.addAction(6300, new AddIntelligentShootingEnemy(handler, enemyHUD, 4));
        }
        if(TIME == 7000){
            eventHandler.addAction(7001, new EnterShop(handler, 8));
            eventHandler.addAction(7010, new AddBasicEnemy(handler, enemyHUD, 20));
            eventHandler.addAction(7100, new AddFastEnemy(handler, enemyHUD, 8));
            eventHandler.addAction(7200, new AddIntelligentEnemy(handler, enemyHUD, 7));
            eventHandler.addAction(7300, new AddIntelligentShootingEnemy(handler, enemyHUD, 5));
        }
        if(TIME == 8000){
            eventHandler.addAction(8001, new EnterShop(handler, 9));
            eventHandler.addAction(8010, new AddBasicEnemy(handler, enemyHUD, 22));
            eventHandler.addAction(8100, new AddFastEnemy(handler, enemyHUD, 10));
            eventHandler.addAction(8200, new AddIntelligentEnemy(handler, enemyHUD, 10));
            eventHandler.addAction(8300, new AddIntelligentShootingEnemy(handler, enemyHUD, 10));
        }
        if(TIME == 9000){
            eventHandler.addAction(9001, new EnterShop(handler, 10));
            eventHandler.addAction(9005, new AddBossEnemy(handler, enemyHUD, 100, 2));
        }

    }

    private void spawnCoin(int time){ //SPAWNINAM COINS
        Random r = new Random();
        if(coinSpawnTimer == time){
            handler.addObject(new Coin(r.nextInt(900), r.nextInt(800), ID.Coin, handler));
            coinSpawnTimer = 0;
        }
    }

}