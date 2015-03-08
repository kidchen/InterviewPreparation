/*
Excel Sheet Column Number:

Given a column title as appear in an Excel sheet, return its corresponding column number.

For example:
    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
*/

// O(n)

public class Solution {
    public int titleToNumber(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int result = 0;
        for(int i = 0; i < s.length(); i++) {
            result = result * 26 + 1 + (int)(s.charAt(i)) - (int)('A');
        }
        return result;
    }
}


/*
Excel Sheet Column Title:

Given a positive integer, return its corresponding column title as appear in an Excel sheet.

For example:
    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
*/

// O(n)

public class Solution {
    public String convertToTitle(int n) {
        if(n <= 0) {
            return null;
        }
        StringBuffer result = new StringBuffer();
        while(n > 0) {
            n--;
            char c = (char)(n % 26 + 'A');
            result.append(c);
            n /= 26;
        }
        return result.reverse().toString();
    }
}
