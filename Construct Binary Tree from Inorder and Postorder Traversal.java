/*
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
*/

// O(nlogn) ? , O(1)

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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null) {
            return null;
        }
        return helper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }
    
    private TreeNode helper(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd) {
        if(inStart > inEnd || postStart > postEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        int divide;
        for(divide = 0; divide <= inEnd; divide++) {
            if(inorder[divide] == root.val) {
                break;
            }
        }
        /*
        !!! when dealing with postOrder, pay attention:
            left: postEnd = postStart + (divide - inStart - 1) --> (the length of the left subtree)
            right: postStart = postStart + (divide - inStart) --> (the length of the right subtree include the root node)
        */
        root.left = helper(inorder, postorder, inStart, divide - 1, postStart, postStart + divide - inStart - 1);
        root.right = helper(inorder, postorder, divide + 1, inEnd, postStart + divide - inStart, postEnd - 1);
        return root;
    }
}


// LintCode:

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
 
 
public class Solution {
    /**
     *@param inorder : A list of integers that inorder traversal of a tree
     *@param postorder : A list of integers that postorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // write your code here
        int inEnd = inorder.length - 1;
        int postEnd = postorder.length - 1;
        return helper(inorder, postorder, 0, inEnd, 0, postEnd);
    }
    
    private TreeNode helper(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd) {
        if(inStart > inEnd || postStart > postEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        int leftLen = 0;
        for(int i = inStart; i <= inEnd; i++) {
            if(inorder[i] == postorder[postEnd]) {
                break;
            }
            leftLen++;
        }
        root.left = helper(inorder, postorder, inStart, inStart + leftLen - 1, postStart, postStart + leftLen - 1);
        root.right = helper(inorder, postorder, inStart + leftLen + 1, inEnd, postStart + leftLen, postEnd - 1);
        return root;
    }
}
