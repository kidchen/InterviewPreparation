public class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 2];
        // !!! don't forget to initial the dp[][] !!!
        // !!! <= len !!!
        for(int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for(int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }
        // calculate the distance
        for(int i = 0; i < len1; i++) {
            char c1 = word1.charAt(i);
            for(int j = 0; j < len2; j++) {
                char c2 = word2.charAt(j);
                if(c1 == c2) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    // !!! delete & insert !!!
                    int replace = dp[i][j] + 1;
                    int delete = dp[i + 1][j] + 1;
                    int insert = dp[i][j + 1] + 1;
                    int min = Math.min(replace,delete);
                    dp[i + 1][j + 1] = Math.min(min, insert);
                }
            }
        }
        return dp[len1][len2];
    }
}
