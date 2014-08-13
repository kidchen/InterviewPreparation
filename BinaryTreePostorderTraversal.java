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
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root==null){
            return result;
        }
        Stack<TreeNode> helper = new Stack<TreeNode>();
        helper.add(root);
        while(!helper.empty()){
            TreeNode cur = helper.peek();
            // leaf node
            if(cur.left==null && cur.right==null){
                result.add(cur.val);
                helper.pop();
            }
            // node with left child
            if(cur.left!=null){
                helper.add(cur.left);
                cur.left = null;
                continue;
            }
            // node with right child
            if(cur.right!=null){
                helper.add(cur.right);
                cur.right = null;
                continue;
            }
        }
        return result;
    }
}
