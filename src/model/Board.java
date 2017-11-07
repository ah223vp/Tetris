package model;

import model.shapeFactory.Shape;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

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
    public boolean updateBoard(ArrayList<model.shapeFactory.Shape> objects, model.shapeFactory.Shape shape){



        // Moving the shape down every frame.
        shape.getPosition().y +=1;

        for(int i = 0; i < shape.getCurrentRotation().length; i++ ){
            for (int j = 0; j < shape.getCurrentRotation()[i].length; j++){
                if (shape.getCurrentRotation()[i][j] == 1){
                    this.board[shape.getPosition().y + i][shape.getPosition().x + j] = 1;
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
                        if (this.previousShapeRotation[i][j] == 1){
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
                if(this.board[i][j] == 1){
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
            System.out.println("Tror den är i botten av boarden");
            return true;
        }

        for(int i = 0; i < 4; i++){
            if(current.getCurrentRotation()[current.getBottomSideIndex()][i] == 1
                    && getBoard()[bottomTempIndex + 1][current.getPosition().x + i] == 1){


                System.out.println("Tror att den är på en piece");
                System.out.println(bottomTempIndex);
                System.out.println(getBoard()[bottomTempIndex + 1][current.getPosition().x + i]);
                for(int j = 0; j < current.getCurrentRotation().length; j++){
                    System.out.println(Arrays.toString(current.getCurrentRotation()[j]));
                }
                System.out.println();
                System.out.println();
                System.out.println();

                // Debugging
                for(int j = 0; j < this.board.length; j++){
                    System.out.println(Arrays.toString(this.board[j]));
                }
                System.out.println();
                System.out.println();
                System.out.println();
                return true;
            }

        }
        return false;
    }
    public void drawBoard(){
        sub.draw(this.board);
    }

}
