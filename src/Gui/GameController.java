
package gui;
import logic.SimpleBoard;
import logic.bricks.ZBrick;

public class GameController {
    private SimpleBoard board = new SimpleBoard(25,10);
    private final GuiController viewController;
    
    private ZBrick brick;
    
    public GameController(GuiController c)
    {
        this.viewController = c;
        board.createNewBrick();
        this.viewController.initGameView( board.getBoardMatrix() ,board.getCurrentShape()); 
        
    }
}
