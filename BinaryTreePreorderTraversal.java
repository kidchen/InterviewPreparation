/*
Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].

Note: Recursive solution is trivial, could you do it iteratively?
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
 
// Recursion
// O(n) time, O(log n) space for the recursion stack

public ArrayList<Integer> preorderTraversal(TreeNode root) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    helper(root, result);
    return result;
}

private void helper(TreeNode root, ArrayList<Integer> result) {
    if(root == null)
        return;
    result.add(root.val);
    helper(root.left, result);
    helper(root.right, result);
}

// Iteration
// O(n) time, O(log n) space

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
     * @return: Preorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root == null) {
            return result;
        }
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        while(!stack.isEmpty() || root != null) {
            if(root != null) {
                stack.push(root);
                result.add(root.val);
                root = root.left;
            } else {
                root = stack.pop();
                root = root.right;
            }
        }
        return result;
    }
}


// Morris Traversal
// O(n) time, O(1) space
// http://blog.csdn.net/linhuanmars/article/details/21428647

public ArrayList<Integer> preorderTraversal(TreeNode root) {
    ArrayList<Integer> res = new ArrayList<Integer>();
    TreeNode cur = root;
    TreeNode pre = null;
    while(cur != null) {
        if(cur.left == null) {
            res.add(cur.val);
            cur = cur.right;
        }
        else {
            pre = cur.left;
            while(pre.right!=null && pre.right!=cur)
                pre = pre.right;
            if(pre.right==null) {
                res.add(cur.val);
                pre.right = cur;
                cur = cur.left;
            }
            else {
                pre.right = null;
                cur = cur.right;
            }
        }
    }
    return res;
}
