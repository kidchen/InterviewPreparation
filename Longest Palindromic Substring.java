public class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return "";
        String result = "";
        int max = 0;
        // check each char and the blank between the chars
        for(int i = 0; i < s.length() * 2 - 1; i++) {
            int left = i / 2;
            int right = i / 2;
            // !!! i % 2 == 1 !!! NOT right % 2 !!! check if this is the blank position !!!
            if(i % 2 == 1) {
                right++;
            }
            String palindrome = helper(s, left, right);
            if(max < palindrome.length()) {
                max = palindrome.length();
                result = palindrome;
            }
        }
        return result;
    }
    
    String helper(String s, int left, int right) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // !!! substring(start, end) : return from start to end - 1 !!!
        return s.substring(left + 1, right);
    }
}
