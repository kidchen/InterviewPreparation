/*
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?
*/


// O(mn)
// First flip top to bottom
// Then flip from top-left to bottom-right
// Since the swap operation is frequently used, we create a swap method

public class Solution {
    public void rotate(int[][] matrix) {
        int row = matrix.length;
        int col = row;
        // flip top to bottom
        for(int i = 0; i < row / 2; i++) {
            for(int j = 0; j < col; j++) {
                swap(matrix, i, j, row - i - 1, j);
            }
        }
        for(int i = 0; i < row; i++) {
             // !!! j = i !!!
            for(int j = i; j < col; j++) {
                swap(matrix, i, j, j, i);
            }
        }
    }
    
    void swap(int[][] matrix, int r1, int c1, int r2, int c2) {
        int temp = matrix[r1][c1];
        matrix[r1][c1] = matrix[r2][c2];
        matrix[r2][c2] = temp;
    }
}


// Divide the image into row/2 layers.
// Doing the rotation: top to right, right to bottom, bottom to left, left to top.
// We can use a temporary integer to do the swap operation.
// So the time: O(mn), space O(1)

public void rotate(int[][] matrix) {
    if(matrix == null || matrix.length==0 || matrix[0].length==0)
        return;
    int layerNum = matrix.length/2;
    for(int layer=0;layer<layerNum;layer++)
    {
        for(int i=layer;i<matrix.length-layer-1;i++)
        {
            int temp = matrix[layer][i];
            matrix[layer][i] = matrix[matrix.length-1-i][layer];
            matrix[matrix.length-1-i][layer] = matrix[matrix.length-1-layer][matrix.length-1-i];
            matrix[matrix.length-1-layer][matrix.length-1-i] = matrix[i][matrix.length-1-layer];
            matrix[i][matrix.length-1-layer] = temp;
        }
    }
}
