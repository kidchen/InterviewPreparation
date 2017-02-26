/**
Reverse a singly linked list.

        click to show more hints.

        Hint:

        A linked list can be reversed either iteratively or recursively. Could you implement both?
**/


// Iteration:

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode tail = null;
        while (cur.next != null) {
            ListNode next = cur.next;
            cur.next = tail;
            tail = cur;
            cur = next;
        }
        cur.next = tail;
        return cur;
    }
}


// recursion:

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        return helper(head, null);
    }

    private ListNode helper(ListNode cur, ListNode prev) {
        if (cur.next == null) {
            cur.next = prev;
            return cur;
        }
        ListNode next = cur.next;
        cur.next = prev;
        return helper(next, cur);
    }
}
