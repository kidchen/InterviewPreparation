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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode preNode = dummy;
        int i = 1;
        while(preNode != null && i < m){
            preNode = preNode.next;
            i++;
        }
        // now i = m
        ListNode mNode = preNode.next;
        ListNode cur = mNode.next;
        while(cur != null && i < n){
            // store cur's next node 
            ListNode curNext = cur.next;
            // use preNode and its next (preNode is static, so it is better to use)
            cur.next = preNode.next;
            preNode.next = cur;
            // use mNode and its next (mNode is also static)
            mNode.next = curNext;
            // cur is changable
            cur = curNext;
            i++;
        }
        
        return dummy.next;
    }
}
