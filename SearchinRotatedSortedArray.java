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

// Not easy to think!

// conditions: A[start]<A[end]: 1,2,[3],4  normal situation
//             A[end]>=target: 3,4,[1],2  right part is increasing
//             A[mid]>A[start]: 2,3,[4],1  right part is not increasing


// More reasonable (easier to think) solution:

public class Solution {
    public int search(int[] A, int target) {
        if(A == null || A.length == 0) {
            return -1;
        }
        int start = 0;
        int end = A.length - 1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if(A[mid] == target) {
                return mid;
            }
            // if right part is in ordered
            if(A[mid] < A[end]) {
                // check if target is in the right part
                // !!! careful at ">=" since boundary condition is not checked !!!
                if(A[mid] < target && A[end] >= target) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                if(A[start] <= target && A[mid] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }
}
