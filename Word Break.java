/*
Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
*/

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
