package model;


import model.shapeFactory.ShapeFactory;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Shape{

    private List<int [][]> shapes = new ArrayList<>();
    private int rotateIndex = 0;

    private int[][] currentRot;

    private Point pos = new Point();

    private int rightSideIndex;
    private int leftSideIndex;
    private int bottomSideIndex;

    private Map<String, int[]> bottomPositions = new HashMap<>();

    public Shape(ShapeFactory shapeFactory){
        this.initializeShapes(shapeFactory);
        this.currentRot = shapes.get(this.rotateIndex);
    }

    public void initializeShapes(ShapeFactory shapeFactory){

        shapes = shapeFactory.getShapeDrawings().getDrawings();

        this.currentRot = shapes.get(0);
        setBottomPieces(this.currentRot);
        this.rightSideIndex = setRightSideIndex();
        this.leftSideIndex = setLeftSideIndex();
        this.bottomSideIndex = setBottomSideIndex();
    }
    public Shape createShape(){

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
        bottomPositions.clear();
        setBottomPieces(currentRot);

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
    public Map<String, int []> getBottomPieces(){
        return bottomPositions;
    }
    private void setBottomPieces(int[][] rotation){

        // Easier collision detection to other pieces.

        for(int i = 0; i < rotation.length; i++){
            for(int j = 0; j < rotation[i].length; j++){
                if(rotation[i][j] != 0 ){
                    if(i == rotation.length - 1){
                        bottomPositions.put("pos" + i+j, new int[] {i,j});
                    }
                    for(int k = 3; k > i ; k--){
                        if (rotation[i+1][j] != 0) {
                        }else {
                            bottomPositions.put("pos" + i+j, new int[] {i,j});
                        }
                    }
                }
            }
        }
    }
    private int setRightSideIndex(){
        int rightSide = 0;
        for(int i = 0; i < currentRot.length; i++){
            for(int j = 0; j < currentRot[i].length; j++){
                if(currentRot[i][j] != 0 && rightSide < j){
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
                if(currentRot[i][j] != 0 && leftSide > j){
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
                if(currentRot[i][j] != 0 && bottomSide < i){
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
