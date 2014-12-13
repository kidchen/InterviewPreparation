/*
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? 
Find all unique quadruplets in the array which gives the sum of target.

Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.
    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
*/

// O(n^3) time

public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length < 4) {
            return result;
        }
        Arrays.sort(num);
        for(int i = num.length - 1; i > 2; i--) {
            if(i < num.length - 1 && num[i] == num[i + 1]) {
                continue;
            }
            ArrayList<ArrayList<Integer>> items = threeSum(num, target - num[i], i - 1);
            for(int j = 0; j < items.size(); j++) {
                items.get(j).add(num[i]);
            }
            result.addAll(items);
        }
        return result;
    }
    
    private ArrayList<ArrayList<Integer>> threeSum(int[] num, int target, int end) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        for(int i = end; i > 1; i--) {
            if(i < end && num[i] == num[i + 1]) {
                continue;
            }
            ArrayList<ArrayList<Integer>> items = twoSum(num, target - num[i], i - 1);
            for(int j = 0; j < items.size(); j++) {
                items.get(j).add(num[i]);
            }
            result.addAll(items);
        }
        return result;
    }
    
    private ArrayList<ArrayList<Integer>> twoSum(int[] num, int target, int end) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        int start = 0;
        while(start < end) {
            int sum = num[start] + num[end];
            if(sum == target) {
                ArrayList<Integer> item = new ArrayList<Integer>();
                item.add(num[start]);
                item.add(num[end]);
                result.add(item);
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

// Another method:
/*
We can find out all pairs of two, and finally do a twoSum by hashmap(which costs O(logn)), 
so it would totally cost O(n^2 * logn) to get fourSum.
This thought can expand to k-sum.
*/
