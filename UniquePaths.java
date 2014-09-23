/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. 
The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?

Above is a 3 x 7 grid. How many possible unique paths are there?

Note: m and n will be at most 100.
*/

// the number of possible paths that the robot can reach this current position (x,y) is 
// the sum of paths from (x-1, y) and (x, y-1).
// O(m*n), O(m*n) space cost

public class Solution {
    public int uniquePaths(int m, int n) {
        int[][] path = new int[m][n];
        for(int i = 0; i < m; i++) {
            path[i][0] = 1;
        }
        for(int j = 0; j < n; j++) {
            path[0][j] = 1;
        }
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                path[i][j] = path[i-1][j] + path[i][j-1];
            }
        }
        return path[m-1][n-1];
    }
}


// improve: we can use a 1D array to store the result, so that the space cost will reduce to O(n)

public class Solution {
    public int uniquePaths(int m, int n) {
        if(m <= 0 || n <= 0) {
            return 0;
        }
        int[] result = new int[n];
        result[0] = 1;
        for(int i = 0; i < m; i++) {
            for(int j = 1; j < n; j++) {
                result[j] += result[j - 1];
            }
        }
        return result[n - 1];
    }
}
