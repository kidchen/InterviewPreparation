public class Solution {
    public ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> result = new ArrayList<String[]>();
        helper(result, n, 0, new int[n]);
        return result;
    }
    
    void helper(ArrayList<String[]> result, int n, int row, int[] column) {
        // all rows are filled
        if(row == n) {
            // use a new item, because we should return String[] in ArrayList !!!
            String[] item = new String[n];
            for(int i = 0; i < n; i++) {
                // new StringBuffer in each for loop !!!
                StringBuffer sb = new StringBuffer();
                for(int j = 0; j < n; j++) {
                    if(column[i] == j) {
                        sb.append("Q");
                    }else{
                        sb.append(".");
                    }
                }
                item[i] = sb.toString();
            }
            result.add(item);
            return;
        }
        // fill each row in different columns
        for(int i = 0; i < n; i++) {
            column[row] = i;
            if(check(row, column)) {
                helper(result, n, row + 1, column);
            }
        }
    }
    
    boolean check(int row, int[] column) {
        for(int i = 0; i < row; i++) {
            // check whether this column have been placed with a queen
            // OR is there any queen in diagonal line --> check if the difference between rows and columns are the same
            if(column[i] == column[row] || row - i == Math.abs(column[i] - column[row])) return false;
        }
        return true;
    }
}
