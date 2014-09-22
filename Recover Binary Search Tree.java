/*
Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
*/

// O(n), O(logn) for recursion stack

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
    public void recoverTree(TreeNode root) {
        if(root == null) {
            return;
        }
        ArrayList<TreeNode> pre = new ArrayList<TreeNode>();
        ArrayList<TreeNode> mistake = new ArrayList<TreeNode>();
        // set pre as null at first
        pre.add(null);
        helper(root, pre, mistake);
        if(mistake.size() != 0) {
            int temp = mistake.get(0).val;
            mistake.get(0).val = mistake.get(1).val;
            mistake.get(1).val = temp;
        }
        return;
    }
    
    private void helper(TreeNode root, ArrayList<TreeNode> pre, ArrayList<TreeNode> mistake) {
        if(root == null) {
            return;
        }
        // do the inorder traversal
        helper(root.left, pre, mistake);
        if(pre.get(0) != null && pre.get(0).val > root.val) {
            if(mistake.size() > 0) {
                // careful of using set()
                mistake.set(1, root);
            } else {
                mistake.add(pre.get(0));
                mistake.add(root);
            }
        }
        // set pre's value here, since after dfs the most left, we can give pre the value
        pre.set(0, root);
        helper(root.right, pre, mistake);
    }
}
