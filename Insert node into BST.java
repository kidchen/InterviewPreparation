/*
Given a binary search tree  and a new tree node, insert the node into the tree. 
You should keep the tree still be a valid binary search tree.

Example
Given binary search tree as follow:
    2
  /   \
1      4
      /   
     3 
after Insert node 6, the tree should be:
    2
  /    \
1       4
      /   \ 
     3     6
*/

// recursion

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
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
        if(root == null) {
            return node;
        }
        if(root.val > node.val) {
            root.left = insertNode(root.left, node);
        } else {
            root.right = insertNode(root.right, node);
        }
        return root;
    }
}


// iterative

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
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
        if(root == null) {
            root = node;
            return root;
        }
        TreeNode parent = null;
        TreeNode cur = root;
        while(cur != null) {
            parent = cur;
            if(cur.val > node.val) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        if(node.val < parent.val) {
            parent.left = node;
        } else {
            parent.right = node;
        }
        return root;
    }
}
