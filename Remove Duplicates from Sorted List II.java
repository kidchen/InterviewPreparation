/*
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        ListNode cur = head;
        int dupValue = Integer.MIN_VALUE;
        while(cur != null && cur.next != null) {
            if(cur.val == cur.next.val) {
                dupValue = cur.val;
                while(cur.val == dupValue) {
                    cur = cur.next;
                    // !!! if rest elements are all the same !!!
                    if(cur == null) {
                        return dummy.next;
                    }
                }
            } else {
                pre.next = cur;
                pre = pre.next;
                cur = cur.next;
                // !!! add null to pre.next: in case the rest of elements are the same and returned in line 36 !!!
                pre.next = null;
            }
        }
        // add the last element (since cur.next != null skip this element)
        // if this element is dup, it will be skiped before (in the second while loop)
        pre.next = cur;
        return dummy.next;
    }
}


/************OLD VERSION AUG 16**************/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        // !!! outer while cur != null !!!
        while(cur != null) {
            // find duplicates: the first non-duplicate node is cur.next
            while(cur.next != null && cur.next.val == pre.next.val) {
                cur = cur.next;
            }
            // if there is no duplicates this time, move pre to its next node
            if(pre.next == cur) {
                pre = pre.next;
            } else {
                // there is duplicates, skip them
                // !!! DO NOT ADD pre = pre.next, eg: 1-1-2-2-... !!!
                pre.next = cur.next;
            }
            // each while loop, move on the cur node
            cur = cur.next;
        }
        return dummy.next;
    }
}

// O(n), O(1) space
