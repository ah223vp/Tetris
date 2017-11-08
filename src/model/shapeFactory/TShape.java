package model.shapeFactory;

import java.util.ArrayList;

public class TShape implements IShape {

    public ArrayList<int [][]> getDrawings(){
        ArrayList<int [][]> shapes = new ArrayList<>();

        shapes.add(new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 3, 3, 3},
                {0, 0, 3, 0}
        });
        shapes.add(new int[][]{
                {0, 0, 0, 0},
                {0, 0, 3, 0},
                {0, 3, 3, 0},
                {0, 0, 3, 0}
        });
        shapes.add(new int[][]{
                {0, 0, 0, 0},
                {0, 0, 3, 0},
                {0, 3, 3, 3},
                {0, 0, 0, 0}
        });
        shapes.add(new int[][]{
                {0, 0, 0, 0},
                {0, 0, 3, 0},
                {0, 0, 3, 3},
                {0, 0, 3, 0}
        });

        return shapes;
    }
}
