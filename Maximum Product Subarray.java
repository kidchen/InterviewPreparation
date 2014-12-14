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
        int localMin = A[0];
        int localMax = A[0];
        int global = A[0];
        for(int i = 1; i < A.length; i++) {
            // void of changes
            int localMaxCopy = localMax;
            int localMinCopy = localMin;
            // compare with (A[i], A[i]*local_min, A[i]*local_max)
            localMin = Math.min(Math.min(A[i], localMax * A[i]), A[i] * localMin);
            localMax = Math.max(Math.max(A[i], localMinCopy * A[i]), A[i] * localMaxCopy);
            global = Math.max(localMax, global);
        }
        return global;
    }
}
