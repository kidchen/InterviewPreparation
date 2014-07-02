public class Solution {
    public void solveSudoku(char[][] board) {
        helper(board, 0, 0);
    }
    
    // i: row, j: col
    boolean helper(char[][] board, int i, int j) {
        // firstly fill each row
        // if we finish this row, fill the next row
        if(j >= 9) {
            // !!! each time use helper, we need to use return !!!
            // !!! set j back to 0 !!!
            return helper(board, i + 1, 0);
        }
        // if the last row is finished, return
        if(i == 9) {
            return true;
        }
        // finish each row:
        // find a blank:
        if(board[i][j] == '.') {
            // try each number
            for(int k = 1; k <= 9; k++) {
                board[i][j] = (char)(k + '0');
                // valid
                if(isValid(board, i, j)) {
                    // !!! j is finished, try j + 1 in if clause !!!
                    if(helper(board, i, j + 1)) return true;
                }
                // not valid
                board[i][j] = '.';
            }
        } else {
            // not a blank
            return helper(board, i, j + 1);
        }
        return false;
    }
    
    // check whether this number is valid in this position
    boolean isValid(char[][] board, int i, int j) {
        // check row:
        for(int k = 0; k < 9; k++) {
            if(k != j && board[i][j] == board[i][k]) return false;
        }
        // check col:
        for(int k = 0; k < 9; k++) {
            if(k != i && board[i][j] == board[k][j]) return false;
        }
        // check block:
        for(int col = j/3*3; col < j/3*3 + 3; col++) {
            for(int row = i/3*3; row < i/3*3 +3; row++) {
                if(col != j && row != i && board[row][col] == board[i][j]) return false;
            }
        }
        return true;
    }
}
