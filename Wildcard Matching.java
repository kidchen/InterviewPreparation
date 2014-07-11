public class Solution {
    public boolean isMatch(String s, String p) {
        int i = 0, j = 0;
        // star: the position of the star
        // spointer: a pointer on String s
        int star = -1;
        int spointer = -1;
        while(i < s.length()) {
            // general situation
            if(j < p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                i++;
                j++;
            } else if(j < p.length() && p.charAt(j) == '*') {
                // find a *
                star = j;                                     // or say star = j++; without j++;
                spointer = i;
                j++;
            } else if(star != -1) {
                // move spointer to find the next match
                j = star + 1;
                i = spointer + 1;                             // or say i = ++spointer; without spointer++;
                spointer++;
            } else {
                return false;
            }
        }
        // check if there any * left at the end of p
        while(j < p.length() && p.charAt(j) == '*') {
            j++;
        }
        return j == p.length();
    }
}

// note: i = 0;
// num1 = i++; --> num1 = 0, i = 1;
// num2 = ++i; --> num2 = 2, i = 2;
