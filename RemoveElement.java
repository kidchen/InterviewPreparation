/*
Given an array and a value, remove all instances of that value in place and return the new length.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.
*/

// O(n) time, O(1) space

public class Solution {
    public int removeElement(int[] A, int elem) {
        if(A == null || A.length == 0) {
            return 0;
        }
        int cur = 0;
        int len = 0;
        while(cur < A.length) {
            if(A[cur] != elem) {
                A[len] = A[cur];
                len++;
            }
            cur++;
        }
        return len;
    }
}
