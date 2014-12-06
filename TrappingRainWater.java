/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, 
compute how much water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
*/

// brute force:
// O(n^2), O(1) space, time limit exceeded
public class Solution {
    public int trap(int[] A) {
        if(A == null || A.length == 0) {
            return 0;
        }
        int result = 0;
        for(int i = 0; i < A.length; i++) {
            int left = 0;
            int right = 0;
            for(int cur = i; cur >= 0; cur--) {
                left = Math.max(left, A[cur]);
            }
            for(int cur = i; cur < A.length; cur++) {
                right = Math.max(right, A[cur]);
            }
            result += (Math.min(left, right) - A[i]);
        }
        return result;
    }
}


// O(2n) = O(n), O(n) space
// first pass (left to right), find max left and store it in an array
// second pass (right to left), find the height of each position and calculate the result

public class Solution {
    public int trap(int[] A) {
        if(A == null || A.length == 0) {
            return 0;
        }
        int[] left = new int[A.length];
        int max = 0;
        for(int i = 0; i < A.length; i++) {
            // first, assign the left[], then re-value the max
            left[i] = max;
            max = Math.max(A[i], max);
        }
        int result = 0;
        // !!! max already defined, don't use "int" again !!!
        max = 0;
        for(int i = A.length - 1; i >= 0; i--) {
            // !!! find height for each position !!!
            left[i] = Math.min(max, left[i]);
            max = Math.max(A[i], max);
            // if (left[i] - A[i]) is negative, do nothing (add 0)
            if(left[i] - A[i] > 0) {
                result += (left[i] - A[i]);
            }
        }
        return result;
    }
}


// O(n), O(1) space with only *one pass*
// keep two indices at two sides, 
// moving forward from the smaller side and add (height - A[cur]) to result as long as its positive
// after finding its negative, redo the comparision on both side and moving again from the smaller side

public class Solution {
    public int trap(int[] A) {
        if(A == null || A.length == 0) {
            return 0;
        }
        int left = 0;
        int right = A.length - 1;
        int result = 0;
        while(left < right) {
            int height = Math.min(A[left], A[right]);
            if(A[left] == height) {
                left++;
                while(left < right && height - A[left] > 0) {
                    result += (height - A[left]);
                    left++;
                }
            } else {
                right--;
                while(left < right && height - A[right] > 0) {
                    result += (height - A[right]);
                    right--;
                }
            }
        }
        return result;
    }
}


/******** old version *********/

public class Solution {
    public int trap(int[] A) {
        if(A.length==0) return 0;
        int[] left = new int[A.length];
        left[0]=A[0];
        for(int i=1; i<A.length; i++){
            left[i]=Math.max(left[i-1],A[i]);
        }
        int[] right = new int[A.length];
        right[A.length-1]=A[A.length-1];
        for(int i=A.length-2; i>=0; i--){
            right[i]=Math.max(right[i+1],A[i]);
        }
        int sum=0;
        for(int i=0; i<A.length; i++){
            sum += (Math.min(left[i],right[i])-A[i]);
        }
        return sum;
    }
}
