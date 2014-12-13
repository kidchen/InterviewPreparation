/*
Given two strings, find the longest comment subsequence (LCS).

Your code should return the length of LCS.

Example
For "ABCD" and "EDCA", the LCS is "A" (or D or C), return 1

For "ABCD" and "EACB", the LCS is "AC", return 2
*/

// DP: O(m*n) time, O(m*n) space

public class Solution {
    /**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        if(A.length() == 0 || B.length() == 0) {
            return 0;
        }
        int[][] result = new int[A.length() + 1][B.length() + 1];
        for(int i = 1; i <= A.length(); i++) {
            for(int j = 1; j <= B.length(); j++) {
                if(A.charAt(i - 1) == B.charAt(j - 1)) {
                    result[i][j] = result[i - 1][j - 1] + 1;
                } else {
                // diff: if not match, the position will be the bigger one among its top and left
                    result[i][j] = Math.max(result[i][j - 1], result[i - 1][j]);
                }
            }
        }
        // no need to use extra parameter, only return the last element of the array[][]
        return result[A.length()][B.length()];
    }
}


// reduce the space cost to O(n)
/*
 * Attention: have to use two arrays to store the last row and the current one.
 *            if we only use one array, when we face matches more than once in a row, the result will be wrong, eg:
 *            [bdacde] & [dceab], (find d)the first row should be [0011111], but if we use one array, it will be [0011122]
*/

public class Solution {
    /**
     * @param A, B: Two strings.
     * @return: The length of longest common subsequence of A and B.
     */
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        if(A.length() == 0 || B.length() == 0) {
            return 0;
        }
        int[] last = new int[A.length() + 1];
        int[] result = new int[A.length() + 1];
        for(int i = 0; i < B.length(); i++) {
        // !!! Similarly, have to new a result !!!
            result = new int[A.length() + 1];
            for(int j = 1; j <= A.length(); j++) {
                if(A.charAt(j - 1) == B.charAt(i)) {
                    result[j] = last[j - 1] + 1;
                } else {
                    result[j] = Math.max(result[j - 1], last[j]);
                }
            }
            last = result;
        }
        return result[A.length()];
    }
}

