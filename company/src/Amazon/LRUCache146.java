/**
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

        get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.

        put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

        Follow up:

        Could you do both operations in O(1) time complexity?

        Example:

        LRUCache cache = new LRUCache( 2 );

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
**/



public class LRUCache {

    private class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            prev = null;
            next = null;
        }
    }

    private final int capacity;
    // dummy node for head and tail
    private Node leastUsed;
    private Node mostUsed;
    private Map<Integer, Node> keyNodeMap;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        leastUsed = new Node(0, 0);
        mostUsed = new Node(0, 0);
        leastUsed.prev = mostUsed;
        mostUsed.next = leastUsed;
        keyNodeMap = new HashMap<Integer, Node>();
    }

    public int get(int key) {
        // System.out.println("get " + key);
        if (!keyNodeMap.containsKey(key)) {
            return -1;
        }
        Node node = keyNodeMap.get(key);
        useNode(node);
        return node.value;
    }

    public void put(int key, int value) {
        // System.out.println("put " + key + "-" + value);
        if (keyNodeMap.containsKey(key)) {
            // set
            Node node = keyNodeMap.get(key);
            node.value = value;
            useNode(node);
        } else {
            // put
            Node newNode = new Node(key, value);
            // if no space
            if (keyNodeMap.size() == capacity) {
                keyNodeMap.remove(leastUsed.prev.key);
                leastUsed.prev = leastUsed.prev.prev;
            }
            newNode.next = mostUsed.next;
            mostUsed.next.prev = newNode;
            mostUsed.next = newNode;
            keyNodeMap.put(key, newNode);
        }
    }

    // use a node, update mostUsed
    private void useNode(Node node) {
        if (mostUsed.next != node) {
            if (leastUsed.prev == node) {
                // leastUsed is at the end of the deque
                leastUsed.prev = node.prev;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
            node.next = mostUsed.next;
            mostUsed.next.prev = node;
            mostUsed.next = node;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */




// 0221

public class LRUCache {

    private class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            prev = null;
            next = null;
        }
    }

    // head is most freq used
    private Node head;
    private Node tail;
    Map<Integer, Node> map;
    int capacity;

    public LRUCache(int capacity) {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        useKey(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            if (map.size() == capacity) {
                // remove tail
                int removeKey = tail.prev.key;
                tail.prev = tail.prev.prev;
                tail.prev.next = tail;
                map.remove(removeKey);
            }
            Node newNode = new Node(key, value);
            newNode.next = head.next;
            head.next = newNode;
            newNode.prev = head;
            newNode.next.prev = newNode;
            map.put(key, newNode);
        } else {
            map.get(key).value = value;
            useKey(map.get(key));
        }
    }

    private void useKey(Node node) {
        if (head.next != node) {
            if (tail.prev == node) {
                tail.prev = tail.prev.prev;
                tail.prev.next = tail;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
            node.next = head.next;
            head.next = node;
            node.prev = head;
            node.next.prev = node;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
