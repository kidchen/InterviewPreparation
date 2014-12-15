/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].
*/

// O(m*n) time, O(1) space

public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return result;
        // level by level
        int min = Math.min(matrix.length, matrix[0].length);
        int levelNum = min / 2;
        for(int level = 0; level < levelNum; level++) {
            // top row
            for(int i = level; i < matrix[0].length - level - 1; i++) {
                result.add(matrix[level][i]);
            }
            // right col
            for(int i = level; i < matrix.length - level - 1; i++) {
                result.add(matrix[i][matrix[0].length - level - 1]);
            }
            // bottom row
            for(int i = matrix[0].length - level - 1; i > level; i--) {
                result.add(matrix[matrix.length - level - 1][i]);
            }
            // left col
            for(int i = matrix.length - level - 1; i > level; i--) {
                result.add(matrix[i][level]);
            }
        }
        // for the last one col or row
        if(min % 2 == 1) {
            // row < col
            if(matrix[0].length > matrix.length) {
                // !!! here, i<length - levelNum, no need to -1 !!!
                for(int i = levelNum; i < matrix[0].length - levelNum; i++) {
                    result.add(matrix[levelNum][i]);
                }                
            } else {
                for(int i = levelNum; i < matrix.length - levelNum; i++) {
                    result.add(matrix[i][levelNum]);
                }
            }
        }
        return result;
    }
}
