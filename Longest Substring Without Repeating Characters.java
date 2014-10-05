/*
 * Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. 
 * For "bbbbb" the longest substring is "b", with the length of 1.
*/

// O(n), O(n) space on hashset

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        HashSet<Character> set = new HashSet<Character>();
        int left = 0;
        int right = 0;
        int max = 0;
        while(right < s.length()) {
            if(set.contains(s.charAt(right))) {
                // every time faced with a already-have char, calculate the max
                if(max < right - left) {
                    max = right - left;
                }
                while(s.charAt(left) != s.charAt(right)) {
                    set.remove(s.charAt(left));
                    left++;
                }
                left++;
                // !!! after reduce left, move right !!!
                right++;
            } else {
                set.add(s.charAt(right));
                right++;
            }
        }
        // if the longest is the last while loop, calculate the max outside
        max = Math.max(max, right - left);
        return max;
    }
}
