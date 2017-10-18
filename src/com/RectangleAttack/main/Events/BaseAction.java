package com.RectangleAttack.main.Events;

abstract class BaseAction implements Action{
    private int time;

    BaseAction(int time){
        this.time = time;

    }

    @Override
    public int getTime(){
        return this.time;
    } //Duodam laika

}
