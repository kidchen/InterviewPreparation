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
     *@param preorder : A list of integers that preorder traversal of a tree
     *@param inorder : A list of integers that inorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // write your code here
        if(preorder == null && inorder == null) {
            return null;
        }
        int preEnd = preorder.length - 1;
        int inEnd = inorder.length - 1;
        return helper(preorder, inorder, 0, preEnd, 0, inEnd);
    }
    
    private TreeNode helper(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if(preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int leftLen = 0;
        for(int i = inStart; i <= inEnd; i++) {
            if(inorder[i] == preorder[preStart]) {
                break;
            }
            leftLen++;
        }
        root.left = helper(preorder, inorder, preStart + 1, preStart + leftLen, inStart, inStart + leftLen);
        root.right = helper(preorder, inorder, preStart + leftLen + 1, preEnd, inStart + leftLen + 1, inEnd);
        return root;
    }
}
