package model;


public class RotationValidator {

    // TODO Check that rotations is valid against the walls. Push the piece outwards if it goes to far.

    // TODO Make sure a piece cant rotate when it intersects with another piece and or the wall.


    public boolean validate(Shape shape, int[][] board){

        int rightSideIndex = shape.getRightSideIndex(shape.getNextRotation())
        int leftSid   eIndex = shape.getLeftSideIndex(shape.getNextRotation());


        // Check rightside
        if(shape.getPosition().x + rightSideIndex > 11){

            int pos = shape.getPosition().x + rightSideIndex;
            int sum = pos - 11;
            if(notIntersectingWithPieceToLeft(shape, board, sum)){
                shape.moveLeft(sum);
            }else{
                return false;
            }

            // Leftside
        }else if(shape.getPosition().x + leftSideIndex < 2){
            int pos = shape.getPosition().x + leftSideIndex;
            int sum = 2 - pos;
            if(notIntersectingWithPieceToRight(shape, board, sum)){
                shape.moveRight(sum);
            }else{
                return false;
            }
        }else{
            if(!checkPieceIntersection(shape, board)){
                return false;
            }
        }

        return true;
    }
    private boolean notIntersectingWithPieceToRight(Shape shape, int[][] board, int moveDistance){

        for(int i = 0; i < shape.getNextRotation().length; i++){
            for(int j = 0; j < shape.getNextRotation()[i].length; j++){
                if(shape.getNextRotation()[i][j] != 0){
                    if(board[shape.getPosition().y + i][shape.getPosition().x + j + moveDistance] != 0 ||
                            board[shape.getPosition().y + i + 1][shape.getPosition().x + j + moveDistance] != 0){
                        System.out.println("Försöker rotera där en piece redan är. Flytta till höger");
                        return false;
                    }
                }
            }
        }
        return true;
    }
    private boolean notIntersectingWithPieceToLeft(Shape shape, int[][] board, int moveDistance){

        for(int i = 0; i < shape.getNextRotation().length; i++){
            for(int j = 0; j < shape.getNextRotation()[i].length; j++){
                if(shape.getNextRotation()[i][j] != 0){
                    if(board[shape.getPosition().y + i][shape.getPosition().x + j - moveDistance] != 0 ||
                            board[shape.getPosition().y + i + 1][shape.getPosition().x + j - moveDistance] != 0){
                        System.out.println("Försöker rotera där en piece redan är. flytta till vänster");
                        return false;
                    }
                }
            }
        }
        return true;
    }
    private boolean checkPieceIntersection(Shape shape, int[][] board){

        for(int i = 0; i < shape.getNextRotation().length; i++){
            for(int j = 0; j < shape.getNextRotation()[i].length; j++){
                if(shape.getNextRotation()[i][j] != 0){
                    if(board[shape.getPosition().y + i][shape.getPosition().x + j] != 0){
                        if(j < 2){
                            // moveRight with j - shape.getNextRotation().length
                            //int distance = shape.getNextRotation().length - j;
                            int distance = 1;
                            if(!notIntersectingWithPieceToRight(shape, board, distance)){
                                return false;

                            }else{
                                System.out.println("Flyttar den : " + distance + "  units");
                                shape.moveRight(distance);
                                break;
                            }
                        }else {
                            int distance = 1;

                            if(!notIntersectingWithPieceToLeft(shape, board, distance)){
                                return false;
                            }else{
                                System.out.println("Flyttar den : " + distance + "  units");
                                shape.moveLeft(distance);
                                break;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
}
