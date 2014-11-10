public class kthNumber {
    public static void main(String[] args) { 
        int[] A = {1,2,3,4,5};
        int[] B = {2,3,4,5,6}; 
        System.out.println(knumber(A, B, 4));
    }
    public static int knumber(int[] A, int[] B, int k) { 
        return helper(A, B, 0, 0, k);
    }
    private static int helper(int[] A, int[] B, int astart, int bstart, int k) { 
        if(astart >= A.length) {
            return B[bstart + k - 1]; 
        }
        if(bstart >= B.length) { 
            return A[astart + k - 1];
        }
        if(k == 1) {
            return Math.min(A[astart], B[bstart]); 
        }
        int ak = astart + k/2 - 1 < A.length ? A[astart + k/2 - 1] : Integer.MAX_VALUE; 
        int bk = bstart + k/2 - 1 < B.length ? B[bstart + k/2 - 1] : Integer.MAX_VALUE; 
        if(ak < bk) {
            return helper(A, B, astart + k/2, bstart, k - k/2); 
        } else {
            return helper(A, B, astart, bstart + k/2, k - k/2); 
        }
    } 
}
