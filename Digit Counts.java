/*
Count the number of k's between 0 and n. k can be 0 - 9.

Example
if n=12, in [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12], we have FIVE 1's (1, 10, 11, 12)
*/

// O(n) time, O(1) space

class Solution {
    /*
     * param k : As description.
     * param n : As description.
     * return: An integer denote the count of digit k in 1..n
     */
    public int digitCounts(int k, int n) {
        // write your code here
        int result = 0;
        for(int i = 0; i <= n; i++) {
            int temp = i;
            // need to deal with k == 0 && n == 0
            if(temp == 0 && k == 0) {
                result++;
            }
            while(temp != 0) {
                if(temp % 10 == k) {
                    result++;
                }
                temp /= 10;
            }
        }
        return result;
    }
};

