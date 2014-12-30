/*
Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".

Example
Clarification
What constitutes a word?
A sequence of non-space characters constitutes a word.
Could the input string contain leading or trailing spaces?
Yes. However, your reversed string should not contain leading or trailing spaces.
How about multiple spaces between two words?
Reduce them to a single space in the reversed string.
*/

// O(n) time/space

public class Solution {
    /**
     * @param s : A string
     * @return : A string
     */
    public String reverseWords(String s) {
        // write your code
        if(s == null || s.length() == 0) {
            return s;
        }
        s = s.trim();
        StringBuffer result = new StringBuffer();
        int i = s.length() - 1;
        while(i >= 0) {
            StringBuffer word = new StringBuffer();
            while(i >= 0 && s.charAt(i) != ' ') {
                word.append(s.charAt(i));
                i--;
            }
            word.reverse();
            result.append(word);
            while(i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            if(i >= 0) {
                result.append(' ');
            }
        }
        return result.toString();
    }
}
