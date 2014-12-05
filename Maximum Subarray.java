/*
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.
*/

// DP: O(n) time, O(1) space
// Global & Local

public class Solution {
    public int maxSubArray(int[] A) {
        if(A.length == 0) return 0;
        int local = A[0];
        int global = A[0];
        for(int i = 1; i < A.length; i++) {
            // !!! Have to include A[i] !!!
            local = Math.max(A[i], local + A[i]);
            global = Math.max(local, global);
        }
        return global;
    }
}

// More practice: If you have figured out the O(n) solution, 
// try coding another solution using the divide and conquer approach, which is more subtle.
