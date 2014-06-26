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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 != null) return l2;
        if(l1 != null && l2 == null) return l1;
        ListNode result = new ListNode(0);
        ListNode cur = result;
        int carry = 0;
        while(l1 != null && l2 != null) {
            int value = l1.val + l2.val + carry;
            if(value >= 10) {
                carry = 1;
                value -= 10;
            } else {
                carry = 0;
            }
            ListNode next = new ListNode(value);
            cur.next = next;
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null) {
            int value = l1.val + carry;
            if(value >= 10) {
                carry = 1;
                value -= 10;
            } else {
                carry = 0;
            }
            ListNode next = new ListNode(value);
            cur.next = next;
            cur = cur.next;
            l1 = l1.next;
        } 
        while(l2 != null) {
            int value = l2.val + carry;
            if(value >= 10) {
                carry = 1;
                value -= 10;
            } else {
                carry = 0;
            }
            ListNode next = new ListNode(value);
            cur.next = next;
            cur = cur.next;
            l2 = l2.next;
        }
        // !!! DO NOT FORGET TO CHECK THE LAST CARRY !!!
        if(carry == 1) {
            ListNode addition = new ListNode(1);
            cur.next = addition;
        }
        return result.next;
    }
}
