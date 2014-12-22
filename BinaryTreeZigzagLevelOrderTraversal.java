/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. 
(ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
*/

// iteration(BFS): use Collections.reverse(), this operation is linear time cost of time
// O(n), O(n)
// Another thought: check level % 2 first, then decide to add left,right or right,left.

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
     * @return: A list of lists of integer include 
     *          the zigzag level order traversal of its nodes' values 
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(root == null) {
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        ArrayList<Integer> level = new ArrayList<Integer>();
        int lastCount = 1;
        int curCount = 0;
        boolean order = false;
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            level.add(cur.val);
            lastCount--;
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
                if(order) {
                    Collections.reverse(level);
                }
                result.add(level);
                order = order == true ? false : true;
                level = new ArrayList<Integer>();
            }
        }
        return result;
    }
}


// recursion, DFS

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
