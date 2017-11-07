package model.shapeFactory;

import java.awt.*;

public interface IShape {

    void initializeShapes();
    void rotate();
    int getRightSideIndex();
    int getLeftSideIndex();
    int getBottomSideIndex();

    Point getPosition();
    int[][] getCurrentRotation();


}
