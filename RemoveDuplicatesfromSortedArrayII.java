/*
Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array A = [1,1,1,2,2,3],

Your function should return length = 5, and A is now [1,1,2,2,3].
*/

public class Solution {
    public int removeDuplicates(int[] A) {
        int n = A.length;
        if(n <= 2) {
            return n;
        }
        // initial two pointers as 1 and 2 (rather than 0, 1), i will be the newer index
        int i=1, j=2;
        while(i < n && j < n) {
            // if current value equals to the former one and the one before the former one
            if(A[i] == A[j] && A[i - 1] == A[j]) {
            // skip the current value (as it shows up in the third time)
                j++;
            } else {
            // move the previous pointer, set current value to the next, then move the current pointer
                i++;
                A[i] = A[j];
                j++;
            }
        }
        // length = index + 1
        return i + 1;
    }
}


// different between I and II is the initial pointer (0,1)-->(1,2)
// because we need to check whether current pointer is the same with the former one and
// the one before the former one (whether 2 is the same with 1 and 0?)
