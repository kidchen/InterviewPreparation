/*
Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Example:
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
Note:
You may assume that the array does not change.
There are many calls to sumRange function.
*/

public class NumArray {
    
    private int[] sums;

    public NumArray(int[] nums) {
        if(nums == null) {
            sums = null;
        } else if(nums.length == 0) {
            sums = new int[0];
        } else {
            sums = new int[nums.length];
            sums[0] = nums[0];
            for(int i = 1; i < nums.length; i++) {
                sums[i] = sums[i - 1] + nums[i];
            }
        }
    }

    public int sumRange(int i, int j) {
        if(sums == null) {
            return 0;
        }
        if(i > j || i < 0 || j < 0 || i >= sums.length) {
            return 0;
        } else if(i == 0) {
            return sums[j];
        } else {
            return sums[j] - sums[i - 1];
        }
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);
