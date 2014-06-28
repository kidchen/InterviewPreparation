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
    public ListNode rotateRight(ListNode head, int n) {
        if(head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        int count = 0;
        while(fast != null && count < n) {
            fast = fast.next;
            count++;
        }
        // 1 -> 2
        // k = 2, 3
        if(fast == null) {
            n %= count;
            fast = head;
            count = 0;
            while(fast.next != null && count < n) {
                fast = fast.next;
                count++;
            }
        }
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        fast.next = head;
        ListNode result = slow.next;
        slow.next = null;
        return result;
    }
}
