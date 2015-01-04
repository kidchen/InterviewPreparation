/*
Implement an algorithm to determine if a string has all unique characters

Example
Given "abc", return true

Given "aab", return false

Challenge
What if you can not use additional data structures?
*/

// Use four long to store 256 ASCII chars
// O(n) time, O(1) space

public class Solution {
    /**
     * @param str: a string
     * @return: a boolean
     */
    public boolean isUnique(String str) {
        // write your code here
        if(str == null || str.length() == 0) {
            return true;
        }
        long check0 = 0;
        long check1 = 0;
        long check2 = 0;
        long check3 = 0;
        for(int i = 0; i < str.length(); i++) {
            // !!! no need to -'a', we use absolute values in ASCII !!!
            int val = str.charAt(i);
            int check = val / 64;
            val %= 64;
            switch(check) {
                case 0:
                    // !!! add L after number to convert it to a long !!!
                    if((check0 & (1L << val)) > 0) {
                        return false;
                    }
                    check0 |= (1L << val);
                    break;
                case 1:
                    if((check1 & (1L << val)) > 0) {
                        return false;
                    }
                    check1 |= (1L << val);
                    break;
                case 2:
                    if((check2 & (1L << val)) > 0) {
                        return false;
                    }
                    check2 |= (1L << val);
                    break;
                case 3:
                    if((check3 & (1L << val)) > 0) {
                        return false;
                    }
                    check3 |= (1L << val);
                    break;                    
            }
        }
        return true;
    }
}


// if there are only 26 chars consists the string:
// use an int(32 bits) to store the 26 chars
// O(n) time, O(1) space

public class Solution {
    /**
     * @param str: a string
     * @return: a boolean
     */
    public boolean isUnique(String str) {
        // write your code here
        if(str == null || str.length() == 0) {
            return true;
        }
        int check = 0;
        for(int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if((check & (1 << val)) > 0) {
                return false;
            }
            check |= (1 << val);
        }
        return true;
    }
}
