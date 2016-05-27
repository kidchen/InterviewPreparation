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
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param head a ListNode
     * @return a ListNode
     */
    public ListNode swapPairs(ListNode head) {
        // Write your code here
        if(head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        while(head.next != null && head.next.next != null) {
            ListNode left = head.next;
            ListNode right = head.next.next;
            head.next = right;
            left.next = right.next;
            right.next = left;
            // now, "left" is actually the right one
            head = left;
        }
        return dummy.next;
    }
}

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
 
// recursion, using extra O(n) space when do recursion
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

// general, O(n), O(1) space

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
        // !!! need to use dummy node, since head already been changed by cur !!!
        ListNode result = new ListNode(0);
        result.next = head;
        ListNode pre = result;
        ListNode cur = head;
        while(cur != null && cur.next != null) {
            ListNode next = cur.next.next;
            cur.next.next = cur;
            // !!! add this time's two nodes into result !!!
            pre.next = cur.next;
            if(next != null && next.next != null) {
                cur.next = next.next;
            } else {
                cur.next = next;
            }
            // !!! move the pre node: pre-1-2-... --> 2-1(pre)-... !!!
            pre = cur;
            cur = next;
        }
        return result.next;
    }
}
