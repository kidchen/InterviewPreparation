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
        if(root == null) {
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<Integer> level = new ArrayList<Integer>();
        // !!! don't forget to add root at first !!!
        queue.add(root);
        int levelNum = 0;
        int lastNum = 1;
        int curNum = 0;
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            level.add(cur.val);
            lastNum--;
            if(cur.left != null) {
                queue.add(cur.left);
                curNum++;
            }
            if(cur.right != null) {
                queue.add(cur.right);
                curNum++;
            }
            if(lastNum == 0) {
                lastNum = curNum;
                curNum = 0;
                levelNum++;
                if(levelNum % 2 == 0){
                    Collections.reverse(level);
                }
                result.add(level);
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
