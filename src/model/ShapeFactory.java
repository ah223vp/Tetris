package model;

import java.util.ArrayList;

public class ShapeFactory {

    private Shape currentFalling;
    private ArrayList<Shape> objects = new ArrayList<>();

    Board board;

    private IObserver sub;

    public ShapeFactory(Board board){
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
    public void checkIfAtBottom(){
        int bottomTempIndex = this.currentFalling.getBottomSideIndex() + this.currentFalling.getPosition().y;

        if(bottomTempIndex >= 26){
            createSquare();
        }
        int temp = 0;

        for(int i = 0; i < 4; i++){
            if(this.currentFalling.getShape()[this.currentFalling.getBottomSideIndex()][temp] == 1
                     && this.board.getBoard()[bottomTempIndex + 1][this.currentFalling.getPosition().x + i] == 1){
                createSquare();
            }
            temp++;
        }


    }
    public void moveCurrentDown(){
        checkIfAtBottom();
        this.currentFalling.getPosition().y += 1;
        //this.board.checkCompleteRow();
        this.board.updateBoard(objects);
    }

}
