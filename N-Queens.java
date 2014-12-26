/*
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, 
where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
*/

// NP, O(2^n)

public class Solution {
    public List<String[]> solveNQueens(int n) {
        List<String[]> result = new ArrayList<String[]>();
        if(n <= 0) {
            return result;
        }
        // !!! in col[i]: the ith row will set the Q in position col[i] !!!
        int[] col = new int[n];
        helper(n, result, 0, col);
        return result;
    }
    
    private void helper(int n, List<String[]> result, int row, int[] col) {
        // if we finished filling the col[]
        if(row == n) {
            String[] item = new String[n];
            for(int i = 0; i < n; i++) {
                StringBuffer eachRow = new StringBuffer();
                for(int j = 0; j < n; j++) {
                    if(col[j] == i) {
                        eachRow.append('Q');
                    } else {
                        eachRow.append('.');
                    }
                }
                item[i] = eachRow.toString();
            }
            result.add(item);
            // !!! need to return after finished one solution !!!
            return;
        }
        for(int i = 0; i < n; i++) {
            // !!! col[row] !!!
            col[row] = i;
            if(valid(row, col)) {
                helper(n, result, row + 1, col);
            }
        }
    }
    
    private boolean valid(int row, int[] col) {
        // check all rows that have been assigned Q
        for(int i = 0; i < row; i++) {
            // if this position has been used before(two Qs appears in the same col), OR
            // two Qs appears in the same diagonal
            if(col[i] == col[row] || row - i == Math.abs(col[row] - col[i])) {
                return false;
            }
        }
        return true;
    }
}
