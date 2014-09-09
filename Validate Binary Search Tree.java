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
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    boolean isValidBST(TreeNode root, int min, int max) {
        if(root == null) return true;
        // out of range
        if(root.val <= min || root.val >= max) return false;
        // check left & right node
        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }
}


// by inorder traversal (recursion)

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
    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> pre = new ArrayList<Integer>();
        pre.add(null);
        return helper(root, pre);
    }
    
    boolean helper(TreeNode root, ArrayList<Integer> pre) {
        if(root == null) {
            return true;
        }
        boolean left = helper(root.left, pre);
        // !!! how about root.val == pre.get(0) : false !!!
        if(pre.get(0) != null && root.val <= pre.get(0)) {
            return false;
        }
        pre.set(0, root.val);
        return left && helper(root.right, pre);
    }
}


// by inorder traversal (iteration)

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
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode pre = null;
        while(root != null || !stack.isEmpty()) {
            if(root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if(pre != null && pre.val >= root.val) {
                    return false;
                }
                pre = root;
                root = root.right;
            }
        }
        return true;
    }
}
