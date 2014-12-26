/*
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
*/

// solution 1 : divide and conquer. Merge sort the lists of linkedList and merge each pair of the them.
// MergeSort:O(klogk)*O(n)Merge = O(nklogk), space O(logk) for the recursion stack

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
    public ListNode mergeKLists(List<ListNode> lists) {
        if(lists == null || lists.size() == 0) {
            return null;
        }
        return helper(lists, 0, lists.size() - 1);
    }
    
    // !!! Merge sort the lists !!!
    private ListNode helper(List<ListNode> lists, int first, int last) {
        // !!! use if rather than while: each time, divide the lists by two !!!
        if(first < last) {
            int mid = (first + last) / 2;
            return merge(helper(lists, first, mid), helper(lists, mid + 1, last));
        }
        // !!! return the only one ,first !!!
        return lists.get(first);
    }
    
    private ListNode merge(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if(l1 != null) {
            cur.next = l1;
        }
        if(l2 != null) {
            cur.next = l2;
        }
        return dummy.next;
    }
}


// solution 2 : using heap(PriorityQueue)
// O(nk) for traverse all elements and O(logk) time to insert it into heap, so O(nklogk), O(k) space cost for the heap

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
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // use PriorityQueue to create a heap
        // the top of the heap will be the smallest element in the heap
        // since we use ListNode as element, we need to override compare method in comparator
        // !!! CAREFUL OF capital the first letter in PriorityQueue & Comparator !!!
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(11, new Comparator<ListNode>() {
            // !!! Override the public method compare() !!!
            @Override
            public int compare(ListNode l1, ListNode l2) {
                // compare(o1, o2), return neg/0/pos when o1<o2/=/o1>o2 --> small to large
                return l1.val - l2.val;
            }
        });
        
        for(int i = 0; i < lists.size(); i++) {
            // !!! PriorityQueue DOES NOT allow null element !!!
            if(lists.get(i) != null) {
                heap.offer(lists.get(i));
            }
        }
        
        // !!! PriorityQueue is a kind of heap, only when poll() elements, its order feature can be shown !!!
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(heap.size() > 0) {
            ListNode node = heap.poll();
            cur.next = node;
            cur = cur.next;
            // !!! PriorityQueue DOES NOT allow null element !!!
            if(node.next != null) {
                heap.offer(node.next);
            }
        }
        return dummy.next;
    }
}
