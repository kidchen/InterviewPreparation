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


// LintCode

public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target : An integer
     * @return : return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers ,int target) {
        // write your code here
        if(numbers == null || numbers.length < 3) {
            return 0;
        }
        Arrays.sort(numbers);
        int minDiff = Integer.MAX_VALUE;
        for(int i = numbers.length - 1; i > 1; i--) {
            int diff = helper(numbers, target - numbers[i], i - 1);
            if(Math.abs(minDiff) > Math.abs(diff)) {
                minDiff = diff;
            }
        }
        return target + minDiff;
    }
    
    private int helper(int[] numbers, int target, int end) {
        int start = 0;
        int minDiff = Integer.MAX_VALUE;
        while(start < end) {
            int sum = numbers[start] + numbers[end];
            if(sum == target) {
                return 0;
            } else {
                int diff = sum - target;
                if(Math.abs(minDiff) > Math.abs(diff)) {
                    minDiff = diff;
                }
                if(sum < target) {
                    start++;
                    while(start < end && numbers[start] == numbers[start - 1]) {
                        start++;
                    }
                } else {
                    end--;
                    while(start < end && numbers[end] == numbers[end + 1]) {
                        end--;
                    }
                }
            }
        }
        return minDiff;
    }
}
