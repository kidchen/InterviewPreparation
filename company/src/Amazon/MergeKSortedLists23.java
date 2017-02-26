/**
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
**/



// solution 1 : divide and conquer. Merge sort the lists of linkedList and merge each pair of the them.
// MergeSort:O(klogk)*O(n)Merge = O(nklogk), space O(logk) for the recursion stack

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        return helper(lists, 0, lists.length - 1);
    }

    private ListNode helper(ListNode[] lists, int start, int end) {
        while (start < end) {
            int mid = start + (end - start) / 2;
            return merge(helper(lists, start, mid), helper(lists, mid + 1, end));
        }
        // start == end
        return lists[start];
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 != null) {
            cur.next = l1;
        }
        if (l2 != null) {
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
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        Comparator<ListNode> comparator = new Comparator<ListNode>() {
            @Override
            public int compare(ListNode node1, ListNode node2) {
                return node1.val - node2.val;
            }
        };
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(comparator);
        for (ListNode listNode : lists) {
            // PriorityQueue DOES NOT allow null element
            if (listNode != null) {
                heap.offer(listNode);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (heap.size() > 0) {
            ListNode node = heap.poll();
            cur.next = node;
            cur = cur.next;
            if (node.next != null) {
                heap.offer(node.next);
            }
        }
        return dummy.next;
    }
}
