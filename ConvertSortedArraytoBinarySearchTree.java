/*
*  Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
*/

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// O(n)，stack:O(logn) + treeNodes:O(n) + extra:O(logn) = O(n) space costs

public class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
        if(num == null || num.length == 0) {
            return null;
        }
        return helper(num, 0, num.length - 1);
    }
    
    private TreeNode helper(int[] num, int start, int end) {
        if(start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = helper(num, start, mid - 1);
        root.right = helper(num, mid + 1, end);
        return root;
    }
}
