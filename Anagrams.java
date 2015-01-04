/*
Given an array of strings, return all groups of strings that are anagrams.

Note: All inputs will be in lower-case.
*/

// O(n)*O(klogk) = O(nklogk), O(nk) space for the hashmap
// n strings and the longest one has k char

public class Solution {
    public List<String> anagrams(String[] strs) {
        List<String> result = new ArrayList<String>();
        if(strs == null || strs.length == 0) {
            return result;
        }
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for(int i = 0; i < strs.length; i++) {
            char[] item = strs[i].toCharArray();
            Arrays.sort(item);
            // !!! DON'T USE "String key = item.toString()", it will return char with "," and space !!!
            String key = new String(item);
            if(map.containsKey(key)) {
                map.get(key).add(strs[i]);
            } else {
                ArrayList<String> newValue = new ArrayList<String>();
                newValue.add(strs[i]);
                map.put(key, newValue);
            }
        }
        for(String s : map.keySet()) {
            if(map.get(s).size() > 1) {
                // !!! addAll can be used to add a set of items in an arrayList !!!
                result.addAll(map.get(s));
            }
        }
        return result;
    }
}


// the last part can also use an iterator:
        Iterator iter = map.values().iterator();
        while(iter.hasNext()) {
            // need what type, just convert the type before iter.next()
            ArrayList<String> item = (ArrayList<String>) iter.next();
            // use addAll to add a list (not an element)
            if(item.size() > 1) result.addAll(item);
        }



// if we only need to check two strings:
// Use a hashmap<Character, Integer> to store each element and its appearance times in one string, and then
// traverse the other string and check if elements and its appearance times are the same with the hashmap(remove when the same),
// finally check the hashmap, if it is empty, then return true.

// This cost O(m+n) time and O(m) space, smaller than the sort method (m, n represents the length of two strings)

public class Solution {
    /**
     * @param s: The first string
     * @param b: The second string
     * @return true or false
     */
    public boolean anagram(String s, String t) {
        // write your code here
        if(s == null && t == null) {
            return true;
        }
        if(s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for(int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if(!map.containsKey(c)) {
                return false;
            } else {
                map.put(c, map.get(c) - 1);
                if(map.get(c) < 1) {
                    map.remove(c);
                }
            }
        }
        return map.isEmpty();
    }
}
