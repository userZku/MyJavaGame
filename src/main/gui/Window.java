package main.gui;

import main.Game;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

/**
 * This class provides the window wich we see and display the game in
 * (and start it)
 */

public class Window extends Canvas {

    private static final long serialVersionUID = 4L;

    public Window(int width, int height, String title, Game game) {
        // JFrame frame = new JFrame(title);
        // frame.setPreferredSize(new Dimension(width, height));
        // frame.setMaximumSize(new Dimension(width, height));
        // frame.setMinimumSize(new Dimension(width, height));
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.setResizable(false);
        // frame.setLocationRelativeTo(null);
        // frame.add(game);
        // frame.setVisible(true);
        // game.start();

        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(game);
        game.setPreferredSize(new Dimension(width, height));
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        game.start();
    }
}
