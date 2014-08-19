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

// general reverse all:
// by iterative: Time O(n), Space:O(1)
public reverseListIteratively (Node root) {
	if (root == null || root.next == null)
		return;  //empty or just one node in list
	Node Second = root.next;
	//store third node before we change 
	Node Third = Second.next;  
	//Second's next pointer
	Second.next = root;  //second now points to root
	root.next = null;  //change root pointer to NULL
	//only two nodes, which we already reversed
	if (Third == null)
		return;  
	Node CurrentNode = Third;
	Node PreviousNode = Second;
	while (CurrentNode != null) { 
		Node NextNode = CurrentNode.next;
		CurrentNode.next = PreviousNode;
	/*  repeat the process, but have to reset
     the PreviousNode and CurrentNode
	*/
		PreviousNode = CurrentNode;
		CurrentNode = NextNode;  
	}
	root  = PreviousNode; //reset the root node
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
