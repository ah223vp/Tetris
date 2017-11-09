package model;

import model.shapeFactory.ShapeFactory;



public class ShapeControl {

    private Shape currentFalling;

    private Board board;

    private int[][] boardSim;

    private ShapeFactory shapeFactory;

    private IObserver sub;
    private RotationValidator rot;


    public ShapeControl(Board board){
        this.board = board;
        this.shapeFactory = new ShapeFactory();
        this.rot = new RotationValidator();
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
    public void createShape() {
        Shape square = new Shape(this.shapeFactory).createShape();
        currentFalling = square;

    }

    public void moveCurrentDown(){
        boardSim = board.getBoard();
        if(!this.board.updateBoard(this.currentFalling)){
            // Should be createShape instead
            createShape();
        }

    }
    public void moveRight(){
        if(isMovementValidRight()){
            currentFalling.getPosition().x +=1;
        }
    }
    private boolean isMovementValidRight(){

        if(currentFalling.getPosition().x + currentFalling
                .getRightSideIndex() >= 11){
            return false;
        }

        // Checking that the pieces next to the ones that are going to be moved are empty
        for(int[] s : currentFalling.getRightSidePieces().values()){
            if(this.boardSim[currentFalling.getPosition().y + s[0]][currentFalling.getPosition().x
                    + s[1] + 1] != 0 ||
                    this.boardSim[currentFalling.getPosition().y + s[0] + 1][currentFalling.getPosition().x
                            + s[1] + 1] != 0){
                System.out.println("Den tror att den tar i en piece!");
                return false;
            }
        }


        return true;
    }
    public void moveLeft(){
        if(isMovementValidLeft()){
            currentFalling.getPosition().x -=1;
        }
    }


    private boolean isMovementValidLeft(){

        if(currentFalling.getPosition().x + currentFalling
                .getLeftSideIndex() <= 2){
            return false;
        }

        // Checking that the pieces next to the ones that are going to be moved are empty
        for(int[] s : currentFalling.getLeftSidePieces().values()){
            if(this.boardSim[currentFalling.getPosition().y + s[0]][currentFalling.getPosition().x
                    + s[1] - 1] != 0 ||
                    this.boardSim[currentFalling.getPosition().y + s[0] + 1][currentFalling.getPosition().x
                            + s[1] - 1] != 0){
                System.out.println("Den tror att den tar i en piece!");
                return false;
            }
        }
        return true;
    }
    public void rotate(){
        if(rot.validate(currentFalling, boardSim)){
            currentFalling.rotate();
        }

    }

}
