// use O(n) time complexity and O(1) space!!!
// by Morris Traversal (inorder) and check whether it is by increased order.


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
    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> pre = new ArrayList<Integer>();
        pre.add(null);
        if(root == null) {
            return true;
        }
        while(root!=null) {
            if(root.left == null) {
                if(pre.get(0) != null && root.val <= pre.get(0)) {
                        return false;
                    }
                pre.set(0, root.val);
                root = root.right;
            }
            else{
                TreeNode ptr=root.left;
                while(ptr.right != null && ptr.right != root)
                    ptr = ptr.right;
                if(ptr.right == null) {
                    ptr.right = root;
                    root = root.left;
                }
                else{                    
                    ptr.right = null;
                    if(pre.get(0) != null && root.val <= pre.get(0)) {
                        return false;
                    }
                    pre.set(0, root.val);
                    root = root.right;
                }
            }
        }
        return true;
    }
}
