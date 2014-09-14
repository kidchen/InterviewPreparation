public class Solution {
    public boolean search(int[] A, int target) {
        if(A.length == 0 || A == null) 
            return false;
        int left = 0, right = A.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(A[mid] == target) 
                return true;
            // left part is sorted
            if(A[mid] > A[left]) {
                // target is in the left
                if(A[mid] > target && A[left] <= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
                // right part is sorted
                // !!! can't use "A[mid] < A[right]", eg: [3,1,1], 3 !!!
            } else if(A[mid] < A[left]) {
                // target is in the right
                if(A[mid] < target && A[right] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                // mid=left or mid=right
                left++;
            }
        }
        return false;
    }
}
