/*
Compare two version numbers version1 and version1.
If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.

You may assume that the version strings are non-empty and contain only digits and the . character.
The . character does not represent a decimal point and is used to separate number sequences.
For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.

Here is an example of version numbers ordering:

0.1 < 1.1 < 1.2 < 13.37
*/

// Compare each substring between '.', O(n) time, O(1) space.
// Other thoughts: we can use split and compare each element in two arrays. 
//                 Or remove all '.' and individual '0's, comparing two integers. But these methods take extra spaces.

public class Solution {
    public int compareVersion(String version1, String version2) {
        int start1 = 0, start2 = 0;
        int end1 = 0, end2 = 0;
        
        while(end1 < version1.length() && end2 < version2.length()) {
            while(end1 < version1.length() && version1.charAt(end1) != '.') {
                end1++;
            }
            while(end2 < version2.length() && version2.charAt(end2) != '.') {
                end2++;
            }
            int v1 = Integer.parseInt(version1.substring(start1, end1));
            int v2 = Integer.parseInt(version2.substring(start2, end2));
            if(v1 - v2 != 0) {
                return v1 - v2 > 0 ? 1 : -1;
            } else {
                end1++;
                end2++;
                start1 = end1;
                start2 = end2;
            }
        }
        // in case: 1.0.0 and 1
        while(end1 < version1.length()) {
            char left = version1.charAt(end1);
            if(left != '.' && left != '0') {
                return 1;
            } else {
                end1++;
            }
        }
        while(end2 < version2.length()) {
            char left = version2.charAt(end2);
            if(left != '.' && left != '0') {
                return -1;
            } else {
                end2++;
            }
        }
        
        return 0;
    }
}
