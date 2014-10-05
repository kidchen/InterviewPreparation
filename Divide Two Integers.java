/*
Divide two integers without using multiplication, division and mod operator.
*/

// directly method: recursion doing the minus operation, O(n), but how about Max_value/1...

// bit operation: O(logn)

public class Solution {
    public int divide(int dividend, int divisor) {
        // if divisor = 0, return MAX_VALUE
        if(divisor == 0) {
            return Integer.MAX_VALUE;
        }
        int result = 0;
        // special case: Integer.MIN_VALUE (can't directly do abs)
        if(dividend == Integer.MIN_VALUE) {
            // add one divisor and add one to the result
            dividend += Math.abs(divisor);
            result = 1;
        }
        // deal with divisor special case
        if(divisor == Integer.MIN_VALUE) {
            return result;
        }
        // check whether dividend and divisor are different sign:
        // unsigned move right 31 bits to see the sign position
        boolean neg = (dividend ^ divisor) >>> 31 == 1;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        // digit: find the biggest base of 2, that is 2 ^ digit
        int digit = 0;
        // when divisor <= dividend/2 (move right 1 bit)
        while(dividend >> 1 >= divisor) {
            divisor <<= 1;
            digit++;
        }
        // calculate the result:
        while(digit >= 0) {
            // each time, when dividend >= divisor, that means we add 2^digit to the result
            if(dividend >= divisor) {
                dividend -= divisor;
                result += 1 << digit;
            }
            // don't forget to reduce divisor by 2 each time
            divisor >>= 1;
            digit--;
        }
        return neg ? -result : result;
    }
}
