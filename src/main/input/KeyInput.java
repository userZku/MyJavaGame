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
    private boolean[] keyDown = new boolean[4];
    private float PLAYER_SPEED = 7;

    public KeyInput(Handler handler) {
        this.handler = handler;
        keyDown[0] = false;
        keyDown[1] = false;
        keyDown[2] = false;
        keyDown[3] = false;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handler.getObjects().size(); i++) {
            GameObject tempObject = handler.getObjects().get(i);
            if (tempObject.getID() == ID.Player) {
                // key event for player
                if (key == KeyEvent.VK_Z) {
                    tempObject.setVelY(-PLAYER_SPEED);
                    keyDown[0] = true;
                }
                if (key == KeyEvent.VK_S) {
                    tempObject.setVelY(PLAYER_SPEED);
                    keyDown[1] = true;
                }
                if (key == KeyEvent.VK_Q) {
                    tempObject.setVelX(-PLAYER_SPEED);
                    keyDown[2] = true;
                }
                if (key == KeyEvent.VK_D) {
                    tempObject.setVelX(PLAYER_SPEED);
                    keyDown[3] = true;
                }
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
                    keyDown[0] = false;
                if (key == KeyEvent.VK_S)
                    keyDown[1] = false;
                if (key == KeyEvent.VK_Q)
                    keyDown[2] = false;
                if (key == KeyEvent.VK_D)
                    keyDown[3] = false;
                if (!keyDown[0] && !keyDown[1])
                    tempObject.setVelY(0);
                if (!keyDown[2] && !keyDown[3])
                    tempObject.setVelX(0);
            }
        }
    }
}
