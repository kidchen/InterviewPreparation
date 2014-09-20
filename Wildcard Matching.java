/*
Implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false
*/

// Note: '*' represent any substring, that means ("abbccd", "a*d") -> true, which * represent "bbcc"
// O(2^n) worst case, this is the brute force method, optimal solution is using DP
// DP reference: http://blog.csdn.net/linhuanmars/article/details/21198049

public class Solution {
    public boolean isMatch(String s, String p) {
        if(p.length() == 0) {
            return s.length() == 0;
        }
        int i = 0;
        int j = 0;
        int star = -1;
        int spoint = -1;
        while(i < s.length()) {
            // normal case
            if(j < p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                i++;
                j++;
            } else if(j < p.length() && p.charAt(j) == '*') {
                // when face to a '*', assume it represents empty, record i & j and move j forward
                star = j;
                spoint = i;
                j++;
            } else if(star != -1) {
                // if it is not a normal case and j is not a '*' but there is a star record:
                // go back to the position when we face to the star, try it to make * = one char in i
                // by move spoint forward
                i = spoint + 1;
                j = star + 1;
                spoint++;
            } else {
                return false;
            }
        }
        // !!! don't forget to ignore any left '*' in p !!!
        // if only left '*', j++
        while(j < p.length() && p.charAt(j) == '*') {
            j++;
        }
        // return the result by check any left in p except '*'
        return j == p.length();
    }
}

// note: i = 0;
// num1 = i++; --> num1 = 0, i = 1;
// num2 = ++i; --> num2 = 2, i = 2;
