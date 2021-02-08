
public class Main {
	
	public static void testHashOpenBook(int size) {
		HashTableOpen<Integer,Integer> hashOpen = new  HashTableOpen<Integer,Integer>();
		
		long beginTime = 0, endTime = 0;
		long beginTimeNano = 0, endTimeNano = 0;

		beginTime = System.currentTimeMillis();
		beginTimeNano = System.nanoTime(); 
		int array[] = new int [size * 2];
		System.out.println("put method starting...");
		for(int i = 0 ; i < size ; i++) {
		   int putKey = (int)(32000 *Math.random());
		    int putVal =  (int)(32000 *Math.random());
		    array[i] = putKey;
		    hashOpen.put(putKey,putVal);
		}
		endTime = System.currentTimeMillis();
		endTimeNano = System.nanoTime(); 
		System.out.println("put method ending...");

		System.out.println("printing the hash table");
		hashOpen.print();
		System.out.println();

		System.out.println("put method:");
		System.out.println("Time taken: " + (endTime - beginTime) +" miliseconds");
		System.out.println("Time taken: " + (endTimeNano - beginTimeNano) +" nanosecond");

		
		int j = size;
		for(int i = 0; i < size ; i++) {
			 int removeKey = (int)(32000 *Math.random());
			 array[j] = removeKey;
			 j++;
		}
		System.out.println("hash table's length: "+ hashOpen.size());

		int numberOfRemoved = 0;
		int numberOfNotRemoved = 0;
		long totalGet = 0;
		long totalRemove = 0;
		long totalGetNano = 0;
		long totalRemoveNano = 0;
		
		System.out.println("removing that elements...");
		for(int i = 0 ; i < array.length ; i++) {
			beginTime = System.currentTimeMillis();
			beginTimeNano = System.nanoTime(); 
		    if(hashOpen.get(array[i]) == null) {
		    	numberOfNotRemoved++;
		    }    
			endTime = System.currentTimeMillis();
			endTimeNano = System.nanoTime(); 
			totalGet += endTime - beginTime;
			totalGetNano += endTimeNano - beginTimeNano;

			if(hashOpen.get(array[i]) != null) {
				beginTime = System.currentTimeMillis();
				beginTimeNano = System.nanoTime(); 
			    System.out.println("key: " + array[i] + "\tvalue: " + hashOpen.remove(array[i]));	
				endTime = System.currentTimeMillis();
				endTimeNano = System.nanoTime(); 
				totalRemove += endTime - beginTime;
				totalRemoveNano += endTimeNano - beginTimeNano;
		    	numberOfRemoved++;
		    }
		}
		
		System.out.println("printing the hash table");
		hashOpen.print();
		System.out.println();

		System.out.println("remove method:");
		System.out.println("Time taken of get: "+ totalGet +" miliseconds");
		System.out.println("Time taken of get: "+ totalGetNano +" nanoseconds");
		System.out.println("Time taken of remove: "+ totalRemove +" miliseconds");
		System.out.println("Time taken of remove: "+ totalRemoveNano +" nanoseconds");
		
		System.out.println("removed data number: " + numberOfRemoved);
		System.out.println("not removed data number: " + numberOfNotRemoved);
		System.out.println("hash table's length: "+ hashOpen.size());

		
	}
	
