package main.input;

import main.gameObjects.GameObject;
import main.gameObjects.Handler;
import main.gameObjects.ID;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * This class manages the keyboard inputs such as movements of the player etc...
 */

public class KeyInput extends KeyAdapter {

    private Handler handler;

    public KeyInput(Handler handler) {
        this.handler = handler;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handler.getObjects().size(); i++) {
            GameObject tempObject = handler.getObjects().get(i);
            if (tempObject.getID() == ID.Player) {
                // key event for player
                if (key == KeyEvent.VK_Z)
                    tempObject.setVelY(-5);
                if (key == KeyEvent.VK_S)
                    tempObject.setVelY(5);
                if (key == KeyEvent.VK_Q)
                    tempObject.setVelX(-5);
                if (key == KeyEvent.VK_D)
                    tempObject.setVelX(5);
            }
        }

        if (key == KeyEvent.VK_ESCAPE)
            System.exit(1);
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handler.getObjects().size(); i++) {
            GameObject tempObject = handler.getObjects().get(i);
            if (tempObject.getID() == ID.Player) {
                // key event for player
                if (key == KeyEvent.VK_Z)
                    tempObject.setVelY(0);
                if (key == KeyEvent.VK_S)
                    tempObject.setVelY(0);
                if (key == KeyEvent.VK_Q)
                    tempObject.setVelX(0);
                if (key == KeyEvent.VK_D)
                    tempObject.setVelX(0);
            }
        }
    }
}
