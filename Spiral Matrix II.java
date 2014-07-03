public class Solution {
    public int[][] generateMatrix(int n) {
        if(n < 0) return null;
        int[][] result = new int[n][n];
        int levelNum = n / 2;
        int num = 1;
        for(int level = 0; level < levelNum; level++) {
            for(int i = level; i < n - level - 1; i++) {
                result[level][i] = num;
                num++;
            }
            for(int i = level; i < n - level - 1; i++) {
                result[i][n - level - 1] = num;
                num++;
            }
            for(int i = n - level - 1; i > level; i--) {
                result[n - level - 1][i] = num;
                num++;
            }
            for(int i = n - level - 1; i > level; i--) {
                result[i][level] = num;
                num++;
            }
        }
        if(n % 2 == 1) {
            result[levelNum][levelNum] = num;
        }
        return result;
    }
}
