public class Solution {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0) return true;
        int left = 0;
        int right = s.length() - 1;
        while(left < right) {
            if(!isValid(s.charAt(left))) {
                left++;
                continue;
            }
            if(!isValid(s.charAt(right))) {
                right--;
                continue;
            }
            if(!isSame(s.charAt(left), s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
    boolean isValid(char c) {
        if(c >= '0' && c <='9' || c >= 'A' && c <= 'Z' || c >= 'a' && c <= 'z') {
            return true;
        }
        return false;
    }
    
    boolean isSame(char c1, char c2) {
        if(c1 >= 'A' && c1 <= 'Z') {
            // !!! convert !!!
            c1 = (char)(c1 + 'a' - 'A');
        }
        if(c2 >= 'A' && c2 <= 'Z') {
            c2 = (char)(c2 + 'a' - 'A');
        }
        return c1 == c2;
    }
}
