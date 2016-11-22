/*
Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
*/

// O(2logn), O(1) space

public class Solution {
    /** 
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        // write your code here
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        if(A == null || A.length == 0) {
            return result;
        }
        // find end
        int start = 0;
        int end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] <= target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (A[end] == target) {
            result[1] = end;
        } else if (A[start] == target) {
            result[1] = start;
        }
        // find start
        start = 0;
        end = A.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (A[start] == target) {
            result[0] = start;
        } else if (A[end] == target) {
            result[0] = end;
        }
        return result;
    }
}


/***** OLD VERSION *****/

public class Solution {
    public int[] searchRange(int[] A, int target) {
        int[] result = {-1, -1};
        if(A == null || A.length == 0) {
            return result;
        }
        // !!! Binary Search Tip: if mid=target, move end, so that *start* will be in the first target !!!
        // find left edge (when mid = target, move *end*, so that *start* will be like: [end, start(left-most one)])
        int start = 0;
        int end = A.length - 1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if(A[mid] >= target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        // find right edge (when mid = target, move *start*, so that *end* will be like: [end(right-most one), start])
        int left = start;
        start = 0;
        end = A.length - 1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if(A[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        // !!! careful of the condition: as long as left<=end, it is valid !!!
        if(left <= end) {
            result[0] = left;
            result[1] = end;
        }
        return result;
    }
}
