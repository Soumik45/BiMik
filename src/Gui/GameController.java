
package Gui;
import logic.bricks.OBrick;


public class GameController {
    
    
    private final GuiController viewController;
    private OBrick brick;
    
    public GameController(GuiController c) {
        brick =new OBrick();
		this.viewController = c;
		//this.viewController.setEventLister(this);
		//board.createNewBrick();
		this.viewController.initGameView(brick);
		//this.viewController.bindScore(board.getScore().scoreProperty());
	}
}
