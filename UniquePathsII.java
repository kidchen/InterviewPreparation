/*
Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

Note: m and n will be at most 100.
*/

// O(m*n) time, O(n) space

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0 || obstacleGrid[0][0] == 1) {
            return 0;
        }
        int[] result = new int[obstacleGrid[0].length];
        result[0] = 1;
        for(int i = 0; i < obstacleGrid.length; i++) {
            for(int j = 0; j < obstacleGrid[0].length; j++) {
                if(obstacleGrid[i][j] == 1) {
                    result[j] = 0;
                } else {
                    if(j > 0) {
                        result[j] += result[j - 1];
                    }
                }
            }
        }
        return result[obstacleGrid[0].length - 1];
    }
}


// O(m*n), O(m*n) space

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int path[][]= new int[row][col];
        // for the start position
        if(obstacleGrid[0][0]==1){
            path[0][0]=0;
        }else{
            path[0][0]=1;
        }
        
        // for the first column
        for(int i=1; i<row; i++){
            if(obstacleGrid[i][0]==1){
                path[i][0]=0;
            }else{
                path[i][0]=path[i-1][0];
            }
        }
        
        // for the first row
        for(int i=1; i<col; i++){
            if(obstacleGrid[0][i]==1){
                path[0][i]=0;
            }else{
                path[0][i]=path[0][i-1];
            }
        }
        
        // dp
        for(int i=1; i<row; i++){
            for(int j=1; j<col; j++){
                if(obstacleGrid[i][j]==1){
                    path[i][j]=0;
                }else{
                    path[i][j]=path[i-1][j]+path[i][j-1];
                }
            }
        }
        return path[row-1][col-1];
    }
}
