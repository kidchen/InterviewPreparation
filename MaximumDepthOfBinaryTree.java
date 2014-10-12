/*
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
*/

// solution 1: recursion
// O(n), O(logn) space for the stack

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
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        // !!! don't forget to add 1: max(left, right) + 1 !!!
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}


// solution 2: iteration (level order traversal and keep a level integer)
// O(n), O(logn) space for the queue(one level's nodes)

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
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        // !!! don't forget to use two counters to track the end of each level !!!
        int lastLevel = 1;
        int curLevel = 0;
        int level = 1;
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            lastLevel--;
            if(cur.left != null) {
                queue.add(cur.left);
                curLevel++;
            }
            if(cur.right != null) {
                queue.add(cur.right);
                curLevel++;
            }
            if(lastLevel == 0) {
                if(!queue.isEmpty()) {
                    level++;
                }
                lastLevel = curLevel;
                curLevel = 0;
            }
        }
        return level;
    }
}
