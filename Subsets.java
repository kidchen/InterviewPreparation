/*
Given a set of distinct integers, S, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If S = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/

public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> subset = new ArrayList<Integer>();
        Arrays.sort(S);
        helper(result, subset, 0, S);
        return result;
    }
    
    void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> subset, int len, int[] S){
        result.add(new ArrayList<Integer>(subset));
        for(int i=len; i<S.length; i++){
            subset.add(S[i]);
            helper(result, subset,i+1, S);         // len = i+1
            subset.remove(subset.size()-1);
        }
    }
}


// typical DFS problem
