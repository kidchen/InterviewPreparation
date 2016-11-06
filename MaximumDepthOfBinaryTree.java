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
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        int lastLevelNum = 1;
        int curLevelNum = 0;
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            lastLevelNum--;
            if (curNode.left != null) {
                queue.offer(curNode.left);
                curLevelNum++;
            }
            if (curNode.right != null) {
                queue.offer(curNode.right);
                curLevelNum++;
            }
            if (lastLevelNum == 0) {
                lastLevelNum = curLevelNum;
                curLevelNum = 0;
                depth++;
            }
        }
        return depth;
    }
}
