public class Solution {
    public int minCut(String s) {
        if(s == null || s.length() == 0) return 0;
        boolean[][] dict = getDict(s);
        int[] result = new int[s.length() + 1];
        result[0] = 0;
        for(int i = 0; i < s.length(); i++) {
            // put max value (each char can't be palindrome) of the position i into result
            result[i + 1] = i + 1;
            for(int j = 0; j <= i; j++) {
                if(dict[j][i]) {
                    // !!! compare with "result[j]+1" means ????
                    // --> !!!
                    result[i + 1] = Math.min(result[j] + 1, result[i + 1]);
                }
            }
        }
        // !!! "-1" means ????
        // --> think of "aaaa", we should return 0 rather than 1
        return result[s.length()] - 1;
    }
    
    boolean[][] getDict(String s) {
        boolean[][] dict = new boolean[s.length()][s.length()];
        for(int i = 0; i < s.length(); i++) {
            for(int j = 0; j <= i; j++) {
                if(s.charAt(i) == s.charAt(j) && (i - j < 2 || dict[j + 1][i - 1])) {
                    dict[j][i] = true;
                }
            }
        }
        return dict;
    }
}
