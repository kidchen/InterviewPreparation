/*
Given an array of integers and a number k, find k non-overlapping subarrays which have the largest sum.

The number in each subarray should be contiguous.

Return the largest sum.

Note
The subarray should contain at least one number

Example
Given [-1,4,-2,3,-2,3],k=2, return 8
*/

// O(n^2*k) time with O(nk) space

public class Solution {
    /**
     * @param nums: A list of integers
     * @param k: An integer denote to find k non-overlapping subarrays
     * @return: An integer denote the sum of max k non-overlapping subarrays
     */
    public int maxSubArray(ArrayList<Integer> nums, int k) {
        // write your code
        if(nums == null || nums.size() == 0 || k < 1) {
            return Integer.MIN_VALUE;
        }
        
        int[][] dp = new int[k][nums.size()];
        
        /* init the dp[][]:
        eg. -7,1,-1,-3,-4,-10,2,-100,-51,-12
        after first for loop:
        -7 0 0 0 0 0 0 0 0 0 
        0 -6 0 0 0 0 0 0 0 0 
        0 0 -7 0 0 0 0 0 0 0 
        0 0 0 -10 0 0 0 0 0 0 
        after second for loop:
        -7 1 0 -3 -4 -10 2 -98 -51 -12 
        0 -6 0 0 0 0 0 0 0 0 
        0 0 -7 0 0 0 0 0 0 0 
        0 0 0 -10 0 0 0 0 0 0 
        */
        int sum = 0;
        for(int i = 0; i < k; i++) {
            sum += nums.get(i);
            dp[i][i] = sum;
        }
        for(int i = 1; i < nums.size(); i++) {
            dp[0][i] = Math.max(nums.get(i), dp[0][i - 1] + nums.get(i));
        }
        
        for(int i = 1; i < k; i++) {
            for(int j = i + 1; j < nums.size(); j++) {
                int curMax = dp[i][j - 1] + nums.get(j);
                for(int m = i - 1; m < j; m++) {
                    if(dp[i - 1][m] + nums.get(j) > curMax) {
                        curMax = dp[i - 1][m] + nums.get(j);
                    }
                }
                dp[i][j] = curMax;
            }
        }
        /*
        after the main loops:
        -7 1 0 -3 -4 -10 2 -98 -51 -12 
        0 -6 0 -2 -3 -9 3 -97 -49 -10 
        0 0 -7 -3 -4 -10 2 -97 -48 -9 
        0 0 0 -10 -7 -13 -1 -98 -49 -10 
        */
        
        int result = Integer.MIN_VALUE;
        for(int i = k - 1; i < nums.size(); i++) {
            if(dp[k - 1][i] > result) {
                result = dp[k - 1][i];
            }
        }
        return result;
    }
}
