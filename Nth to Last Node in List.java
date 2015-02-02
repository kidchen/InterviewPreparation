/*
Find the nth to last element of a singly linked list. 

The minimum number of nodes in list is n.

Example
Given a List  3->2->1->5->null and n = 2, return node  whose value is 1.
*/

// similar: rotate list

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
     * @param n: An integer.
     * @return: Nth to last node of a singly linked list. 
     */
    ListNode nthToLast(ListNode head, int n) {
        // write your code here
        if(head == null || head.next == null) {
            return head;
        }
        int length = 0;
        ListNode end = head;
        while(length < n && end != null) {
            end = end.next;
            length++;
        }
        if(length < n) {
            n %= length;
            end = head;
            while(length < n) {
                end = end.next;
                length++;
            }
        }
        ListNode last = head;
        while(end != null) {
            last = last.next;
            end = end.next;
        }
        return last;
    }
}
