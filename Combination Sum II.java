/*
Given a collection of candidate numbers (C) and a target number (T), 
find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
A solution set is: 
[1, 7] 
[1, 2, 5] 
[2, 6] 
[1, 1, 6] 
*/

// NP: O(2^n), O(n) space for the result

public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length == 0) {
            return result;
        }
        // don't forget to sort
        Arrays.sort(num);
        ArrayList<Integer> item = new ArrayList<Integer>();
        helper(num, target, result, item, 0);
        return result;
    }
    
    private void helper(int[] num, int target, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> item, int start) {
        if(target == 0) {
            result.add(new ArrayList<Integer>(item));
            return;
        }
        for(int i = start; i < num.length; i++) {
            // still, we need to remove duplicates(avoid duplicated results)
            // if we need to use the same value, it will be considered in the next recursion
            // !!! i > start, rather than i > 0
            if(i > start && num[i] == num[i - 1]) {
                continue;
            }
            if(target - num[i] >= 0) {
                item.add(num[i]);
                // diff: here, we need to "i+1" to skip the current element
                helper(num, target - num[i], result, item, i + 1);
                item.remove(item.size() - 1);
            }
        }
    }
}
