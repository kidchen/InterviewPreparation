/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array
*/

// Binary search: O(logn) time, O(1) space

public class Solution {
    public int search(int[] A, int target) {
        if(A == null || A.length == 0) {
            return -1;
        }
        int start = 0;
        int end = A.length - 1;
        // should add "=", if there is only one element..
        while(start <= end) {
            int mid = (start + end) / 2;
            if(A[mid] == target) {
                return mid;
            } else if(A[start] < A[mid]) {
                // left is sorted
                if(target >= A[start] && target < A[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if(A[start] > A[mid]) {
                // right is sorted
                if(target > A[mid] && target <= A[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                start++;
            }
        }
        return -1;
    }
}


// Not easy to think!
// conditions: A[start]<A[end]: 1,2,[3],4  normal situation
//             A[end]>=target: 3,4,[1],2  right part is increasing
//             A[mid]>A[start]: 2,3,[4],1  right part is not increasing

public class Solution {
    public int search(int[] A, int target) {
        int start=0, end=A.length-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(A[mid]==target){
                return mid;
            }else if(A[mid]>target){
                if(A[start]<A[end] || A[start]<=target || A[mid]<A[end]){
                    end=mid-1;
                }else{
                    start=mid+1;
                }
            }else{
                if(A[start]<A[end] || A[end]>=target || A[mid]>A[start]){
                    start=mid+1;
                }else{
                    end=mid-1;
                }
            }
        }
        return -1;
    }
}
