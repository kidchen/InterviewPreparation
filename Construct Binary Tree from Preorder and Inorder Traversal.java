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
        // Preorder: 12453687. Inorder: 42516837
        // Preorder: Left: 245, Right: 3687, Root: 1 (by index)
        // Inorder: Left: 425, Right: 6837, Root: 1
        int preEnd = preorder.length - 1;
        int inEnd = inorder.length - 1;
        return buildTree(preorder, inorder, 0, preEnd, 0, inEnd);
    }
    
    TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd){
        if(preStart > preEnd || inStart > inEnd) return null;
        // find root:
        // The root is the first element in Preorder.
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        // find left & right:
        // In the inorder, find the root and it will divide all nodes into two.
        int divide = 0;
        for(divide = 0; divide < inorder.length; devide++){
            if(inorder[divide] == rootVal) break;
        }
        // DFS:
        // In left part: preStart = preStart + 1
        //      !!!      preEnd = (divide - inStart) + prestart, (divide - inStart) length of the left subtree (in inorder)
        //               inStart = inStart
        //               inEnd = divide - 1
        root.left = buildTree(preorder, inorder, preStart + 1, divide + preStart - inStart, inStart, divide - 1);
        //      !!!       preStart = preStart +(divide - inStart) + 1 (+1 is for excluding the divide node)
        // In right part: preEnd = preEnd
        //                inStart = divide + 1
        //                inEnd = inEnd
        root.right = buildTree(preorder, inorder, preStart + divide + 1 - inStart, preEnd, divide + 1, inEnd);
        return root;
    }
}
