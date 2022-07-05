package main.gameObjects;

import main.Game;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;

public class FastEnemy extends GameObject {

    public static final int FAST_ENEMY_SIZE = 12;

    private Handler handler;

    public FastEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        velX = 4;
        velY = 10;
    }

    @Override
    public void tick() {
        this.x += this.velX;
        this.y += this.velY;

        if (y <= 0 || y >= Game.HEIGHT - FAST_ENEMY_SIZE)
            velY *= -1;
        if (x <= 0 || x >= Game.WIDTH - FAST_ENEMY_SIZE)
            velX *= -1;

        handler.addObject(new Trail(x, y, ID.Trail, handler, Color.pink, FAST_ENEMY_SIZE, FAST_ENEMY_SIZE, 0.02f));
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.pink);
        g.fillRect((int) x, (int) y, FAST_ENEMY_SIZE, FAST_ENEMY_SIZE);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, FAST_ENEMY_SIZE, FAST_ENEMY_SIZE);
    }
}
