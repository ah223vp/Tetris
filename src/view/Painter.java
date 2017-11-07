package view;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import model.IObserver;
import model.shapeFactory.Shape;
import model.ShapeControl;

import java.util.ArrayList;


public class Painter implements IObserver {

    GraphicsContext context;
    ShapeControl shapeFactory;

    private int unit = 20;

    public Painter(GraphicsContext context, ShapeControl shapeFactory){
        this.context = context;
        this.shapeFactory = shapeFactory;
    }

    public void draw(int[][] board){

        context.clearRect(0,0,500,500);
        context.setFill(Color.GRAY);
        context.fillRect(0,0,500,500);

        context.setFill(Color.BLACK);

        ArrayList<Shape> objects = shapeFactory.getObjects();

        /*
        for(Shape s: objects){
            Point temp = s.getPosition();
            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 4; j++){

                    // Hardcoded, rotations needs to be sent from model.
                    if(s.getCurrentRotation()[i][j] == 1){
                        context.fillRect(temp.x + j * unit, temp.y + i * unit, unit, unit );
                    }
                }
            }
        }*/

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == 1){
                    context.fillRect(j * unit-40, i * unit-80, unit, unit);
                }
            }
        }
    }
}
