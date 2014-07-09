// only return positive result !?


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
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        ArrayList<Integer> result = new ArrayList<Integer>();
        // !!! have to use Integer.MIN_VALUE, eg: {-3} !!!
        result.add(Integer.MIN_VALUE);
        // no need to define a new int
        helper(root, result);
        return result.get(0);
    }
    
    // !!! have to return int value so that we can calculate the max value in 
    // left or right subtree in recursion !!!
    int helper(TreeNode root, ArrayList<Integer> result) {
        if(root == null) return 0;
        int left = helper(root.left, result);
        int right = helper(root.right, result);
        // !!! have to check whether left/right > 0 !!!
        int cur = root.val + (left > 0 ? left: 0) + (right > 0 ? right : 0);
        if(cur > result.get(0)) {
            result.set(0, cur);
        }
        return root.val + Math.max(left, Math.max(right, 0));
    }
}
