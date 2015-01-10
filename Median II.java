/*
Numbers keep coming, return the median of numbers at every time a new number added.

Example
For numbers coming list: [1, 2, 3, 4, 5], return [1, 1, 2, 2, 3]
For numbers coming list: [4, 5, 1, 3, 2, 6, 0], return [4, 4, 4, 3, 3, 3, 3]
For numbers coming list: [2, 20, 100], return [2, 2, 20]

Challenge
O(nlogn) time
*/

// O(nlogn) time, O(n) space cost
// use two priorityQueue to store the left(include median number) and right of the median.
// left one is a maxheap, right one is a minheap

public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: the median of numbers
     */
    public int[] medianII(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0) {
            return null;
        }
        int[] result = new int[nums.length];
        // !!! Collections.reverseOrder() !!!
        PriorityQueue<Integer> leftMaxHeap = new PriorityQueue<Integer>(11, Collections.reverseOrder());
	    PriorityQueue<Integer> rightMinHeap = new PriorityQueue<Integer>(11);
	    result[0] = nums[0];
        int median = result[0];
        leftMaxHeap.offer(nums[0]);
        for(int i = 1; i < nums.length; i++) {
            int income = nums[i];
            if(income <= median) {
                leftMaxHeap.offer(income);
            } else {
                rightMinHeap.offer(income);
            }
            int diff = leftMaxHeap.size() - rightMinHeap.size();
            if(diff > 1) {
                int temp = leftMaxHeap.poll();
                rightMinHeap.offer(temp);
            } else if(diff < 0) {
                int temp = rightMinHeap.poll();
                leftMaxHeap.offer(temp);
            }
            result[i] = leftMaxHeap.peek();
            median = result[i];
        }
        return result;
    }
}
