/*
Design an iterator over a binary search tree with the following properties:
Elements are visited in ascending order (i.e. an inorder traversal)
next() and hasNext() queries run in O(1) time in average.
Example
For the following binary search tree, inorder traversal by using iterator is [1, 6, 10, 11, 12]
    10
   /   \
 1      11
  \      \
    6     12

Challenge
Extra memory usage O(h), h is the height of the tree.
Super Star: Extra memory usage O(1)
*/

// O(h) space solution: use a stack to store all *left* nodes

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
 * Example of iterate a tree:
 * Solution iterator = new Solution(root);
 * while (iterator.hasNext()) {
 *    TreeNode node = iterator.next();
 *    do something for node
 * } 
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

public class BSTIterator {
    
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        if(root == null) {
            return;
        }
        stack.push(root);
        while(root.left != null) {
            root = root.left;
            stack.push(root);
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(stack.isEmpty()) {
            return false;
        }
        return true;
    }

    /** @return the next smallest number */
    public int next() {
        if(stack.isEmpty()) {
            return Integer.MIN_VALUE;
        }
        TreeNode next = stack.pop();
        TreeNode cur = next.right;
        if(cur == null) {
            return next.val;
        } else {
            stack.push(cur);
            while(cur.left != null) {
                cur = cur.left;
                stack.push(cur);
            }
        }
        return next.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
