public class LRUCache {
    // define the new class Node
    class Node {
        Node pre;
        Node next;
        int key;
        int val;
        public Node(int key, int value) {
            this.key = key;
            this.val = value;
        }
    }
    
    // initial the values
    private int num;
    private int capacity;
    private HashMap<Integer, Node> map;
    // first: less used, last: recently used
    private Node first, last;
    
    // implement the cache
    public LRUCache(int capacity) {
        int num = 0;
        this.capacity = capacity;
        // !!! new a hashmap !!!
        map = new HashMap<Integer, Node>();
        first = null;
        last = null;
    }
    
    // implement the get method
    public int get(int key) {
        // get the node by the key
        Node node = map.get(key);
        // if the key is not exist
        if(node == null) {
            return -1;
        } else if(node != last) {
            // if node is not the most recently used (need to modify the list)
            // delete the node from the list and add it to the first
            if(node == first) {
                first = first.next;
            } else {
                node.pre.next = node.next;
            }
            // add to first
            node.next.pre = node.pre;
            last.next = node;
            node.pre = last;
            node.next = null;
            last = node;
        }
        // return value(if key is the recent one, directly return the val)
        return node.val;
    }
    
    public void set(int key, int value) {
        // first check if the key is existed
        Node node = map.get(key);
        // if exist
        if(node != null) {
            node.val = value;
            // modify the position of the node in the list
            if(node != last) {
                if(node == first) {
                    first = first.next;
                } else {
                    node.pre.next = node.next;
                }
                node.next.pre = node.pre;
                last.next = node;
                node.pre = last;
                node.next = null;
                last = node;
            }
        } else {
            // this is a new kv pair int he list
            Node newNode = new Node(key, value);
            // check if there is any space to add a new node
            if(num >= capacity) {
                map.remove(first.key);
                first = first.next;
                if(first != null) {
                    first.pre = null;
                } else {
                    // in this case: null <=> key(deleted) <=> null
                    last = null;
                }
                num--;
            }
            // if there is only one position(last) in the list and yet been valued
            if(first == null || last == null) {
                first = newNode;
            } else {
                last.next = newNode;
            }
            newNode.pre = last;
            newNode.next = null;
            last = newNode;
            map.put(key, newNode);
            num++;
        }
    }
}
