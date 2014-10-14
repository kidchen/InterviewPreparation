/*
Given two sorted integer arrays A and B, merge B into A as one sorted array.

Note:
You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B. 
The number of elements initialized in A and B are m and n respectively.
*/

// O(m+n), O(1) space

public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        if(A == null && B == null) {
            return;
        }
        int result = m + n - 1;
        while(m > 0 && n > 0) {
            if(A[m - 1] < B[n - 1]) {
                A[result] = B[n - 1];
                n--;
            } else {
                A[result] = A[m - 1];
                m--;
            }
            result--;
        }
        while(n > 0) {
            A[result] = B[n - 1];
            result--;
            n--;
        }
    }
}
