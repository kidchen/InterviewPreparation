/*
Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

For example:
Given the below binary tree,

       1
      / \
     2   3
Return 6.
*/

// only return positive result !? --> NO! We need to check the value's sign because if its negative, 
//                                    the result will be reduced, which means we cannot find the max !!
// O(n), O(logn) space cost

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
        helper(root, result);
        return result.get(0);
    }
    
    // !!! have to return int value so that we can calculate the max value in 
    // left or right subtree in recursion !!!
    int helper(TreeNode root, ArrayList<Integer> result) {
        if(root == null) return 0;
        // inorder traversal
        int left = helper(root.left, result);
        int right = helper(root.right, result);
        // !!! have to check whether left/right > 0 !!!
        int cur = root.val + (left > 0 ? left: 0) + (right > 0 ? right : 0);
        if(cur > result.get(0)) {
            result.set(0, cur);
        }
        // !!! return the path sum of cur node + max(left, right) --> still need to check the positive/negative !!!
        return root.val + Math.max(left, Math.max(right, 0));
    }
}
