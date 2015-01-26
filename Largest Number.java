/*
Given a list of non negative integers, arrange them such that they form the largest number.

For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.
*/

// create a new comparator and compare s1+s2 with s2+s1
// O(n) time, O(n) space

public class Solution {
    public String largestNumber(int[] num) {
        if(num == null || num.length == 0) {
            return "";
        }
        
        StringBuffer result = new StringBuffer();
        ArrayList<String> numStr = new ArrayList<String>();
        for(int i : num) {
            numStr.add(Integer.toString(i));
        }
        
        class StringComparator implements Comparator<String> {
            @Override
            public int compare(String s1, String s2) {
                String s12 = s1 + s2;
                String s21 = s2 + s1;
                return s12.compareTo(s21);
            }
        }
        Collections.sort(numStr, new StringComparator());
        
        for(int i = numStr.size() - 1; i >= 0; i--) {
            // [0, 0, 0]
            if(result.length() == 0 && numStr.get(i).equals("0")) {
                continue;
            }
            result.append(numStr.get(i));
        }
        // [0]
        if(result.length() == 0) {
            return "0";
        }
        return result.toString();
    }
}
