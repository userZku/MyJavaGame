package main.gameObjects;

import java.awt.Graphics;
import java.awt.Rectangle;

import main.Game;
import main.gui.HUD;
import main.utils.Utils;

import java.awt.Color;

/**
 * This class implementes a player
 */

public class Player extends GameObject {

    public static final int PLAYER_SIZE = 32;

    private Handler handler;

    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
    }

    @Override
    public void tick() {
        this.x += this.velX;
        this.y += this.velY;

        this.x = Utils.clamp(this.x, 0, Game.WIDTH - PLAYER_SIZE);
        this.y = Utils.clamp(this.y, 0, Game.HEIGHT - PLAYER_SIZE);

        handler.addObject(new Trail(x, y, ID.Trail, handler, Color.white, PLAYER_SIZE, PLAYER_SIZE, 0.05f));

        collision();
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x, y, PLAYER_SIZE, PLAYER_SIZE);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, PLAYER_SIZE, PLAYER_SIZE);
    }

    private void collision() {
        for (int i = 0; i < handler.objects.size(); i++) {
            GameObject tempObject = handler.objects.get(i);
            if (tempObject.getID() == ID.BasicEnemy) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    HUD.HEALTH -= 2;
                }
            }
        }
    }
}
