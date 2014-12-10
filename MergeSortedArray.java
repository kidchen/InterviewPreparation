/*
Given two sorted integer arrays A and B, merge B into A as one sorted array.

Note:
You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B. 
The number of elements initialized in A and B are m and n respectively.
*/

// O(m+n), O(1) space

class Solution {
    /**
     * @param A: sorted integer array A which has m elements, 
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        while(m > 0 && n > 0) {
            if(A[m - 1] > B[n - 1]) {
                A[m + n - 1] = A[m - 1];
                m--;
            } else {
                A[m + n - 1] = B[n - 1];
                n--;
            }
        }
        while(n > 0) {
            A[m + n - 1] = B[n - 1];
            n--;
        }
        return;
    }
}


// LintCode Challenge:
// How can you optimize your algorithm if one array is very large and the other is very small?

class Solution {
    /**
     * @param A and B: sorted integer array A and B.
     * @return: A new sorted integer array
     */
    public ArrayList<Integer> mergeSortedArray(ArrayList<Integer> A, ArrayList<Integer> B) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        int i = 0, j = 0;
        while(i < A.size() && j < B.size()) {
            if(A.get(i) < B.get(j)) {
                result.add(A.get(i));
                i++;
            } else {
                result.add(B.get(j));
                j++;
            }
        }
        while(i < A.size()) {
            result.add(A.get(i));
            i++;
        }
        while(j < B.size()) {
            result.add(B.get(j));
            j++;
        }
        return result;
    }
}

