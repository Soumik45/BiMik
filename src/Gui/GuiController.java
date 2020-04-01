package Gui;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.IntegerProperty;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.effect.Reflection;

import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;
import logic.ViewData;

import logic.events.InputEventListener;

public class GuiController implements Initializable
{
    
    private static final int BRICK_SIZE = 20;
    Timeline timeLine;
   private InputEventListener eventLister;
    
    
    @FXML
	private GridPane gamePanel;
    @FXML
	private GridPane brickPanel;
	 @FXML
	private Text scoreValue;
    
    
  public void initGameView(int[][] boardMatrix,ViewData viewData) {
		
		for (int i = 2; i < boardMatrix.length; i++) {
			for (int j = 0; j < boardMatrix[i].length; j++) {
				Rectangle rectangle = new Rectangle(BRICK_SIZE, BRICK_SIZE);
				rectangle.setFill(Color.TRANSPARENT);
                          
				
				gamePanel.add(rectangle, j, i - 2);
                                                        }
                                            }
 
    for(int i=0;i<viewData.getBrickData().length;i++)
    {
        for(int j=0;j<viewData.getBrickData()[i].length;j++)
        {
            Rectangle rectangle = new Rectangle(BRICK_SIZE, BRICK_SIZE);
				rectangle.setFill(getFillColor(viewData.getBrickData()[i][j]));
                                brickPanel.add(rectangle, j, i);
                              
                                
                                
        }
        
    }
    brickPanel.setLayoutX(gamePanel.getLayoutX() + viewData.getxPosition() * BRICK_SIZE);
    brickPanel.setLayoutY(gamePanel.getLayoutY()-42 + viewData.getyPosition() * BRICK_SIZE);
    
    timeLine = new Timeline(new KeyFrame(Duration.millis(400),ae -> moveDown()));
    timeLine.setCycleCount(25);
    timeLine.play();
                                }
    
   private void moveDown() {
		ViewData viewData = eventLister.onDownEvent();
		refreshBrick(viewData);
	}
    private void refreshBrick(ViewData viewData){
         brickPanel.setLayoutX(gamePanel.getLayoutX() + viewData.getxPosition() * BRICK_SIZE);
    brickPanel.setLayoutY(gamePanel.getLayoutY()-42 + viewData.getyPosition() * BRICK_SIZE);
    
        
    }
    public void setEventLister(InputEventListener eventLister) {
		this.eventLister = eventLister;
	}
    public void bindScore(IntegerProperty integerProperty) {
		scoreValue.textProperty().bind(integerProperty.asString());
	}
    
    public Paint getFillColor(int i) {
		Paint returnPaint;
		switch (i) {
		case 0:
			returnPaint = Color.TRANSPARENT;
			break;
		case 1:
			returnPaint = Color.AQUAMARINE;
			break;
		case 2:
			returnPaint = Color.PALEGREEN;
			break;
		case 3:
			returnPaint = Color.DARKGRAY;
			break;
		case 4:
			returnPaint = Color.YELLOW;
			break;
		case 5:
			returnPaint = Color.RED;
			break;
		case 6:
			returnPaint = Color.VIOLET;
			break;
		case 7:
			returnPaint = Color.CORNSILK;
			break;
		default:
			returnPaint = Color.WHITE;
			break;
		}

		return returnPaint;
	}
	 @Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		Reflection reflection = new Reflection();
		reflection.setFraction(0.8);
		reflection.setTopOpacity(0.9);
		reflection.setTopOffset(-12);
		scoreValue.setEffect(reflection);
	}
    
}

