
package Gui;



import javafx.fxml.FXML;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import javafx.scene.shape.Rectangle;
import logic.bricks.OBrick;
public class GuiController 
{
    
    private static final int BRICK_SIZE = 20;
    @FXML
	private GridPane gamePanel;
    @FXML
	private GridPane brickPanel;
    
    public void initGameView(OBrick brick) {
		//displayMatrix = new Rectangle[boardMatrix.length][boardMatrix[0].length];
		for (int i = 2; i < 25; i++) {
			for (int j = 0; j < 10; j++) {
				Rectangle rectangle = new Rectangle(BRICK_SIZE, BRICK_SIZE);
				rectangle.setFill(Color.TRANSPARENT);
				//displayMatrix[i][j] = rectangle;
				gamePanel.add(rectangle, j, i - 2);
                                                        }
                                            }
    int [][] currentShape = brick.getBrickMatrix().get(0);
    for(int i=0;i<currentShape.length;i++)
    {
        for(int j=0;j<currentShape[i].length;j++)
        {
            Rectangle rectangle = new Rectangle(BRICK_SIZE, BRICK_SIZE);
				rectangle.setFill(getFillColor(currentShape[i][j]));
                                brickPanel.add(rectangle, j, i);
                                
                                
        }
        
    }
                                }
    
    
    
    public Paint getFillColor(int i) {
		Paint returnPaint;
		switch (i) {
		case 0:
			returnPaint = Color.TRANSPARENT;
			break;
		case 1:
			returnPaint = Color.AQUA;
			break;
		case 2:
			returnPaint = Color.BLUEVIOLET;
			break;
		case 3:
			returnPaint = Color.DARKGREEN;
			break;
		case 4:
			returnPaint = Color.YELLOW;
			break;
		case 5:
			returnPaint = Color.RED;
			break;
		case 6:
			returnPaint = Color.BEIGE;
			break;
		case 7:
			returnPaint = Color.BURLYWOOD;
			break;
		default:
			returnPaint = Color.WHITE;
			break;
		}

		return returnPaint;
	}
    
}
