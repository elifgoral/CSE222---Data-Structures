
public class HashTableOpenNew<K, V> implements KWHashMap<K, V> {
	
	private Entry<K, V>[] table;
	private static final int START_CAPACITY = 101;
	private double LOAD_THRESHOLD = 0.75;
	private int numKeys;
	private int numDeletes;
	private final Entry<K, V> DELETED = new Entry<K, V>(null, null);
	private static final int PRIME = 31;

	
	public HashTableOpenNew() {
		table = new Entry[START_CAPACITY];
	}
	
	/**
	 * my second hash function as a (PRIME - (key.hashCode() % PRIME)).
	 * @param key key of table index
	 * @return return index calculated by hash2 function.
	 */
	public int hash2(Object key) {
		return (PRIME - (key.hashCode() % PRIME));
	}
	
	/**
	 * my first hash function as a key.hashCode() % START_CAPACITY
	 * @param key key of table index
	 * @return return index calculated by hash1 function.
	 */
	public int hash1(Object key) {
		return key.hashCode() % START_CAPACITY;
	}
	
	/**
	 * That method finds the key. Firstly generate hash1 value with my hash1() function.
	 * Then generate hash2 value with my hash2() function. than as you said I calculate subsequent probe locations 
	 * with (hash(x) + i*second_hash(x)). that is my index now.
	 * if index is smaller than 0, I added with table's length.
	 * Otherwise I started to search table's index, if it is not null and its key value is not equals to given parameter key,
	 * I continue to search. Every loop turned, I increase the i value and calculate again the index. then control the index value.
	 * If index value is bigger and equal than table's length,I assign o to index.
	 * If index value is smaller than 0, I added index value with table's length.
	 * @param key  key which will be searched
	 * @return the index of given key.
	 */
	public int find(Object key) {
		int hash1 = hash1(key);
		int hash2 = hash2(key);
		int i = 1;
		int index = ( hash1 + i * hash2 ) % table.length;
		if(index < 0)
			index += table.length;
		
		while((table[index] != null) && (!key.equals(table[index].key))) {
			i++;
			index = ( hash1 + i * hash2 ) % table.length;
			if(index >= table.length)
				index = 0;
			if(index < 0)
				index += table.length;

		}
		return index;  	
	}
	
	/**
	 * That method prints the table
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
	 * That method returns the given key's value.
	 */
	@Override
	public V get(Object key) {
		try {
			int index = find(key);
			if(table[index] != null)
				return table[index].value;
			else 
				return null;
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}

	/**
	 * That methods controls the table which is  empty or not.
	 */
	@Override
	public boolean isEmpty() {
		if(numKeys == 0)
			return true;
		return false;
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
		numKeys = 0 ;
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
	 * That methos returns the size of table.
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
