/*
You are given a string, S, and a list of words, L, that are all of the same length. Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.

For example, given:
S: "barfoothefoobarman"
L: ["foo", "bar"]

You should return the indices: [0,9].
(order does not matter).
*/

// time complexity of O(nw) and space of O(lw)
// 'n' is number of characters in the string ,'l' is the number of words in the list. and 'w' is the words length

public class Solution {
    public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> result = new ArrayList<Integer>();
        if(S == null || S.length() == 0 || L == null || L.length == 0) {
            return result;
        }
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for(int i = 0; i < L.length; i++) {
            if(map.containsKey(L[i])) {
                map.put(L[i], map.get(L[i]) + 1);
            } else {
                map.put(L[i], 1);
            }
        }
        for(int i = 0; i < L[0].length(); i++) {
            // curMap: store for each valid result
            HashMap<String, Integer> curMap = new HashMap<String, Integer>();
            // count: count how many valid substring found so far
            int count = 0;
            int left = i;
            // !!! <= : "a", "a" !!!
            for(int j = i; j <= S.length() - L[0].length(); j += L[0].length()) {
                String sub = S.substring(j, j + L[0].length());
                if(map.containsKey(sub)) {
                    if(curMap.containsKey(sub)) {
                        curMap.put(sub, curMap.get(sub) + 1);
                    } else {
                        curMap.put(sub, 1);
                    }
                    if(curMap.get(sub) <= map.get(sub)) {
                        count++;
                    } else {
                        // valid substring number is over what we need: find the previous one
                        while(curMap.get(sub) > map.get(sub)) {
                            String temp = S.substring(left, left + L[0].length());
                            // !!! have to check containsKey first !!!
                            if(curMap.containsKey(temp)) {
                                curMap.put(temp, curMap.get(temp) - 1);
                                if(curMap.get(sub) > map.get(sub)) {
                                    count--;
                                }
                            }
                            left += L[0].length();
                        }
                    }
                    // check result
                    if(count == L.length) {
                        result.add(left);
                        // in case of "ababab", "a,b", we only move left L[0].length forward
                        String temp = S.substring(left, left + L[0].length());
                        // !!! have to check containsKey first !!!
                        if(curMap.containsKey(temp)) 
                            curMap.put(temp, curMap.get(temp) - 1);
                        count--;
                        left += L[0].length();
                    }
                } else {
                    // !!! j +, not left + !!!
                    left = j + L[0].length();
                    curMap.clear();
                    count = 0;
                }
            }
        }
        return result;
    }
}
