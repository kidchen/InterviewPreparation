/*
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.
*/

// O(n) --> preorder traversal, O(logn) space for recursion stack cost

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int sumNumbers(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int result = 0;
        return helper(root, result);
    }
    
    private int helper(TreeNode root, int result) {
        // if root is a null, return 0 as there is no value to add sum
        if(root == null) {
            return 0;
        }
        // if root is a leaf node, return the pathSum
        if(root.left == null && root.right == null) {
            return result = result * 10 + root.val;
        }
        // if not, do the recursion sum
        return helper(root.left, result * 10 + root.val) + helper(root.right, result * 10 + root.val);
    }
}
