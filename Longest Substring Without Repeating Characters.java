public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // keep a window between left and right
        if(s == null || s.length() == 0) return 0;
        HashSet<Character> set = new HashSet<Character>();
        int left = 0, right = 0, max = 0;
        while(right < s.length()) {
            if(set.contains(s.charAt(right))) {
                if(max < right - left) {
                    max = right - left;
                }
                while(s.charAt(left) != s.charAt(right)) {
                    set.remove(s.charAt(left));
                    left++;
                }
                // !!! DO NOT FORGET TO ADD THIS LINE !!!
                left++;
            } else {
                set.add(s.charAt(right));
            }
            right++;
        }
        max = Math.max(right - left, max);
        return max;
    }
}
