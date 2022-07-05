package main.gameObjects;

import main.Game;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;

public class BasicEnemy extends GameObject {

    public static final int BASIC_ENEMY_SIZE = 16;

    private Handler handler;

    public BasicEnemy(float x, float y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        velX = 5;
        velY = 5;
    }

    @Override
    public void tick() {
        this.x += this.velX;
        this.y += this.velY;

        if (y <= 0 || y >= Game.HEIGHT - BASIC_ENEMY_SIZE)
            velY *= -1;
        if (x <= 0 || x >= Game.WIDTH - BASIC_ENEMY_SIZE)
            velX *= -1;

        handler.addObject(new Trail(x, y, ID.Trail, handler, Color.red, BASIC_ENEMY_SIZE, BASIC_ENEMY_SIZE, 0.02f));
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect((int) x, (int) y, BASIC_ENEMY_SIZE, BASIC_ENEMY_SIZE);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, BASIC_ENEMY_SIZE, BASIC_ENEMY_SIZE);
    }
}
