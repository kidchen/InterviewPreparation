/*
Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

For example,
X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
*/

// BFS with a queue:
// search four sides first, then do the BFS for all 'O' on the sides, remark them as 'S'
// O(mn), O(m+n) space cost

public class Solution {
    public void solve(char[][] board) {
        if(board == null || board.length < 2 || board[0].length < 2) {
            return;
        }
        // careful of the index
        for(int i = 0; i < board.length; i++) {
            fill(board, i, 0);
            fill(board, i, board[0].length - 1);
        }
        for(int i = 0; i < board[0].length; i++) {
            fill(board, 0, i);
            fill(board, board.length - 1, i);
        }
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if(board[i][j] == 'S') {
                    board[i][j] = 'O';
                }
            }
        }
        return;
    }
    
    private void fill(char[][] board, int i, int j) {
        // != 'O', can't use == 'X', because we may change X to S before
        if(board[i][j] != 'O') {
            return;
        }
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(i);
        queue.add(j);
        board[i][j] = 'S';
        while(!queue.isEmpty()) {
            int row = queue.poll();
            int col = queue.poll();
            if(row > 0 && board[row - 1][col] == 'O') {
                queue.add(row - 1);
                queue.add(col);
                board[row - 1][col] = 'S';
            }
            if(row < board.length - 1 && board[row + 1][col] == 'O') {
                queue.add(row + 1);
                queue.add(col);
                board[row + 1][col] = 'S';
            }
            if(col > 0 && board[row][col - 1] == 'O') {
                queue.add(row);
                queue.add(col - 1);
                board[row][col - 1] = 'S';
            }
            if(col < board[0].length - 1 && board[row][col + 1] == 'O') {
                queue.add(row);
                queue.add(col + 1);
                board[row][col + 1] = 'S';
            }
        }
        return;
    }
}
