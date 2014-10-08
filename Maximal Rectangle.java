/*
Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.
*/

// Basically a DP + Largest Rectangle in Histogram
// O(m*n), O(2n) space (a int[] and a stack)

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        // add 1 extra for helper function (0)
        int[] height = new int[matrix[0].length + 1];
        int max = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == '1') {
                    height[j]++; 
                } else {
                    height[j] = 0;
                }
            }
            max = Math.max(max, helper(height));
        }
        return max;
    }
    
    private int helper(int[] height) {
        if(height == null || height.length == 0) {
            return 0;
        }
        LinkedList<Integer> stack = new LinkedList<Integer>();
        int max = 0;
        int i = 0;
        // !!! while i<height.length !!!
        while(i < height.length) {
            // !!! careful of comparision, stack only stores index, not real values !!!
            if(!stack.isEmpty() && height[i] <= height[stack.peek()]) {
                int index = stack.pop();
                max = Math.max(max, stack.isEmpty() ? i * height[index] : (i - stack.peek() - 1) * height[index]);
            } else {
                stack.push(i);
                i++;
            }
        }
        return max;
    }
}
