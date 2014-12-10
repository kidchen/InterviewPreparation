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
            // A[i] should be positive && no larger than A.length && one larger than its index
            if(A[i] > 0 && A[i] <= A.length && A[i] != A[A[i] - 1]) {
                // have to temp A[A[i] - 1] rather A[i]
                int temp = A[A[i] - 1];
                A[A[i] - 1] = A[i];
                A[i] = temp;
                // !!! need to stay in current position after swap !!!
                i--;
            }
        }
        for(int i = 0; i < A.length; i++) {
            if(A[i] != i + 1) {
                return i + 1;
            }
        }
        // means after for loop, then return A.length+1
        return A.length + 1;
    }
}
