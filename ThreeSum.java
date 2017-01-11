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

// two pointers: O(n^2) time cost and O(1) space cost

  public static List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> results = new ArrayList<>();
    if (nums == null || nums.length < 3) {
      return results;
    }
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 2; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      int target = -nums[i];
      int left = i + 1;
      int right = nums.length - 1;
      while (left < right) {
        int sum = nums[left] + nums[right];
        if (sum == target) {
          List<Integer> result = new ArrayList<>();
          result.add(nums[i]);
          result.add(nums[left]);
          result.add(nums[right]);
          results.add(result);
          // don't forget to move left & right after finding a match
          left++;
          right--;
          while (left < right && nums[left] == nums[left - 1]) {
            left++;
          }
          while (left < right && nums[right] == nums[right + 1]) {
            right--;
          }
        } else if (sum < target) {
          left++;
        } else {
          right--;
        }
      }
    }
    return results;
  }


// reuse the twoSum code:
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
