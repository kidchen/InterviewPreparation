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

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(candidates == null || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        List<Integer> sum = new ArrayList<Integer>();
        helper(candidates, target, result, sum, 0);
        return result;
    }
    
    private void helper(int[] candidates, int target, List<List<Integer>> result, List<Integer> sum, int start) {
        /*
        if(target < 0) {
            return;
        }
        */
        if(target == 0) {
            result.add(new ArrayList<Integer>(sum));
            return;
        }
        for(int i = start; i < candidates.length; i++) {
            // !!! duplicated elements: ignore !!!
            if(i > 0 && candidates[i] == candidates[i - 1]) {
                continue;
            }
            sum.add(candidates[i]);
            // !!! actually, no need to add this check condition if you do the above check !!!
            if(target - candidates[i] >= 0) {
                helper(candidates, target - candidates[i], result, sum, i);
            }
            sum.remove(sum.size() - 1);
        }
    }
}
