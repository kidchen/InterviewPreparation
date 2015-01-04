/*
Given an array of integers, the majority number is the number that occurs more than 1/3 of the size of the array.

Find it.

Note
There is only one majority number in the array

Example
For [1, 2, 1, 2, 1, 3, 3] return 1

Challenge
O(n) time and O(1) space
*/

// Keep 2 values. If the new number is the same as any of the 2 values, decrease the count. 
// If the new number is a totally new one, decrease both. 

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: The majority number that occurs more than 1/3
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        // write your code
        if(nums == null || nums.size() == 0) {
            return -1;
        }
        int num1 = 0;
        int num2 = 0;
        int count1 = 0;
        int count2 = 0;
        for(int i = 0; i < nums.size(); i++) {
            // !!! num1 has higher priority, so don't need to check whether it equals to nums.get(i) !!!
            if(count1 == 0) {
                num1 = nums.get(i);
            }
            // !!! num2 should not be the same with num1 !!!
            if(count2 == 0 && nums.get(i) != num1) {
                num2 = nums.get(i);
            }
            // if the new coming num is a totally new one:
            if(nums.get(i) != num1 && nums.get(i) != num2 && count1 != 0 && count2 != 0) {
                count1--;
                count2--;
            }
            // if the new coming num equals to one of the two:
            if(nums.get(i) == num1) {
                count1++;
            }
            if(nums.get(i) == num2) {
                count2++;
            }
        }
        // check whether it is the REAL majority 1/3:
        count1 = 0;
        count2 = 0;
        for(int i = 0; i < nums.size(); i++) {
            if(nums.get(i) == num1) {
                count1++;
            }
            if(nums.get(i) == num2) {
                count2++;
            }
        }
        if(count1 > nums.size() / 3) {
            return count1 > count2 ? num1 : num2;
        }
        if(count2 > nums.size() / 3) {
            return num2;
        }
        return -1;
    }
}
