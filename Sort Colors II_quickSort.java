/*
Given an array of n objects with k different colors (numbered from 1 to k), 
sort them so that objects of the same color are adjacent, with the colors in the order 1, 2, ... k.

Note
You are not suppose to use the library's sort function for this problem.

Example
GIven colors=[3, 2, 2, 1, 4], k=4, your code should sort colors in-place to [1, 2, 2, 3, 4]. 

Challenge
A rather straight forward solution is a two-pass algorithm using counting sort. That will cost O(k) extra memory.
Can you do it without using extra memory?
*/

// Quick sort: o(nlogn) time, O(1) space

class Solution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     */
    public void sortColors2(int[] colors, int k) {
        // write your code here
        if(colors == null || colors.length < 2) {
            return;
        }
        quickSort(colors, 0, colors.length - 1);
        return;
    }
    
    private void quickSort(int[] colors, int left, int right) {
        if(left >= right) {
            return;
        }
        int pivot = colors[right];
        int pos = helper(colors, left, right, pivot);
        quickSort(colors, left, pos - 1);
        quickSort(colors, pos + 1, right);
    }
    
    private int helper(int[] colors, int left, int right, int pivot) {
        int rightPoint = right;
        while(left < right) {
            if(colors[right] >= pivot) {
                right--;
            } else {
                swap(colors, left, right);
                left++;
            }
        }
        // !!! when left==right, check if this element belongs to left or right, then do the swap(left, pivotPointer) !!!
        if(colors[left] < pivot) {
            left++;
        }
        swap(colors, left, rightPoint);
        return left;
    }
    
    private void swap(int[] colors, int left, int right) {
        int temp = colors[left];
        colors[left] = colors[right];
        colors[right] = temp;
    }
}
