/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
*/

// O(n), O(1)

public class Solution {
    public void nextPermutation(int[] num) {
        if(num.length <= 1) return;
        // scan from the last but one
        // eg : 236541 --> 246531 --> 241356
        // find "3"
        for(int i = num.length - 2; i >= 0; i--) {
            if(num[i] < num[i + 1]) {
                // !!! have to new a j before for loop, this j will be used later !!!
                int j;
                for(j = num.length - 1; j > i; j--) {
                    // find "4"
                    if(num[j] > num[i]) {
                        break;
                    }
                }
                // swap "3" and "4"
                int temp = num[i];
                num[i] = num[j];
                num[j] = temp;
                reverse(num, i + 1, num.length - 1);
                return;
            }
        }
        // eg: 654321 --> 123456
        reverse(num, 0, num.length - 1);
        return;
    }
    
    void reverse(int[] num, int start, int end) {
        while(start < end) {
            int temp = num[start];
            num[start] = num[end];
            num[end] = temp;
            start++;
            end--;
        }
    }
}


// easier to think:
/* 1. from right to left, find the first digit (p) which violate the increase trend
 * 2. from right to left, find the first digit which is larger than p, call it q
 * 3. swap p and q
 * 4. reverse all digits from the next element after position p
 */

public class Solution {
    public void nextPermutation(int[] num) {
        if (num == null || num.length < 2) {
            return;
        }
        int p = num.length - 2;
        int q = num.length - 1;
        // need to add "=" for duplicates elements
        while(p >= 0 && num[p] >= num[p + 1]) {
            p--;
        }
        if(p >= 0) {
            // need to add "=" for duplicates elements
            while(q > p && num[q] <= num[p]) {
                q--;
            }
            int temp = num[q];
            num[q] = num[p];
            num[p] = temp;
        }
        // reverse the elements from the one after position p (p + 1)
        reverse(num, p + 1);
        return;
    }
    
    private void reverse(int[] num, int start) {
        int end = num.length - 1;
        while(start < end) {
            int temp = num[end];
            num[end] = num[start];
            num[start] = temp;
            start++;
            end--;
        }
    }
}


// LintCode:

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers that's next permuation
     */
    public ArrayList<Integer> nextPermuation(ArrayList<Integer> nums) {
		// write your code
		if(nums == null || nums.size() == 0) {
		    return null;
		}
		int p = nums.size() - 2;
		int q = nums.size() - 1;
		while(p >= 0 && nums.get(p) >= nums.get(p + 1)) {
		    p--;
		}
		if(p >= 0) {
		    while(q > p && nums.get(q) <= nums.get(p)) {
		        q--;
		    }
		    int temp = nums.get(p);
		    nums.set(p, nums.get(q));
		    nums.set(q, temp);
		}
		reverse(nums, p + 1);
		return nums;
    }
    
    private void reverse(ArrayList<Integer> nums, int start) {
        int end = nums.size() - 1;
        while(start < end) {
            int temp = nums.get(start);
            nums.set(start, nums.get(end));
            nums.set(end, temp);
            start++;
            end--;
        }
    }
}
