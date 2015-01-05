/*
Given 2*n + 2 numbers, every numbers occurs twice except two, find them.

Example
Given [1,2,2,3,4,4,5,3] return 1 and 5

Challenge
O(n) time, O(1) extra space.
*/

// Those two different numbers have one different bit at least. 
// Using one of these bits as mask, find the first number. And then get the result.
// Pay attention to the priority: bitwise left/right > comparison operation > & > ^ > |

public class Solution {
    /**
     * @param A : An integer array
     * @return : Two integers
     */
    public List<Integer> singleNumberIII(int[] A) {
        // write your code here
        List<Integer> result = new ArrayList<Integer>();
        if(A == null || A.length == 0) {
            return result;
        }
        // two: two nums that appear once
        int two = 0;
        for(int i = 0; i < A.length; i++) {
            two ^= A[i];
        }
        // diff: one of the position that these two nums are diff(bit), using XOR
        int diff = 0;
        for(int i = 0; i < 32; i++) {
            if((two & (1 << i)) != 0) {
                diff = 1 << i;
            }
        }
        // first: find first num, by do all XOR to nums which have 1 on position diff
        int first = 0;
        for(int i = 0; i < A.length; i++) {
            if((A[i] & diff) != 0) {
                first ^= A[i];
            }
        }
        result.add(first);
        // the second num is the result of first XOR two
        result.add(first ^ two);
        return result;
    }
}
