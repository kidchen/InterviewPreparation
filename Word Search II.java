/*
Given a matrix of lower alphabets and a dictionary. Find all words in the dictionary that can be found in the matrix. 
A word can start from any position in the matrix and go left/right/up/down to the adjacent position. 

Example
Given matrix:
doaf
agai
dcan
and dictionary:
{"dog", "dad", "dgdg", "can", "again"}

return {"dog", "dad", "can", "again"}
*/

// O(m*n*k) time, O(m*n) space

public class Solution {
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
    public ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
        // write your code here
        ArrayList<String> result = new ArrayList<String>();
        if(board == null || board.length == 0 || board[0].length == 0 || words == null || words.size() == 0) {
            return result;
        }
        for(int k = 0; k < words.size(); k++) {
            boolean[][] used = new boolean[board.length][board[0].length];
            for(int i = 0; i < board.length; i++) {
                for(int j = 0; j < board[0].length; j++) {
                    if(helper(board, used, words.get(k), i, j, 0)) {
                        result.add(words.get(k));
                        i = board.length;
                        j = board[0].length;
                    }
                }
            }
        }
        return result;
    }
    
    private boolean helper(char[][] board, boolean[][] used, String word, int row, int col, int index) {
        if(index == word.length()) {
            return true;
        }
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length 
            || used[row][col] || board[row][col] != word.charAt(index)) {
            return false;
        }
        used[row][col] = true;
        boolean result = helper(board, used, word, row + 1, col, index + 1) ||
        helper(board, used, word, row - 1, col, index + 1) ||
        helper(board, used, word, row, col + 1, index + 1) ||
        helper(board, used, word, row, col - 1, index + 1);
        used[row][col] = false;
        return result;
    }
}


// Challenge
// Using trie to implement your algorithm.
