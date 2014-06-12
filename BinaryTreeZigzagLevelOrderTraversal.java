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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root == null) return result;
        helper(root, result, 1);
        // reverse the even lines
        for(int i = 1; i <= result.size(); i++){
            if(i%2 == 0){
                Collections.reverse(result.get(i - 1));
            }
        }
        return result;
    }
    
    void helper(TreeNode root, ArrayList<ArrayList<Integer>> result, int level){
        if(root == null) return;
        if(level > result.size()){
            result.add(new ArrayList<Integer>());
        }
        result.get(level - 1).add(root.val);
        helper(root.left, result, level + 1);
        helper(root.right, result, level + 1);
    }
}
