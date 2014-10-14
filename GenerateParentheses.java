/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
*/

// O(result), O(result)

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        if(n <= 0) {
            return result;
        }
        String item = "";
        helper(n, n, result, item);
        return result;
    }
    
    private void helper(int left, int right, List<String> result, String item) {
    // here, we minus left and right, so if left>right, that means we have more '(' than ')' to assign, which is wrong
        if(left > right) {
            return;
        }
        if(left == 0 && right == 0) {
            result.add(item);
            return;
        }
        // if we have left to assign, minus left by one and add '(' to the item
        // !!! note: we don't need to remove the last element after doing the recursion !!!
        //     --> ?
        if(left > 0) {
            helper(left - 1, right, result, item+"(");
        }
        if(right > 0) {
            helper(left, right - 1, result, item+")");
        }
    }
}


/******** OLD VERSION *********/


public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<String>();
        if(n==0){
            res.add("");
            return res;
        }
        help(0,0,n,res,"");
        return res;
    }
    
    void help(int left, int right, int n, ArrayList<String> res, String temp){
        // left = n
        if(left == n){
            for(int i=0; i<left-right; i++){
                temp+=")";
            }
            res.add(temp);
            return;
        }
        
        // left>right
        if(left>right){
            help(left+1,right,n,res,temp+"(");
            help(left,right+1,n,res,temp+")");
        }
        
        // left=right
        if(left==right){
            help(left+1,right,n,res,temp+"(");
        }
    }
}
