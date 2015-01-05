/*
Given a rotated sorted array, recover it to sorted array in-place.

Example
[4, 5, 1, 2, 3] -> [1, 2, 3, 4, 5]

Challenge
In-place, O(1) extra space and O(n) time.
*/

// when find the rotated position, reverse two parts of the array, and then reverse the whole one
// 4,5,1,2,3 -> [4,5],[1,2,3] -> 5,4,3,2,1 -> 1,2,3,4,5

public class Solution {
    /**
     * @param nums: The rotated sorted array
     * @return: The recovered sorted array
     */
    public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        // write your code
        if(nums == null || nums.size() < 2 || nums.get(0) < nums.get(nums.size() - 1)) {
            return;
        }
        for(int i = 1; i < nums.size(); i++) {
            if(nums.get(i) < nums.get(i - 1)) {
                reverse(nums, 0, i - 1);
                reverse(nums, i, nums.size() - 1);
                reverse(nums, 0, nums.size() - 1);
                return;
            }
        }
    }
    
    private void reverse(ArrayList<Integer> nums, int start, int end) {
        if(start == end) {
            return;
        }
        while(start < end) {
            int temp = nums.get(start);
            nums.set(start, nums.get(end));
            nums.set(end, temp);
            start++;
            end--;
        }
    }
}
