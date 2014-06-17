public class Solution {
    public int totalNQueens(int n) {
        // !!! we can not use int result to pass result !!!
        ArrayList<Integer> result = new ArrayList<Integer>();
        // !!! initial result !!!
        result.add(0);
        helper(n, result, 0, new int[n]);
        return result.get(0);
    }
    
    void helper(int n, ArrayList<Integer> result, int row, int[] column) {
        if(row == n) {
        // add count to the first element in result (we only use the first element) !!!
            result.set(0,result.get(0)+1);
            return;
        }
        for(int i = 0; i < n; i++) {
            column[row] = i;
            if(check(row, column)){
                helper(n, result, row + 1, column);
            }
        }
    }
    
    boolean check(int row, int[] column) {
        for(int i = 0; i < row; i++) {
            if(column[i] == column[row] || row - i == Math.abs(column[row] - column[i])) return false;
        }
        return true;
    }
}
