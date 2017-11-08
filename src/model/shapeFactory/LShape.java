package model.shapeFactory;

import java.util.ArrayList;

public class LShape implements IShape {
    public ArrayList<int [][]> getDrawings(){
        ArrayList<int [][]> shapes = new ArrayList<>();

        shapes.add(new int[][]{
                {0, 0, 0, 0},
                {0, 4, 0, 0},
                {0, 4, 0, 0},
                {0, 4, 4, 0}
        });
        shapes.add(new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {4, 4, 4, 0},
                {4, 0, 0, 0}
        });
        shapes.add(new int[][]{
                {0, 0, 0, 0},
                {4, 4, 0, 0},
                {0, 4, 0, 0},
                {0, 4, 0, 0}
        });
        shapes.add(new int[][]{
                {0, 0, 0, 0},
                {0, 0, 4, 0},
                {4, 4, 4, 0},
                {0, 0, 0, 0}
        });

        return shapes;
    }
}
