/*
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, 
find the area of largest rectangle in the histogram.
For example,
Given height = [2,1,5,6,2,3],
return 10.
*/

// brute force: totally O(n^2) windows and O(n) to find the minimun one in each window, so we need O(n^3) time
// improve: for each number, search both side of it until find two smaller number, calculate the result, O(n^2) cost
// best: use a stack to store the *index* (all increased heights), 
//       when faced with a smaller one, pop out from tha stack and calculate the area until the value bigger than the peek() one 

// O(n), O(n) space in worst case (two passes)

public class Solution {
    public int largestRectangleArea(int[] height) {
        if(height == null || height.length == 0) {
            return 0;
        }
        LinkedList<Integer> stack = new LinkedList<Integer>();
        int max = 0;
        for(int i = 0; i < height.length; i++) {
            while(!stack.isEmpty() && height[i] <= height[stack.peek()]) {
                int index = stack.pop();
                // !!! i-stack.peek()-1, rather than i-index: [1,2,2] the last one to calculate the area
                // WHEN stack[0,2], not consecutive, we need to calculate from stack.peek() + 1 ~ i !!!
                max = Math.max(max, stack.isEmpty() ? i * height[index] : (i - stack.peek() - 1) * height[index]);
            }
            stack.push(i);
        }
        // Note: another solution is use another int[] which add a 0 at the end of the height[] and do a while
        // for this solution, we just do another while when stack is not empty after the for loop
        while(!stack.isEmpty()) {
            int index = stack.pop();
            // i --> height.length, imagine we add a 0 at the end of height[]
            max = Math.max(max, stack.isEmpty() ? height.length * height[index] : (height.length - stack.peek() - 1) * height[index]);
        }
        return max;
    }
}

// expanded: Maximal Rectangle 
