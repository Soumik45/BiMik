
package Gui;

import logic.SimpleBoard;

public class GameController {
    private SimpleBoard board = new SimpleBoard(25, 10);
    private final GuiController viewController;
    
    public GameController(GuiController c)
    {

       this.viewController = c;
		//this.viewController.setEventLister(this);
		board.createNewBrick();
		this.viewController.initGameView(board.getBoardMatrix(),board.getCurrentShape());

        
    }
}
