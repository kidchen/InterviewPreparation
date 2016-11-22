package LinkedIn;

/**
 * Created by czhang on 11/22/16.
 */
public class BinaryTreeUpsideDown156 {
  /**
   * Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the
   * same parent node) or empty, flip it upside down and turn it into a tree where the original right nodes turned into
   * left leaf nodes. Return the new root.
   * 
   * For example: Given a binary tree {1,2,3,4,5}, 1 / \ 2 3 / \ 4 5
   * 
   * return the root of the binary tree [4,5,2,#,#,3,1].
   * 
   * 4 / \ 5 2 / \ 3 1
   * 
   */

  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

  public class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
      if (root == null) {
        return null;
      }
      // found leaf, return the leaf node
      if (root.left == null && root.right == null) {
        return root;
      }
      // newRoot is the left-most leaf
      TreeNode newRoot = upsideDownBinaryTree(root.left);
      // now the root is the left-most leaf's parent node
      root.left.left = root.right;
      root.left.right = root;
      root.left = null;
      root.right = null;
      return newRoot;
    }
  }
}
