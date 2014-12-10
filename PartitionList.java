/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
*/

// O(n), O(1) space

/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @param x: an integer
     * @return: a ListNode 
     */
    public ListNode partition(ListNode head, int x) {
        // write your code here
        if(head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = dummy;
        while(cur.next != null) {
            if(cur.next.val < x) {
                // !!! have to check if cur == pre !!!
                if(cur != pre) {
                    ListNode temp = cur.next;
                    cur.next = cur.next.next;
                    ListNode last = pre.next;
                    pre.next = temp;
                    pre = pre.next;
                    pre.next = last;
                } else {
                    pre = pre.next;
                    cur = cur.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}


// LeetCode:

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
