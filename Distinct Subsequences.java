/*
Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string 
by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. 
(ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Example
S = "rabbbit", T = "rabbit"

Return 3.
*/

// DP: O(m*n) time/space
/*
  * r a b b b i t (s)
* 1 1 1 1 1 1 1 1
r 0 1 1 1 1 1 1 1
a 0 0 1 1 1 1 1 1
b 0 0 0 1 2 3 3 3
b 0 0 0 0 1 3 3 3
i 0 0 0 0 0 0 3 3
t 0 0 0 0 0 0 0 3
(t)
*: null
http://blog.csdn.net/abcbc/article/details/8978146
*/

public class Solution {
    /**
     * @param S, T: Two string.
     * @return: Count the number of distinct subsequences
     */
    public int numDistinct(String S, String T) {
        // write your code here
        if(T.length() == 0) {
            return 1;
        }
        if(S.length() == 0) {
            return 0;
        }
        int[][] result = new int[T.length() + 1][ S.length() + 1];
        // initial the first row as 1
        for(int i = 0; i <= S.length(); i++) {
            result[0][i] = 1;
        }
        for(int i = 1; i <= T.length(); i++) {
            for(int j = 1; j <= S.length(); j++) {
                if(S.charAt(j - 1) == T.charAt(i - 1)) {
                    // match: left + top-left
                    result[i][j] = result[i - 1][j - 1] + result[i][j - 1];
                } else {
                    // not match: same as the left
                    result[i][j] = result[i][j - 1];
                }
            }
        }
        return result[T.length()][S.length()];
    }
}


// O(m*n) time, O(m) space

public class Solution {
    /**
     * @param S, T: Two string.
     * @return: Count the number of distinct subsequences
     */
    public int numDistinct(String S, String T) {
        // write your code here
        if(T.length() == 0) {
            return 1;
        }
        if(S.length() == 0) {
            return 0;
        }
        int[] result = new int[T.length() + 1];
        result[0] = 1;
        for(int i = 0; i < S.length(); i++) {
            // !!! have to do it from bottom to top, so that the result[j - 1] will keep the original !!!
            for(int j = T.length(); j > 0; j--) {
                if(S.charAt(i) == T.charAt(j - 1)) {
                    result[j] += result[j - 1];
                } 
            }
        }
        return result[T.length()];
    }
}
