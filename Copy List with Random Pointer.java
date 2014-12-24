// solution 1 : O(n), O(n)
// using HashMap:
// first while loop, copy the list and build the map, then in the second loop, add random node to each node
// use a hashmap to store <oldNode, newNode> so that when we get map.get(oldNode.random), we can get the corresponding node in new

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) {
            return null;
        }
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode pre = dummy;
        RandomListNode cur = head;
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        // copy the list, and build the map<oldNode, newNode>
        while(cur != null) {
            RandomListNode newNode = new RandomListNode(cur.label);
            pre.next = newNode;
            pre = pre.next;
            map.put(cur, newNode);
            cur = cur.next;
        }
        RandomListNode oldNode = head;
        RandomListNode random = dummy.next;
        while(oldNode != null) {
            // !!! get the corresponding random node in new !!!
            random.random = map.get(oldNode.random);
            oldNode = oldNode.next;
            random = random.next;
        }
        return dummy.next;
    }
}


// LintCode:

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        if(head == null) {
            return null;
        }
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        map.put(head, new RandomListNode(head.label));
        RandomListNode cur = head;
        while(cur != null) {
            // !!! have to check whether its next == null first !!!
            if(cur.next != null) {
                if(!map.containsKey(cur.next)) {
                    map.put(cur.next, new RandomListNode(cur.next.label));
                }
                map.get(cur).next = map.get(cur.next);
            }
            if(cur.random != null) {
                if(!map.containsKey(cur.random)) {
                    map.put(cur.random, new RandomListNode(cur.random.label));
                }
                map.get(cur).random = map.get(cur.random);
            }
            cur = cur.next;
        }
        return map.get(head);
    }
}




// solution 2 : O(n), O(1)
// old1 -> new1 -> old2 -> new2 -> old3 -> new3
// !!! node.next.random = node.random.next !!!
// split into two lists

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) {
            return null;
        }
        RandomListNode cur = head;
        while(cur != null) {
            RandomListNode newNode = new RandomListNode(cur.label);
            RandomListNode temp = cur.next;
            cur.next = newNode;
            newNode.next = temp;
            cur = temp;
        }
        cur = head;
        while(cur != null) {
            // !!! have to judge whether node.random == null !!!
            // eg: only one element 1, 1.random == null, in this case node.random.next not exist
            // wrong case : {-1, #}
            if(cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode pre = dummy;
        cur = head;
        while(cur != null) {
            pre.next = cur.next;
            cur.next = cur.next.next;
            pre = pre.next;
            cur = cur.next;
        }
        return dummy.next;
    }
}
