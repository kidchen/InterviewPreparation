/*
Sort a linked list using insertion sort.
*/

// O(n^2), O(1) space
// reference: http://en.wikipedia.org/wiki/Insertion_sort

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
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        // !!! don't forget to add cur.next != null !!!
        while(cur != null && cur.next != null) {
            if(cur.next.val < cur.val) {
                ListNode small = cur.next;
                cur.next = cur.next.next;
                while(pre.next.val < small.val) {
                    pre = pre.next;
                }
                ListNode temp = pre.next;
                pre.next = small;
                small.next = temp;
                pre = dummy;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}



/************OLD VERSION - AUG 17*************/

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
    public ListNode insertionSortList(ListNode head) {
        if(head == null) {
            return head;
        }
        ListNode result = new ListNode(0);
        result.next = head;
        ListNode cur = head;
        while(cur != null && cur.next != null) {
            if(cur.val > cur.next.val) {
                // find a position to swap with cur.next (smaller)
                ListNode smaller = cur.next;
                ListNode pre = result;
                while(pre.next.val < smaller.val) {
                    pre = pre.next;
                }
                ListNode temp = pre.next;
                pre.next = smaller;
                cur.next = smaller.next;
                smaller.next = temp;
            } else {
                cur = cur.next;
            }
        }
        
        return result.next;
    }
}
