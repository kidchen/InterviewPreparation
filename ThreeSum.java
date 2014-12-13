/*
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
*/

// O(nlogn + n^2) = O(n^2), space O(n)

public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length < 3) {
            return result;
        }
        Arrays.sort(num);
        for(int i = num.length - 1; i > 1; i--) {
            // skip duplicates
            if(i < num.length - 1 && num[i] == num[i + 1]) {
                continue;
            }
            // pass ArrayList<ArrayList<Integer>> to store all possible solutions
            ArrayList<ArrayList<Integer>> items = twoSum(num, i - 1, -num[i]);
            for(int j = 0; j < items.size(); j++) {
                items.get(j).add(num[i]);
            }
            // use addAll to put all items in result
            result.addAll(items);
        }
        return result;
    }
    
    private ArrayList<ArrayList<Integer>> twoSum(int[] num, int end, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int start = 0;
        while(start < end) {
            int sum = num[start] + num[end];
            if(sum == target) {
                ArrayList<Integer> item = new ArrayList<Integer>();
                item.add(num[start]);
                item.add(num[end]);
                result.add(item);
                // first move two pointers, then skip duplicates
                start++;
                end--;
                while(start < end && num[start] == num[start - 1]) {
                    start++;
                }
                while(start < end && num[end] == num[end + 1]) {
                    end--;
                }
            } else if(sum < target) {
                start++;
            } else {
                end--;
            }
        }
        return result;
    }
}
