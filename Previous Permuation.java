/*
Given a list of integers, which denote a permutation.

Find the previous permutation in ascending order.

Note
The list may contains duplicate integers.

Example
For [1,3,2,3], the previous permutation is [1,2,3,3]
For [1,2,3,4], the previous permutation is [4,3,2,1]
*/

// 1. find 1st *increasing* position from the back
// 2. swap p with the first *smaller* value from the back
// 3. swap array in range of (p+1, end)

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers that's previous permuation
     */
    public ArrayList<Integer> previousPermuation(ArrayList<Integer> nums) {
		// write your code
		if(nums == null || nums.size() < 2) {
		    return nums;
		}
		int p = nums.size() - 2;
		while(p >= 0 && nums.get(p) <= nums.get(p + 1)) {
		    p--;
		}
		int q = nums.size() - 1;
		// !!! don't forget to check whether p >= 0 !!!
		if(p != -1) {
		    while(q > p && nums.get(q) >= nums.get(p)) {
		        q--;
		    }
		    swap(nums, p, q);
		}
		p++;
		q = nums.size() - 1;
		while(p < q) {
		    swap(nums, p, q);
		    p++;
		    q--;
		}
		return nums;
    }
    
    private void swap(ArrayList<Integer> nums, int p, int q) {
        int temp = nums.get(p);
        nums.set(p, nums.get(q));
        nums.set(q, temp);
    }
}

