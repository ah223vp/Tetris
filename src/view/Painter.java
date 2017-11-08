package view;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import model.IObserver;

import model.ShapeControl;


public class Painter implements IObserver {

    GraphicsContext context;
    ShapeControl shapeFactory;

    private int unit = 20;

    public Painter(GraphicsContext context, ShapeControl shapeFactory){
        this.context = context;
        this.shapeFactory = shapeFactory;
    }

    public void draw(int[][] board){

        context.clearRect(0,0,context.getCanvas().getWidth(), context.getCanvas().getHeight());
        context.setFill(Color.GRAY);
        context.fillRect(0,0,context.getCanvas().getWidth(), context.getCanvas().getHeight());

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] != 0){
                    // Setting color
                    context.setFill(getColor(board[i][j]));

                    // Drawing border and drawing rect.
                    context.setStroke(Color.BLACK);
                    context.setLineWidth(2);
                    context.fillRect(j * unit-40, i * unit-80, unit, unit);
                    context.strokeRect(j * unit-40, i * unit-80, unit, unit);

                }
            }
        }
    }
    private Color getColor(int color){
        switch(color){
            case 1: return Color.RED;
            case 2: return Color.YELLOWGREEN;
            case 3: return Color.GREEN;
            case 4: return Color.FORESTGREEN;
            case 5: return Color.AZURE;
            case 6: return Color.MAGENTA;
            case 7: return Color.PINK;
        }
        return null;
    }
}
