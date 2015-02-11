
public class HashMapImplementation {
	
	/**
	 * The CustomHashMap uses an array of HashEntry.
	 * HashEntry class  where K is the key and V value and  next is the element appended to it. The HashEntry acts 
	 * as a list
	 * 
	 *  MapList is used to store elements. the getHash() method is used to find the index of the array. 
	 * 
	 * @param <K>
	 * @param <V>
	 */
	
	// Well, a hashmap is a kind of data structure used to maintain entries, 
	// that is key-value pair. So first of all, I need to define the entry class. 
	// We declare two integers as the key and value, create a method entry. 
	// And two methods to get key and value.
	class HashEntry<K, V> {
	    K key;
	    V value;
	    HashEntry<K, V> entry = null;
	 
	    public HashEntry<K, V> getEntry() {
	        return entry;
	    }
	 
	    public void setNext(HashEntry<K, V> entry) {
	        this.entry = entry;
	    }
	 
	    public HashEntry(K key, V value) {
	        super();
	        this.key = key;
	        this.value = value;
	    }
	 
	    public K getKey() {
	        return key;
	    }
	 
	    public void setKey(K key) {
	        this.key = key;
	    }
	 
	    public V getValue() {
	        return value;
	    }
	 
	    public void setValue(V value) {
	        this.value = value;
	    }
	 
	}
	
	public class HashMap<K, V> {
		
		// First, we need to define what the base size of the map. 
		// For example, 128. Since when we do rehash, 
		// we need to double the map by its size, 
		// so we need to initially define a size.
		private final static int MAP_SIZE = 128;
	 
	    HashEntry<K, V> mapList[] = new HashEntry[MAP_SIZE];
	 
	    public V get(K key) {
	        int index = getHash(key);
	        HashEntry<K,V> list = mapList[index];
	        return getMatchValue(list, key);
	    }
	 
	    public void put(K key, V value) {
	        int index = getHash(key);
	        storeValue(index, key, value);
	    }
	     
//	    public void remove(K key) {
//	        int index = getHash(key);
//	        HashEntry<K,V> list = mapList[index];
//	        if (list == null)
//	            return;
//	        // if only one element is present in the list ,set the index to null
//	        if(list.getKey().equals(key)){
//	            if (list.next == null){
//	                mapList[index] = null;
//	                return;
//	            }
//	        }
//	        HashEntry<K,V> prev = null;
//	        do{
//	            if(list.key.equals(key)){
//	                if (prev == null){
//	                    list = list.getNext();
//	                }else{
//	                    prev.next = list.getNext();
//	                }
//	                break;
//	            }
//	            list = list.next;
//	        }while(list != null);
//	         
//	        mapList[index] = list;
//	    }
	 
	    /*
	     * find the match value and return , if not found either throw exception or return null.
	     */
	    private V getMatchValue(HashEntry<K, V> list, K key) {
	        while (list != null) {
	            if (list.getKey().equals(key))
	                return list.getValue();
	            list = list.entry;
	        }
	        return null;
	    }
	 
	    private void storeValue(int index, K key, V value) {
	        HashEntry<K, V> list = mapList[index];
	         
	        // if list is empty , enter as first element
	        if (list == null) {
	            mapList[index] = new HashEntry<K, V>(key, value);
	        } else {
	            boolean done = false;
	            // traverse through list , if a key is found ,replace the value or add it at the end of the list
	            while(list.entry != null) {
	                if (list.getKey().equals(key)) {
	                    list.setValue(value);
	                    done = true;
	                    break;
	                } 
	                list = list.entry;
	            }
	            // add at the end of the list
	            if (!done)
	                list.entry = new HashEntry<K, V>(key, value);
	        }
	 
	    }
	     
	    private int getHash(K key) {
	        int hash = key.hashCode();
	        return hash % MAP_SIZE;
	    }
	     
//	    public void main(String args[]) {
//	        CustomHashMap<Integer, Integer> map = new CustomHashMap<Integer, Integer>();
//	        map.put(1, 1);
//	        map.put(2, 2);
//	        map.put(201,201);
//	        System.out.println("get value is " + map.get(1));
//	        System.out.println("get value is " + map.get(201));
//	        System.out.println("get value is " + map.get(2));
//	        map.remove(1);
//	        System.out.println("After deletion " + map.get(1));
//	        System.out.println("get value is " + map.get(201));
//	    }
	 
	}
	 


	
////  first, implement the entry<key, value> class:
//public class HashEntry {
//      private int key;
//      private int value;
// 
//      public HashEntry(int key, int value) {
//            this.key = key;
//            this.value = value;
//      }      
//      public int getKey() {
//            return key;
//      }
//      public int getValue() {
//            return value;
//      }
//}
//
//// then, implement hash function:
//public class HashMap {
//      private final static int TABLE_SIZE = 128;
// 
//      HashEntry[] table;
// 
//      HashMap() {
//            table = new HashEntry[TABLE_SIZE];
//            for (int i = 0; i < TABLE_SIZE; i++)
//                  table[i] = null;
//      }
// 
//      public int get(int key) {
//            int hash = (key % TABLE_SIZE);
//            while (table[hash] != null && table[hash].getKey() != key)
//                  hash = (hash + 1) % TABLE_SIZE;
//            if (table[hash] == null)
//                  return -1;
//            else
//                  return table[hash].getValue();
//      }
// 
//      public void put(int key, int value) {
//            int hash = (key % TABLE_SIZE);
//            while (table[hash] != null && table[hash].getKey() != key)
//                  hash = (hash + 1) % TABLE_SIZE;
//            table[hash] = new HashEntry(key, value);
//      }
//}

}
