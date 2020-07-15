package logic;

import java.awt.Point;
import logic.bricks.Brick;
import logic.bricks.RandomBrickGenerator;
import logic.MatrixOperation;
public class SimpleBoard {

	private final int width;
	private final int height;
	private int[][] currentGameMatrix;
	private final RandomBrickGenerator brickGenerator;
	private Brick brick;
	private int currentShape = 0;
	private Point currentOffset;
        private Score score;


	public SimpleBoard(int width, int height) {
		this.width = width;
		this.height = height;
		currentGameMatrix = new int[width][height];
		brickGenerator = new RandomBrickGenerator();
                score = new Score();
		
	}

	public boolean createNewBrick() {
		currentShape = 0;
		Brick currentBrick = brickGenerator.getBrick();
		setBrick(currentBrick);
		currentOffset = new Point(4, 0);

		return MatrixOperation.intersects(currentGameMatrix,
				getCurrentShape(), 
				currentOffset.x, 
				currentOffset.y);
	}

        
       public boolean moveBrickDown() {
		Point p = new Point(currentOffset);
		p.translate(0, 1);
		currentOffset = p;
		boolean conflict = MatrixOperation.intersects(currentGameMatrix,getCurrentShape(),p.x, p.y) ;
		if (conflict) {
                   // System.out.println("Out now");
			return false;
		} else {
			currentOffset = p;
			return true;
		}
	}
       
        public boolean moveBrickLeft() {
            Point p = new Point(currentOffset);
		p.translate(-1,0);
                
                boolean conflict = MatrixOperation.intersects(currentGameMatrix,getCurrentShape(),p.x, p.y) ;
		if (conflict) {
                   // System.out.println("Out now");
                  
			return false;
		} else {
			currentOffset = p;
			return true;
		}
        
        
    }
        public boolean moveBrickRight() {
         Point p = new Point(currentOffset);
		p.translate(1,0);
                
                boolean conflict = MatrixOperation.intersects(currentGameMatrix,getCurrentShape(),p.x, p.y) ;
		if (conflict) {
                   // System.out.println("Out now");
                  
			return false;
		} else {
			currentOffset = p;
			return true;
		}
    }
       
        public ViewData getViewData() {
		return new ViewData(getCurrentShape(),
				currentOffset.x,
				currentOffset.y,
                brickGenerator.getNextBrick().getBrickMatrix().get(0));
	}

	public int[][] getCurrentShape() {
		return this.brick.getBrickMatrix().get(currentShape);
	}

	public void setBrick(Brick brick) {
		this.brick = brick;
		currentOffset = new Point(4, 0);
	}

	public Score getScore() {
		return score;
	}
        

	public int[][] getBoardMatrix() {
		return currentGameMatrix;
	}

    public void mergeBrickToBackground() {
        int i,j;
        currentGameMatrix= MatrixOperation.merge(currentGameMatrix, getCurrentShape(), currentOffset.x,
				currentOffset.y);
       
        
    }
    public NextShapeInfo getNextShape() {
		int nextShape = currentShape;
		nextShape = ++nextShape % brick.getBrickMatrix().size();
		return new NextShapeInfo(brick.getBrickMatrix().get(nextShape), nextShape);
	}
    public boolean rotateBrickLeft() {
        NextShapeInfo nextShape = getNextShape();
		boolean conflict = MatrixOperation.intersects(currentGameMatrix, nextShape.getShape(), currentOffset.x, currentOffset.y);
		if(conflict) {
			return false;
		}else {
			setCurrentShape(nextShape.getPosition());
			return true;
		}
    }
    
    public void setCurrentShape(int currentShape) {
		this.currentShape = currentShape;
	}

    public ClearRow clearRows() {
        ClearRow clearRow =  MatrixOperation.checkRemoving(currentGameMatrix);
        currentGameMatrix = clearRow.getNextMatrix();
        return clearRow;
    }

   
}
