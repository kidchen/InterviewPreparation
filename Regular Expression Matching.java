/*
Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
*/

// worst case: Exponential time cost, that is O(2^n)
//             Space O(n)

public class Solution {
    public boolean isMatch(String s, String p) {
        // if p.length() == 0
        if(p.length() == 0) {
            return s.length() == 0;
        }
        // if p.length() == 1
        if(p.length() == 1) {
            return s.length() == 1 && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.');
        }
        // if p.next != *
        if(p.charAt(1) != '*') {
            // not match:
            if(s.length() < 1 || (s.charAt(0) != p.charAt(0) && p.charAt(0) != '.')) {
                return false;
            }
            // match this time, do recursion
            return isMatch(s.substring(1), p.substring(1));
        } else {
            // !!! p.next == * !!!
            while(s.length() > 0 && (s.charAt(0) ==p.charAt(0) || p.charAt(0) == '.')) {
                // !!! when s(0) == p(0), find if there is a place when s == p.sub(2) !!!
                // eg: aaa, a*a
                if(isMatch(s, p.substring(2))) {
                    // found, return true:
                    return true;
                }
                // !!! not found this time, move s one by one to find it !!!
                s = s.substring(1);
            }
            // if not find, return (s, p.sub(2)): maybe this * means zero s(0), check its(*) next substring
            // eg: aa, b*a*
            return isMatch(s, p.substring(2));
        }
    }
}


/******** hard to understand and think *********/

public class Solution {
    public boolean isMatch(String s, String p) {
        return helper(s, p, 0, 0);
    }
    
    boolean helper(String s, String p, int i, int j) {
        // for the last loop
        if(j == p.length()) {
            return i == s.length();
        }
        // if p[j+1] != *
        if(j == p.length() - 1 || p.charAt(j + 1) != '*') {
            if(i == s.length() || (s.charAt(i) != p.charAt(j) && p.charAt(j) != '.')) {
                return false;
            }
            return helper(s, p, i + 1, j + 1);
        }
        // if p[j+1] == *
        while(i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')) {
            // aaa, a*a: check this "i" and "j+2" is the same or not, if yes, it means
            // that from i(initial) to this "i" are the same with j*
            if(helper(s, p, i, j + 2)) {
                return true;
            }
            i++;
        }
        return helper(s, p, i, j + 2);
    }
}
