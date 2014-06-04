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
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root==null) return result;
        helper(root, result, 1);
        return result;
    }
    
    void helper(TreeNode root, ArrayList<ArrayList<Integer>> result, int level){
        // root.left and root.right are null
        if(root == null) return;
        // new level
        if(level>result.size()){
            result.add(new ArrayList<Integer>());
        }
        // add this node value (level is start from 1, so we need to "-1")
        result.get(level-1).add(root.val);
        helper(root.left,result,level+1);
        helper(root.right,result,level+1);
    }
}
