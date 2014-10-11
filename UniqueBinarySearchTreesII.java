/*
Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

*/

// Recursion, similar with NP(N-QUEEN), O(2^n) exponential


/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        // directly do the helper(left, right): from the most left node to the most right one
        return helper(1, n);
    }
    
    private List<TreeNode> helper(int left, int right) {
        List<TreeNode> result = new ArrayList<TreeNode>();
        // if can't create a tree, return/add null
        if(left > right) {
            result.add(null);
            return result;
        }
        for(int i = left; i <= right; i++) {
            // set i as the root, calculate the two subtrees and store them in two lists
            List<TreeNode> leftSubtree = helper(left, i - 1);
            List<TreeNode> rightSubtree = helper(i + 1, right);
            // retrieve subtree(nodes) from lists
            for(int j = 0; j < leftSubtree.size(); j++) {
                for(int k = 0; k < rightSubtree.size(); k++) {
                    // set all possible combination of left and right subtrees after root(i)
                    TreeNode root = new TreeNode(i);
                    root.left = leftSubtree.get(j);
                    root.right = rightSubtree.get(k);
                    result.add(root);
                }
            }
        }
        return result;
    }
}
