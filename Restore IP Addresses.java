/*
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
*/

// Similar to NP, but only 4 layers of recursion. O(n^4), O(2n) space

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        if(s == null || s.length() == 0) {
            return result;
        }
        // item: store each segment (4 total)
        List<String> item = new ArrayList<String>();
        helper(s, result, item, 0);
        return result;
    }
    
    private void helper(String s, List<String> result, List<String> item, int start) {
        // if all 4 segments are created
        if(item.size() == 4) {
            if(start != s.length()) {
                return;
            }
            StringBuffer sb = new StringBuffer();
            for(int i = 0; i < 3; i++) {
                sb.append(item.get(i));
                sb.append('.');
            }
            sb.append(item.get(3));
            result.add(sb.toString());
            return;
        }
        // !!! start: the index that we begin segment. --> i from start to start+3 !!!
        for(int i = start; i < s.length() && i < start + 3; i++) {
            String sub = s.substring(start, i + 1);
            if(valid(sub)) {
                item.add(sub);
                // start = i + 1, move on to next digit
                helper(s, result, item, i + 1);
                item.remove(item.size() - 1);
            }
        }
    }
    
    private boolean valid(String s) {
        // !!! don't forget to check '0'/'000' !!!
        if(s.charAt(0) == '0' && s.length() > 1) {
            return false;
        }
        int num = Integer.parseInt(s);
        return num >= 0 && num <= 255;
    }
}



/******** OLD VERSION *********/


public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> result = new ArrayList<String>();
        if(s == null || s.length() == 0) return result;
        helper(s, result, 0, 1, "");
        return result;
    }
    
    void helper(String s, ArrayList<String> result, int index, int segment, String item) {
        // index: position of the char in s
        // segment: identify which part is it in all four
        // item: current part
        if(index >= s.length()) return;
        // for the last part, we need to return it and add to the result
        if(segment == 4) {
            // substring(int begin) !!! lower case !!!
            String str = s.substring(index);
            if(isValid(str)) {
                result.add(item + "." + str);
            }
            return;
        }
        // for loop to get first three parts
        for(int i = 1; i < 4 && (i + index < s.length()); i++) {
            String str = s.substring(index, index + i);
            if(isValid(str)) {
                // for the first part, we don't need to add "."
                if(segment == 1) {
                    // !!! index + i, segment + 1 !!!
                    helper(s, result, index + i, segment + 1, str);
                } else {
                    helper(s, result, index + i, segment + 1, item + "." + str);
                }
            }

        }
    }
    
    boolean isValid(String item) {
    // !!! we have to add the first two conditions:
    // first line to check validation
    // second line to check "001"
        if(item == null || item.length() > 3) return false;
        if(item.charAt(0) == '0' && item.length() > 1) return false;
        int num = Integer.parseInt(item);
        if(num >= 0 && num <= 255) return true;
        return false;
    }
}
