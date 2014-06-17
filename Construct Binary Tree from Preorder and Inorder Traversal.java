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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preEnd = preorder.length - 1;
        int inEnd = inorder.length - 1;
        return buildTree(preorder, inorder, 0, preEnd, 0, inEnd);
    }
    
    TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd){
        if(preStart > preEnd || inStart > inEnd) return null;
        // find root
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        // find left & right
        int devide = 0;
        for(devide = 0; devide < inorder.length; devide++){
            if(inorder[devide] == rootVal) break;
        }
        // DFS
        root.left = buildTree(preorder, inorder, preStart + 1, devide + preStart - inStart, inStart, devide - 1);
        root.right = buildTree(preorder, inorder, preStart - inStart + devide + 1, preEnd, devide + 1, inEnd);
        return root;
    }
}
