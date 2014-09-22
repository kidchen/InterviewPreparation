/*
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
*/

// O(n), O(n) space cost

// DFS: recursion, similar with preorder traversal

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
        if(root == null) {
            return result;
        }
        helper(root, result, 1);
        return result;
    }
    
    private void helper(TreeNode root, ArrayList<ArrayList<Integer>> result, int level) {
        if(root == null) {
            return;
        }
        if(level > result.size()) {
            result.add(new ArrayList<Integer>());
        }
        result.get(level - 1).add(root.val);
        helper(root.left, result, level + 1);
        helper(root.right, result, level + 1);
    }
}



// BFS: iteration level by level, using a queue to store the last level's nodes

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
        if(root == null) {
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<Integer> level = new ArrayList<Integer>();
        queue.add(root);
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
                result.add(level);
                // can't use clear(), since we need to use extra space to store the result anyway
                level = new ArrayList<Integer>();
            }
        }
        return result;
    }
}
