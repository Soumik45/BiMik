
package Gui;
import logic.SimpleBoard;
import logic.ViewData;
import logic.events.InputEventListener;

public class GameController implements InputEventListener {
    
    
    private SimpleBoard board = new SimpleBoard(25, 10);
    
    private final GuiController viewController;
  
    
    public GameController(GuiController c) {
       // brick =new JBrick();
		this.viewController = c;
		this.viewController.setEventLister(this);
		board.createNewBrick();
		this.viewController.initGameView(board.getBoardMatrix(),board.getViewData());
		//this.viewController.bindScore(board.getScore().scoreProperty());
	}
    @Override
    public ViewData onDownEvent() {
		 board.moveBrickDown();
		
		
		return board.getViewData();
	}
}
