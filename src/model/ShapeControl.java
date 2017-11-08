package model;

import model.shapeFactory.ShapeFactory;



public class ShapeControl {

    private Shape currentFalling;

    private Board board;

    private ShapeFactory shapeFactory;

    private IObserver sub;

    public ShapeControl(Board board){
        this.board = board;
        this.shapeFactory = new ShapeFactory();
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
    public void createSquare() {
        Shape square = new Shape(this.shapeFactory).createShape();
        currentFalling = square;

    }

    public void moveCurrentDown(){

        if(!this.board.updateBoard(this.currentFalling)){
            // Should be createShape instead
            createSquare();
        }

    }

}
