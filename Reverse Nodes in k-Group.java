/*
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null) {
            return head;
        }
        // dummy-->head(1->2->3->4) ,k = 3
        // (pre) -> 1(cur) -> 2(next) -> 3 -> (4 end)
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        // !!! cur = head. because we will return dummy.next, not head !!!
        ListNode cur = head;
        int count = 1;
        while(cur != null) {
            ListNode next = cur.next;
            if(count == k) {
                // !!! the reverse is actually in place, we only need to move pre to its right position !!!
                // !!! pre will be moved forward !!! pre = , rather than pre.next = ; pre = cur !!!
                pre = reverse(pre, next);
                count = 0;
            }
            count++;
            // !!! cur = next, rather than cur = cur.next !!!
            cur = next;
        }
        return dummy.next;
    }
    
    ListNode reverse(ListNode start, ListNode end) {
        // start -> 1(first, will be returned) -> 2(cur) -> 3(next) -> end
        if(start == null || start.next == null) return start;
        ListNode first = start.next;
        ListNode cur = start.next.next;
        while(cur != end) {
            ListNode next = cur.next;
            // !!! use start.next rather than first !!!
            cur.next = start.next;
            start.next = cur;
            cur = next;
        }
        first.next = end;
        return first;
    }
}
