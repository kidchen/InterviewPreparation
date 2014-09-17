/*
Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.
*/

// O(n), O(1) in general space, worst case O(n) space if we need to new an array

public class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 0;
        int i = digits.length - 1;
        digits[i]++;
        while(digits[i] >= 10) {
            digits[i] -= 10;
            i--;
            if(i >= 0) {
                digits[i]++;
            } else {
                carry = 1;
                break;
            }
        }
        if(carry == 0) 
            return digits;
        int[] result = new int[digits.length + 1];
        res[0] = 1;
        // the following for loop is not necessary in Java since the initial value of int[] is 0
        // and the only chance we need to new an array is carray = 1, which means the orignal value should be all 9
        for(int j = 1; j < digits.length; j++) {
            result[j] = digits[j-1];
        }
        return result;
    }
}
