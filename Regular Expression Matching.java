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
