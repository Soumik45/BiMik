package logic;

import java.awt.Point;

import logic.bricks.Brick;
import logic.bricks.RandomBrickGenerator;

public class SimpleBoard {

	private final int width;
	private final int height;
	private int[][] currentGameMatrix;
	private final RandomBrickGenerator brickGenerator;
	private Brick brick;
	private int currentShape = 0;
	private Point currentOffset;


	public SimpleBoard(int width, int height) {
		this.width = width;
		this.height = height;
		currentGameMatrix = new int[width][height];
		brickGenerator = new RandomBrickGenerator();
		
	}

	public boolean createNewBrick() {
		Brick currentBrick = brickGenerator.getBrick();
		setBrick(currentBrick);
		currentOffset = new Point(4, 0);

		return true;
	}




	public int[][] getCurrentShape() {
		return this.brick.getBrickMatrix().get(currentShape);
	}

	public void setBrick(Brick brick) {
		this.brick = brick;
		//currentOffset = new Point(4, 0);
	}

	

	public int[][] getBoardMatrix() {
		return currentGameMatrix;
	}


}