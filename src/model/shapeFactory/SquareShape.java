package model.shapeFactory;

import java.util.ArrayList;

public class SquareShape implements IShape {

    public ArrayList<int [][]> getDrawings(){
        ArrayList<int [][]> shapes = new ArrayList<>();

        shapes.add(new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 1, 1, 0},
                {0, 1, 1, 0}
        });

        return shapes;
    }
}
