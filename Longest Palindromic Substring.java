/*
Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, 
and there exists one unique longest palindromic substring.
*/

// O(2n - 1) * O(n) = O(n^2)
// O(1) space cost --> unless use HashSet to store all non-duplicates result O(result numbers)

public class Solution {
    /**
     * @param s input string
     * @return the longest palindromic substring
     */
    public String longestPalindrome(String s) {
        // Write your code here
        if (s == null || s.length() < 2) {
            return s;
        }
        // i: center of the palindrome
        String result = "";
        for (int i = 0; i < s.length() * 2 - 1; i++) {
            String temp = "";
            if (i % 2 == 0) {
                temp = helper(s, i / 2, i / 2);
            } else {
                temp = helper(s, i / 2, i / 2 + 1);
            }
            if (temp.length() > result.length()) {
                result = temp;
            }
        }
        return result;
    }
    
    private String helper(String s, int left, int right) {
        if (left < 0 || right > s.length() - 1) {
            return "";
        }
        while(left >= 0 && right <= s.length() - 1) {
            if (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            } else {
                break;
            }
        }
        return s.substring(left + 1, right);
    }
}


/***** OLD VERSION *****/


public class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0 || s.length() == 1) {
            return s;
        }
        String result = "";
        for(int i = 0; i < s.length() * 2 - 1; i++) {
            int left = i / 2;
            int right = i / 2;
            if(i % 2 == 1) {
                right++;
            }
            String temp = helper(s, left, right);
            // more than one result:
            /*
            if(temp.length() >= result.length()) {
                -- store it into the result or just print it out
                -- if duplicate result:
                   store the result into a HashSet
            }
            */
            if(temp.length() > result.length()) {
                result = temp;
            }
        }
        return result;
    }
    
    private String helper(String s, int left, int right) {
        while(left >= 0 && right < s.length()) {
            if(s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            } else {
                break;
            }
        }
        // !!! [substring) !!!
        return s.substring(left + 1, right);
    }
}
