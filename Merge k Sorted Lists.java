// solution 1 : divide and conquer
// O(nklogk), space O(logk)


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
        if(lists == null || lists.size() == 0) return null;
        return helper(lists, 0, lists.size() - 1);
    }
    
    ListNode helper(ArrayList<ListNode> lists, int left, int right) {
        if(left < right) {
            int mid = (left + right) / 2;
            return merge(helper(lists, left, mid), helper(lists, mid + 1, right));
        }
        return lists.get(left);
    }
    
    ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        dummy.next = l1;
        ListNode cur = dummy;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                l1 = l1.next;
            } else {
                ListNode temp = l2.next;
                l2.next = cur.next;
                cur.next = l2;
                l2 = temp;
            }
            cur = cur.next;
        }
        if(l2 != null) {
            cur.next = l2;
        }
        return dummy.next;
    }
}


// solution 2 : using heap
// O(nklogk), space O(k)


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
            @Override
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        });
        // finished creating heap, now initial the heap
        
        for(int i = 0; i < lists.size(); i++) {
            // PriorityQueue DOES NOT allow null element
            if(lists.get(i) != null) {
                heap.add(lists.get(i));
            }
        }
        
        ListNode head = null;
        ListNode pre = head;
        while(heap.size() > 0) {
            ListNode cur = heap.poll();
            if(head == null) {
                head = cur;
                pre = head;
            } else {
                pre.next = cur;
                pre = pre.next;
            }
            if(cur.next != null) heap.add(cur.next);
        }
        return head;
    }
}

