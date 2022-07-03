package main.gameObjects;

import java.awt.Graphics;
import java.awt.Color;

/**
 * This class implementes a player
 */

public class Player extends GameObject {

    public Player(int x, int y, ID id) {
        super(x, y, id);
    }

    @Override
    public void tick() {
        this.x += velX;
        this.y += velY;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x, y, 32, 32);
    }
}
