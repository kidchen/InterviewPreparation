/*
The code base version is an integer and start from 1 to n. 
One day, someone commit a bad version in the code case, 
so it caused itself and the following versions are all failed in the unit tests.
You can determine whether a version is bad by the following interface: 

Java:
    public VersionControl {
        boolean isBadVersion(int version);
    }

Find the first bad version.
Note
You should call isBadVersion as few as possible. 

Please read the annotation in code area to get the correct way to call isBadVersion in different language. 
For example, Java is VersionControl.isBadVersion.

Example
Given n=5

Call isBadVersion(3), get false
Call isBadVersion(5), get true
Call isBadVersion(4), get true

return 4 is the first bad version

Challenge
Do not call isBadVersion exceed O(logn) times.
*/

// similar with Search Insert Position

/**
 * public class VersionControl {
 *     public static boolean isBadVersion(int k);
 * }
 * you can use VersionControl.isBadVersion(k) to judge wether 
 * the kth code version is bad or not.
*/
class Solution {
    /**
     * @param n: An integers.
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        // write your code here
        if(n < 1) {
            return -1;
        }
        int start = 1;
        int end = n;
        while(start <= end) {
            int mid = (start + end) / 2;
            if(VersionControl.isBadVersion(mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}

