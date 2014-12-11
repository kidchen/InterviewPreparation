/*
Using O(1) time to check whether an integer n is a power of 2.
Example
For n=4, return true

For n=5, return false
*/

// O(1) time/space
/* Thought: if n is a power of 2, its binary number only contains one 1,
 * eg: n = 8 --> 1000
 *     n = 7 --> 0111
 *     n&(n-1)   0000
 */

class Solution {
    /*
     * @param n: An integer
     * @return: True or false
     */
    public boolean checkPowerOf2(int n) {
        // write your code here
        if(n == 0) {
            return false;
        }
        if((n & (n - 1)) == 0) {
            return true;
        }
        return false;
    }
}
