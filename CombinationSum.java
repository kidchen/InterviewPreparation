/*
Given a set of candidate numbers (C) and a target number (T), 
find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 
*/

// NP: O(2^n), O(n) for the result
// modify the target value to push it near 0

public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(candidates == null || candidates.length == 0) {
            return result;
        }
        // don't forget to sort
        Arrays.sort(candidates);
        ArrayList<Integer> item = new ArrayList<Integer>();
        helper(candidates, target, result, item, 0);
        return result;
    }
    
    private void helper(int[] candidates, int target, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> item, int start) {
        if(target == 0) {
            result.add(new ArrayList<Integer>(item));
            return;
        }
        for(int i = start; i < candidates.length; i++) {
            // deall with duplicates
            if(i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if(target - candidates[i] >= 0) {
                item.add(candidates[i]);
                helper(candidates, target - candidates[i], result, item, i);
                item.remove(item.size() - 1);
            }
        }
    }
}
