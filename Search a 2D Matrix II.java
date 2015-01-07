/*
Write an efficient algorithm that searches for a value in an m x n matrix, return the occurrence of it.

This matrix has the following properties:

    * Integers in each row are sorted from left to right.
    * Integers in each column are sorted from up to bottom.
    * No duplicate integers in each row or column.

Example
Consider the following matrix:

[
    [1, 3, 5, 7],
    [2, 4, 7, 8],
    [3, 5, 9, 10]
]

Given target = 3, return 2.

Challenge
O(m+n) time and O(1) extra space
*/

// O(m+n) time with O(1) space cost

public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
    public int searchMatrix(ArrayList<ArrayList<Integer>> matrix, int target) {
        // write your code
        if(matrix == null || matrix.size() == 0 || matrix.get(0).size() == 0) {
            return 0;
        }
        int result = 0;
        // from top-right to bottom-left, so that left element is always smaller and the bottom one is always bigger
        int i = 0;
        int j = matrix.get(0).size() - 1;
        while(i < matrix.size() && j >= 0) {
            if(matrix.get(i).get(j) == target) {
                result++;
                i++;
                j--;
            } else if(matrix.get(i).get(j) > target) {
                j--;
            } else {
                i++;
            }
        }
        return result;
    }
}

