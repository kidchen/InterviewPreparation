// Deal with collision by linkedlist 

public class HashMapImplementation {

    class HashEntry {
        int key;
        int value;
        HashEntry entry = null;
     
        public HashEntry(int key, int value) {
            this.key = key;
            this.value = value;
        }
     
        public int getKey() {
            return key;
        }
     
        public int getValue() {
            return value;
        }
     
        public void setValue(int value) {
            this.value = value;
        } 
    }
    
    public class ListNode {
         HashEntry val;
         ListNode next;
         ListNode(HashEntry x) {
             val = x;
             next = null;
        }
    }
    
    public class HashMap {      
        private final static int MAP_SIZE = 128;

        ListNode mapList[] = new ListNode[MAP_SIZE];
        
        public void put(int key, int value) {

            int hash = key % MAP_SIZE;

            ListNode node = mapList[hash];
            HashEntry entry = new HashEntry(key, value);
             
            if (node == null) {
                mapList[hash] = new ListNode(entry);
            } else {
                boolean found = false;
                while(node.next != null) {
                    if (node.val.getKey() == key) {
                        node.val.setValue(value);
                        found = true;
                        break;
                    } 
                    node = node.next;
                }
                if (!found) {
                    node.next = new ListNode(entry);
                }
            }
        }
     
        public int get(int key) {
            int hash = key % MAP_SIZE;
            ListNode node = mapList[hash];
            while (node != null) {
                if (node.val.getKey() == key) {
                    return node.val.getValue();
                }
                node = node.next;
            }
            return 0;
        }
         
        public void remove(int key) {
            int hash = key % MAP_SIZE;
            ListNode node = mapList[hash];
            if (node == null)
                return;
            if(node.val.getKey() == key){
                if (node.next == null){
                    mapList[hash] = null;
                    return;
                }
            }
            ListNode pre = node;
            node = node.next;
            while(node != null && node.val.getKey() != key) {
                node = node.next;
                pre = pre.next;
            }
            if(node.val.getKey() == key) {
                pre.next = node.next;
            }
            return;
        }
     
    }
}


// Deal collision by nearest available position

class HashEntry {
    int key;
    String value;
    HashEntry entry = null;
    
    public HashEntry(int key, String value) {
        this.key = key;
        this.value = value;
    }
    
    public int getKey() {
        return key;
    }
    
    public String getValue() {
        return value;
    }
    
    public void setValue(String value) {
        this.value = value;
    }
}


public class HashMap {
    private final static int MAP_SIZE = 128;
    HashEntry map[] = new HashEntry[MAP_SIZE];
    
    public void put(int key, String value) {
        int hash = key % MAP_SIZE;
        HashEntry entry = new HashEntry(key, value);
        
        if(map[hash] == null) {
            map[hash] = entry;
        } else {
                boolean found; 
                boolean foundEmpty;
                int emptyHash = hash;       
                int count = 0;
                while(count < MAP_SIZE) {
                    if(map[hash] != null && !foundEmpty) {
                        emptyHash = hash;
                        foundEmpty = true;
                    }
                    if(map[hash] != null && map[hash].getKey() == key) {
                        found = true;
                        break;
                    }
                    hash++;
                    count++;
                }
                if(found) {
                    map[hash].setValue(value);
                } else if(foundEmpty) {
                    map[emptyHash] = entry;
                } else {              
                    Exception.throw(System.out.println("HashMap is full"));
                } 
                        
        }
    }
    
    public String get(int key) {
        int hash = key % MAP_SIZE;
        while(map[hash] != null) {
            if(map[hash].getKey() == key) {
                return map[hash].getValue();
            }
            hash++;
        }
        return null;
    }
    
    public void remove(int key) {
        int hash = key % MAP_SIZE;

        if (map[hash] == null) {
            return;
        }
        int count = 0;
        while(count < MAP_SIZE) {
            if(map[hash].getKey() == key){
                map[hash] = null;
                return;
            }
            hash++;
            count++;
        }
        return;
    }

}
