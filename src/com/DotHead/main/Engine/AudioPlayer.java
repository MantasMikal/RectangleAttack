package com.DotHead.main.Engine;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

import java.util.HashMap;
import java.util.Map;

public class AudioPlayer{

    public static Map<String, Sound> soundMap = new HashMap<>(); // PASPAUDIMO GARSAS
    private static Map<String, Music> musicMap = new HashMap<>(); //PADARIAU PRIVATE

    public static void load(){
        try{
            musicMap.put("music", new Music("Resources/bcgr.ogg")); //Užkrauna
        } catch(SlickException e){
            e.printStackTrace();
        }
    }

    public static Music getMusic(String key){
        return musicMap.get(key);
    }

}
