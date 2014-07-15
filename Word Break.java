public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        if(s == null || s.length() == 0) return true;
        boolean[] result = new boolean[s.length() + 1];
        result[0] = true;
        // !!! from i = 0 !!!
        for(int i = 0; i < s.length(); i++) {
            // !!! have to use stringBuilder for later delete use !!!
            StringBuilder word = new StringBuilder(s.substring(0, i + 1));
            for(int j = 0; j <= i; j++) {
                if(result[j] && dict.contains(word.toString())) {
                    result[i + 1] = true;
                    break;
                }
                // if the word doesn't match dict, delete the first char(tcode --> code)
                word.deleteCharAt(0);
            }
        }
        return result[s.length()];
    }
}
