package model.shapeFactory;


import java.util.Random;

public class ShapeFactory {

    public IShape getShapeDrawings(){
        int shape = getRandomShape();
        switch(shape){
            case 0: return new SquareShape();
            case 1: return new LineShape();
            case 2: return new TShape();
            case 3: return new LShape();
            case 4: return new ZShape();
            case 5: return new SShape();
            case 6: return new JShape();
        }
        return null;
    }
    private int getRandomShape(){
        Random r  = new Random();
        int random = r.nextInt(7);
        return random;
    }
}
