/*
Given a string s and a dictionary of words dict, 
determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
*/

// DP: O(nl) time, here n is the length of the string and l is the max length of the words in dict (O()

public class Solution {
    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    public boolean wordSegmentation(String s, Set<String> dict) {
        // write your code here 
        if(s == null || s.length() == 0) {
            return true;
        }
        int maxLength = maxLength(dict);
        boolean[] canSeg = new boolean[s.length() + 1];
        canSeg[0] = true;
        for(int i = 1; i <= s.length(); i++) {
            for(int j = 1; j <= i && j <= maxLength; j++) {
                // [i - j], so that we can find the position which last time all the substrings can be found in dict
                // think in this way: for the initialization, only canSag[0] is true, but j starts from 1, so we have to do i - j
                if(!canSeg[i - j]) {
                    continue;
                }
                // !!! [i - j] !!!
                String word = s.substring(i - j, i);
                if(dict.contains(word)) {
                    canSeg[i] = true;
                    break;
                }
            }
        }
        return canSeg[s.length()];
    }
    
    // get the max length of the word in dict
    private int maxLength(Set<String> dict) {
        int maxLength = 0;
        for(String word : dict) {
            maxLength = Math.max(maxLength, word.length());
        }
        return maxLength;
    }
}


/********** old version **********/
// DP: O(n^2), O(n)

public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        if(s == null || s.length() == 0) {
            return true;
        }
        // store whether all chars can form words from dict *so far*
        boolean[] result = new boolean[s.length() + 1];
        // record the result from result[1]
        result[0] = true;
        // have to do from 0, eg: "a", ["a"]
        for(int i = 0; i < s.length(); i++) {
            // !!! from 0 each time !!!
            StringBuffer word = new StringBuffer(s.substring(0, i + 1));
            // j is the left boundary of the substring
            for(int j = 0; j <= i; j++) {
                // if all chars can form words from dict until j, and substring(j,i+1) contains in dict:
                if(result[j] && dict.contains(word.toString())) {
                    result[i + 1] = true;
                    break;
                }
                // if not, delete the left most char in the substring
                word.deleteCharAt(0);
            }
        }
        return result[s.length()];
    }
}
