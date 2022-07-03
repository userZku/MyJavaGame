package main.gameObjects;

import main.Game;

import java.awt.Graphics;
import java.awt.Color;

public class BasicEnemy extends GameObject {

    public BasicEnemy(int x, int y, ID id) {
        super(x, y, id);

        velX = 5;
        velY = 5;
    }

    @Override
    public void tick() {
        this.x += velX;
        this.y += velY;

        if (y <= 0 || y >= Game.HEIGHT - 16)
            velY *= -1;
        if (x <= 0 || x >= Game.WIDTH - 16)
            velX *= -1;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(x, y, 12, 12);
    }

}
