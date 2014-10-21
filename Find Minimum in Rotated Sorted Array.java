/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array!!!!!!
*/

// O(logn), O(1) space
// worst case: O(n), since we need to deal with left++ operation

public class Solution {
    public int findMin(int[] num) {
        if(num == null || num.length == 0) {
            return Integer.MIN_VALUE;
        }
        int left = 0;
        int right = num.length - 1;
        while(left < right) {
            if(num[left] < num[right]) {
                return num[left];
            }
            int mid = (left + right) / 2;
            if(num[mid] > num[left]) {
                left = mid + 1;
            } else if(num[mid] < num[left]) {
                right = mid;
            } else {
            // to deal with duplicate...
                left += 1;
            }
        }
        return num[left];
    }
}
