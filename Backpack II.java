/*
Given n items with size A[i] and value V[i], and a backpack with size m. What's the maximum value can you put into the backpack?
Note
You cannot divide item into small pieces and the total size of items you choose should smaller or equal to m.

Example
Given 4 items with size [2, 3, 5, 7] and value [1, 5, 2, 4], and a backpack with size 10. The maximum value is 9.
*/

// O(m * n) time, O(m) space

public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A & V: Given n items with size A[i] and value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int V[]) {
        // write your code here
        if(m == 0 || A.length == 0 || V.length == 0) {
            return 0;
        }
        int[] result = new int[m + 1];
        int value = 0;
        for(int i = 0; i < A.length; i++) {
            int size = A[i];
            for(int j = m; j >= size; j--)  {
                // diff: add current value as V[i], not size !!!
                result[j] = Math.max(result[j], result[j - size] + V[i]);
                // maintain the value to return
                value = Math.max(value, result[j]);
            }
        }
        return value;
    }
}
