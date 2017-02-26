/**
Given a set of distinct integers, nums, return all possible subsets.

        Note: The solution set must not contain duplicate subsets.

        For example,

        If nums = [1,2,3], a solution is:

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
**/


// Recursion: O(2^n)

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return results;
        }
        List<Integer> subset = new ArrayList<>();
        helper(nums, 0, subset, results);
        return results;
    }

    private void helper(int[] nums, int index, List<Integer> subset, List<List<Integer>> results) {
        results.add(new ArrayList<>(subset));
        for (int i = index; i < nums.length; i++) {
            subset.add(nums[i]);
            helper(nums, i + 1, subset, results);
            subset.remove(subset.size() - 1);
        }
    }
}


// Iteration:

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return results;
        }
        // add empty one first
        results.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int size = results.size();
            // add new number to all previous subsets
            for (int j = 0; j < size; j++) {
                List<Integer> subset = new ArrayList<>(results.get(j));
                subset.add(nums[i]);
                results.add(subset);
            }
        }
        return results;
    }
}
