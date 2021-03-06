/*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
*/

// O(n) time (2*n), O(n) space

public class Solution {
    public int longestConsecutive(int[] num) {
        if(num == null || num.length == 0) {
            return 0;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        // initial to 1 rather than 0, for single integer case
        int longest = 1;
        for(int i : num) {
            set.add(i);
        }
        for(int i : num) {
            int count = 1;
            int left = i - 1, right = i + 1;
            while(set.contains(left)) {
                count++;
                // if not remove, complexity will be increased
                // Also, because it is consecutive, so an element won't be appeared in two different sequences
                set.remove(left);
                left--;
            }
            while(set.contains(right)) {
                count++;
                set.remove(right);
                right++;
            }
            longest = Math.max(longest, count);
        }
        return longest;
    }
}


// easy one:
// only return consecutive sequence length, eg: [1,2,3,5,4], return 3.

	public static int longestConsecutive(int[] num) {
	    if(num == null || num.length == 0) {
	        return 0;
	    }
	    int longest = 1;
	    int local = 1;
	    for(int i = 0; i < num.length - 1; i++) {
	        if(num[i + 1] - num[i] == 1) {
	            local++;
	            longest = Math.max(longest, local);
	        } else {
	            local = 1;
	        }
	    }
	    return longest;
	}
