/*
Write a function to find the longest common prefix string amongst an array of strings.
*/

// O(m*n), m is the max string.length() and n is the number of strings
// O(m) space cost

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }
        // first, choose a prefix substring
        // we based on the first string
        for(int i = 0; i < strs[0].length(); i++) {
            // then, check each string whether they also have the same prefix substring
            for(int j = 1; j < strs.length; j++) {
                // !!! if shorter than the first string: strs[j].length() <= i !!!
                if(strs[j].length() <= i || strs[j].charAt(i) != strs[0].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        // if all strings are the same: 
        return strs[0];
    }
}
