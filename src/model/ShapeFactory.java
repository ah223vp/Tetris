package model;

import java.util.ArrayList;

public class ShapeFactory {

    private Shape currentFalling;
    private ArrayList<Shape> objects = new ArrayList<>();

    private IObserver sub;


    private void addObject(Shape shape){
        objects.add(shape);

    }
    public ArrayList<Shape> getObjects(){
        return objects;
    }
    public void addSubscriber(IObserver sub){
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
    public void checkIfAtBottom(){

        // How to do this when there are other cubes at bottom?
        // Simulate bottomline?
        if(this.currentFalling.getPosition().y >= 200){
            createSquare();
        }
    }
    public void moveCurrentDown(){
        checkIfAtBottom();
        this.currentFalling.getPosition().y += 10;
        sub.draw();
    }

}
