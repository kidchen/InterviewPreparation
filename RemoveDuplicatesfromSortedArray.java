/*
Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array A = [1,1,2],

Your function should return length = 2, and A is now [1,2].
*/

public class Solution {
    public int removeDuplicates(int[] A) {
        if(A == null || A.length < 2){
            return A.length;
        }
        // index is the new length
        int index = 1;
        for(int i = 1; i < A.length; i++) {
            if(A[i] != A[i - 1]) {
                // set the current value to index
                A[index] = A[i];
                index++;
            }
        }
        return index;
    }
}
