/*
Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

For example,

Given numerator = 1, denominator = 2, return "0.5".
Given numerator = 2, denominator = 1, return "2".
Given numerator = 2, denominator = 3, return "0.(6)".
*/

// use a hashmap to record remainders, O(n)

public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(denominator == 0) {
            return null;
        }
        if(numerator == 0) {
            return "0";
        }
        StringBuffer result = new StringBuffer();
        if((numerator > 0) ^ (denominator > 0)) {
            result.append('-');
        }
        // in case  two numbers are MAX_VALUE or MIN_VALUE
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        // integer part
        result.append(num / den);
        num %= den;
        if(num == 0) {
            return result.toString();
        }
        // fractional part
        result.append('.');
        // map<remainder, occur index>
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        map.put(num, result.length());
        while(num > 0) {
            num *= 10;
            result.append(num / den);
            num %= den;
            if(map.containsKey(num)) {
                // in order to avoid ambiguous insert index, we need to declare it first
                int index = map.get(num);
                result.insert(index, '(');
                result.append(')');
                return result.toString();
            } else {
                map.put(num, result.length());
            }
        }
        return result.toString();
    }
}
