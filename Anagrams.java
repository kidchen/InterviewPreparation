public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        ArrayList<String> result = new ArrayList<String>();
        if(strs == null || strs.length == 0) return result;
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        // build the map
        for(int i = 0; i < strs.length; i++) {
            // eachStr: each string in strs[]
            String eachStr = strs[i];
            // convert string into char[] so that we can sort it
            char[] strChar = eachStr.toCharArray();
            Arrays.sort(strChar);
            // str: string after sorted
            String str = new String(strChar);
            // if there are same keys (str is a key in the map)
            if(map.containsKey(str)) {
                map.get(str).add(strs[i]);
            } else {
                // this is a new key to the map
                ArrayList<String> list = new ArrayList<String>();
                list.add(strs[i]);
                map.put(str, list);
            }
        }
        // check the map
        // !!! FAMILIAR WITH THE ITERATOR !!!
        Iterator iter = map.values().iterator();
        while(iter.hasNext()) {
            // need what type, just convert the type before iter.next()
            ArrayList<String> item = (ArrayList<String>) iter.next();
            // use addAll to add a list (not an element)
            if(item.size() > 1) result.addAll(item);
        }
        return result;
    }
}
