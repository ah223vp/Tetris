package model;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Board {

    private int[][] board;

    private IObserver sub;

    private int [][] previousShapeRotation;
    private int [][] currentShapeRotation;
    private Point previousPosition;

    public Board(){

        // Creating board, could be done with loop aswell.
        // Like this for visual thinking.
        board = new int[][]{
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0}

        };
    }
    public void addSubscriber(IObserver sub){
        this.sub = sub;
    }
    public int[][] getBoard(){
        return this.board;
    }
    public boolean updateBoard(Shape shape){

        // Moving the shape down every frame.
        shape.getPosition().y +=1;

        for(int i = 0; i < shape.getCurrentRotation().length; i++ ){
            for (int j = 0; j < shape.getCurrentRotation()[i].length; j++){
                if (shape.getCurrentRotation()[i][j] != 0){
                    this.board[shape.getPosition().y + i][shape.getPosition().x + j]
                            = shape.getCurrentRotation()[i][j] ;
                }
            }
        }
        drawBoard();

        this.previousShapeRotation = shape.getCurrentRotation().clone();
        this.previousPosition = (Point)shape.getPosition().clone();

        if(shapeIsAtBottom(shape)){
            this.previousPosition = null;
            this.previousShapeRotation = null;
            checkCompleteRow();
            return false;
        }else {
            if(this.previousPosition != null){
                for(int i = 0; i < this.previousShapeRotation.length; i++ ){
                    for (int j = 0; j < this.previousShapeRotation[i].length; j++){
                        if (this.previousShapeRotation[i][j] != 0){
                            this.board[this.previousPosition.y + i][this.previousPosition.x + j] = 0;
                        }
                    }
                }
            }
        }
        return true;
    }

    public void deleteRow(int row){
        System.out.println("Delete row: " + row);

        for(int i = 0; i < this.board[row].length; i++){
            this.board[row][i] = 0;
        }
        for (int i = row; i > 0; i--){
            for(int j = 0; j < this.board[i].length; j++){
                this.board[i][j] = this.board[i-1][j];
            }
        }
    }
    public void checkCompleteRow(){
        for(int i = 0; i < this.board.length; i++){
            int checker = 0;
            for(int j = 0; j < this.board[i].length; j++){
                if(this.board[i][j] != 0){
                    checker++;
                }
            }
            // Means a row is full.
            if(checker == 10){
                deleteRow(i);
            }
        }
    }
    public boolean shapeIsAtBottom(Shape current){
        int bottomTempIndex = current.getBottomSideIndex() + current.getPosition().y;

        if(bottomTempIndex >= 26){
            return true;
        }

        currentShapeRotation = current.getCurrentRotation();


        for(int[] pos : current.getBottomPieces().values()){
            System.out.println(pos[0]+ ", " +pos[1]);
            for(int i = 0; i < current.getBottomPieces().size(); i++){
                /*
                if(current.getCurrentRotation()[pos[0]][pos[1]] != 0
                        && getBoard()[bottomTempIndex + 1][current.getPosition().x + i] != 0){
                    //System.out.println("At bottom");

                    return true;
                }*/

                // Working maybe=!=!
                if(getBoard()[current.getPosition().y + pos[0] +1][current.getPosition().x + pos[1]] != 0){
                    return true;
                }
            }
        }
        System.out.println("--------------------");

        return false;
    }
    public void drawBoard(){
        sub.draw(this.board);
    }

}
