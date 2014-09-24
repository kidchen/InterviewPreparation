/*
Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character
*/

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


// simple one: find if two strings are only equal or less than one edit distance
// O(n), O(1)


public class OneEditDistance {
	
	public static void main(String[] args) {
		String s1 = "as";
		String s2 = "abs";
		System.out.print(oneDistance(s1, s2));
	}
	
	private static boolean oneDistance(String s1, String s2) {
		if(s1.length() == 0) {
			return s2.length() <= 1;
		}
		if(s2.length() == 0) {
			return s1.length() <= 1;
		}
		boolean operation = false;
		if(s1.length() == s2.length()) {
			int i = 0;
			while(i < s1.length()) {
				if(s1.charAt(i) != s2.charAt(i)) {
					if(operation) {
						return false;
					} else {
						operation = true;
					}
				}
				i++;
			}
		} else if(Math.abs(s1.length() - s2.length()) == 1){
			String longword = s1.length() > s2.length() ? s1 : s2;
			String shortword = s1.length() > s2.length() ? s2 : s1;
			int i = 0;
			int j = 0;
			while(j < shortword.length()) {
				if(longword.charAt(i) != shortword.charAt(j)) {
					if(operation) {
						return false;
					} else {
						operation = true;
						i++;
					}
				}
				i++;
				j++;
			}
			// !!!
			if(i < longword.length() && operation) {
				return false;
			}
		} else {
			return false;
		}
		return true;
	}

}
