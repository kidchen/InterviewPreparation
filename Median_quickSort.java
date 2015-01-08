/*
Given a unsorted array with integers, find the median of it. 

A median is the middle number of the array after it is sorted. 

If there are even numbers in the array, return the N/2-th number after sorted.

Example
Given [4, 5, 1, 2, 3], return 3
Given [7, 9, 4, 5], return 5

Challenge
O(n) time.
*/

// O(n) on average (quick sort)

public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: An integer denotes the middle number of the array.
     */
    public int median(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0) {
            return 0;
        }
        // !!! don't forget to add one if the length is odd !!!
        return median(nums, 0, nums.length - 1, nums.length / 2 + (nums.length & 1));
    }
    
    private int median(int[] nums, int start, int end, int k) {
        // set nums[start] as pivot
        int i = start + 1;
        int j = end;
        while(i <= j) {
            while(i <= j && nums[i] < nums[start]) {
                i++;
            }
            while(i <= j && nums[j] >= nums[start]) {
                j--;
            }
            if(i < j) {
                swap(nums, i, j);
            }
        }
        swap(nums, start, j);
        if(j + 1 == k) {
            return nums[j];
        } else if(j + 1 < k) {
            return median(nums, j + 1, end, k);
        } else {
            return median(nums, start, j, k);
        }
    }
    
    private void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}
