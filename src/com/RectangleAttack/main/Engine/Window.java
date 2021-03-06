//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.RectangleAttack.main.Engine;

import com.RectangleAttack.main.Game;

import javax.swing.*;
import java.awt.*;

public class Window extends Canvas{ //KURIAM LANGA
    public Window(int width, int height, String title, Game game){
        JFrame frame = new JFrame(title);
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);
        frame.setFocusable(true);
        game.start();
    }
}
