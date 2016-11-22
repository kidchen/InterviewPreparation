/*
Given an array of integers, find two non-overlapping subarrays which have the largest sum.

The number in each subarray should be contiguous.

Return the largest sum.

Note
The subarray should contain at least one number

Example
For given [1, 3, -1, 2, -1, 2], the two subarrays are [1, 3] and [2, -1, 2] or [1, 3, -1, 2] and [2], 
they both have the largest sum 7.

Challenge
Can you do it in time complexity O(n) ?
*/

// O(n) time, O(n) space
// similar with Maximum Subarray Difference

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    public int maxTwoSubArrays(ArrayList<Integer> nums) {
        // write your code
        if(nums == null || nums.size() == 0) {
            return Integer.MIN_VALUE;
        }
        int len = nums.size();
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = nums.get(0);
        right[len - 1] = nums.get(len - 1);
        int max = nums.get(0);
        for(int i = 1; i < len; i++) {
            // max: max sum includes current number (i)
            max = Math.max(nums.get(i), nums.get(i) + max);
            // left[i]: max sum so far (may or may not include current number (i))
            left[i] = Math.max(left[i - 1], max);
        }
        max = nums.get(len - 1);
        for(int i = len - 2; i >= 0; i--) {
            max = Math.max(nums.get(i), nums.get(i) + max);
            right[i] = Math.max(right[i + 1], max);
        }
        int result = Integer.MIN_VALUE;
        for(int i = 0; i < len - 1; i++) {
            result = Math.max(result, left[i] + right[i + 1]);
        }
        return result;
    }
}
