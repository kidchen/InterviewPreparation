/*
Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

spoilers alert... click to show requirements for atoi.

Requirements for atoi:
The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
*/


public class Solution {
    public int atoi(String str) {
        if(str == null || str.length() == 0) {
            return 0;
        }
        // !!! set str to its trim(), rather than just trim the str !!!
        str = str.trim();
        int flag = 0;
        int i = 0;
        if(str.charAt(0) == '-') {
            flag = -1;
            i++;
        }
        if(str.charAt(0) == '+') {
            flag = 1;
            i++;
        }
        int result = 0;
        while(i < str.length()) {
            if(str.charAt(i) < '0' || str.charAt(i) > '9') {
                break;
            }
            // !!! deal with out of range problem !!!
            int digit = (int)(str.charAt(i) - '0');
            if(flag != -1 && (Integer.MAX_VALUE - digit) / 10 < result) {
                return Integer.MAX_VALUE;
            }
            if(flag == -1 && (Integer.MIN_VALUE + digit) / 10 > -result) {
                return Integer.MIN_VALUE;
            }
            result = result * 10 + digit;
            i++;
        }
        return flag == -1 ? -result : result;
    }
}
