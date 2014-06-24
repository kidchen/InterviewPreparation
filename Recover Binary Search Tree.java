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
        if(root == null) return;
        // !!! since java is pass by value, we need to set pointers as arraylist to !!!
        // !!! pass nodes in global !!!
        ArrayList<TreeNode> mistake = new ArrayList<TreeNode>();
        ArrayList<TreeNode> pre = new ArrayList<TreeNode>();
        // !!! have to set pre as null at first, since we need to check its node later !!!
        pre.add(null);
        helper(mistake, pre, root);
        // swap value
        if(mistake.size() != 0) {
            int temp = mistake.get(0).val;
            mistake.get(0).val = mistake.get(1).val;
            mistake.get(1).val = temp;
        }
    }
    
    void helper(ArrayList<TreeNode> mistake, ArrayList<TreeNode> pre, TreeNode root) {
        if(root == null) return;
        helper(mistake, pre, root.left);
        // find wrong nodes
        if(pre.get(0) != null && pre.get(0).val > root.val) {
            // have to set two nodes when there is no mistake recorded
            if(mistake.size() == 0) {
                mistake.add(pre.get(0));
                mistake.add(root);
            } else {
                // !!! find the second wrong place, reset the second mistake by the new one !!!
                mistake.set(1, root);
            }
        }
        // !!! record the current node as pre so that we can move on traversal to the right nodes !!!
        pre.set(0, root);
        helper(mistake, pre, root.right);
    }
}


// time: O(n). space: O(log n)
