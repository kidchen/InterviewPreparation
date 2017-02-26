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
    public void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while(cur!=null){
            if(cur.right!=null){
                stack.push(cur.right);
            }
            if(cur.left!=null){
                cur.right=cur.left;
                cur.left=null;
                
            }else if(!stack.isEmpty()){
                TreeNode temp=stack.pop();
                cur.right=temp;
            }
            cur=cur.right;
        }
    }
}
