package main.gameObjects;

import java.awt.Graphics;

import java.util.LinkedList;

/**
 * This class manages all objects of the game
 * Update -> tick() and Display -> render() objects
 */

public class Handler {

    LinkedList<GameObject> objects = new LinkedList<GameObject>();

    public void tick() {
        for (int i = 0; i < objects.size(); i++) {
            GameObject tempObject = objects.get(i);
            tempObject.tick();
        }
    }

    public void render(Graphics g) {
        for (int i = 0; i < objects.size(); i++) {
            GameObject tempObject = objects.get(i);
            tempObject.render(g);
        }
    }

    public void addObject(GameObject object) {
        this.objects.add(object);
    }

    public void removeObject(GameObject object) {
        this.objects.remove(object);
    }

    public LinkedList<GameObject> getObjects() {
        return this.objects;
    }
}
