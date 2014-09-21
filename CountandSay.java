/*
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.
*/

// O(n*length), O(length) space cost. length means the length of the result

public class Solution {
    public String countAndSay(int n) {
        if(n <= 0) {
            return "";
        }
        String result = "1";
        if(n == 1) {
            return result;
        }
        int count = 1;
        for(int i = 2; i <= n; i++) {
        	// !!! new the buffer out of the inner for loop, otherwise the result will be the sum of the previous all !!!
            StringBuffer temp = new StringBuffer();
            for(int j = 0; j < result.length(); j++) {
                while(j + 1 < result.length() && result.charAt(j) == result.charAt(j + 1)) {
                    count++;
                    j++;
                }
                temp.append(count);
                temp.append(result.charAt(j));
                count = 1;
            }
            result = temp.toString();
        }
        return result;
    }
}
