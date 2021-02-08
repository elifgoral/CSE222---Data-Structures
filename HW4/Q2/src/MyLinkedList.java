import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<E> {
	
	public DequeNode<E> front;
	public DequeNode<E> rear;
	public int DequeSize;

	public MyLinkedList() {
		front = null;
		rear = null;
		DequeSize = 0;
	}

	/**
	 * That method creates a new node and add to the list's first node.
	 * @param dataItem our newNode's data.
	 */
	public void addFirst(E dataItem) {
		if(front == null) {
			rear = new DequeNode<E>(dataItem);
			front = rear;
		}
		else {
			DequeNode<E> newNode = new DequeNode<E>(dataItem);
			front.prev = newNode;
			newNode.next = front;
			front = newNode;			
		}
		DequeSize++;
	}
	
	/**
	 * That method adds the node which is given by parameter to the list's first node.
	 * @param node node we add to list.
	 */
	public void addFirst(DequeNode<E> node) {
		if(front == null) {
			rear = node;
			front = rear;		
		}
		else {
			front.prev = node;
			node.next = front;
			front = node;			
		}
		DequeSize++;
	}
	
	/**
	 * 	That method adds the node which is given by parameter to the list's last node.	 
	 *  @param node node we add to list.
	 */
	public void addLast(DequeNode<E> node) {
		if(front == null) {
			front = node;
			rear = front;		
		}
		else {
			DequeNode<E> temp = node;
			temp.prev = rear;
			rear.next = temp;
			rear = temp;
			rear.next = null;
		}
		DequeSize++;
	}
	
	/**
	 * That method creates a new node and add to the list's last node.
	 * @param dataItem added element's data.
	 */
	public void addLast(E dataItem) {
		if(front == null) {
			front = new DequeNode<E>(dataItem);
			rear = front;		
		}
		else {
			DequeNode<E> temp = new DequeNode<E>(dataItem);
			temp.prev = rear;
			rear.next = temp;
			rear = temp;
		}
		DequeSize++;		
	}
	
	/**
	 * That method return the first element.
	 * @return 	return the first element.
	 */
	public E getFirst() {
		if(DequeSize == 0)
			throw new NoSuchElementException("Dequeue is empty");
		return front.getData();
	}
	
	/**
	 * That method returns the last element.
	 * @return returns the last element
	 */
	public E getLast() {
		if(DequeSize == 0)
			throw new NoSuchElementException("Dequeue is empty");
		return rear.getData();
	}
	
	/**
	 * That method returns the deque's size.
	 * @return returns deque's size
	 */
	public int getDequeSize() {
		return DequeSize;
	}
	
	/**
	 * That method creates and returns the node.
	 * @param dataItem node's data.
	 * @return node.
	 */
	public DequeNode<E> node(E dataItem){
		DequeNode<E> node = new DequeNode<E>(dataItem);
		return node;
	}	
	
	/**
	 * That method returns the node.
	 * @param node node
	 * @return returns the node.
	 */
	public DequeNode<E> node(DequeNode<E> node){
		return node;
	}
	
	protected static class DequeNode<E> {
		protected E data;
		protected DequeNode<E> next = null;
		protected DequeNode<E> prev = null;
			
		protected DequeNode(E dataItem) {
			prev = null;
			next = null;
			data = dataItem;
		}
	
		protected E getData() {
			return data;
		}
		
		protected void setData(E dataItem) {
			data = dataItem;
		}				
	}
	
	/**
	 * @return iterator
	 */
	public DequeIter iterator() {
		DequeIter iter = new DequeIter(0);
		return iter;
	}
	
	/** 
	 * @param index iterator's current index
	 * @return iterator which starts given index.
	 */
	public DequeIter iterator(int index){
		DequeIter iter = new DequeIter(index);
		return iter;
	}
		
	public class DequeIter implements Iterator<E>{
		
		private DequeNode<E> nextItem;
		private DequeNode<E> lastItemReturned;
		private int currentIndex;
		
		public DequeIter() {
			lastItemReturned = null;
			nextItem = front; 	
		}
		
		public DequeIter(int i) {
			if(i > DequeSize || i < 0 ) {
				throw new IndexOutOfBoundsException("Invalid index "+ i);
			}
			lastItemReturned = null;
			currentIndex = i;
			nextItem = front; 
			for(int j = 0 ; j < currentIndex ; j++)
				nextItem = nextItem.next;	
		}
		
		public E getData() {
			return nextItem.getData();
		}
		
		@Override
		public boolean hasNext() {
			if(nextItem == null)
				return false;
			return true;
		}

		@Override
		public E next() {
			if(!hasNext()) {
				throw new NoSuchElementException("Dequeue has no next element");
			}
			lastItemReturned = nextItem;
			nextItem = nextItem.next;
			currentIndex++;
			return lastItemReturned.getData();
		}
		
		public boolean hasPrevious() {
			if(DequeSize > 0 && nextItem.prev != null) 
				return true;
			return false;			
		}
		
		public E previous() {
			if(!hasPrevious())
				throw new NoSuchElementException("Dequeue has no previous element");
		
			nextItem = nextItem.prev;
			lastItemReturned = nextItem;
			currentIndex--;
			return lastItemReturned.getData();			
		}
		
		public int getCurrentIndex() {
			return currentIndex;
		}
		
		public void setCurrentIndex(int a) {
			currentIndex = a;
		}
		
		public int getNextIndex() {
			return currentIndex+1;
		}
		
		public int getPreviousIndex() {
			return currentIndex-1;
		}
		
		/**
		 * That method add the element to the list.
		 * @param dataItem added element's data.
		 */
		public void add(E dataItem){
			DequeNode<E> newNode = new DequeNode<E>(dataItem);
			newNode.prev = nextItem;
			newNode.next = nextItem.next;
			nextItem.next = newNode;
			DequeSize++;
			currentIndex++;
		}
		
		/**
		 *That methods removes the element of list.
		 */
		public void remove() {
			try {
				if(getNextIndex() == 0)
					throw new Exception("deque is empty");
				nextItem.next = nextItem.next.next;
				//DequeSize--;
				currentIndex--; 
			}
			catch(Exception e) {
				System.out.println(e);	
			}			
		}		
	}
	

		
	
	
}
