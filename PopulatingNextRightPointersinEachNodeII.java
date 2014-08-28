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
        if(root == null) return;
        // current: cur node
        // head: the first node in a level
        // end: keep moving in each level and connecting two nodes
        TreeLinkNode current = root, head = null, end = null;
        while(current != null) {
            if(current.left != null) {
                if(head != null) {
                // connect two node by end
                    end.next = current.left;
                    end = end.next;
                } else {
                // put head&end into the next level
                    head = current.left;
                    end = head;
                }
            }
            
            if(current.right != null) {
                if(head != null) {
                // connect two node by end
                    end.next = current.right;
                    end = end.next;
                } else {
                // put head&end into the next level
                    head = current.right;
                    end = head;
                }
            }
            
            // after checking left&right, move current to its next
            current = current.next;
            // if there is no node in this level, reset and move cur into the next level
            if(current == null) {
                current = head;
                head = null;
                end = null;
            }
        }
    }
}


// no need to add null at the end of each row!!!
// O(n), O(1)
