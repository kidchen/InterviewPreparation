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
        if(head == null || head.next == null) return head;
        // pre -> 1 (3 temp) (4 cur) (2 smaller) 5 ==> 1 2 3 4 5
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        while(cur != null && cur.next != null) {
            // find smaller node(cur.next)
            if(cur.val > cur.next.val) {
                ListNode smaller = cur.next;
                // new pre to do the while loop
                ListNode pre = dummy;
                // find position for smaller node
                while(pre.next.val < smaller.val) {
                    pre = pre.next;
                }
                ListNode temp = pre.next;
                pre.next = smaller;
                cur.next = smaller.next;
                smaller.next = temp;
            } else {
                // !!! have to use "else" !!!
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}



/************UPDATE AUG 17*************/

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
