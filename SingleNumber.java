/*Given an array of integers, every element appears twice except for one. Find that single one.
Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
*/

public class Solution {
    public int singleNumber(int[] A) {
        int single = 0;
        for(int i = 0; i < A.length; i++){
            // Exclusive or:
            // 1 xor 1 = 0: same int xor = 0
            // 1 xor 0 = 1: any int xor 0 = this int
            single = single ^ A[i];
        }
        return single;
    }
}

