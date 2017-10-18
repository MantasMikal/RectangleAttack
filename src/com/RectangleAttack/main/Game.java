package com.RectangleAttack.main;

import com.RectangleAttack.main.Engine.*;
import com.RectangleAttack.main.Engine.Window;
import com.RectangleAttack.main.Events.EventHandler;
import com.RectangleAttack.main.LevelConstruction.Levels;
import com.RectangleAttack.main.Object.ID;
import com.RectangleAttack.main.Object.Particle;
import com.RectangleAttack.main.Object.UI.EnemyHUD;
import com.RectangleAttack.main.Object.UI.HUD;
import com.RectangleAttack.main.Object.UI.Shop;
import com.RectangleAttack.main.Object.UI.Menu;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game extends Canvas implements Runnable{
    public static Game.STATE gameState = STATE.Menu;
    public static BufferedImage sprite_sheet;
    public static boolean paused = false;

    private Thread thread;
    private boolean running;
    private Handler handler;
    private HUD hud;
    private Levels levels;
    private Menu menu;
    private Shop shop;
    private EnemyHUD enemyHUD;
    private Shooting shooting;
    private EventHandler eventHandler;

    public Game(){
        this.handler = new Handler();
        this.menu = new Menu(this.handler);
        this.hud = new HUD();
        this.shop = new Shop();
        this.enemyHUD = new EnemyHUD();
        this.shooting = new Shooting(handler);
        this.addMouseListener(this.shooting);
        this.addMouseMotionListener(this.shooting);
        this.addMouseListener(this.menu);
        this.addMouseListener(this.shop);
        this.addKeyListener(new Input(this.handler));
        this.addKeyListener(this.shooting);
        this.eventHandler = new EventHandler();

        //MUSIC SWITCH
        //AudioPlayer.load();
        //AudioPlayer.getMusic("music").loop();

        //SPRITES
        BufferedImageLoader loader = new BufferedImageLoader();
        sprite_sheet = loader.loadimage("/guste_Boss.png");

        new Window(1024, 768, "RectangleAttack", this);

        this.levels = new Levels(this.handler, enemyHUD, eventHandler);

    }

    public static float clamp(float var, float min, float max){
        return var >= max ? max : (var <= min ? min : var);
    }

    public static void main(String[] args){
        new Game();
    }

    public synchronized void start(){
        this.thread = new Thread(this);
        this.thread.start();
        this.running = true;
    }

    private synchronized void stop(){
        try{
            this.thread.join();
            this.running = false;
        } catch(Exception var2){
            var2.printStackTrace();
        }

    }

    public void run(){
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0D;
        double ns = 1.0E9D / amountOfTicks;
        double delta = 0.0D;
        long timer = System.currentTimeMillis();
        int frames = 0;

        while(this.running){
            long now = System.nanoTime();
            delta += (double) (now - lastTime) / ns;

            for(lastTime = now; delta >= 1.0D; --delta){
                this.tick();
            }

            if(this.running){
                this.render();
            }

            ++frames;
            if(System.currentTimeMillis() - timer > 1000L){
                timer += 1000L;
                System.out.println(frames);
                frames = 0;
            }
        }

        this.stop();
    }

    private void tick(){
        if(!paused){
            if(gameState == Game.STATE.Game){

                this.hud.tick();
                this.levels.tick();
                this.handler.tick();
                this.enemyHUD.tick();
                this.shooting.tick();
                //GAME OVER
                if(HUD.HEALTH <= 0){
                    handler.removeObjects();
                    gameState = STATE.GameOver;

                    HUD.reset(); //RESETS STATS

                    for(int i = 0; i < 20; i++){
                        this.handler.addObject(new Particle(1 + (int) (Math.random() * 1000.0D), 1 + (int) (Math
                                .random() * 1000.0D), ID.Particle));
                    }
                }
            } else if(gameState == Game.STATE.Menu || gameState == STATE.Help || gameState == STATE.GameOver){
                this.menu.tick();
                this.handler.tick();

                //SHOP MODE
            } else if(gameState == STATE.Shop){
                this.shop.tick();
                this.handler.tick();

            }

        }
    }

    private void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            this.createBufferStrategy(3);
        } else{
            Graphics2D g = (Graphics2D) bs.getDrawGraphics();
            //g.scale(1, 1);
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, 1024, 768);

            if(paused){
                g.setColor(Color.black);
                g.drawString("PAUSE", 505, 205);
            }
            if(gameState == Game.STATE.Game){
               // System.out.println("GAME STATE");
                this.hud.render(g);
                this.handler.render(g);
                this.enemyHUD.render(g);

            } else if(gameState == Game.STATE.Menu || gameState == STATE.Help || gameState == STATE.GameOver){
                this.menu.render(g);
                this.handler.render(g);
                //System.out.println("MENU STATE");
            } else if(gameState == Game.STATE.Shop){
                paused = true;

               // System.out.println("SHOP STATE");

                this.handler.render(g);
                g.setColor(Color.WHITE);
                g.fillRect(0, 0, 1024, 768);

                this.shop.render(g);
                this.hud.render(g);
            }

            g.dispose();
            bs.show();
        }
    }

    public enum STATE{
        Menu,
        Game,
        Help,
        GameOver,
        Shop
    }


}
