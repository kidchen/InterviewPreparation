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
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        if(checkHeight(root)==-1){
            return false;
        }
        return true;
    }
    
    public int checkHeight(TreeNode root){
        if(root==null) return 0;
        int leftHeight = checkHeight(root.left);
        int rightHeight = checkHeight(root.right);
        if(leftHeight == -1 || rightHeight == -1) return -1;
        if(Math.abs(leftHeight - rightHeight) > 1) return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }
}


// DFS. O(n), O(logn), recursion:

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
    public boolean isBalanced(TreeNode root) {
        return helper(root) >= 0;
    }
    
    int helper(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        if(left < 0 || right < 0) {
            return -1;
        }
        if(Math.abs(left - right) >= 2) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}
