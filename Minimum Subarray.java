/*
Given an array of integers, find the subarray with smallest sum.

Return the sum of the subarray.

Note
The subarray should contain at least one integer.

Example
For [1, -1, -2, 1], return -3
*/

// O(n) time, O(1) space

public class Solution {
    /**
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
    public int minSubArray(ArrayList<Integer> nums) {
        // write your code
        if(nums == null || nums.size() == 0) {
            return 0;
        }
        int local = nums.get(0);
        int global = nums.get(0);
        for(int i = 1; i < nums.size(); i++) {
            local = Math.min(local + nums.get(i), nums.get(i));
            global = Math.min(local, global);
        }
        return global;
    }
}
