/*
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

click to show follow up.

Follow up:
Did you use extra space?
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
*/

// O(m*n), O(1) space:

public class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int row = 0, col = 0;
        for(int i = 0; i < matrix.length; i++) {
            if(matrix[i][0] == 0) {
                col = 1;
                break;
            }
        }
        for(int i = 0; i < matrix[0].length; i++) {
            if(matrix[0][i] == 0) {
                row = 1;
                break;
            }
        }
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        // !!! be careful the initial i, j equals to 1, not 0 !!!
        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if(row == 1) {
            for(int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }
        if(col == 1) {
            for(int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
        return;
    }
}


// in CTCI, there is another solution which costs more spaces. 
// use two boolean[] to store all 0 positions (row & col) at first for-for loop
// then in the second for-for loop, if boolean row or boolean col is true,
// change the whole row or col into 0.
