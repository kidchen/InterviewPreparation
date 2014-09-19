/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
*/

// O(n), O(1) space

public class Solution {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0) {
            return true;
        }
        int start = 0;
        int end = s.length() - 1;
        while(start <= end) {
            char left = s.charAt(start);
            char right = s.charAt(end);
            if(!valid(left)) {
                start++;
                continue;
            }
            if(!valid(right)) {
                end--;
                continue;
            }
            // A --> a: +32
            if(left >= 'A' && left <= 'Z') {
                left += 32;
            }
            if(right >= 'A' && right <= 'Z') {
                right += 32;
            }
            if(left != right) {
                return false;
            } else {
                start++;
                end--;
            }
        }
        return true;
    }
    
    private boolean valid(char c) {
        if(c >= '0' && c <= '9' || c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
            return true;
        }
        return false;
    }
}
