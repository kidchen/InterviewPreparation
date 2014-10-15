/*
Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.
*/

// O(2n), O(1) space cost

public class Solution {
    public int firstMissingPositive(int[] A) {
        if(A == null || A.length == 0) {
            return 1;
        }
        for(int i = 0; i < A.length; i++) {
            // !!! A[A[i] - 1] vs. A[i] !!!
            // we only consider numbers that are positive && smaller or equal to A.length
            // !!! Also, we skip the numbers that already in the right position !!!
            if(A[i] <= A.length && A[i] > 0 && A[A[i] - 1] != A[i]) {
                // !!! temp should store A[A[i] - 1] rather than A[i], consider [2,1] !!!
                int temp = A[A[i] - 1];
                A[A[i] - 1] = A[i];
                A[i] = temp;
                // !!! to still leave at this point, or use a while loop !!!
                i--;
            }
        }
        for(int i = 0; i < A.length; i++) {
            if(A[i] != i + 1) {
                return i + 1;
            }
        }
        return A.length + 1;
    }
}
