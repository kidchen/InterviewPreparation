/*
Sort a linked list in O(n log n) time using constant space complexity.
*/

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
        return seperate(head);
    }
    
    // seperate the list into two
    ListNode seperate(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head1 = head;
        ListNode head2 = slow.next;
        slow.next = null;
        head1 = seperate(head1);
        head2 = seperate(head2);
        return merge(head1, head2);
    }
    
    // merge two sorted lists
    ListNode merge(ListNode head1, ListNode head2) {
        ListNode result = new ListNode(0);
        ListNode temp = result;
        while(head1 != null && head2 != null) {
            if(head1.val < head2.val) {
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }
        if(head1 != null) {
            temp.next = head1;
        }
        if(head2 != null) {
            temp.next = head2;
        }
        return result.next;
    }
}
