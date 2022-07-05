package main.gameObjects;

import main.Game;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;

public class SmartEnemy extends GameObject {

    public static final int SMART_ENEMY_SIZE = 16;

    private Handler handler;
    private GameObject player;
    private float diffX;
    private float diffY;

    public SmartEnemy(float x, float y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;

        for (int i = 0; i < handler.objects.size(); i++) {
            if (handler.objects.get(i).getID() == ID.Player)
                player = handler.objects.get(i);
        }

        velX = 5;
        velY = 5;
    }

    @Override
    public void tick() {
        this.x += this.velX;
        this.y += this.velY;

        diffX = this.x - player.getX();
        diffY = this.y - player.getY();

        float distance = (float) Math
                .sqrt((x - player.getX()) * (x - player.getX()) + (y - player.getY()) * (y - player.getY()));

        velX = ((-1 / distance) * diffX);
        velY = ((-1 / distance) * diffY);

        // if (y <= 0 || y >= Game.HEIGHT - SMART_ENEMY_SIZE)
        // velY *= -1;
        // if (x <= 0 || x >= Game.WIDTH - SMART_ENEMY_SIZE)
        // velX *= -1;

        handler.addObject(new Trail(x, y, ID.Trail, handler, Color.green, SMART_ENEMY_SIZE, SMART_ENEMY_SIZE, 0.02f));
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.green);
        g.fillRect((int) x, (int) y, SMART_ENEMY_SIZE, SMART_ENEMY_SIZE);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, SMART_ENEMY_SIZE, SMART_ENEMY_SIZE);
    }
}
