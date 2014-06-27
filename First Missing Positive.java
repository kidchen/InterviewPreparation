public class Solution {
    public int firstMissingPositive(int[] A) {
        // only sort positive numbers, eg: [-1,4,1,9]-->[1,4,-1,9]
        if(A == null || A.length == 0) return 1;
        for(int i = 0; i < A.length; i++) {
            // A[A[i] - 1] != A[i] : consider [1,1]
            if(A[i] <= A.length && A[i] > 0 && A[A[i] - 1] != A[i]) {
                // temp should store A[A[i] - 1] rather than A[i], consider [2,1]
                int temp = A[A[i] - 1];
                A[A[i] - 1] = A[i];
                A[i] = temp;
                // !!! to still leave at this point !!!
                i--;
            }
        }
        for(int i = 0; i < A.length; i++) {
            if(A[i] != i + 1) return i + 1;
        }
        return A.length + 1;
    }
}
