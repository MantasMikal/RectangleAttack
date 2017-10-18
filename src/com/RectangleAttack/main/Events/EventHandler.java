package com.RectangleAttack.main.Events;

import java.util.Iterator;
import java.util.LinkedList;


public class EventHandler{

    private LinkedList<Action> actions = new LinkedList<>();

    private void addAction(Action action){ //Naujas veiksmas
    actions.add(action);
    }

    public void excecuteAtions(int time){ //Ivykdom veiksmus

        Iterator<Action> iterator = actions.iterator();
        while(iterator.hasNext()){
            Action action = iterator.next();
            if(action.getTime() == time){ //Palyginam, jei zjbys, tai vykdom
                action.run();
                iterator.remove(); //Istrinam, kad nesikartotu
            }

        }
    }
    public void addAction(int time, Runnable runnable) {
        addAction(new RunnableAction(time, runnable));
    }


}
