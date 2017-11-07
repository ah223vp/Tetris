package model;

import model.shapeFactory.Shape;

import java.util.ArrayList;

public class ShapeControl {

    private Shape currentFalling;
    private ArrayList<Shape> objects = new ArrayList<>();

    private Board board;

    private IObserver sub;

    public ShapeControl(Board board){
        this.board = board;
    }

    private void addObject(Shape shape){
        objects.add(shape);

    }
    public ArrayList<Shape> getObjects(){
        return objects;
    }
    public void addSubscriber(IObserver sub){
        this.board.addSubscriber(sub);
        this.sub = sub;
    }
    public IObserver getSub(){
        return sub;
    }
    public Shape getCurrentShape(){
        return currentFalling;
    }

    // This will be createShape later on
    public void createSquare(){
        Shape square = new Shape().createSquare();
        currentFalling = square;
        addObject(square);

    }

    public void moveCurrentDown(){

        if(!this.board.updateBoard(objects, this.currentFalling)){
            // Should be createShape instead
            createSquare();
        }

    }

}
