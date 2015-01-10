/*
Given an array with integers.

Find two non-overlapping subarrays A and B, which |SUM(A) - SUM(B)| is the largest.

Return the largest difference.

Note
The subarray should contain at least one number

Example
For [1, 2, -3, 1], return 6

Challenge
O(n) time and O(n) space.
*/

// O(n) time and O(n) space.
// find leftmax[], leftmin[], rightmax[], rightmin[]: so far to position i, from left/right, the max/min sum of subarray

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer indicate the value of maximum difference between two
     *          Subarrays
     */
    public int maxDiffSubArrays(ArrayList<Integer> nums) {
        // write your code
        if(nums == null || nums.size() < 2) {
            return 0;
        }
        // leftMin[i]: so far to position i, from left, the min sum of subarray
        int[] leftMin = new int[nums.size()];
        int[] leftMax = new int[nums.size()];
        leftMin[0] = nums.get(0);
        leftMax[0] = nums.get(0);
        int minEnd = nums.get(0);
        int maxEnd = nums.get(0);
        for(int i = 1; i < nums.size(); i++) {
            minEnd = Math.min(nums.get(i), nums.get(i) + minEnd);
            leftMin[i] = Math.min(minEnd, leftMin[i - 1]);
            maxEnd = Math.max(nums.get(i), nums.get(i) + maxEnd);
            leftMax[i] = Math.max(maxEnd, leftMax[i - 1]);
        }
        int[] rightMin = new int[nums.size()];
        int[] rightMax = new int[nums.size()];
        rightMin[nums.size() - 1] = nums.get(nums.size() - 1);
        rightMax[nums.size() - 1] = nums.get(nums.size() - 1);
        int minStart = nums.get(nums.size() - 1);
        int maxStart = nums.get(nums.size() - 1);
        for(int i = nums.size() - 2; i >= 0; i--) {
            minStart = Math.min(nums.get(i), nums.get(i) + minStart);
            rightMin[i] = Math.min(minStart, rightMin[i + 1]);
            maxStart = Math.max(nums.get(i), nums.get(i) + maxStart);
            rightMax[i] = Math.max(maxStart, rightMax[i + 1]);
        }
        int maxDiff = 0;
        for(int i = 0; i < nums.size() - 1; i++) {
            if(maxDiff < Math.abs(leftMax[i] - rightMin[i + 1])) {
                maxDiff = Math.abs(leftMax[i] - rightMin[i + 1]);
            }
            if(maxDiff < Math.abs(leftMin[i] - rightMax[i + 1])) {
                maxDiff = Math.abs(leftMin[i] - rightMax[i + 1]);
            }
        }
        return maxDiff;
    }
}
