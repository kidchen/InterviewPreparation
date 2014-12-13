/*
Given a string which contains only letters. Sort it by lower case first and upper case second.

Note
It's not necessary to keep the original order of lower-case letters and upper case letters.

Example
For "abAcD", a reasonable answer is "acbAD"

Challenge
Do it in one-pass and in-place.
*/

// O(n) time, O(1) space

public class Solution {
    /** 
     *@param chars: The letter array you should sort by Case
     *@return: void
     */
    public void sortLetters(char[] chars) {
        //write your code here
        if(chars == null || chars.length < 2) {
            return;
        }
        int start = 0;
        int end = chars.length - 1;
        while(start < end) {
            if(chars[start] >= 'A' && chars[start] <= 'Z') {
                char temp = chars[start];
                chars[start] = chars[end];
                chars[end] = temp;
                end--;
            } else {
                start++;
            }
        }
    }
}

