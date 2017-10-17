package com.DotHead.main.Engine;

import java.awt.image.BufferedImage;

public class SpriteSheet{
    private BufferedImage sprite;

    public SpriteSheet(BufferedImage bufferedImage){
        this.sprite = bufferedImage;
    }

    public BufferedImage grabImage(int col, int row, int width, int height){
        return sprite.getSubimage((row * 128) - 128, (col * 128) - 128, width, height);
    }
}
