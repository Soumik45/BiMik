
package logic;


public class MatrixOperation {
    public static boolean intersects(int[][]matrix,int[][]brick, int x,int y)
    {
        int i,j;
        int targetY=0;
        for(i=0;i<brick.length;i++)
        {
            for(j=0;j<brick[i].length;j++)
            {
                
                //System.out.print(matrix[i][j]);
                targetY=y+j;
               if (brick[j][i]!=0&&outOfBounds(matrix,targetY) ) {
                    System.out.println("y is =" +y);
             System.out.println("targetY is =" +targetY);
					return true;
				}
            }
           
        }
        
        return false;
        
    }
    private static boolean outOfBounds(int[][] matrix, int targetY) {
		return targetY >= matrix.length;
	}
}
