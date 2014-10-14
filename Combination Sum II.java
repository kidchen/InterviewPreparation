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
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(num == null || num.length == 0) {
            return result;
        }
        // don't forget to sort the array at first
        Arrays.sort(num);
        List<Integer> sum = new ArrayList<Integer>();
        helper(num, target, result, 0, sum);
        return result;
    }
    
    private void helper(int[] num, int target, List<List<Integer>> result, int start, List<Integer> sum) {
        if(target == 0) {
            result.add(new ArrayList<Integer>(sum));
            return;
        }
        for(int i = start; i < num.length; i++) {
            // !!! still need to skip the duplicates !!!
            //     --> if we need to use the same value, it will be considered in the next recursion, 
            //         now we skip the duplicates value for not recalculate the cases (void of duplicates results)
            // !!! Pay attention to i>start, not i>0 !!!
            if(i > start && num[i] == num[i - 1]) {
                continue;
            }
            sum.add(num[i]);
            if(target - num[i] >= 0) {
                helper(num, target - num[i], result, i + 1, sum);
            }
            sum.remove(sum.size() - 1);
        }
    }
}
