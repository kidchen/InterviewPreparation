/*
Given a root of Binary Search Tree with unique value for each node.  
Remove the node with given value. If there is no such a node with given value in the binary search tree, do nothing. 
You should keep the tree still a binary search tree after removal.

Example
Given binary search tree:
          5
       /    \
    3          6
 /    \
2       4

Remove 3, you can either return:
          5
       /    \
    2          6
      \
         4
or :
          5
       /    \
    4          6
 /   
2
*/



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
     * @param value: Remove the node with given value.
     * @return: The root of the binary search tree after removal.
     */
    public TreeNode removeNode(TreeNode root, int value) {
        // write your code here
        if(root == null) {
            return null;
        }
        TreeNode dummy = new TreeNode(0);
        dummy.left = root;
        TreeNode parent = find(root, value, dummy);
        TreeNode node;
        if(parent.left != null && parent.left.val == value) {
            node = parent.left;
        } else if(parent.right != null && parent.right.val == value) {
            node = parent.right;
        } else {
            return dummy.left;
        }
        remove(node, parent);
        return dummy.left;
    }
    
    // find parent of the node
    private TreeNode find(TreeNode root, int value, TreeNode parent) {
        if(root == null) {
            return parent;
        }
        if(root.val == value) {
            return parent;
        } else if(root.val < value) {
            return find(root.right, value, root);
        } else {
            return find(root.left, value, root);
        }
    }

/*
delete:
- if node.right == null: parent.child = node.left (replace the node with its left child)
- if node has right child: (replace the node with the smallest one that in its right subtree)
  - keep two nodes(temp & father) tracking to find the smallest one that in its right subtree
  - replace
*/    
    private void remove(TreeNode node, TreeNode parent) {
        if(node.right == null) {
            if(parent.left == node) {
                parent.left = node.left;
            } else {
                parent.right = node.left;
            }
        } else {
            TreeNode temp = node.right;
            TreeNode father = node;
            while(temp.left != null) {
                father = temp;
                temp = temp.left;
            }
            if(father.right == temp) {
                father.right = temp.right;
            } else {
                father.left = temp.right;
            }
            if(parent.left == node) {
                parent.left = temp;
            } else {
                parent.right = temp;
            }
            temp.left = node.left;
            temp.right = node.right;
        }
    }
}
