/*
A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
*/

/*
1. 00: res[i]=0
2. 10,20: res[i]=res[i-2] --> first if statement
3. 01-09 && 30-99, 27-29: res[i]=res[i-1] --> second if statement
4. 11-19, 21-26: res[i]=res[i-1]+res[i-2] --> general situation
*/

public class Solution {
    public int numDecodings(String s) {
        // for each element newly input, there are two possibilities:
        // 1. it can be identified as a letter, that means there are dp[i-1] ways
        // 2. it also can be a letter combining with its former char, so dp[i-2] ways
        if(s.charAt(0) == '0' || s.length() == 0 || s == null)
            return 0;
        // we need three parameters to pass dp[i], dp[i-1], dp[i-2] as num, num1, num2
        int num = 1;
        int num1 = 1;
        int num2 = 1;
        for(int i = 1; i < s.length(); i++) {
            // if the new input is '0'
            if(s.charAt(i) == '0') {
                // s = 10 or 20
                if(s.charAt(i - 1) == '1' || s.charAt(i - 1) == '2') {
                    num = num2;
                } else {
                    // s = 30
                    return 0;
                }
            } else {
                // new input is not '0', is x
                // s = m0x or n3x
                if(s.charAt(i - 1) == '0' || s.charAt(i - 1) >= '3') {
                    num = num1;
                } else {
                    // s = m
                    if(s.charAt(i - 1) == '2' && s.charAt(i) >= '7' && s.charAt(i) <= '9') {
                        num = num1;
                    } else {
                        num = num1 + num2;
                    }
                }
            }
            // pass the parameters, dp[i-1] will be dp[i-2] and dp[i] will be dp[i-1]
            num2 = num1;
            num1 = num;
        }
        return num;
    }
}
