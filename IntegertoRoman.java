public class Solution {
    /**
     * @param n The integer
     * @return Roman representation
     */
    public String intToRoman(int n) {
        // Write your code here
        if (n <= 0) {
            return "";
        }
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder result = new StringBuilder();
        for (int i = 0; n > 0; i++) {
            while (n >= nums[i]) {
                n -= nums[i];
                result.append(symbols[i]);
            }
        }
        return result.toString();
    }
}


/*** old version ***/

public class Solution {
    public String intToRoman(int num) {
        String result="";
        String symbol[] = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int value[] = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        for(int i=0; num!=0; i++){
            while(num>=value[i]){    //!!!  >=
                num -= value[i];
                result += symbol[i];
            }
        }
        return result;
    }
}
