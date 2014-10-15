/*
Write a program to solve a Sudoku puzzle by filling the empty cells.

Empty cells are indicated by the character '.'.

You may assume that there will be only one unique solution.
*/

// O(9^4), O(1) space

public class Solution {
    public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) {
            return;
        }
        helper(board, 0, 0);
        return;
    }
    
    // !!! in order to do recursion in this case, we have to use boolean return type !!!
    private boolean helper(char[][] board, int row, int col) {
        // if this is the end of a row
        if(col == 9) {
            return helper(board, row + 1, 0);
        }
        // if this is the end of the board, return true (we successfully go there)
        if(row == 9) {
            return true;
        }
        // if this is an empty position, fill in numbers from 1 to 9
        if(board[row][col] == '.') {
            for(int i = 1; i <= 9; i++) {
                board[row][col] = (char)(i + '0');
                if(valid(board, row, col)) {
                    // if this number is valid, 
                    // THEN check its next, here we go deep
                    //      --> until the end, return true, OR can't go to the end, return false in if clause
                    if(helper(board, row, col + 1)){
                        return true;
                    }
                }
                // if go deep, then we can't reach here, if we can't go deep, that means current number is wrong
                // here we have to add this line, because for outer recursion usage
                board[row][col] = '.';
            }
        } else {
            // if this is not an empty position, go to the next one
            return helper(board, row, col + 1);
        }
        return false;
    }
    
    private boolean valid(char[][] board, int row, int col) {
        // have to check all numbers in a row/col except THIS one
        for(int i = 0; i < 9; i++) {
            if(i != col && board[row][i] == board[row][col]) {
                return false;
            }
        }
        for(int i = 0; i < 9; i++) {
            if(i != row && board[i][col] == board[row][col]) {
                return false;
            }
        }
        for(int i = row/3*3; i < 3 + row/3*3; i++) {
            for(int j = col/3*3; j < 3 + col/3*3; j++) {
                if(i != row && j != col && board[i][j] == board[row][col]) {
                    return false;
                }
            }
        }
        return true;
    }
}
