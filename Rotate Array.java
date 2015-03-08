/*
Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
*/

// O(n) time, O(1) space

public class Solution {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length < 2 || k <= 0) {
            return;
        }
        if(k >= nums.length) {
            k %= nums.length;
        }
        if(k == 0) {
            return;
        }
        int length = nums.length - 1;
        swap(nums, 0, length - k);
        swap(nums, length - k + 1, length);
        swap(nums, 0, length);
        return;
    }
    
    private void swap(int[] nums, int left, int right) {
        if(left == right) {
            return;
        }
        while(left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
        return;
    }
}
