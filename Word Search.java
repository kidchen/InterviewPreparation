public class Solution {
    public boolean exist(char[][] board, String word) {
        if(word == null || word.length() == 0) return true;
        if(board == null || board.length == 0 || board[0].length == 0) return false;
        boolean[][] used = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
            // if we can find a word:
                if(search(board, word, used, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    boolean search(char[][] board, String word, boolean[][] used, int i, int j, int index) {
        // index: scan with the word
        if(index == word.length()) {
            return true;
        }
        // if i, j are legal, this board isn't used, and board == word, return true, otherwise return false
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || used[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }
        // set this position as true(used)
        used[i][j] = true;
        // find its neighbor to match a char
        boolean result = search(board, word, used, i + 1, j, index + 1) || search(board, word, used, i, j + 1, index + 1) || search(board, word, used, i - 1, j, index + 1) || search(board, word, used, i, j - 1, index + 1);
        // if this position is existed, it will go further search, if not, set this position as false for future use
        used[i][j] = false;
        return result;
    }
}
