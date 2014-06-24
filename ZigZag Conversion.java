public class Solution {
    public String convert(String s, int nRows) {
        // P   A   H   N
        // A P L S I I G
        // Y   I   R
        
        // P     I     N
        // A   L S   I G
        // Y A   H R
        // P     I
        //
        if(s.length() == 0 || s == null || nRows == 0) return "";
        if(nRows == 1) return s;
        StringBuffer result = new StringBuffer();
        // size: how many elements in one zigzag (PAYP if nRows = 3; PAYPAL if nRows = 4)
        int size = 2 * nRows - 2;
        for(int i = 0; i < nRows; i++) {
            for(int j = i; j < s.length(); j += size) {
                result.append(s.charAt(j));
                // if this row is not the first row or the last row
                // !!! DO NOT FORGET TO -1 !!!
                // !!! To add L when nRows = 4, j + size - i * 2 !!!
                if(i != 0 && i != nRows - 1 && j + size - i * 2 < s.length()) {
                    result.append(s.charAt(j + size - i * 2));
                }
            }
        }
        return result.toString();
    }
}
