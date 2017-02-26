/**
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

        For example,
        Given [3,2,1,5,6,4] and k = 2, return 5.


        Note:
        You may assume k is always valid, 1 ≤ k ≤ array's length.


        Heap (min) : O(nlogk) time and O(k) space
**/

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int i : nums) {
            heap.offer(i);
            if(heap.size() > k) {
                heap.poll();
            }
        }
        return heap.peek();
    }
}

//    Other methods:
//        Sort: nlogn
