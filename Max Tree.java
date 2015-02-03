/*
Given an integer array with no duplicates. A max tree building on this array is defined as follow:

The root is the maximum number in the array
The left subtree and right subtree are the max trees of the subarray divided by the root number.
Construct the max tree by the given array.
Example
Given [2, 5, 6, 0, 3, 1], the max tree is
              6
            /    \
         5       3
       /        /   \
     2        0     1
*/

// O(n) time complexity, with O(n) space cost for the stack

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
     * @param A: Given an integer array with no duplicates.
     * @return: The root of max tree.
     */
    public TreeNode maxTree(int[] A) {
        // write your code here
        if(A == null || A.length == 0) {
            return null;
        }
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        for(int i : A) {
            TreeNode cur = new TreeNode(i);
            if(!stack.isEmpty()) {
                TreeNode top = stack.peek();
                // compare with the current node value and the one on the top of the stack,
                // back track to find the one that smaller than the current one in the stack.
                while(!stack.isEmpty() && stack.peek().val < cur.val) {
                    top = stack.pop();
                }
                if(stack.isEmpty()) {
                    cur.left = top;
                } else {
                    // 6 - 0 - 3 - 1 
                    /*   6        6 - 3      6 - 3        
                        / \      /   /      /   / \
                           0        0          0   1
                          /        /          /    /
                     null      null        null  null
                    */
                    
                    cur.left = stack.peek().right;
                    stack.peek().right = cur;
                }
            }
            stack.push(cur);
        }
        while(stack.size() > 1) {
            stack.pop();
        }
        return stack.pop();
    }

}



/********* Stack Overflow *********/

// O(n^2) solution by Divide & Conquer

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
     * @param A: Given an integer array with no duplicates.
     * @return: The root of max tree.
     */
    public TreeNode maxTree(int[] A) {
        // write your code here
        if(A == null || A.length == 0) {
            return null;
        }
        // two sides of the tree
        int left = 0;
        int right = A.length - 1;
        return helper(A, left, right);
    }
    
    private TreeNode helper(int[] A, int left, int right) {
        if(left > right) {
            return null;
        }
        int maxIndex = left;
        for(int i = left; i <= right; i++) {
            if(A[maxIndex] < A[i]) {
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(A[maxIndex]);
        root.left = helper(A, left, maxIndex - 1);
        root.right = helper(A, maxIndex + 1, right);
        return root;
    }
}
