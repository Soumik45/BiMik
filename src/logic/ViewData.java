package logic;

public class ViewData {
	
	//private final int[][] nextBrickData;
	private final int[][] brickData;
	private final int xPosition;
	private final int yPosition;
	
	public ViewData(int[][] brickData,
			int xPosition,
			int yPosition) {
		this.brickData = brickData;
		this.xPosition = xPosition;
		this.yPosition = yPosition;
	}
	
	
	public int[][] getNextBrickData() {
		return nextBrickData;
	}


	public int[][] getBrickData() {
		return brickData;
	}
	public int getxPosition() {
		return xPosition;
	}
	public int getyPosition() {
		return yPosition;
	}
	
	
}
