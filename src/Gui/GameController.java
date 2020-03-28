
package gui;
import logic.bricks.ZBrick;

public class GameController {
    private final GuiController viewController;
    
    private ZBrick brick;
    
    public GameController(GuiController c)
    {
        brick = new ZBrick();
        this.viewController = c;
        this.viewController.initGameView(brick);
        
    }
}
