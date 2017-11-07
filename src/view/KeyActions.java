package view;

import javafx.scene.canvas.Canvas;
import model.TetrisGame;

public class KeyActions {

    public KeyActions(Canvas canvas, TetrisGame tetris){
        keyPressedActions(canvas, tetris);
    }

    public void keyPressedActions(Canvas canvas, TetrisGame tetris){

        canvas.setFocusTraversable(true);
        canvas.setOnKeyPressed(e -> {

            switch (e.getCode()){
                case UP:
                    // Something similar
                    tetris.rotatePiece();
                    break;
                case DOWN:
                    //shapeFactory.getSnake().setMoveDown();
                    break;
                case LEFT:
                    tetris.moveLeft();
                    break;
                case RIGHT:
                    tetris.moveRight();
                    break;
                case SPACE:
                    //System.out.println(shapeFactory);
                    tetris.start();
            }
        });

    }

}
