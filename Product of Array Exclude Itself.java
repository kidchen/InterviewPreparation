/*
Given an integers array A.

Define B[i] = A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1], calculate B without divide operation.

Example
For A=[1, 2, 3], B is [6, 3, 2]
*/

// O(n) time, O(n) space

public class Solution {
    /**
     * @param A: Given an integers array A
     * @return: A Long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    public ArrayList<Long> productExcludeItself(ArrayList<Integer> A) {
        // write your code
        ArrayList<Long> result = new ArrayList<Long>();
        if(A == null || A.size() < 2) {
            return result;
        }
        long left = 1;
        long right = 1;
        for(int i = 0; i < A.size(); i++) {
            result.add(1L);
            result.set(i, result.get(i) * left);
            left *= A.get(i);
        }
        for(int i = 0; i < A.size(); i++) {
            result.set(A.size() - 1 - i, result.get(A.size() - 1 - i) * right);
            right *= A.get(A.size() - 1 - i);
        }
        return result;
    }
}
