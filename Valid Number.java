/*
Validate if a given string is numeric.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
*/

// O(n), O(1) space
// Many corner cases, careful...

public class Solution {
    public boolean isNumber(String s) {
        if(s == null) {
            return false;
        }
        s = s.trim();
        if(s.length() == 0) {
            return false;
        }
        boolean dot = false;
        boolean exp = false;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // digits can appear in any place
            if(c >= '0' && c <= '9') {
                continue;
            } else if(c == '+' || c == '-') {
                // '+' or '-'
                // begining, or after 'e/E' and followed by digits or '.'
                if((i == 0 || (i - 1 >= 0 && (s.charAt(i - 1) == 'e' || s.charAt(i - 1) == 'E'))) && (i + 1 < s.length() && (s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9' || s.charAt(i + 1) == '.'))) {
                    continue;
                } else {
                    return false;
                }
            } else if(c == '.') {
                // '.'
                // can only appear once and have to have digits before or after it
                if(!dot && !exp) {
                    if((i - 1 >= 0 && (s.charAt(i - 1) >= '0' && s.charAt(i - 1) <= '9')) || (i + 1 < s.length() && s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9')) {
                        dot = true;
                        continue;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else if(c == 'e' || c == 'E') {
                // 'e' or 'E'
                // can only appear once and can't be at the first or last place
                if(!exp) {
                    if(i != 0 && i != s.length() - 1) {
                        exp = true;
                        continue;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                // invalid chars
                return false;
            }
        }
        return true;
    }
}
