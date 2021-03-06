package model.shapeFactory;

import java.util.ArrayList;

public class LineShape implements IShape {

    public ArrayList<int [][]> getDrawings(){
        ArrayList<int [][]> shapes = new ArrayList<>();

        shapes.add(new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {2, 2, 2, 2},
                {0, 0, 0, 0}
        });
        shapes.add(new int[][]{
                {0, 2, 0, 0},
                {0, 2, 0, 0},
                {0, 2, 0, 0},
                {0, 2, 0, 0}
        });

        return shapes;
    }

}
