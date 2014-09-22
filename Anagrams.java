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



// 
