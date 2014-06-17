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
        int inEnd = inorder.length - 1;
        int postEnd = postorder.length - 1;
        return buildTree(inorder, postorder, 0, inEnd, 0, postEnd);
    }
    
    TreeNode buildTree(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd) {
        if(inStart > inEnd || postStart > postEnd) return null;
        // find root
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);
        // find left & right
        int devide = 0;
        for(devide = 0; devide < inorder.length; devide++) {
            if(inorder[devide] == rootVal) {
                break;
            }
        }
        // DFS
        // ATTENTION: have to add (postStart - inStart) in left(postEnd) and right(postStart)
        // there is no need to add anything on inorder, because devide is created in inorder.
        root.left = buildTree(inorder, postorder, inStart, devide - 1, postStart, postStart - inStart + devide - 1);
        root.right = buildTree(inorder, postorder, devide + 1, inEnd, postStart - inStart + devide, postEnd - 1);
        return root;
    }
}
