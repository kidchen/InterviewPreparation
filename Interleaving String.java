/*
Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.
*/

// O(m*n), O(s1.length()) space

/*
 * 2D DP problem (can be reduced to 1D solution, below)
 * think of the matrix:
 
    s2 d b b c a
 s1  T F ...
 a   T F ...
 a   T T T T T
 b   F   T   T
 c   F   T T T T
 c   F ...     T
 
*/

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) {
            return false;
        }
        boolean[] result = new boolean[s1.length() + 1];
        result[0] = true;
        // initial the first row
        for(int i = 0; i < s1.length(); i++) {
            result[i + 1] = s1.charAt(i) == s3.charAt(i) && result[i];
        }
        for(int i = 0; i < s2.length(); i++) {
        // !!! initial result[0] at each col !!!
            result[0] = s2.charAt(i) == s3.charAt(i) && result[0];
            for(int j = 0; j < s1.length(); j++) {
            // !!! s3.charAt(i + j + 1) !!!
            // s2(i) && result[j+1], s1(j) && result[j] : 
            // s2 go down, so the above one should be true, s1 go right, so the left one should be true
                result[j + 1] = (result[j + 1] && s2.charAt(i) == s3.charAt(i + j + 1)) 
                    || (result[j] && s1.charAt(j) == s3.charAt(i + j + 1));
            }
        }
        return result[s1.length()];
    }
}
