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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        // dummy: reserve the head (return dummy.next)
        // !!! DO NOT ADD dummy.next = head, since pre = dummy later and we will operate pre !!!
        ListNode dummy = new ListNode(0);
        // pre: keep the return list: pre -> 1 -> 2 ...
        // cur: keep moving pointer (from the first element)
        ListNode pre = dummy;
        ListNode cur = head;
        // dupValue: store the duplicate value
        int dupValue = Integer.MIN_VALUE;
        while(cur != null && cur.next != null) {
            // find same value
            if(cur.val == cur.next.val) {
                dupValue = cur.val;
                while(cur.val == dupValue) {
                    // skip same value nodes
                    cur = cur.next;
                    // if rest elements are all the same
                    if(cur == null) return dummy.next;
                }
            } else {
                // add cur to pre.next: pre -> 1 -> 1 -> (2 cur) ==> pre -> 2
                // move pre to the new element: (pre 2)
                // move cur forward
                // add null to pre.next: (pre 2) -> null
                pre.next = cur;
                pre = pre.next;
                cur = cur.next;
                pre.next = null;
            }
        }
        // add the last element (since cur.next != null skip this element)
        // if this element is dup, it will be skiped before (in the second while loop)
        pre.next = cur;
        return dummy.next;
    }
}
