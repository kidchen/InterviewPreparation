/*
Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
*/

// DP problem similar with Maximum Subarray (global & local method), but maintain both local_min & local_max
// because the product can be easily changed if the current value is negative

// O(n), O(1) space cost

public class Solution {
    public int maxProduct(int[] A) {
        if(A == null || A.length == 0) {
            return 0;
        }
        int local_min = A[0];
        int local_max = A[0];
        int global = A[0];
        for(int i = 1; i < A.length; i++) {
            int local_max_copy = local_max;
            local_max = Math.max(Math.max(A[i], A[i] * local_max), A[i] * local_min);
            local_min = Math.min(Math.min(A[i], A[i] * local_max_copy), A[i] * local_min);
            global = Math.max(global, local_max);
        }
        return global;
    }
}
