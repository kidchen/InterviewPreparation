/*
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the emtpy string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
*/

// O(n), O(T) space cost (for the map)

public class Solution {
    public String minWindow(String S, String T) {
        if(S == null || S.length() == 0) {
            return "";
        }
        // T may have duplicates, if input "aa", "aa", then output "aa"
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < T.length(); i++) {
            if(map.containsKey(T.charAt(i))) {
                map.put(T.charAt(i), map.get(T.charAt(i)) + 1);
            } else {
                map.put(T.charAt(i), 1);
            }
        }
        int left = 0;
        int right = 0;
        // need to add one at first, for substring, and also for return ""
        int minLength = S.length() + 1;
        int minStart = 0;
        // count: count how many chars we have found in T
        int count = 0;
        while(right < S.length()) {
            if(map.containsKey(S.charAt(right))) {
                map.put(S.charAt(right), map.get(S.charAt(right)) - 1);
                if(map.get(S.charAt(right)) >= 0) {
                    count++;
                }
            }
            // when we found all chars in T, move left
            while(count == T.length()) {
                if(right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    minStart = left;
                }
                if(map.containsKey(S.charAt(left))) {
                    map.put(S.charAt(left), map.get(S.charAt(left)) + 1);
                    if(map.get(S.charAt(left)) > 0) {
                        count--;
                    }
                }
                left++;
            }
            right++;
        }
        // don't use minLength < T.length(), that is impossible, 
        // because we initial minLength as the longest and if we can't find a match, 
        // we will return minLength as S.length() + 1
        if(minLength > S.length()) {
            return "";
        }
        return S.substring(minStart, minStart + minLength);
    }
}
