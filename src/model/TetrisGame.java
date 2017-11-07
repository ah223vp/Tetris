package model;

import javafx.animation.AnimationTimer;
import model.shapeFactory.Shape;

public class TetrisGame {

    private AnimationTimer loop;
    private ShapeControl shapeControl;
    private Board board;

    public TetrisGame(){

        this.board = new Board();
        this.shapeControl = new ShapeControl(this.board);

        gameLoop();
    }
    public ShapeControl getFactory(){
        return this.shapeControl;
    }
    public void start(){
        this.loop.start();
        this.shapeControl.createSquare();
    }
    private void gameLoop(){
        loop = new AnimationTimer(){
            long lastUpdate = 0;

            @Override
            public void handle(long now) {
                // Framerate
                if(now - lastUpdate >= 500_000_000){
                    //board.updateBoard();
                    shapeControl.moveCurrentDown();
                    lastUpdate = now;
                }
            }
        };
    }
    public void rotatePiece(){
        shapeControl.getCurrentShape().rotate();
        shapeControl.getSub().draw(this.board.getBoard());
    }
    public void moveLeft(){
        if(isMovementValidLeft()){
            Shape current = shapeControl.getCurrentShape();
            current.getPosition().x -= 1;
            shapeControl.getSub().draw(this.board.getBoard());
        }

    }
    public void moveRight(){
        if(isMovementValidRight()){
            Shape current = shapeControl.getCurrentShape();
            current.getPosition().x += 1;
            shapeControl.getSub().draw(this.board.getBoard());
        }
    }

    // Fix this, it needs to check for the boxes.
    // Check valid rotations aswell.
    public boolean isMovementValidRight(){
        return shapeControl.getCurrentShape().getPosition().x + shapeControl.getCurrentShape()
                .getRightSideIndex() < 11;
    }
    public boolean isMovementValidLeft(){
        return shapeControl.getCurrentShape().getPosition().x + shapeControl.getCurrentShape()
                .getLeftSideIndex() > 2;
    }
}
