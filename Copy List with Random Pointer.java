// solution 1 : O(n), O(n)
// using HashMap:

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
        if(head == null) return null;
        // map(oldListNode, newListNode)
        HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        // newHead: will be returned
        RandomListNode newHead = new RandomListNode(head.label);
        // initial the head of old & new list in the map
        map.put(head, newHead);
        // pre: running on the new node
        RandomListNode pre = newHead;
        // nextNode: running on the old node (faster than pre by one node)
        RandomListNode nextNode = head.next;
        // create the map
        while(nextNode != null) {
            // add value to the new node
            RandomListNode newNode = new RandomListNode(nextNode.label);
            map.put(nextNode, newNode);
            pre.next = newNode;
            pre = pre.next;
            nextNode = nextNode.next;
        }
        // put nextNode (old list) back to the head
        nextNode = head;
        // second scan: add random node
        RandomListNode newRandom = newHead;
        while(nextNode != null) {
            newRandom.random = map.get(nextNode.random);
            newRandom = newRandom.next;
            nextNode = nextNode.next;
        }
        return newHead;
    }
}



// solution 2 : O(n), O(1)
// old1 -> new1 -> old2 -> new2 -> old3 -> new3
// node.next.random = node.random.next
// split two node

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
        if(head == null) return null;
        RandomListNode node = head;
        while(node != null) {
            // !!! node.label, not head.label !!!
            RandomListNode newNode = new RandomListNode(node.label);
            newNode.next = node.next;
            node.next = newNode;
            node = node.next.next;
        }
        node = head;
        while(node != null) {
            // !!! have to judge whether node.random == null !!!
            // eg: only one element 1, 1.random == null, in this case node.random.next not exist
            // wrong case : {-1, #}
            if(node.random != null)
                node.next.random = node.random.next;
            node = node.next.next;
        }
        node = head;
        RandomListNode newHead = head.next;
        while(node != null) {
            RandomListNode newNode = node.next;
            node.next = newNode.next;
            if(newNode.next != null)
                newNode.next = newNode.next.next;
            node = node.next;
        }
        return newHead;
    }
}


