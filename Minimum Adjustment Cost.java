/*
Given an integer array, adjust each integers so that the difference of every adjcent integers 
are not greater than a given number target.

If the array before adjustment is A, the array after adjustment is B, you should minimize the sum of |A[i]-B[i]| 

Note
You can assume each number in the array is a positive integer and not greater than 100

Example
Given [1,4,2,3] and target=1, one of the solutions is [2,3,2,3], the adjustment cost is 2 and it's minimal. Return 2.
*/

// O(100*100*n) time, O(100*n) space 

public class Solution {
    /**
     * @param A: An integer array.
     * @param target: An integer.
     */
    public int MinAdjustmentCost(ArrayList<Integer> A, int target) {
        // write your code here
        if(A == null || A.size() == 0) {
            return 0;
        }
        // result[i][j]: among first i elements, change ith to value j cost result[i][j]
        int[][] result = new int[A.size()][101];
        // for each element i, change it to j(from 1 to 100)
        for(int i = 0; i < A.size(); i++) {
            for(int j = 1; j <= 100; j++) {
                // initial to the max_value
                result[i][j] = Integer.MAX_VALUE;
                // if this is the first element, just set cost value
                if(i == 0) {
                    result[i][j] = Math.abs(j - A.get(i));
                } else {
                    // otherwise, do another for loop, k is the previous element's value
                    for(int k = 1; k <= 100; k++) {
                        // if the diff between cur and prev is bigger than target, continue
                        if(Math.abs(j - k) > target) {
                            continue;
                        }
                        // newer diff = cur diff + previous i-1 cost
                        int diff = Math.abs(j - A.get(i)) + result[i - 1][k];
                        // newer cost is the smaller one (related with different previous value)
                        result[i][j] = Math.min(result[i][j], diff);
                    }
                }
            }
        }
        // find the min result when i = A.size() - 1
        int min = result[A.size() - 1][1];
        for(int j = 2; j < 101; j++) {
            min = Math.min(min, result[A.size() - 1][j]);
        }
        return min;
    }
}
