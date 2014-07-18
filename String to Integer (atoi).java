public class Solution {
    public int atoi(String str) {
        if(str == null) return 0;
        // ignore blanks !
        str = str.trim();
        if(str.length() == 0) return 0;
        boolean isNeg = false;
        int i = 0;
        if(str.charAt(0) == '-') {
            isNeg = true;
            i++;
        }
        if(str.charAt(0) == '+') {
            i++;
        }
        int result = 0;
        while(i < str.length()) {
            if(str.charAt(i) < '0' || str.charAt(i) > '9') {
                // not a number !
                break;
            }
            // !!! don't forget to - '0' !!!
            int digit = (int)(str.charAt(i) - '0');
            // out of range!
            if(isNeg && result > -((Integer.MIN_VALUE + digit) / 10)) {
                return Integer.MIN_VALUE;
            }
            if(!isNeg && result > ((Integer.MAX_VALUE - digit) / 10)) {
                return Integer.MAX_VALUE;
            }
            result = result * 10 + digit;
            i++;
        }
        return isNeg? -result: result;
    }
}
