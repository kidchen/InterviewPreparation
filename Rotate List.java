/*
Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
*/

// O(n), O(1) space


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
    public ListNode rotateRight(ListNode head, int n) {
        if(head == null || head.next == null || n == 0) {
            return head;
        }
        // !!! count from 0, since we need to get the length of the list !!!
        // thought: 1-2-3-4-5, n = 2.
        // if we want to rotate, one node should be at 3, which means we need to move two times
        // that is to say from 0 to 1 and 1 to 2, two times.
        int count = 0;
        ListNode fast = head;
        // so here, no need to equal to n
        while(count < n && fast != null) {
            fast = fast.next;
            count++;
        }
        if(fast == null) {
            // !!! have to use mod rather than minus !!!
            n %= count;
            // when n equals to the length of the list, straightly return head
            if(n == 0) {
                return head;
            }
            count = 0;
            fast = head;
            // here, fast can not be null since n is definately smaller than list.length
            while(count < n) {
                fast = fast.next;
                count++;
            }
        }
        ListNode slow = head;
        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;
        return newHead;
    }
}
