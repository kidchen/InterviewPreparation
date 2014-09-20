/*
Implement strStr().

Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack.
*/

// original string.length() = n, substring.length() = m:
// O((n-m+1)*m)=O(n*m)
// O(1) space

public class Solution {
    public String strStr(String haystack, String needle) {
        // check length first, then check whether it is null
        if(haystack.length() < needle.length()) {
            return null;
        }
        if(haystack == null || needle == null || needle.length() == 0) {
            return haystack;
        }
        // should be <=, eg: a, a
        for(int i = 0; i <= haystack.length() - needle.length(); i++) {
            boolean find = true;
            for(int j = 0; j < needle.length(); j++) {
                if(haystack.charAt(i + j) != needle.charAt(j)) {
                    find = false;
                    break;
                }
            }
            if(find == true) {
                // lower case substring
                return haystack.substring(i);
            }
        }
        return null;
    }
}


// Best solution: KMP algorithm


// Another method: O(n), O(1) space
// Use a hashcode to represent the needle and calculate each substring's hashcode, eg:
// needle = abacd, hashcode = 1 + 2*29 + 1*29^2 + 3*29^3 + 4*29^4
// haystack = abacde, then substring = abacd: hashcode = h (== needle)
//                         substring = bacde: hashcode = h/29 + 5*29^4 (!= needle)
// Find the hashcode: 
// in order to be unique, we choose the bigger prime(su-shu, 29 in this case) than the total char(all lower case, 26, for example) as the base(power)

