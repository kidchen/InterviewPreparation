/*
Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
*/

// no need to add null at the end of each row!!!
// O(n), O(1)

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) {
            return;
        }
        TreeLinkNode cur = null;
        TreeLinkNode first = null;
        TreeLinkNode last = root;
        // !!! when last != null !!!
        while(last != null) {
            if(last.left != null) {
                if(cur == null) {
                    cur = last.left;
                    // !!! first is on the beginning of the cur level !!!
                    first = last.left;
                } else {
                    cur.next = last.left;
                    cur = cur.next;
                }
            }
            if(last.right != null) {
                if(cur == null) {
                    cur = last.right;
                    first = last.right;
                } else {
                    cur.next = last.right;
                    cur = cur.next;
                }
            }
            if(last.next == null) {
                last = first;
                first = null;
                cur = null;
            } else {
                last = last.next;
            }
        }
    }
}
