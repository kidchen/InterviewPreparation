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
        if(head == null) return null;
        // !!! don't forget to initial the value "0" !!!
        ListNode small = new ListNode(0);
        ListNode large = new ListNode(0);
        ListNode sHead = small;
        ListNode lHead = large;
        // !!! not head.next == null, but head !!!
        while(head != null) {
            if(head.val < x){
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            // !!! don't forget to move head !!!
            head = head.next;
            // !!! have to close the listnode !!!
            // otherwise there may create a linkedlist cycle
            small.next = null;
            large.next = null;
        }
        // !!! equals to lHead.next, not lHead (both Head equals to 0) !!!
        small.next = lHead.next;
        return sHead.next;
    }
}
