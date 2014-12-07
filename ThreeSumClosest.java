/*
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. 
Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/

// O(n^2) time, O(n) space

public class Solution {
    public int threeSumClosest(int[] num, int target) {
        if(num == null || num.length < 3) {
            return Integer.MIN_VALUE;
        }
        Arrays.sort(num);
        // keep the diff and return diff+target
        int diff = num[0] + num[1] + num[2] - target;
        for(int i = 0; i < num.length - 2; i++) {
            // closest: min diff between the target and twoSum
            // don't forget to minus current number (-num[i]) in twoSum
            int closest = twoSum(num, target - num[i], i + 1);
            if(Math.abs(closest) < Math.abs(diff)) {
                diff = closest;
            }
        }
        return diff + target;
    }
    
    private int twoSum(int[] num, int target, int start) {
        int end = num.length - 1;
        // similar with the above, keep diff and return it
        int diff = num[start] + num[end] - target;
        while(start < end) {
            if(diff == 0) {
                return 0;
            }
            // closest: min diff between the target and twoSum
            int closest = num[start] + num[end] - target;
            if(Math.abs(closest) < Math.abs(diff)) {
                diff = closest;
            }
            if(num[start] + num[end] < target) {
                start++;
            } else {
                end--;
            }
        }
        return diff;
    }
}
