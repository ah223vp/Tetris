package model.shapeFactory;

import java.util.ArrayList;

public class JShape implements IShape {

    public ArrayList<int [][]> getDrawings(){
        ArrayList<int [][]> shapes = new ArrayList<>();

        shapes.add(new int[][]{
                {0, 6, 6, 0},
                {0, 6, 0, 0},
                {0, 6, 0, 0},
                {0, 0, 0, 0}
        });
        shapes.add(new int[][]{
                {0, 0, 0, 0},
                {6, 6, 6, 0},
                {0, 0, 6, 0},
                {0, 0, 0, 0}
        });
        shapes.add(new int[][]{
                {0, 6, 0, 0},
                {0, 6, 0, 0},
                {6, 6, 0, 0},
                {0, 0, 0, 0}
        });
        shapes.add(new int[][]{
                {6, 0, 0, 0},
                {6, 6, 6, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        });

        return shapes;
    }
}
