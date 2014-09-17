/*
Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


A partially filled sudoku which is valid.

Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
*/


// with three passes (actually 27 times check), O(3*n^2), n=9

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board == null || board.length != 9 || board[0].length != 9) {
            return false;
        }
        // each row
        for(int i = 0; i < 9; i++) {
            boolean[] num = new boolean[9];
            for(int j = 0; j < 9; j++) {
                if(board[i][j] != '.') {
                    if(num[(int)(board[i][j] - '1')]) {
                        return false;
                    } 
                    num[(int)(board[i][j] - '1')] = true;
                }
            }
        }
        // each col
        for(int i = 0; i < 9; i++) {
            boolean[] num = new boolean[9];
            for(int j = 0; j < 9; j++) {
                if(board[j][i] != '.') {
                    if(num[(int)(board[j][i] - '1')]) {
                        return false;
                    } 
                    num[(int)(board[j][i] - '1')] = true;
                }
            }
        }
        // each block
        for(int block = 0; block < 9; block++) {
            boolean[] num = new boolean[9];
            // for row
            for(int i = block/3*3; i < block/3*3 + 3; i++) {
                // for col
                for(int j = block%3*3; j < block%3*3 + 3; j++) {
                    if(board[i][j] != '.') {
                        if(num[(int)(board[i][j] - '1')]) {
                            return false;
                        } 
                        num[(int)(board[i][j] - '1')] = true;
                    }
                }
            }
        }
        return true;
    }
}


// Or use HashSet to store the numbers:

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> set = new HashSet<Character>();
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j]=='.'){
                    continue;
                }
                if(set.contains(board[i][j])){
                    return false;
                }
                set.add(board[i][j]);
            }
            set.clear();
        }

        for(int j=0; j<9; j++){
            for(int i=0; i<9; i++){
                if(board[i][j]=='.'){
                    continue;
                }
                if(set.contains(board[i][j])){
                    return false;
                }
                set.add(board[i][j]);
            }
            set.clear();
        }
        
        for(int k=0; k<9; k++){
            for(int i=k/3*3; i<k/3*3+3; i++){
                for(int j=k%3*3; j<k%3*3+3; j++){
                    if(board[i][j]=='.'){
                        continue;
                    }
                    if(set.contains(board[i][j])){
                        return false;
                    }
                    set.add(board[i][j]);
                }
            }
            set.clear();
        }
        
        return true;
    }
}



// using extra spaces, we can do it in one pass

// One pass: 556ms for 501 test cases
public boolean isValidSudoku(char[][] board) {
    // rowChecker[i][j]=true: j appears in row i
    boolean[][] rowChecker = new boolean[9][9];
    // columnChecker[i][j]=true: j appears in column i
    boolean[][] columnChecker = new boolean[9][9];
    // gridChecker[i][j]=true: j appears in grid i
    // numberring from left to right, then top to bottom
    boolean[][] gridChecker = new boolean[9][9];

    // One-pass scan in row-major manner
    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            if (board[i][j] == '.')
                continue;
            int val = board[i][j] - '1';
            // Check for the corresponding row, column, and grid at the same time
            if (rowChecker[i][val] || columnChecker[j][val] || gridChecker[i/3*3+j/3][val])
                return false;
            rowChecker[i][val] = columnChecker[j][val] = gridChecker[i/3*3+j/3][val] = true;
        }
    }
    return true;
}
