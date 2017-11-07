package model.shapeFactory;


import java.awt.*;
import java.util.ArrayList;
import java.util.List;

abstract class Shape implements IShape{

    private List<int [][]> shapes = new ArrayList<>();
    private int rotateIndex = 0;

    private int[][] currentRot;

    private Point pos = new Point();

    private int rightSideIndex;
    private int leftSideIndex;
    private int bottomSideIndex;

    public Shape(){
        this.initializeShapes();
        this.currentRot = shapes.get(this.rotateIndex);
    }

    public void initializeShapes(){
        shapes.add(new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 1, 1, 1},
                {0, 0, 0, 0}
        });
        shapes.add(new int[][]{
                {0, 1, 0, 0},
                {0, 1, 0, 0},
                {0, 1, 0, 0},
                {0, 1, 0, 0}
        });
        this.currentRot = shapes.get(0);
        this.rightSideIndex = setRightSideIndex();
        this.leftSideIndex = setLeftSideIndex();
        this.bottomSideIndex = setBottomSideIndex();
    }
    public Shape createSquare(){

        pos.x = 5;
        pos.y = 0;
        return this;
    }
    public void rotate(){
        if(rotateIndex == shapes.size()-1){
            rotateIndex = 0;
        }else{
            rotateIndex++;
        }
        currentRot = shapes.get(rotateIndex);

        this.rightSideIndex = setRightSideIndex();
        this.leftSideIndex = setLeftSideIndex();
        this.bottomSideIndex = setBottomSideIndex();
    }
    public int getRightSideIndex(){
        return rightSideIndex;
    }
    public int getLeftSideIndex(){
        return leftSideIndex;
    }
    public int getBottomSideIndex(){
        return bottomSideIndex;
    }
    private int setRightSideIndex(){
        int rightSide = 0;
        for(int i = 0; i < currentRot.length; i++){
            for(int j = 0; j < currentRot[i].length; j++){
                if(currentRot[i][j] == 1 && rightSide < j){
                    rightSide = j;
                }
            }
        }
        return rightSide;
    }
    private int setLeftSideIndex(){
        int leftSide = 3;
        for(int i = 0; i < currentRot.length; i++){
            for(int j = currentRot[i].length-1; j >= 0; j--){
                if(currentRot[i][j] == 1 && leftSide > j){
                    leftSide = j;
                }
            }
        }
        return leftSide;
    }
    private int setBottomSideIndex(){
        int bottomSide = -1;
        for(int i = 0; i < currentRot.length; i++){
            for(int j = 0; j < currentRot[i].length; j++){
                if(currentRot[i][j] == 1 && bottomSide < i){
                    bottomSide = i;
                }
            }
        }
        return bottomSide;
    }

    public Point getPosition(){
        return pos;
    }

    public int[][] getCurrentRotation(){
        return currentRot;
    }

}
