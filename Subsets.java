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

// typical DFS problem: O(2^n) time/space

public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> subset = new ArrayList<Integer>();
        // Don't forget to sort the array first
        Arrays.sort(S);
        helper(result, subset, 0, S);
        return result;
    }
    
    private void helper(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> subset, int len, int[] S) {
        result.add(new ArrayList<Integer>(subset));
        // !!! i = len !!!
        for(int i = len; i < S.length; i++) {
            subset.add(S[i]);
            // !!! len = i + 1 !!!
            helper(result, subset,i + 1, S);
            // backtracking
            subset.remove(subset.size() - 1);
        }
    }
}


// non-recursion method: 
// No backtracking, but add items one by one

public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        result.add(new ArrayList<Integer>());
        if(S == null || S.length == 0) {
            return result;
        }
        // don't forget to sort at first
        Arrays.sort(S);
        for(int i = 0; i < S.length; i++) {
            // record the size of current result array
            int size = result.size();
            for(int j = 0; j < size; j++) {
                // copy the privous items and add the current new one element to all of them
                ArrayList<Integer> item = new ArrayList<Integer>(result.get(j));
                item.add(S[i]);
                result.add(item);
            }
        }
        return result;
    }
}
