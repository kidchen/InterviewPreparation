public class Solution {
    public String strStr(String haystack, String needle) {
        if(haystack.length() < needle.length()) return null;
        if(haystack == null || needle == null || needle.length() == 0) return haystack;
        for(int i = 0; i <= haystack.length() - needle.length(); i++) {
            boolean find = true;
            for(int j = 0; j < needle.length(); j++) {
                if(haystack.charAt(i + j) != needle.charAt(j)) {
                    find = false;
                    break;
                }
            }
            if(find) return haystack.substring(i);
        }
        return null;
    }
}


// original string.length() = n, substring.length() = m:
// O((n-m+1)*m)=O(n*m)
// O(1)
