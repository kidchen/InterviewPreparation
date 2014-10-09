/*
Given a string s and a dictionary of words dict, 
add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].
*/

// brute force: Exponential complexity O(2^n)

public class Solution {
    public List<String> wordBreak(String s, Set<String> dict) {
        List<String> result = new ArrayList<String>();
        if(s == null || s.length() == 0) {
            return result;
        }
        // not necessary to do the valid check
        if(validWordBreak(s, dict)) {
            helper(s, dict, 0, result, "");
        }
        return result;
    }
    
    private void helper(String s, Set<String> dict, int start, List<String> result, String item) {
        // !!! if start == s.length(): when s.length() - 1 finished !!!
        if(start == s.length()) {
            result.add(item);
            return;
        }
        StringBuffer word = new StringBuffer();
        // !!! i = start !!!
        for(int i = start; i < s.length(); i++) {
            word.append(s.charAt(i));
            // if word(start, i) contained in dict, add this word to item and check the next
            if(dict.contains(word.toString())) {
                String newItem = item.length() == 0 ? word.toString() : item + " " + word.toString();
                helper(s, dict, i + 1, result, newItem);
            }
        }
        // if all left chars can't be words in dict, return
        return;
    }
    
    // word break I: not necessary, but only to pass the OJ
    private boolean validWordBreak(String s, Set<String> dict) {
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
