package main;

import main.gameObjects.BasicEnemy;
import main.gameObjects.Handler;
import main.gameObjects.ID;
import main.gameObjects.Player;
import main.gameObjects.Spawner;
import main.gui.Window;
import main.gui.HUD;
import main.input.KeyInput;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = 1L;

    public static final int WIDTH = 1280, HEIGHT = WIDTH / 16 * 9;

    private Thread thread;
    private boolean running = false;
    private Handler handler;
    private HUD hud;
    private Spawner spawner;

    public Game() {
        handler = new Handler();
        this.addKeyListener(new KeyInput(handler));
        new Window(WIDTH, HEIGHT, "My Java Game", this);
        hud = new HUD();
        spawner = new Spawner(handler, hud);

        handler.addObject(
                new Player(WIDTH / 2 - Player.PLAYER_SIZE, HEIGHT / 2 - Player.PLAYER_SIZE, ID.Player, handler));
    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Game Loop
     */
    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0.0;
        long timer = System.currentTimeMillis();
        int frames = 0;

        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick(); // update via handler
                delta--;
            }
            if (running) {
                render(); // display via handler
            }
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    private void tick() {
        handler.tick();
        hud.tick();
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3); // ???
            return;
        }

        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        handler.render(g); // dislay all objects
        hud.render(g);

        g.dispose();
        bs.show();
    }

    public static void main(String args[]) {
        new Game();
    }
}
