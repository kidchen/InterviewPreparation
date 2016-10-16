/*
A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.


Note:
Your solution should be in logarithmic complexity.
*/

// Binary search: O(logn) time, O(1) space

/*** general pattern ***/

class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return -1;
        }
        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] < A[mid + 1]) {
                start = mid;
            } else if (A[mid] < A[mid - 1]) {
                end = mid;
            } else {
                return mid;
            }
        }
        // in case the array is a monotonic (increase/decrease) array, return the one with larger value
        return Math.max(start, end);
    }
}

/*** original version ***/

public class Solution {
    public int findPeakElement(int[] num) {
        if(num == null || num.length == 0) {
            return -1;
        }
        int start = 0;
        int end = num.length - 1;
        while(start < end) {
            int mid = (start + end) / 2;
            // compare the two neighbors
            if(num[mid] < num[mid + 1]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        // !!! return start or end rather than mid !!!
        return start;
    }
}
