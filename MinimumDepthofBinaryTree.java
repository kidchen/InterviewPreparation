/*
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
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
    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        // if root is not a leaf node, go deep (add 1 each time to calculate the height)
        if(root.left == null) {
            return minDepth(root.right) + 1;
        }
        if(root.right == null) {
            return minDepth(root.left) + 1;
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}


// solution 2: iteration (level order traversal)
// O(n), O(logn) space for the queue

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
    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int lastLevel = 1;
        int curLevel = 0;
        int level = 1;
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            lastLevel--;
            // The only different to calculate max depth:
            if(cur.left == null && cur.right == null) {
                return level;
            }
            if(cur.left != null) {
                queue.add(cur.left);
                curLevel++;
            }
            if(cur.right != null) {
                queue.add(cur.right);
                curLevel++;
            }
            if(lastLevel == 0) {
                level++;
                lastLevel = curLevel;
                curLevel = 0;
            }
        }
        return level;
    }
}
