
public class HashTableChainBinaryTree<K extends Comparable<K>, V extends Comparable<V>> implements KWHashMap<K,V> {

	private BinarySearchTree<Entry<K,V>>[] table;
	private int numKeys;
	private static final int CAPACITY = 101;
	private static final double LOAD_THRESHOLD = 3.0;
	
	public HashTableChainBinaryTree() {
		table = new BinarySearchTree[CAPACITY];		
	}

	/**
	 * That method search the value of given key. Firstly calculate index with hashCode.
	 * Then control the index if it is smaller than 0, add with table's length.
	 * Then control the table's index element is null or not. 
	 * Then control the key for finding existing knowledge with my binary search tree's contains method
	 * If table's index element has key, I returned that key's value.
	 * Otherwise return Exception which express the key is not here.
	 */
	@Override
	public V get(Object key){
		try {
			int index = key.hashCode() % table.length;
			if(index < 0)
				index += table.length;
			if(table[index] == null)
				return null;
			
			if(!(table[index].contains(new Entry <K, V>((K) key,null)))) {
				throw new Exception("there is no that key.");
			}			
			return (V) table[index].find(new Entry <K, V>((K) key,null)).getValue();		
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
		
	/**
	 *That method checks the table is empty or not.
	 */
	@Override
	public boolean isEmpty() {
		if(table.length == 0 )
			return true;
		return false;
	}

	/**
		 * That method puts the element to the binary search tree which is on table's index value.
		 * Firstly calculate index with hashCode and control the index is smaller than 0 or not.
		 * If index is smaller than 0, add with table's length.
		 * If the table's index's value is null which means there is no element in that index,
		 * I create a binary search tree. Otherwise I call the add method of binary search tree
		 * and try to add given key and given value. If add method returns false, that means that key already 
		 * exist in binary search tree. Than I find the value and delete the key from the tree and add my new value
		 * and return deletedValue. Then I increase the numKeys.
		 * If numKeys bigger than (LOAD_THRESHOLD * table.length), I rehash the table and return null.
	 */
	@Override
	public V put(K key, V value) {
		try {
			int index = key.hashCode() % table.length;
			if(index < 0)
				index += table.length;
			
			if(table[index] == null) {
				table[index] = new BinarySearchTree<Entry<K,V>>();
			}
			
			boolean result = table[index].add(new Entry <K, V>(key,value));		
			if(result == false) {
				V deletedValue = table[index].find(new Entry <K, V>(key,null)).getValue();
				table[index].delete(new Entry <K, V>(key,null));
				table[index].add(new Entry <K, V>(key,value));	
				return deletedValue;
			}
			
			numKeys++;
			if(numKeys > (LOAD_THRESHOLD * table.length) )
				rehash();
			
			return null;	
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	/**
	 * That method rehash the table.
	 */
	private void rehash() {
		BinarySearchTree<Entry<K,V>> oldTable [] =  table;
		table = new BinarySearchTree[2 * oldTable.length + 1];		
		numKeys = 0;
		
		for(int i = 0 ; i < oldTable.length; i++) {
			if(oldTable[i] != null) {
				table[i].setRoot(oldTable[i].root);				
			}
		}			
	}
	
	/**
	 * That method prints the table.
	 * (called method printTree from BinarySearchTree)
	 */
	public void print() {
		for(int i = 0 ; i <  table.length ; i++) {
			if(table[i] != null && table[i].root != null) {				
				System.out.println("index " + i);
				table[i].printTree();
				System.out.println();			
			}			
		}
	}

	/**
	 * That method remove given key from table.
	 * Firstly calculate index with hashCode and control the index is smaller than 0 or not.
	 * If index is smaller than 0, add with table's length.
	 * If the table's index's value is null which means there is no element in that index, return null.
	 * Then I call the find method, if key will be found, I save the deleted value and deleted key and
	 * delete them from the tree decrease the numKeys and return deleted value.
	 * If method can not find the key, throws an exception and says there is no exist that key.
	 */
	@Override
	public V remove(Object key) {
		try {
			int index = key.hashCode() % table.length;
			if(index < 0)
				index += table.length;

			if(table[index].equals(null)) {
				return null;
			}
			
			V deletedValue = table[index].find(new Entry <K, V>((K)key,null)).getValue();
			K deletedKey = table[index].find(new Entry <K, V>((K)key,null)).getKey();

			table[index].delete(new Entry<K,V>(deletedKey,deletedValue));
			numKeys--;
			return deletedValue;			
		}
		catch(Exception e) {
			System.out.println("There is no exist that key");		
		}
		return null;

	}

	/**
	 * That method returns the size of table
	 */
	@Override
	public int size() {
		return numKeys;	
	}

	private static class Entry<K extends Comparable<K>, V extends Comparable<V>> implements Comparable<Entry<K,V>>{
		/** The key */
		private final K key;
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
		
		public String toString() {
			return "key:" + key.toString() + " value:" + value.toString();
		}
		
		/**
		 * I compare the keys. Because I am searching the keys, not the values. 
		 * keys provide the enter the binary search tree
		 */
		@Override
		public int compareTo(Entry<K, V> o) {
			int cmp = this.getKey().compareTo(o.getKey());
			return cmp;		
		}	
	}	
}