/*
Design and implement a data structure for Least Recently Used (LRU) cache. 
It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. 
When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
*/

// Both get(key) and set(key, value) cost O(1) time, we need O(n) space to set the hashmap

// Thought:
// 1. use the combination of hashmap<key, node<key, value>> & double-linkedlist<node<key, value>>
// 2. get: check if the corresponding value(node) of the key is exist, if so, is it least, if so, reorder the list
// 3. set: check if the corresponding value(node) of the key is exist, if NOT, add new node
//         --> if there is no extra space, delete the least-->during the deletion, check if the capacity is 1 !!!

public class LRUCache {
    // define the Node class, which is double-linked-list-node with both key and value
    class Node {
        int key;
        int val;
        Node pre;
        Node next;
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    
    // !!! have initial these parameters because later more than one method will use them !!!
    private int num;
    private int capacity;
    private Node most, least;
    private HashMap<Integer, Node> map;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        // don't need to declear their types
        num = 0;
        map = new HashMap<Integer, Node>();
        most = null;
        least = null;
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if(node == null) {
            return -1;
        } else if(node != most) {
            if(node == least) {
                least = least.next;
                least.pre = null;
            } else {
                node.pre.next = node.next;
                node.next.pre = node.pre;
            }
            node.pre = most;
            node.next = null;
            most.next = node;
            most = node;
        }
        return node.val;
    }
    
    public void set(int key, int value) {
        Node node = map.get(key);
        if(node != null) {
            // no need to modify map, since map's value stored node
            node.val = value;
            if(node != most) {
                if(node == least) {
                    least = least.next;
                    least.pre = null;
                } else {
                    node.pre.next = node.next;
                    node.next.pre = node.pre;
                }
                node.pre = most;
                node.next = null;
                most.next = node;
                most = node;
            }
        } else {
            Node newNode = new Node(key, value);
            if(num >= capacity) {
                // delete least
                map.remove(least.key);
                least = least.next;
                // !!! check least, if the capacity = 1 and least is removed, put most = null !!!
                if(least != null) {
                    least.pre = null;
                } else {
                    // before delete least, both least & most = oldNode, now what we actually do is
                    // to replace it with newNode, so we also need to set most as null
                    most = null;
                }
                num--;
            }
            // add newNode to most
            // !!! if the capacity = 1, that is least == null, the same as most == null, set 
            // least = newNode, here we won't set most = newNode since later we will do it !!!
            if(least == null || most == null) {
                least = newNode;
            } else {
                most.next = newNode;
            }
            newNode.pre = most;
            newNode.next = null;
            most = newNode;
            map.put(key, newNode);
            num++;
        }
    }
}
