/*
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/


public class Solution {
    public int threeSumClosest(int[] num, int target) {
        // return MIN_VALUE !!!
        if(num.length < 3 || num == null) 
            return Integer.MIN_VALUE;
        Arrays.sort(num);
        // initial this way:
        int result = num[0] + num[1] + num[2] - target;
        for(int i = 0; i < num.length - 2; i++) {
            int closest = twoSum(num, target - num[i], i + 1);
            if(Math.abs(closest) < Math.abs(result)) {
                result = closest;
            }
        }
        // !!! don't forget to add target !!!
        return result + target;
    }
    
    int twoSum(int[] num, int target, int start) {
        int end = num.length - 1;
        int result = num[start] + num[end] - target;
        while(start < end) {
            if(result == 0) return 0;
            // new int to compare and get the smaller result !!!
            int closest = num[start] + num[end] -target;
            if(Math.abs(closest) < Math.abs(result)) {
                result = closest;
            }
            if(num[start] + num[end] < target) {
                start++;
            } else {
                end--;
            }
        }
        return result;
    }
}
