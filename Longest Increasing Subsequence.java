/*
Given a sequence of integers, find the longest increasing subsequence (LIS).

You code should return the length of the LIS.

Example
For [5, 4, 1, 2, 3], the LIS  is [1, 2, 3], return 3
For [4, 2, 4, 5, 3, 7], the LIS is [4, 4, 5, 7], return 4

Challenge
Time complexity O(n^2) or O(nlogn)

Clarification
What's the definition of longest increasing subsequence?
* The longest increasing subsequence problem is to find a subsequence of a given sequence 
in which the subsequence's elements are in sorted order, lowest to highest, 
and in which the subsequence is as long as possible. 
This subsequence is not necessarily contiguous, or unique.  
*/

// DP solution: O(n^2) time with O(n) space cost

public class Solution {
    /**
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0) {
            return 0;
        }
        // result[i]: make ith element as the end of the subsequence, what's the length of the result
        int[] result = new int[nums.length];
        result[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            result[i] = 1;
            for(int j = 0; j < i; j++) {
                if(nums[j] <= nums[i]) {
                    result[i] = Math.max(result[i], result[j] + 1);
                }
            }
        }
        int length = 1;
        for(int res : result) {
            length = Math.max(length, res);
        }
        return length;
    }
}
