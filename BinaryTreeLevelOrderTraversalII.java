/*
Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
(ie, from left to right, level by level from leaf to root).

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


// iteration:

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
     * @param root: The root of binary tree.
     * @return: buttom-up level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrderButtom(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root == null) {
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<Integer> items = new ArrayList<Integer>();
        queue.offer(root);
        int lastCount = 1;
        int curCount = 0;
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            lastCount--;
            items.add(cur.val);
            if(cur.left != null) {
                queue.offer(cur.left);
                curCount++;
            }
            if(cur.right != null) {
                queue.offer(cur.right);
                curCount++;
            }
            if(lastCount == 0) {
                lastCount = curCount;
                curCount = 0;
                result.add(items);
                items = new ArrayList<Integer>();
            }
        }
        Collections.reverse(result);
        return result;
    }
}
