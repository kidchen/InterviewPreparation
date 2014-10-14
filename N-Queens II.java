/*
Follow up for N-Queens problem.

Now, instead outputting board configurations, return the total number of distinct solutions.

*/

// O(2^n), O(n) space for the int[]

public class Solution {
    public int totalNQueens(int n) {
        if(n <= 0) {
            return 0;
        }
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(0);
        int[] col = new int[n];
        helper(n, result, 0, col);
        return result.get(0);
    }
    
    private void helper(int n, ArrayList<Integer> result, int row, int[] col) {
        if(row == n) {
            result.set(0, result.get(0) + 1);
            return;
        }
        for(int i = 0; i < n; i++) {
            // diff: no need to use two loops, we only need to try every position for col[row]
                col[row] = i;
                if(valid(row, col)) {
                    helper(n, result, row + 1, col);
                }
        }
    }
    
    private boolean valid(int row, int[] col) {
        for(int i = 0; i < row; i++) {
            // !!! col[i] & col[row] !!!
            if(col[i] == col[row] || row - i == Math.abs(col[row] - col[i])) {
                return false;
            }
        }
        return true;
    }
}
