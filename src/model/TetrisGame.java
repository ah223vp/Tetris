package model;

import javafx.animation.AnimationTimer;

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
        this.shapeControl.createShape();
    }
    private void gameLoop(){
        loop = new AnimationTimer(){
            long lastUpdate = 0;

            @Override
            public void handle(long now) {
                // Framerate
                if(now - lastUpdate >= 100_000_000){
                    //board.updateBoard();
                    shapeControl.moveCurrentDown();
                    lastUpdate = now;
                }
            }
        };
    }
    public void rotatePiece(){
        shapeControl.rotate();

    }
    public void moveLeft(){
        shapeControl.moveLeft();


    }
    public void moveRight(){
        shapeControl.moveRight();

    }




}
