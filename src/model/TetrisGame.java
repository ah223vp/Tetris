package model;

import javafx.animation.AnimationTimer;

public class TetrisGame {

    AnimationTimer loop;
    ShapeFactory shapeFactory;

    public TetrisGame(){
        this.shapeFactory = new ShapeFactory();
        gameLoop();
    }
    public ShapeFactory getFactory(){
        return this.shapeFactory;
    }
    public void start(){
        this.loop.start();
        this.shapeFactory.createSquare();
    }
    private void gameLoop(){
        loop = new AnimationTimer(){
            long lastUpdate = 0;

            @Override
            public void handle(long now) {
                // Framerate
                if(now - lastUpdate >= 500_000_000){
                    shapeFactory.moveCurrentDown();
                    lastUpdate = now;
                }

            }
        };
    }
    public void moveLeft(){
        if(isMovementValidLeft()){
            Shape current = shapeFactory.getCurrentShape();
            current.getPosition().x -= 10;
            shapeFactory.getSub().draw();
        }

    }
    public void moveRight(){
        if(isMovementValidRight()){
            Shape current = shapeFactory.getCurrentShape();
            current.getPosition().x += 10;
            shapeFactory.getSub().draw();
        }

    }

    // Fix this, it needs to check for the boxes.
    // Create function in shape that gets the indexes from the sides.
    public boolean isMovementValidRight(){
        return shapeFactory.getCurrentShape().getPosition().x <= 200;
    }
    public boolean isMovementValidLeft(){
        return shapeFactory.getCurrentShape().getPosition().x >= 50;
    }
}
