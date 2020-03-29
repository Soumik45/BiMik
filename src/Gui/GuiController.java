
package gui;

//import com.sun.prism.paint.Color;
//import java.awt.Color;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import logic.bricks.ZBrick;

public class GuiController {
    private static final int BRICK_SIZE = 20;
    
    @FXML
    private GridPane gamePanel;
    @FXML
    private GridPane brickPanel;
    public void initGameView(int[][] boardMatrix, int[][] brickData)
    {
        for(int i=2;i<boardMatrix.length;i++)
        {
            for(int j=0;j<boardMatrix[i].length;j++)
            {
                Rectangle rectangle =new Rectangle(BRICK_SIZE , BRICK_SIZE );
                rectangle.setFill(Color.TRANSPARENT);
                gamePanel.add(rectangle, j,i-2);
                
            }
        }
        
        
        for(int i=0;i<brickData.length;i++)
        {
            
            for(int j=0;j<brickData[i].length;j++)
            {
                Rectangle rectangle =new Rectangle(BRICK_SIZE , BRICK_SIZE );
                rectangle.setFill(getFillColor(brickData[i][j]));
                brickPanel.add(rectangle, j, i);
            }
        }
    }
    public Paint getFillColor(int i)
    {
        Paint returnPaint;
        switch(i)
        {
            case 0:
                returnPaint=Color.TRANSPARENT;
                break;
            case 1:
                returnPaint = Color.Color.AQUAMARINE;
                break;
            case 2:
                returnPaint = Color.DARKGREEN;
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
                returnPaint = Color.BROWN;
                break;
            default:
                returnPaint = Color.WHITE;
                break;
        }
        return returnPaint;
    }

}
