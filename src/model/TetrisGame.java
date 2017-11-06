package model;

import javafx.animation.AnimationTimer;

public class TetrisGame {

    AnimationTimer loop;
    ShapeFactory shapeFactory;
    Board board;

    public TetrisGame(){

        this.board = new Board();

        this.shapeFactory = new ShapeFactory(this.board);

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
                    //board.updateBoard();
                    shapeFactory.moveCurrentDown();
                    lastUpdate = now;
                }

            }
        };
    }
    public void moveLeft(){
        if(isMovementValidLeft()){
            Shape current = shapeFactory.getCurrentShape();
            current.getPosition().x -= 1;
            shapeFactory.getSub().draw(this.board.getBoard());
        }

    }
    public void moveRight(){
        if(isMovementValidRight()){
            Shape current = shapeFactory.getCurrentShape();
            current.getPosition().x += 1;
            shapeFactory.getSub().draw(this.board.getBoard());
        }

    }

    // Fix this, it needs to check for the boxes.
    // Create function in shape that gets the indexes from the sides.
    public boolean isMovementValidRight(){
        return shapeFactory.getCurrentShape().getPosition().x + shapeFactory.getCurrentShape()
                .getRightSideIndex() < 11;
    }
    public boolean isMovementValidLeft(){
        return shapeFactory.getCurrentShape().getPosition().x + shapeFactory.getCurrentShape()
                .getLeftSideIndex() > 2;
    }
}
