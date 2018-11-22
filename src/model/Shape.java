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
    private int[][] nextRotation;
    private Point pos = new Point();
    private int bottomSideIndex;
    private Map<String, int[]> bottomPositions = new HashMap<>();

    public Shape(ShapeFactory shapeFactory){
        this.initia   lizeShapes(shapeFactory);
        this.currentRot = shapes.get(this.rotateIndex)
    }

    public void initializeShapes(ShapeFactory shapeFactory){

        shapes = shapeFactory.getShapeDrawings().getDrawings();

        this.currentRot = shapes.get(0);
        if(shapes.size() == 1){
            this.nextRotation = shapes.get(0);
        }else {
            this.nextRotation = shapes.get(1);
        }

        setBottomPieces(this.currentRot);

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
        if(rotateIndex == shapes.size() - 1){
            nextRotation = shapes.get(0);
        }else {
            nextRotation = shapes.get(rotateIndex+1);
        }

        currentRot = shapes.get(rotateIndex);
        bottomPositions.clear();
        setBottomPieces(currentRot);
        this.bottomSideIndex = setBottomSideIndex();
    }
    public int[][] getNextRotation(){
        return nextRotation;
    }

    public int getBottomSideIndex(){
        return bottomSideIndex;
    }
    public Map<String, int []> getBottomPieces(){
        return bottomPositions;
    }

    public int getRightSideIndex(int[][] rotation){
        int rightSide = 0;
        for(int i = 0; i < rotation.length; i++){
            for(int j = 0; j < rotation[i].length; j++){
                if(rotation[i][j] != 0 && rightSide < j){
                    rightSide = j;
                }
            }
        }
        return rightSide;
    }

    public Map<String, int[]> getRightSidePieces(int [][] rotation){
        Map<String, int[]> map = new HashMap<>();
        // Working
        for(int i = 0; i < rotation.length; i++){
            for(int j = 0; j < rotation[i].length; j++){
                if(rotation[i][j] != 0 ){
                    if(j == rotation.length - 1){
                        map.put("pos" + i+j, new int[] {i,j});
                    }
                    for(int k = 3; k > j ; k--){
                        if (rotation[i][j+1] != 0) {
                        }else {
                            map.put("pos" + i+j, new int[] {i,j});
                        }
                    }
                }
            }
        }
        return map;
    }

    public int getLeftSideIndex(int[][] rotation){
        int leftSide = 3;
        for(int i = 0; i < rotation.length; i++){
            for(int j = rotation[i].length-1; j >= 0; j--){
                if(rotation[i][j] != 0 && leftSide > j){
                    leftSide = j;
                }
            }
        }
        return leftSide;
    }

    public Map<String, int[]> getLeftSidePieces(int[][] rotation){
        Map<String, int[]> map = new HashMap<>();
        for(int i = 0; i < rotation.length; i++){
            for(int j = currentRot.length - 1; j >= 0; j--){
                if(rotation[i][j] != 0 ){
                    if(j == 0){
                        map.put("pos" + i+j, new int[] {i,j});
                    }
                    for(int k = 0; k < j ; k++){
                        if (rotation[i][j-1] != 0) {
                        }else {
                            map.put("pos" + i+j, new int[] {i,j});
                        }
                    }
                }
            }
        }
        return map;
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
    public void moveRight(int value){
        getPosition().x += value;
    }
    public void moveLeft(int value){
        getPosition().x -= value;
    }

    public Point getPosition(){
        return pos;
    }

    public int[][] getCurrentRotation(){
        return currentRot;
    }

}
