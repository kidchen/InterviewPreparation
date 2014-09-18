/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
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
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        ListNode cur = head;
        ListNode last = new ListNode(0);
        ListNode lastCur = last;
        while(cur != null) {
            ListNode next = cur.next;
            if(cur.val < x) {
                pre.next = cur;
                pre = pre.next;
                // !!! have to close the listnode !!!
                // !!! otherwise there may create a linkedlist cycle !!!
                pre.next = null;
            } else {
                lastCur.next = cur;
                lastCur = lastCur.next;
                // !!! have to close the listnode !!!
                // !!! otherwise there may create a linkedlist cycle !!!
                lastCur.next = null;
            }
            cur = next;
        }
        if(last.next != null) {
            pre.next = last.next;
        }
        return dummy.next;
    }
}
