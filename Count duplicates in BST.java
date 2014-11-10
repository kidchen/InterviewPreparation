// inorder traversal and count:

// recursion:

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public int countDup(Node root) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    ArrayList<Integer> pre = new ArrayList<Integer>();
    result.add(0);
    pre.add(null);
    helper(root, pre, result);
    return result.get(0);
}

private void helper(Node root, ArrayList<Integer> pre, ArrayList<Integer> result) {
    if(root == null) {
        return;
    }
    helper(root.left, pre, result);
    if(pre.get(0) != null && root.val == pre.get(0)) {
        result.set(0, result.get(0) + 1);
        return;
    }
    pre.set(0, root.val);
    helper(root.right, pre, result);
    return;
}

// iteration:

public class Solution {
    public int countDup(TreeNode root) {
        if(root == null) {
            return 0;
        }
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode pre = null;
        int dup = 0;
        // do the while loop until root==null && stack.isEmpty()
        while(root != null || !stack.isEmpty()) {
            if(root != null) {
                // go deep left
                stack.push(root);
                root = root.left;
            } else {
                // root == null, then we define root as stack.pop()
                root = stack.pop();
                if(pre != null && pre.val == root.val) {
                    dup++;
                }
                pre = root;
                // go right subtree
                root = root.right;
            }
        }
        return dup;
    }
}
