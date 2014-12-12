/*
Given n items with size A[i], an integer m denotes the size of a backpack. How full you can fill this backpack? 

Note
You can not divide any item into small pieces.

Example
If we have 4 items with size [2, 3, 5, 7], the backpack size is 11, we can select 2, 3 and 5, 
so that the max size we can fill this backpack is 10. 
If the backpack size is 12. we can select [2, 3, 7] so that we can fulfill the backpack.

You function should return the max size we can fill in the given backpack.
*/

// DP: O(m*n) time, O(m) space

public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        // write your code here
        if(m == 0 || A == null || A.length == 0) {
            return 0;
        }
        // set an array that one size bigger than target
        int[] result = new int[m + 1];
        for(int i = 0; i < A.length; i++) {
            int size = A[i];
            // outer: select an item
            // inner: decide whether put it into the bag or not(from last to first include 0)
            for(int j = m; j >= 0; j--) {
                // if the item is smaller than target, try each possible solution
                if(j >= size) {
                    // max(not put in, put in)
                    // put in: previous [j-size] items and current one(size)
                    result[j] = Math.max(result[j], result[j - size] + size);
                }
            }
        }
        // return the last element
        return result[m];
    }
}
