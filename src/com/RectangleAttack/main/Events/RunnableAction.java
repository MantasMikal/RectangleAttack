package com.RectangleAttack.main.Events;

class RunnableAction extends BaseAction{
    private Runnable runnable;

    RunnableAction(int time, Runnable runnable){
        super(time); //Paveldim laika
        this.runnable = runnable;
    }

    @Override
    public void run(){
        runnable.run();
    } //Vykdom
}
