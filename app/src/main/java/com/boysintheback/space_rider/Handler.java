package com.boysintheback.space_rider;

import android.graphics.Canvas;

import java.util.ArrayList;

public class Handler {
    private ArrayList<GameObject> objects = new ArrayList<>();
    private Player playerShip;
    private Score score;

    public Handler(Player spaceship){
        this.playerShip = spaceship;
        this.score = new Score();
    }


    public ArrayList<GameObject> getObjects(){
        return objects;
    }

    public void addObject(GameObject go) {
        objects.add(go);
    }

    public void renderObjects(Canvas c) {
        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).render(c);
        }
        playerShip.render(c);
        score.render(c);
    }

    public void updateScore() {
        score.updateScore();
    }

    public void updateObjects(GamePanel g) {
//        for (GameObject o: objects){
//            if (o.getType().equals("Asteroid") && o.isCollided){
//
//            }
//        }
        for (int i = 0; i < objects.size(); i++) {
            if (objects.get(i).getY() > g.size.y) {
                objects.remove(objects.get(i));
            }
            objects.get(i).update();
        }
    }

    public void updateCurrentStars(int speed) {
        for (int i = 0; i < objects.size(); i++) {
            if (objects.get(i).getType() == "Star") {
                BGStar temp = (BGStar)objects.get(i);
                temp.incSpeed(speed);
            }
        }
    }
}
