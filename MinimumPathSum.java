/*
Given a m x n grid filled with non-negative numbers, 
find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
*/

// Use a 1D array to store the results (for a row/col), first initial the result[], then update the elements
// O(m*n), O(m) space cost --> only use a 1D array (one row length)

public class Solution {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int[] result = new int[grid[0].length];
        result[0] = grid[0][0];
        for(int i = 1; i < grid[0].length; i++) {
            // !!! initial the result[] !!!
            result[i] = result[i - 1] + grid[0][i];
        }
        for(int i = 1; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(j == 0) {
                    result[j] += grid[i][j];
                } else {
                    // !!! compare result[j-1] & result[j] !!!
                    result[j] = Math.min(result[j - 1], result[j]) + grid[i][j];
                }
            }
        }
        return result[grid[0].length - 1];
    }
}
