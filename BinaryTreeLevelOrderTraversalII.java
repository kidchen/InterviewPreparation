/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
*/


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
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root==null) return result;
        helper(root,result,0);
        Collections.reverse(result);                     // !!! only need to add this line !!!
        return result;
    }
    
    void helper(TreeNode root, ArrayList<ArrayList<Integer>> result, int level){
        if(root==null) return;
        if(result.size()<=level){
            result.add(new ArrayList<Integer>());
        }
        result.get(level).add(root.val);
        helper(root.left,result,level+1);
        helper(root.right,result,level+1);
    }
}

