
public class HashTableOpen<K, V> implements KWHashMap<K, V> {
	
	private Entry<K, V>[] table;
	private static final int START_CAPACITY = 101;
	private double LOAD_THRESHOLD = 0.75;
	private int numKeys;
	private int numDeletes;
	private final Entry<K, V> DELETED = new Entry<K, V>(null, null);
	
	public HashTableOpen() {
		table = new Entry[START_CAPACITY];
	}
	
	/**
	 * That methods find the given key's index value.
	 * @param key key which will be searched
	 * @return returns the given key's index value.
	 */
	public int find(Object key) {
		int index = key.hashCode() % table.length;
		if(index < 0)
			index += table.length;
		while((table[index] != null) && (!key.equals(table[index].key))) {
			index++;
			if(index >= table.length)
				index = 0;
		}
		return index;			
	}
	
	/**
	 * That method returns the given key's value.
	 */
	@Override
	public V get(Object key) {
		int index = find(key);
		if(table[index] != null)
			return table[index].value;
		else 
			return null;
	}

	/**
	 *That method checks the table is empty or not.
	 */
	@Override
	public boolean isEmpty() {
		if(numKeys == 0)
			return true;
		return false;
	}

	/**
	 * That method prints the table.
	 */
	public void print() {
		for(int i = 0 ; i < table.length ; i++) {
			if(table[i] != null && table[i].getKey() != null) {
				System.out.println("index "+ i);
				System.out.println("key: " + table[i].getKey() + "\tvalue: " +  table[i].getValue());
			}
		}
	}
	
	/**
	 * That method puts the given key and value to the table.
	 */
	@Override
	public V put(K key, V value) {
		int index = find(key);
		if(table[index] == null) {
			table[index] = new Entry<K , V>(key,value);
			numKeys++;
			double loadFactor = (double) (numKeys + numDeletes) / table.length;
			if(loadFactor > LOAD_THRESHOLD)
				rehash();
			return null;			
		}
		V oldVal = table[index].value;
		table[index].value = value;
		return oldVal;		
	}

	/**
	 *  That method rehash the table with (2 * oldTable.length +1)
	 */
	private void rehash() {
		Entry<K,V>[] oldTable = table;
		table = new Entry[2 * oldTable.length +1];
		numKeys = 0;
		numDeletes = 0;
		
		for(int i = 0 ; i < oldTable.length; i++) {
			if( (oldTable[i] != null) && (oldTable[i] != DELETED)) {
				put(oldTable[i].key,oldTable[i].value);
			}
		}
		
	}
	
	/**
	 * That method removes the key which is given as a parameter. Firstly with find method, find the index.
	 * if table's specified index is null, return null. Otherwise save the deleted value and remove the key and return deleted value.
	 */
	@Override
	public V remove(Object key) {
		int index = find(key);
		if(table[index] == null)
			return null;
		else {
			V deletedValue = table[index].value;
			table[index] = DELETED;
			numKeys--;
			numDeletes++;
			return deletedValue;
		}	
	
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
