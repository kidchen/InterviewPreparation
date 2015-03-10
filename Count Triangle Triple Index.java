/*
You are given a non-empty zero-based indexing array A that consists of N integers, 
count the number of the triangle triple indexes.

A triangle triple index is a triple of integers ( 0 <= P < Q < R < N ) that is defined as follows: 

A[P] + A[Q] > A[R] 
A[p] + A[R] > A[Q] 
A[Q] + A[R] > A[P]

The input should be a list of N non-negative integers less than 1,000,000, where N should be less than or equal to 1,000.
*/

class Solution {
    int countTriangleTripleIndex(int [] A) {
        if(A == null || A.length < 3) {
            return 0;
        }
        int count = 0;
        Arrays.sort(A);
        for(int i = 0; i < A.length - 2; i++) {
            int k = i + 2;
            for(int j = i + 1; j < A.length - 1; j++) {
                while(k < A.length && A[i] + A[j] > A[k]) {
                    k++;
                }
                if(k - 1 > j) {
                    count += k - j - 1;
                }
            }
        }
        return count;
    }
}
