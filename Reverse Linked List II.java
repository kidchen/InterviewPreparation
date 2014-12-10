/*
Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.
*/

// O(n), O(1) space -- one pass

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
        if(head == null) {
            return head;
        }
        // find the m position node
        int count = 1;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while(count < m) {
            pre = pre.next;
            count++;
        }
        // do the reverse: pre-> reverse[first->cur->next] ...
        ListNode first = pre.next;
        ListNode cur = pre.next.next;
        while(count < n) {
            ListNode next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = next;
            count++;
            if(count == n) {
                first.next = next;
            }
        }
        return dummy.next;
    }
}


// general reverse all:
// by iterative: Time O(n), Space:O(1)

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
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        // write your code here
        if(head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        dummy.next = head;
        ListNode first = pre.next;
        ListNode cur = pre.next.next;
        while(cur != null) {
            ListNode next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = next;
        }
        first.next = null;
        return dummy.next;
    }
}


// by recursive: Time O(n), Space O(n) stack overhead
public void recursiveReverse(Node head) {  
	//check for empty list 
	if(head == null)
    		return;
	if(head.next == null) { 
	//set HEAD to current TAIL since we are reversing list
		newHead = head; 
		return; //since this is the base case
	}
	recursiveReverse(head.next);
	head.next.next = head;
	head.next = null; //set "old" next pointer to NULL
}
