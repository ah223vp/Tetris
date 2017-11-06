package model;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Board {

    private int[][] board;

    private IObserver sub;

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
    public void updateBoard(ArrayList<Shape> objects){
        checkCompleteRow();


        // Cahnge this so the board only draws the currentfalling shape.
        // The others pieces are managed and session saved or whatever.


        // Clearing the board each update
        for(int i = 0; i < board.length; i++ ){
            for (int j = 0; j < board[i].length; j++){
                board[i][j] = 0;
            }
        }




        // Drawing the new stuff
        for(Shape s : objects){
            for(int i = 0; i < s.getShape().length; i++ ){
                for (int j = 0; j < s.getShape()[i].length; j++){
                    if(s.getShape()[i][j] == 1){
                        board[s.getPosition().y + i][s.getPosition().x + j] = 1;
                    }
                }
            }
        }

        /*
        // Debugging
        for(int i = 0; i < this.board.length; i++){
            System.out.println(Arrays.toString(this.board[i]));
        }
        System.out.println();
        System.out.println();
        System.out.println();
        */
        drawBoard();

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
    public void drawBoard(){
        sub.draw(this.board);
    }

}
