/*
Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

For example, given s = "aab",
Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
*/

// O(n^2) time cost, with O(n) space

public class Solution {
	public int minCut(String s) {
		int n = s.length();
		boolean dict[][] = new boolean[n][n];
		int cut[] = new int[n];
		// j: the end of the cur substring
		for (int j = 0; j < n; j++) {
		    // as each char is a palindrome
			cut[j] = j;
			// i: the start of the cur substring
			for (int i = 0; i <= j; i++) {
			    // if s.start == s.end && (s is a char || between i and j is also palindrome)
				if (s.charAt(i) == s.charAt(j) && (j - i <= 1 || dict[i + 1][j - 1])) {
					dict[i][j] = true;
					if (i > 0) {
					    // dp: [i,j] is palindrome, check whether prevSum + cur is smaller
					    cut[j] = Math.min(cut[j], cut[i - 1] + 1);
					} else {
					    // if i == 0(this is a whole palindrome)
					    cut[j] = 0; 
					}
				}
			}
		}
		// return when j = n - 1
		return cut[n - 1];
	}
}


/****** old version ******/
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
