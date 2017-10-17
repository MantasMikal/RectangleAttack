//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.DotHead.main.Engine;

import com.DotHead.main.Object.GameObject;
import com.DotHead.main.Object.ID;

import java.awt.*;
import java.util.LinkedList;

public class Handler{
    public LinkedList<GameObject> objects = new LinkedList<>(); //Cia saugom objektus

    public Handler(){
        //
    }

    public void tick(){
        for(int i = 0; i < this.objects.size(); ++i){ //NEGALIMA KEISTI I FOREACH
            GameObject tempObject = this.objects.get(i);
            tempObject.tick();
            if(objects.get(i).isDead()) objects.remove(i);
        }
    }

    public void render(Graphics g){
        LinkedList<GameObject> objects1 = this.objects;
        for(int i = 0; i < objects1.size(); i++){ //NEGALIMA KEISTI I FOREACH
            GameObject tempObject = objects1.get(i);
            tempObject.render(g);
        }

    }

    public GameObject getObject(ID id){ //Lengvai gauna objekta pagal ID

        for(GameObject object : objects){
            if(object.getId() == id){
                return object;
            }
        }
        return null;
    }

    public void addObject(GameObject o){
        this.objects.add(o);
    }

    public void removeObjects(){
        objects.clear();
        //System.out.println("OBJECTS REMOVED");
    }

    public void removeObject(GameObject o){
        this.objects.remove(o);
    } //Neoptimalu

    public void removeObjectsExceptPlayer(){ //Trinam viska, bet paliekam Player'i. Idomu ar po player'io istrynimio,
        // jo id pasidaro 0?
        for(int i = 0; i < objects.size(); i++){
            if(objects.get(i).getId() != ID.Player){
                objects.get(i).setDead(true);

            }
        }
    }
}
