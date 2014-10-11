/*
* Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
*/


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
 
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 // Inorder traversal: O(n), stack:O(logn) + treeNodes:O(n) + extra:O(logn) = O(n) space costs
 
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) {
            return null;
        }
         
        // get list length
        int len = 0;
        ListNode cur = head;
        while(cur != null) {
            len++;
            cur = cur.next;
        }
        // passing the head in recursion
        ArrayList<ListNode> list = new ArrayList<ListNode>();
        list.add(head);
        return helper(list, 0, len - 1);
    }
     
    // build bottom-to-top
    public TreeNode helper(ArrayList<ListNode> list, int start, int end) {
        // if finished (root)
        if(start > end) {
            return null;
        }
         
        // get mid val
        int mid = (start + end) / 2;
         
        // !!! build left sub tree !!!
        TreeNode left = helper(list, start, mid - 1);
        // !!! build root node !!!
        TreeNode root = new TreeNode(list.get(0).val);
        root.left = left;
        // !!! move to next node to build right sub tree !!!
        list.set(0, list.get(0).next);
        root.right = helper(list, mid + 1, end);
         
        return root;
    }
}