	public static void testHashChainLinkedList(int size) {
		HashTableChain<Integer,Integer> hashChain = new  HashTableChain<Integer,Integer>();
		
		long beginTime = 0, endTime = 0;
		long beginTimeNano = 0, endTimeNano = 0;

		beginTime = System.currentTimeMillis();
		beginTimeNano = System.nanoTime(); 
		int array[] = new int [size * 2];
		System.out.println("put method starting...");
		for(int i = 0 ; i < size ; i++) {
		   int putKey = (int)(32000 *Math.random());
		    int putVal =  (int)(32000 *Math.random());
		    array[i] = putKey;
		    hashChain.put(putKey,putVal);
		}
		endTime = System.currentTimeMillis();
		endTimeNano = System.nanoTime(); 
		System.out.println("put method ending...");

		System.out.println("printing the hash table");
		hashChain.print();
		System.out.println();

		System.out.println("put method:");
		System.out.println("Time taken: " + (endTime - beginTime) +" miliseconds");
		System.out.println("Time taken: " + (endTimeNano - beginTimeNano) +" nanosecond");

		
		int j = size;
		for(int i = 0; i < size ; i++) {
			 int removeKey = (int)(32000 *Math.random());
			 array[j] = removeKey;
			 j++;
		}
		System.out.println("hash table's length: "+hashChain.size());

		int numberOfRemoved = 0;
		int numberOfNotRemoved = 0;
		long totalGet = 0;
		long totalRemove = 0;
		long totalGetNano = 0;
		long totalRemoveNano = 0;
		
		System.out.println("removing that elements...");
		for(int i = 0 ; i < array.length ; i++) {
			beginTime = System.currentTimeMillis();
			beginTimeNano = System.nanoTime(); 
		    if(hashChain.get(array[i]) == null) {
		    	numberOfNotRemoved++;
		    }    
			endTime = System.currentTimeMillis();
			endTimeNano = System.nanoTime(); 
			totalGet += endTime - beginTime;
			totalGetNano += endTimeNano - beginTimeNano;

			if(hashChain.get(array[i]) != null) {
				beginTime = System.currentTimeMillis();
				beginTimeNano = System.nanoTime(); 
			    System.out.println("key: " + array[i] + "\tvalue: " + hashChain.remove(array[i]));	
				endTime = System.currentTimeMillis();
				endTimeNano = System.nanoTime(); 
				totalRemove += endTime - beginTime;
				totalRemoveNano += endTimeNano - beginTimeNano;
		    	numberOfRemoved++;
		    }
		}
		
		System.out.println("printing the hash table");
		hashChain.print();
		System.out.println();
		System.out.println("remove method:");
		System.out.println("Time taken of get: "+ totalGet +" miliseconds");
		System.out.println("Time taken of get: "+ totalGetNano +" nanoseconds");
		System.out.println("Time taken of remove: "+ totalRemove +" miliseconds");
		System.out.println("Time taken of remove: "+ totalRemoveNano +" nanoseconds");
		
		System.out.println("removed data number: " + numberOfRemoved);
		System.out.println("not removed data number: " + numberOfNotRemoved);
		System.out.println("hash table's length: "+ hashChain.size());
		
	}
	
	public static void testHashChainBinarySearchTree(int size) {
		HashTableChainBinaryTree<Integer,Integer> hashChainBST = new  HashTableChainBinaryTree<Integer,Integer>();
		
		
		long beginTime = 0, endTime = 0;
		long beginTimeNano = 0, endTimeNano = 0;

		beginTime = System.currentTimeMillis();
		beginTimeNano = System.nanoTime(); 
		int array[] = new int [size * 2];
		System.out.println("put method starting...");
		for(int i = 0 ; i < size ; i++) {
		   int putKey = (int)(32000 *Math.random());
		    int putVal =  (int)(32000 *Math.random());
		    array[i] = putKey;
		    hashChainBST.put(putKey,putVal);
		}
		endTime = System.currentTimeMillis();
		endTimeNano = System.nanoTime(); 
		System.out.println("put method ending...");

		System.out.println("printing the hash table");
		hashChainBST.print();
		System.out.println();
		System.out.println("put method:");
		System.out.println("Time taken: " + (endTime - beginTime) +" miliseconds");
		System.out.println("Time taken: " + (endTimeNano - beginTimeNano) +" nanosecond");

		
		int j = size;
		for(int i = 0; i < size ; i++) {
			 int removeKey = (int)(32000 *Math.random());
			 array[j] = removeKey;
			 j++;
		}
		System.out.println("hash table's length: "+hashChainBST.size());

		int numberOfRemoved = 0;
		int numberOfNotRemoved = 0;
		long totalGet = 0;
		long totalRemove = 0;
		long totalGetNano = 0;
		long totalRemoveNano = 0;
		
		System.out.println("removing that elements...");
		for(int i = 0 ; i < array.length ; i++) {
			beginTime = System.currentTimeMillis();
			beginTimeNano = System.nanoTime(); 
		    if(hashChainBST.get(array[i]) == null) {
		    	numberOfNotRemoved++;
		    }    
			endTime = System.currentTimeMillis();
			endTimeNano = System.nanoTime(); 
			totalGet += endTime - beginTime;
			totalGetNano += endTimeNano - beginTimeNano;

			if(hashChainBST.get(array[i]) != null) {
				beginTime = System.currentTimeMillis();
				beginTimeNano = System.nanoTime(); 
			    System.out.println("key: " + array[i] + "\tvalue: " + hashChainBST.remove(array[i]));	
				endTime = System.currentTimeMillis();
				endTimeNano = System.nanoTime(); 
				totalRemove += endTime - beginTime;
				totalRemoveNano += endTimeNano - beginTimeNano;
		    	numberOfRemoved++;
		    }
		}
		
		System.out.println("printing the hash table");
		hashChainBST.print();
		System.out.println();
		System.out.println("remove method:");
		System.out.println("Time taken of get: "+ totalGet +" miliseconds");
		System.out.println("Time taken of get: "+ totalGetNano +" nanoseconds");
		System.out.println("Time taken of remove: "+ totalRemove +" miliseconds");
		System.out.println("Time taken of remove: "+ totalRemoveNano +" nanoseconds");
		
		System.out.println("removed data number: " + numberOfRemoved);
		System.out.println("not removed data number: " + numberOfNotRemoved);
		System.out.println("hash table's length: "+ hashChainBST.size());
		
	}
	
