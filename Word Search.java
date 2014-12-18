/*
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, 
where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
*/

// O(m^2 * n^2), O(1) space (or O(mn) space if we can't modify the original input)

public class Solution {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        if(word == null || word.length() == 0) {
            return true;
        }
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
              // check the first char to reduce wastes
                if(board[i][j] == word.charAt(0)) {
                    if(helper(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    // or use an additional char[][] to store the used (if the original input is invalid to modify)
    private boolean helper(char[][] board, String word, int row, int col, int index) {
        if(index == word.length()) {
            return true;
        }
        // !!! don't forget "="
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length 
            || board[row][col] == 'x' || board[row][col] != word.charAt(index)) {
            return false;
        }
        board[row][col] = 'x';
        // if we can use the same char many times, we need add helper(board, word, row, col, index+1)
        boolean result = helper(board, word, row + 1, col, index + 1) || helper(board, word, row - 1, col, index + 1) 
                            || helper(board, word, row, col + 1, index + 1) || helper(board, word, row, col - 1, index + 1);
        board[row][col] = word.charAt(index);
        return result;
    }
}
