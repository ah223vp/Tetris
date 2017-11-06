package model;


import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Shape {

    public double posX = 100;
    public double posY = 0;
    private List<int [][]> shapes = new ArrayList<>();
    private int[][] currentRot;

    private Point pos = new Point();


    public Shape createSquare(){

        pos.x = 5;
        pos.y = 0;

        shapes.add(new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 1, 1, 0},
                {0, 1, 1, 0}
        });
        this.currentRot = shapes.get(0);

        return this;

    }
    public void rotate(){

    }
    public int getRightSideIndex(){
        return 2;
    }
    public int getLeftSideIndex(){
        return 1;
    }
    public int getBottomSideIndex(){
        return 3;
    }

    public Point getPosition(){
        return pos;
    }

    public int[][] getShape(){
        return shapes.get(0);
    }
}
