package com.DotHead.main.LevelConstruction;

import com.DotHead.main.Engine.Handler;
import com.DotHead.main.Game;
import com.DotHead.main.Object.UI.HUD;

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
