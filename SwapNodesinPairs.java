/*
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
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
 
// recursion
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null) 
            return null;
        if(head.next == null) 
            return head;
        ListNode first = head;
        ListNode second = first.next;
        ListNode third = second.next;
        second.next = first;
        first.next = swapPairs(third);
        return second;
    }
}

// general

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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode result = new ListNode(0);
        result.next = head;
        ListNode pre = result;
        ListNode cur = head;
        while(cur != null && cur.next != null) {
            // 1-2-3-4 --> 2-1-4-3
            ListNode next = cur.next.next;
            // !!! 2.next = 1 !!!
            cur.next.next = cur;
            // 2-1-...
            pre.next = cur.next;
            if(next != null && next.next != null) {
                cur.next = next.next;
            } else {
                cur.next = next;
            }
            pre = cur;
            cur = next;
        }
        return result.next;
    }
}
