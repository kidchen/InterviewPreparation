public class Solution {
    public int numDistinct(String S, String T) {
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
        // need additional +1 to store the first row & col for initial
        int[][] dp = new int[T.length() + 1][S.length() + 1];
        for(int i = 0; i < S.length() + 1; i++) {
            dp[0][i] = 1;
        }
        for(int j = 1; j < T.length() + 1; j++) {
            dp[j][0] = 0;
        }
        for(int i = 1; i < T.length() + 1; i++) {
            for(int j = 1; j < S.length() + 1; j++) {
                dp[i][j] = dp[i][j - 1];
                // !!! Do not forget to -1 when get the index !!!
                if(T.charAt(i - 1) == S.charAt(j - 1)) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        return dp[T.length()][S.length()];
    }
}
