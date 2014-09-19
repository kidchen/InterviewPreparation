/*
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.
*/

// O(n), O(1) space


/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) {
            return;
        }
        // divide
        ListNode slow = head;
        ListNode fast = head;
        // !!! don't forget the fast.next != null condition !!!
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head1 = head;
        ListNode newHead = slow.next;
        slow.next = null;
        // !!! reverse head2 !!!
        // DON'T NEED TO USE dummy NODE
        ListNode pre = null;
        ListNode cur = newHead;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        ListNode head2 = pre;
        // merge
        while(head1 != null && head2 != null) {
            ListNode temp = head2.next;
            head2.next = head1.next;
            head1.next = head2;
            head1 = head1.next.next;
            head2 = temp;
        }
        return;
    }
}
