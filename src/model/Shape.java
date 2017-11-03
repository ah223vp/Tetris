package model;


import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Shape {

    public double posX = 100;
    public double posY = 0;
    private List<int [][]> shapes = new ArrayList<>();

    private Point pos = new Point();


    public Shape createSquare(){

        pos.x =125;
        pos.y = 0;

        shapes.add(new int[][]{
                {0, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 1, 1, 0},
                {0, 1, 0, 0}
        });

        return this;

    }
    public void rotate(){

    }
    public int getRightSideIndex(){
        return 0;
    }
    public int getLeftSideIndex(){
        return 0;
    }

    public Point getPosition(){
        return pos;
    }

    public List<int[][]> getShape(){
        return shapes;
    }
}
