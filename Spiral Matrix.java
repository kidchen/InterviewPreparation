public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return result;
        // level by level
        // levelNum: how many levels is there in the matrix
        // !!! min is useful later !!!
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
        // !!! have to use min to check whether there is one line left !!!
        if(min % 2 == 1) {
            // row < col
            if(matrix[0].length > matrix.length) {
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
