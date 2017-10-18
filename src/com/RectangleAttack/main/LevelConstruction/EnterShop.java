package com.RectangleAttack.main.LevelConstruction;

import com.RectangleAttack.main.Engine.Handler;
import com.RectangleAttack.main.Game;
import com.RectangleAttack.main.Object.UI.HUD;

class EnterShop implements Runnable{
    private Handler handler;
    private int setLevel;

    EnterShop(Handler handler, int setLevel){
        this.handler = handler;
        this.setLevel = setLevel;
    }

    @Override
    public void run(){
        handler.removeObjectsExceptPlayer();
        HUD.LEVEL = setLevel;
        Game.gameState = Game.STATE.Shop;
    }
}
