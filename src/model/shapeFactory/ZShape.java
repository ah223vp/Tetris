package model.shapeFactory;

import java.util.ArrayList;

public class ZShape implements IShape{
    public ArrayList<int [][]> getDrawings(){
        ArrayList<int [][]> shapes = new ArrayList<>();

        shapes.add(new int[][]{
                {0, 0, 0, 0},
                {0, 0, 5, 0},
                {0, 5, 5, 0},
                {0, 5, 0, 0}
        });
        shapes.add(new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {5, 5, 0, 0},
                {0, 5, 5, 0}
        });


        return shapes;
    }
}
