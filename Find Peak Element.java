/*
A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.


Note:
Your solution should be in logarithmic complexity.
*/

// Binary search: O(logn) time, O(1) space

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
        return start;
    }
}