	public static void testHashTableOpenNew(int size) {
		HashTableOpenNew<Integer,Integer> hashOpenNew = new  HashTableOpenNew<Integer,Integer>();
		
		
		long beginTime = 0, endTime = 0;
		long beginTimeNano = 0, endTimeNano = 0;

		beginTime = System.currentTimeMillis();
		beginTimeNano = System.nanoTime(); 
		int array[] = new int [size * 2];
		System.out.println("put method starting...");
		for(int i = 0 ; i < size ; i++) {
		   int putKey = (int)(32000 *Math.random());
		    int putVal =  (int)(32000 *Math.random());
		    array[i] = putKey;
		    hashOpenNew.put(putKey,putVal);
		}
		endTime = System.currentTimeMillis();
		endTimeNano = System.nanoTime(); 
		System.out.println("put method ending...");

		System.out.println("printing the hash table");
		hashOpenNew.print();
		System.out.println();
		System.out.println("put method:");
		System.out.println("Time taken: " + (endTime - beginTime) +" miliseconds");
		System.out.println("Time taken: " + (endTimeNano - beginTimeNano) +" nanosecond");

		
		int j = size;
		for(int i = 0; i < size ; i++) {
			 int removeKey = (int)(32000 *Math.random());
			 array[j] = removeKey;
			 j++;
		}
		System.out.println("hash table's length: "+ hashOpenNew.size());

		int numberOfRemoved = 0;
		int numberOfNotRemoved = 0;
		long totalGet = 0;
		long totalRemove = 0;
		long totalGetNano = 0;
		long totalRemoveNano = 0;
		
		System.out.println("removing that elements...");
		for(int i = 0 ; i < array.length ; i++) {
			beginTime = System.currentTimeMillis();
			beginTimeNano = System.nanoTime(); 
		    if(hashOpenNew.get(array[i]) == null) {
		    	numberOfNotRemoved++;
		    }    
			endTime = System.currentTimeMillis();
			endTimeNano = System.nanoTime(); 
			totalGet += endTime - beginTime;
			totalGetNano += endTimeNano - beginTimeNano;

			if(hashOpenNew.get(array[i]) != null) {
				beginTime = System.currentTimeMillis();
				beginTimeNano = System.nanoTime(); 
			    System.out.println("key: " + array[i] + "\tvalue: " + hashOpenNew.remove(array[i]));	
				endTime = System.currentTimeMillis();
				endTimeNano = System.nanoTime(); 
				totalRemove += endTime - beginTime;
				totalRemoveNano += endTimeNano - beginTimeNano;
		    	numberOfRemoved++;
		    }
		}
		
		System.out.println("printing the hash table");
		hashOpenNew.print();
		System.out.println();
		System.out.println("remove method:");
		System.out.println("Time taken of get: "+ totalGet +" miliseconds");
		System.out.println("Time taken of get: "+ totalGetNano +" nanoseconds");
		System.out.println("Time taken of remove: "+ totalRemove +" miliseconds");
		System.out.println("Time taken of remove: "+ totalRemoveNano +" nanoseconds");
		
		System.out.println("removed data number: " + numberOfRemoved);
		System.out.println("not removed data number: " + numberOfNotRemoved);
		System.out.println("hash table's length: "+ hashOpenNew.size());
	}
	
	public static void main(String[] args) {
		
		int size = 10;
		//testHashOpenBook(size);
		//testHashTableOpenNew(size);
		//testHashChainLinkedList(size);
		//testHashChainBinarySearchTree(size);
		
		
		
	}

}
