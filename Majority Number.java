/*
Given an array of integers, the majority number is the number that occurs more than half of the size of the array. Find it.

Example
For [1, 1, 1, 1, 2, 2, 2], return 1
*/

// O(n) time and O(1) space

public class Solution {
    /**
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        // write your code
        if(nums == null || nums.size() < 1) {
            return 0;
        }
        int result = 0;
        int count = 0;
        for(int i = 0; i < nums.size(); i++) {
            if(count == 0) {
                result = nums.get(i);
                // !!! don't forget to add count here !!!
                count++;
            } else {
                if(nums.get(i) == result) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        // to check if it exists a majority number
        count = 0;
        for(int i = 0; i < nums.size(); i++) {
            if(nums.get(i) == result) {
                count++;
            }
        }
        if(count > nums.size() / 2) {
            return result;
        } else {
            return -1;
        }
    }
}

