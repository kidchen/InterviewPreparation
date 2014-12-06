/*
Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
*/

// O(m+n) time, O(1) space

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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        int countA = 0;
        ListNode curA = headA;
        while(curA.next != null) {
            curA = curA.next;
            countA++;
        }
        int countB = 0;
        ListNode curB = headB;
        while(curB.next != null) {
            curB = curB.next;
            countB++;
        }
        if(curA != curB) {
            return null;
        }
        if(countA > countB) {
            while(countA != countB) {
                headA = headA.next;
                countA--;
            }
        } else {
            while(countB != countA) {
                headB = headB.next;
                countB--;
            }
        }
        while(headA != null && headB != null) {
            if(headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}
