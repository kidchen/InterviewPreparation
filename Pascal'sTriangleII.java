/*
Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?
*/

// from last to first, O(n^2) time, O(k) space cost

public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(rowIndex < 0) {
            return result;
        }
        // first "1"
        result.add(1);
        for(int i = 0; i < rowIndex; i++) {
            // last "1"
            result.add(1);
            // from the last but one to the second one
            for(int j = result.size() - 2; j > 0; j--) {
                result.set(j, result.get(j) + result.get(j - 1));
            }
        }
        return result;
    }
}


// Solution simply from Pascal's Triangle I

public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        for(int i=0; i<=rowIndex; i++){
            ArrayList<Integer> row = new ArrayList<Integer>();
            row.add(1);
            if(rowIndex==0) return row;
            if(i>0){
                for(int j=0; j<res.get(i-1).size()-1; j++){
                    row.add(res.get(i-1).get(j)+res.get(i-1).get(j+1));
                }
                row.add(1);
            }
            res.add(row);
        }
        return res.get(rowIndex);
    }
}
