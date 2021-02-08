import java.util.LinkedList;

public class HashTableChain<K, V> implements KWHashMap<K, V> {

	private LinkedList<Entry<K, V>>[] table;
	private int numKeys;
	private static final int CAPACITY = 101;
	private static final double LOAD_THRESHOLD = 3.0;
	
	public HashTableChain() {
		table = new LinkedList[CAPACITY];
	}
	
	/**
	 * That method gets the given key.firstly calculate index with hashCode.
 	 * Then control the index. Index is smaller than 0, add table's length to the index.
 	 * 	If table's index is null, return null,otherwise search the linkedlist and if we find that key, return it.
 	 * otherwise return null.
 	 * 
 	 */
	@Override
	public V get(Object key) {
		int index = key.hashCode() % table.length;
		if(index < 0)
			index += table.length;
		if(table[index] == null)
			return null;
		for(Entry<K, V> nextItem: table[index]) {
			if(nextItem.key.equals(key))
				return nextItem.value;
		}
		return null;
	}

	@Override
	public boolean isEmpty() {
		if(numKeys == 0)
			return true;
		return false;
	}

	/**
	 * That method add the key to the table. firstly calculate index with hashCode.
	 * Then control the index. Index is smaller than 0, add table's length to the index.
	 * If table's index is null, create a linkedlist to that index of table.
	 * Otherwise search the list. If we find the key, change its value and return it, 
	 * otherwise add list's start point they key and value couple. increase the numkeys.
	 * if numkeys bigger than (LOAD_THRESHOLD * table.length), we rehash the table.
	 */
	@Override
	public V put(K key, V value) {
		int index = key.hashCode() % table.length;
		if(index < 0)
			index += table.length;
		if(table[index] == null) {
			table[index] = new LinkedList <Entry <K, V> >();
		}
		for(Entry<K, V> nextItem: table[index]) {
			if(nextItem.key.equals(key)) {
				V oldVal = nextItem.value;
				nextItem.setValue(value);
				return oldVal;
			}
		}
		
		table[index].addFirst(new Entry <K, V>(key,value));
		numKeys++;
		if(numKeys > (LOAD_THRESHOLD * table.length) )
			rehash();
		return null;		
	}

	/**
	 * That method rehash the table with  (2 * oldTable.length + 1).
	 */
	private void rehash() {
		LinkedList <Entry <K, V>> oldTable [] =  table;
		table = new LinkedList[2 * oldTable.length + 1];
		numKeys = 0;
		for(int i = 0 ; i < oldTable.length; i++) {
			if(oldTable[i] != null) {
				for(int j = 0 ; j < oldTable[i].size() ; j++) {
					put(oldTable[i].peek().key,oldTable[i].peek().value);
				}				
			}
		}		
		
	}

	/**
	 * That method prints the table.
	 */
	public void print() {
		for(int i = 0 ; i < table.length ; i++) {
			if(table[i] != null) {
				System.out.println("index " + i);
				for(Entry<K, V> nextItem: table[i]) {
					System.out.println("key: " + nextItem.getKey() + "\tvalue: " + nextItem.getValue());
				}	
				System.out.println();
			}
			
		}
	}
	
	/**
	 *That method removes the key. Firstly calculate the index of table with hashCode.
	 *Then control the index of table element. If it is null, returns null.
	 *Otherwise search the table until find the key. When find the key, delete that value.
	 *If in the list, there is no element, we assign null to table's specified index and return deleted value.
	 */
	@Override
	public V remove(Object key) {
		int index = key.hashCode() % table.length;
			
		//key is not in the table
		if(table[index] == null) {
			return null;
		}
		
		for(int i = 0 ; i < table.length ; i++) {
			if(table[i] != null) {
				for(int j = 0 ; j < table[i].size() ; j++) {
					if(table[i].peek().key.equals(key)) {
						V deletedValue = table[i].peek().value;
						table[i].poll();
						numKeys--;
						if(table[i].size() == 0) {
							table[i] = null;
						}
						return deletedValue;
					}
				}	
			}
			
		}
		return null;		
	
	}

	/**
	 * That method returns the size of table.
	 */
	@Override
	public int size() {
		return numKeys;
	}
	
	private static class Entry<K,V>{
		/** The key */
		private K key;
		/** The value */
		private V value;
		
		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}
		
		/**
		 * Retrieves the key
		 * @return the key
		 */
		public K getKey() {
			return key;
		}
		
		/**
		 * Retrieves the value
		 * @return the value
		 */
		public V getValue() {
			return value;
		}
		
		/**
		 * sets the value
		 * @param val the new value
		 * @return the old value
		 */
		public V setValue(V val) {
			V oldVal = value;
			value = val;
			return oldVal;
		}
		
	}
	
}
