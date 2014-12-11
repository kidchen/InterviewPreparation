/*
Given two strings, find the longest common substring.

Return the length of it.

Note
The characters in substring should occur continiously in original string. This is different with subsequnce.
*/

// O(m*n) time, O(m*n) space

public class Solution {
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
        // write your code here
        if(A.length() == 0 || B.length() == 0) {
            return 0;
        }
        int[][] result = new int[A.length() + 1][B.length() + 1];
        int max = 0;
        for(int i = 1; i <= A.length(); i++) {
            for(int j = 1; j <= B.length(); j++) {
                if(A.charAt(i - 1) == B.charAt(j - 1)) {
                    result[i][j] = result[i - 1][j - 1] + 1;
                    if(result[i][j] > max) {
                        max = result[i][j];
                    }
                }
            }
        }
        return max;
    }
}


// reduce the space cost to O(n)

public class Solution {
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
        // write your code here
        if(A.length() == 0 || B.length() == 0) {
            return 0;
        }
        int[] last = new int[A.length() + 1];
        int max = 0;
        for(int i = 1; i <= B.length(); i++) {
        // !!! each time, we need to reset the result array !!!
            int[] result = new int[A.length() + 1];
            for(int j = 1; j <= A.length(); j++) {
                if(A.charAt(j - 1) == B.charAt(i - 1)) {
                    result[j] = last[j - 1] + 1;
                    if(result[j] > max) {
                        max = result[j];
                    }
                } else {
                    result[j] = 0;
                }
            }
            // after each for loop, set last as current result (and result will be reset at the beginning of the new loop)
            last = result;
        }
        return max;
    }
}
