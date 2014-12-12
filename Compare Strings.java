/*
Compare two strings A and B, determine whether A contains all of the characters in B.

The characters in string A and B are all Upper Case letters.

Example
For A = "ABCD", B = "ABC", return true.

For A = "ABCD" B = "AABC", return false.
*/

// O(m + n + 26) = O(n) time, O(26) space

public class Solution {
    /**
     * @param A : A string includes Upper Case letters
     * @param B : A string includes Upper Case letter
     * @return :  if string A contains all of the characters in B return true else return false
     */
    public boolean compareStrings(String A, String B) {
        // write your code here
        if(A.length() < B.length()) {
            return false;
        }
        int[] count = new int[26];
        for(int i = 0; i < B.length(); i++) {
            int index = B.charAt(i) - 'A';
            count[index]++;
        }
        for(int i = 0; i < A.length(); i++) {
            int index = A.charAt(i) - 'A';
            count[index]--;
        }
        for(int i = 0; i < 26; i++) {
            if(count[i] > 0) {
                return false;
            }
        }
        return true;
    }
}
