There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).


public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        if((A.length + B.length) % 2 == 1) {
            return helper(A, B, 0, A.length - 1, 0, B.length - 1, (A.length + B.length) / 2 + 1);
        } else {
            return (helper(A, B, 0, A.length - 1, 0, B.length - 1, (A.length + B.length) / 2) + helper(A, B, 0, A.length - 1, 0, B.length - 1, (A.length + B.length) / 2 + 1) ) / 2.0;
        }
    }
    
    // !!! k is not the index, but the kth top number !!!
    private int helper(int[] A, int[] B, int al, int ar, int bl, int br, int k) {
        // m, n: the length of two arrays
        int m = ar - al + 1;
        int n = br - bl + 1;
        // always assume that m <= n
        if(m > n) {
            return helper(B, A, bl, br, al, ar, k);
        }
        // !!! order matters, have to check m == 0 first !!!
        // if m == 0: return the top k  in B
        if(m == 0) {
            return B[bl + k - 1];
        }
        // if k == 1: return the min of the first element in A and B
        if(k == 1) {
            return Math.min(A[al], B[bl]);
        }
        // !!! posA, posB are not index !!!
        int posA = Math.min(k/2, m);
        int posB = k - posA;
        // find the kth number
        if(A[al + posA - 1] == B[bl + posB - 1]) {
            return A[al + posA - 1];
        } else if(A[al + posA - 1] < B[bl + posB - 1]) {
            // !!! keep the posB element and discard the posA !!!
            return helper(A, B, al + posA, ar, bl, bl + posB - 1, k - posA);
        } else {
            // !!! keep the posB element and discard the posA !!!
            return helper(A, B, al, al + posA - 1, bl + posB, br, k - posB);
        }
    }
}
