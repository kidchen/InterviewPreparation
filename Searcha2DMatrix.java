/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.
*/

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0) return false;
        int start = 0, end = matrix.length*matrix[0].length-1;
        while(start<=end){
            int mid = (start+end)/2;
            int midx = mid/matrix[0].length;
            int midy = mid%matrix[0].length;
            if(matrix[midx][midy]==target) return true;
            if(matrix[midx][midy]<target) start=mid+1;
            if(matrix[midx][midy]>target) end=mid-1;
        }
        return false;
    }
}

/****************UPDATE AUG 24*****************/

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int left = 0;
        int right = matrix.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(matrix[mid][0] == target) {
                return true;
            } else if(matrix[mid][0] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // !!! we use right<0 so that we can make sure that right can be the right one as the row index !!!
        if(right < 0) {
            return false;
        }
        int row = right;
        // !!! here, left & right are already defined, so DO NOT ADD int !!!
        left = 0;
        right = matrix[0].length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(matrix[row][mid] == target) {
                return true;
            } else if(matrix[row][mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
