/*
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/

public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> eachResult = new ArrayList<Integer>();
        if(n<1 || k<1) return results;
        helper(1,n,k,eachResult,results);
        return results;
    }
    
    void helper(int start, int n, int k, ArrayList<Integer> eachResult, ArrayList<ArrayList<Integer>> results){
        if(eachResult.size()==k){
            // !!! have to use a new ArrayList
            // !!! eachResult will be removed later
            results.add(new ArrayList<Integer>(eachResult)); 
            return;
        }else{
            for(int i=start; i<=n; i++){
                eachResult.add(i);
                helper(i+1,n,k,eachResult,results);
                eachResult.remove(eachResult.size()-1);
            }
        }
    }
}
