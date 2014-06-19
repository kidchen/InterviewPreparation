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
        // dummy-->head(1->2->3->4) ,k = 3
        // (pre) -> 1(cur) -> 2(next) -> 3 -> (4 end)
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        // !!! cur = head. because we will return dummy.next, not head !!!
        ListNode cur = head;
        // !!! DO NOT add head.next == null !!!
        if(head == null) return null;
        int count = 0;
        while(cur != null) {
            count++;
            ListNode next = cur.next;
            if(count == k) {
                // pre will be moved forward
                pre = reverse(pre, next);
                // !!! clear count !!!
                count = 0;
            }
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
