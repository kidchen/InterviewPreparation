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
    public ListNode sortList(ListNode head) {
        return merge(head);
    }
    
    // sperate head into two lists
    ListNode merge(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head2 = slow.next;
        ListNode head1 = head;
        slow.next = null;
        head1 = merge(head1);
        head2 = merge(head2);
        return sort(head1, head2);
    }
    
    // merge two sorted list
    ListNode sort(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        dummy.next = head1;
        ListNode pre = dummy;
        while(head1 != null && head2 != null) {
            if(head1.val < head2.val) {
                head1 = head1.next;
            } else {
                // !!! classic swap !!!
                ListNode next = head2.next;
                head2.next = pre.next;
                pre.next = head2;
                head2 = next;
            }
            pre = pre.next;
        }
        if(head2 != null) {
            pre.next = head2;
        }
        return dummy.next;
    }
}
