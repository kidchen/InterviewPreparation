public class Solution {
    public String reverseWords(String s) {
        if(s == null || s.length() == 0) return s;
        s = s.trim();
        int start = 0, end = s.length() - 1;
        StringBuilder result = new StringBuilder();
        while(start <= end) {
            StringBuilder word = new StringBuilder();
            while(start <= end && s.charAt(end) != ' ') {
                word.append(s.charAt(end));
                end--;
            }
            word.reverse();
            result.append(word + " ");
            while(start <= end && s.charAt(end) == ' ') {
                end--;
            }
        }
        return result.toString().trim();
    }
}
