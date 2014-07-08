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
