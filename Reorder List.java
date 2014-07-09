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
        if(head == null || head.next == null) return;
        ListNode fast = head;
        ListNode slow = head;
        // !!! order matters !!!
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head1 = head;
        ListNode head2 = slow.next;
        slow.next = null;
        head2 = reverse(head2);
        while(head1 != null && head2 != null) {
            ListNode next = head2.next;
            head2.next = head1.next;
            head1.next = head2;
            head1 = head2.next;
            head2 = next;
        }
    }
    
    ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null) {
            // 1(cur)->2(next)->3->4
            ListNode next = cur.next;
            // 1(cur)->null(pre) 2(next)->3->4
            cur.next = pre;
            // 1(pre)->null 2(next)->3->4
            pre = cur;
            // 1(pre)->null 2(cur)->3->4
            cur = next;
        }
        return pre;
    }
}
