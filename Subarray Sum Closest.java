/*
Given an integer array, find a subarray with sum closest to zero. Return the indexes of the first number and last number.
Example
Given [-3, 1, 1, -3, 5], return [0, 2], [1, 3], [1, 1], [2, 2] or [0, 4]

Challenge
O(nlogn) time
*/

// !!! need to define a new class to store the number with its index !!!

    class Element implements Comparable<Element> {
        int val;
        int index;
        // !!! need to be diff with val/index !!!
        public Element(int v, int i) {
            val = v;
            index = i;
        }

        public int compareTo(Element other) {
            return this.val - other.val;
        }

        public int index() {
            return index;
        }

        public int value() {
            return val;
        }
    }

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    
    /* original: [   -3, 1, 1, -3, 5]
     * sum:      [0, -3,-2,-1, -4, 1] --> sum prefix
     * sort sum: [-4,-3,-2,-1,  0, 1] --> sort sum
     * diff:     [  1  1  1   1   1 ] --> find diff between two neighbors
     * index:   [0,3][0,1][1,2][-1,2][-1,4] --> corresponding index
     * first +1:[1,3][1,1][2,2][0.2] [0,4] --> add one to each first index
     */
    

    
    public ArrayList<Integer> subarraySumClosest(int[] nums) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(nums == null || nums.length == 0) {
            return result;
        }
        Element[] sum = new Element[nums.length + 1];
        sum[0] = new Element(0, -1);
        int prefix = 0;
        for(int i = 0; i < nums.length; i++) {
            prefix += nums[i];
            sum[i + 1] = new Element(prefix, i);
        }
        Arrays.sort(sum);
        int min = Math.abs(sum[0].value() - sum[1].value());
        int index1 = Math.min(sum[0].index(), sum[1].index()) + 1;
        int index2 = Math.max(sum[0].index(), sum[1].index());
        for(int i = 1; i < nums.length; i++) {
            if(Math.abs(sum[i + 1].value() - sum[i].value()) < min) {
                min = Math.abs(sum[i + 1].value() - sum[i].value());
                index1 = Math.min(sum[i].index(), sum[i + 1].index()) + 1;
                index2 = Math.max(sum[i].index(), sum[i + 1].index());
            }
        }
        result.add(index1);
        result.add(index2);
        return result;
    }
}
