/*
Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. 
If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
*/

// O(n), O(1) space

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
        TreeLinkNode top = root;
        TreeLinkNode cur = root;
        TreeLinkNode first = root.left;
        cur.next = null;
        while(top != null && top.left != null){
            while(top != null){
                cur = top.left;
                cur.next = top.right;
                top = top.next;
                cur = cur.next;
                cur.next = (top != null)?top.left:null;
            }
            top = first;
            first = (top != null)?first.left:null;
        }
    }
}




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

// O(n), O(1) space

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
        /*
        last: keep moving the last level(alreay added next pointers)
        first: stay the first node of the next level
        cur: keep moving the current level and add next pointers
        */
        TreeLinkNode last = root;
        TreeLinkNode first = null;
        TreeLinkNode cur = null;
        while(last != null) {
            // check whether the node in the last level has child node:
            if(last.left != null) {
                // if has child node, check whether now it is the begining of a new level:
                if(cur == null) {
                    // if it is a new level, value the cur node and first node
                    cur = last.left;
                    first = last.left;
                } else {
                    // if it is not a new level, add next pointer and move to it
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
            // after add pointers, move last to the next node
            last = last.next;
            // if there is no next node, that means we end traversing the last level
            if(last == null) {
                // put last node to first, and initial cur/first node to null
                last = first;
                cur = null;
                first = null;
            }
        }
    }
}
