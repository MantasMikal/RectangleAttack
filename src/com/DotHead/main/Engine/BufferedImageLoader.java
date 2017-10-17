package com.DotHead.main.Engine;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class BufferedImageLoader{
    private BufferedImage image;

    public BufferedImage loadimage(String path){
        try{
            image = ImageIO.read(getClass().getResource(path)); //gauna img
        } catch(IOException e){
            e.printStackTrace();
        }
        return image;
    }
}
