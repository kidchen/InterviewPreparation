/*
Sort a linked list in O(n log n) time using constant space complexity.
*/

// O(nlogn), O(logn) space for the recursion stack

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
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list,
                    using constant space complexity.
     */
    public ListNode sortList(ListNode head) {  
        // write your code here
        if(head == null || head.next == null) {
            return head;
        }
        return seperate(head);
    }
    
    private ListNode separate(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode head1 = head;
        ListNode head2 = slow.next;
        slow.next = null;
        // !!! do the recursion until there is only one element left, do the merge method so that we can get sorted lists !!!
        return merge(separate(head1), separate(head2));
    }
    
    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        while(head1 != null && head2 != null) {
            if(head1.val < head2.val) {
                pre.next = head1;
                head1 = head1.next;
            } else {
                pre.next = head2;
                head2 = head2.next;
            }
            pre = pre.next;
        }
        if(head1 != null) {
            pre.next = head1;
        }
        if(head2 != null) {
            pre.next = head2;
        }
        return dummy.next;
    }
}
