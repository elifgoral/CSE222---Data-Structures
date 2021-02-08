import java.util.AbstractCollection;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author  Elif Goral
 * 			171044003
 */
public class MyDeque<E> extends AbstractCollection<E> implements Deque<E> {
	MyLinkedList<E> deque;
	MyLinkedList<E> removedList;
	
	public MyDeque() {
		deque = new MyLinkedList<E>();
		removedList = new MyLinkedList<E>();
	}
	

	/**
	 * That method prints the linked list which is given as a parameter.
	 * @param list which linked list we want to print.
	 */
	public void print(MyLinkedList<E> list) {
		Iterator<E> iter = iterator(list);
		if(list == deque)
			System.out.println("dequesize: "+ deque.DequeSize);
		if(!iter.hasNext()) {
			System.out.println("list is empty");
			return;
		}
		while(iter.hasNext()) {
			System.out.printf(iter.next()+" ");
		}
		System.out.println();
	}	

	/**
	 * That method decides which linked list will print and call print(list) method. 
	 * @param c which linked list we want to print
	 */
	public void print(char c) {
		if(c == 'd') {
			System.out.println("printing deque...");
			print(deque);
		}
		else if(c == 'r') {
			System.out.println("printing removed list...");
			print(removedList);
		}
		else
			System.out.println("please enter d or r.");
	}
	
	/**
	 * That method add the data which is given as a parameter to the given linkedlist's first element.
	 * @param list which linked list we want to add.
	 * @param dataItem data  which we will add to first.
	 */
	public void addFirst(MyLinkedList<E> list,E dataItem) {
		try {
			if(list == deque) {
				if(removedList.DequeSize == 0)
					deque.addFirst(dataItem);		
				else {
					MyLinkedList<E> temp = new MyLinkedList<E>();
					temp.addFirst(removedList.front);
					temp.front.setData(dataItem);
					removedList.front = removedList.front.next;
					removedList.DequeSize--;
					deque.addFirst(temp.front);
				}
			}
			else if(list == removedList)
				removedList.addFirst(dataItem);
		}
		catch(Exception e) {
			System.out.println(e);
		}	
	}
	
	/**
	 *That method add the data which is given as a parameter to the deque's first position.
	 */
	@Override
	public void addFirst(E dataItem) {
		try {
			addFirst(deque,dataItem);
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * That method add the data which is given as a parameter to the given linkedlist's last element.
	 * @param list list which linked list we want to add.
	 * @param dataItem data  which we will add to last.
	 */
	public void addLast(MyLinkedList<E> list,E dataItem) {
		if(list == deque) {
			if(removedList.DequeSize == 0)
				deque.addLast(dataItem);		
			else {
				MyLinkedList<E> temp = new MyLinkedList<E>();
				temp.addFirst(removedList.front);
				temp.front.setData(dataItem);
				removedList.front = removedList.front.next;
				removedList.DequeSize--;
				deque.addLast(temp.front);		
			}
		}
		else if(list == removedList)
			removedList.addLast(dataItem);
	}
	
	/**
	 * That method add the data which is given as a parameter to the deque's last position.
	 */
	@Override
	public void addLast(E dataItem) {
		try {
			addLast(deque,dataItem);
		}
		catch(Exception e) {
			System.out.println(e);
		}	
	}

	/**
	 * That method add the data which is given as a parameter to the given linkedlist's first element.Difference between the addFirst and offerFirst is,addFirst throw an exception.
	 * @param list list which linked list we want to add.
	 * @param dataItem data which we will add to first.
	 * @return return true if offering process is executed,otherwise false;
	 */
	public boolean offerFirst(MyLinkedList<E> list,E dataItem) {
		if(list == deque) {
			if(removedList.DequeSize == 0)
				deque.addFirst(dataItem);		
			else {
				removedList.front.setData(dataItem);
				deque.addFirst(removedList.front);
				removedList.front = removedList.front.next;
				removedList.DequeSize--;
			}
		}
		else if(list == removedList)
			removedList.addFirst(dataItem);
		return true;
	}
	
	/**
	 * That method add the data which is given as a parameter to the deque's first element.Difference between the addFirst and offerFirst is,addFirst throw an exception.
	 */
	@Override
	public boolean offerFirst(E dataItem) {
		return offerFirst(deque,dataItem);
	}

	/**
	 * That method add the data which is given as a parameter to the given linkedlist's last element. Difference between the addFirst and offerFirst is,addFirst throw an exception.
	 * @param list  list which linked list we want to add.
	 * @param dataItem data which we will add to first.
	 * @return  return true if offering process is executed,otherwise false;
	 */
	public boolean offerLast(MyLinkedList<E> list,E dataItem) {
		if(list == deque) {
			if(removedList.DequeSize == 0)
				deque.addLast(dataItem);		
			else {
				removedList.front.setData(dataItem);
				deque.addLast(removedList.front);
				removedList.front = removedList.front.next;
				removedList.DequeSize--;
			}
		}
		else if(list == removedList)
			removedList.addLast(dataItem);
		return true;
	}
	
	/**
	 * That method add the data which is given as a parameter to the deque's last element. Difference between the addFirst and offerFirst is,addFirst throw an exception.
	 */
	@Override
	public boolean offerLast(E dataItem) {
		return offerLast(deque,dataItem);
	}
	
	/**
	 * That method removes the first element of linked list which is given as a parameter.
	 * @param list list which linked list we want to remove.
	 * @return removed node's data.
	 */
	public E removeFirst(MyLinkedList<E> list) {
		E dataItem = list.getFirst();
		if(list == deque) {
			if(dataItem == null)
				throw new NoSuchElementException("list is empty");
			
			removedList.addFirst(removedList.node(dataItem));
			list.front = list.front.next;
			list.DequeSize--;
		}
		else if(list == removedList) {
			list.front = list.front.next;
			list.DequeSize--;
		}
		return dataItem;
	}
	
	/**
	 * That method removes the first element of deque.
	 */
	@Override
	public E removeFirst() {
		try {
			return removeFirst(deque);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}

	/**
	 * That method removes the last element of linked list which is given as a parameter.
	 * @param list  list which linked list we want to remove.
	 * @return removed node's data.
	 */
	public E removeLast(MyLinkedList<E> list) {
		E dataItem = list.getLast();
		Iterator<E> iter = iterator(list,list.DequeSize-2);
		if(list == deque) {
			if(dataItem == null)
				throw new NoSuchElementException("deque is empty");
			
			removedList.addFirst(removedList.node(dataItem));
			iter.remove();
			E data = iter.next();
			deque.rear.setData(data);
			list.DequeSize--;
			return dataItem;
		}
		else if(list == removedList) {
			iter.remove();
			list.DequeSize--;
			return dataItem;
		}
		return dataItem;
	}
	
	/**
	 * That method removes the last element of deque.
	 */
	@Override
	public E removeLast() {
		try {
			return removeLast(deque);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}

	/**
	 * That method removes the first element of linked list which is given as a parameter.
	 * @param list list which linked list we want to remove.
	 * @return removed node's data.
	 */
	public E pollFirst(MyLinkedList<E> list) {
		E dataItem = list.getFirst();
		if(list == deque) {
			if(dataItem == null)
				throw new NoSuchElementException("list is empty");
			
			removedList.addFirst(removedList.node(dataItem));
			list.front = list.front.next;
			list.DequeSize--;
		}
		else if(list == removedList) {
			list.front = list.front.next;
			list.DequeSize--;
		}
		return dataItem;
	}
	
	/**
	 * That method removes the first element of deque.
	 */
	@Override
	public E pollFirst() {
		return pollFirst(deque);
	}

	/**
	 * That method removes the first element of linked list which is given as a parameter.
	 * @param list list which linked list we want to remove.
	 * @return removed node's data.
	 */
	public E pollLast(MyLinkedList<E> list) {
		E dataItem = list.getLast();
		Iterator<E> iter = iterator(list,list.DequeSize);
		if(list == deque) {
			if(dataItem == null)
				throw new NoSuchElementException("deque is empty");
			
			removedList.addFirst(removedList.node(dataItem));
			iter.remove();
			E data = iter.next();
			deque.rear.setData(data);
			list.DequeSize--;
			return dataItem;
		}
		else if(list == removedList) {
			iter.remove();
			list.DequeSize--;
			return dataItem;
		}
		return dataItem;
	}
	
	/**
	 * That method removes the last element of deque.
	 */
	@Override
	public E pollLast() {
		return removeLast(deque);
	}
	
	/**
	 * That method returns the first element of linked list which is given by parameter.
	 * @param list list which linked list we are checking
	 * @return list's first element
	 */
	public E getFirst(MyLinkedList<E> list) {
		try {
			if(list == deque)
				return deque.getFirst();
			else if(list == removedList)
				return removedList.getFirst();	
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	/**
	 * That method returns the first element of deque
	 */
	@Override
	public E getFirst() {
		return getFirst(deque);
	}

	/**
	 * That method returns the last element of linked list which is given by parameter.
	 * @param list list which linked list we are checking
	 * @return list's last element
	 */
	public E getLast(MyLinkedList<E> list) {
		try {
			if(list == deque) 
				return deque.getLast();
			else if(list == removedList)
				return removedList.getLast();
		}
		catch(NoSuchElementException e) {
			System.out.println(e);
		}
		return null;
	}
	
	/**
	 * That method returns the last element of deque
	 */
	@Override
	public E getLast() {
		return getLast(deque);
	}
	
	/**
	 * That method returns the first element of linked list which is given by parameter.
	 * @param list list which linked list we are checking
	 * @return list's first element
	 */
	public E peekFirst(MyLinkedList<E> list) {
		if(list == deque)
			return deque.getFirst();
		else if(list == removedList)
			return removedList.getFirst();
		return null;
	}
	
	/**
	 *That method returns the first element of deque
	 */
	@Override
	public E peekFirst() {
		return peekFirst(deque);
	}

	/**
	 * That method returns the last element of linked list which is given by parameter.
	 * @param list list which linked list we are checking
	 * @return list's last element
	 */
	public E peekLast(MyLinkedList<E> list) {
		if(list == deque)
			return deque.getLast();
		else if(list == removedList)
			return removedList.getLast();
		return null;
	}
	
	/**
	 * That method returns the last element of deque.
	 */
	@Override
	public E peekLast() {
		return peekLast(deque);
	}

	/**
	 * That method remove the given index's node.
	 * @param list list which linked list we are checking
	 * @param index list's current index.
	 */
	public void removeOccurence(MyLinkedList<E> list,int index) {
		Iterator<E> iter = iterator(list,index-1);
		Iterator<E> iter2 = iterator(list,index);
		iter.remove();	
		E data = iter.next();
		removedList.addFirst(data);
		removedList.front.setData(iter2.next());
		if(!iter.hasNext())
			deque.rear.setData(data);
		
		list.DequeSize--;
	}
	
	/**
	 * That method finds the index of object's last occurrence index.
	 * @param list list which linked list we are checking
	 * @param o object which we are looking for
	 * @param index iterator's index.
	 * @return return last occurrence index of object.
	 */
	public int findLastIndex(MyLinkedList<E> list,Object o,int index) {
		Iterator<E> iter = iterator(list);
		int counter = 0;
		while(iter.hasNext()) {
			if(iter.next().equals(o)) {
				index = counter;
			}
			counter++;
		}	
		return index;
	}
	
	/**
	 * That method finds the index of object's first occurrence index.
	 * @param list  list which linked list we are checking
	 * @param o object which we are looking for
	 * @return return first occurrence index of object.
	 */
	public int findFirstIndex(MyLinkedList<E> list,Object o) {
		Iterator<E> iter = iterator(list);
		int counter = 0;
		while(iter.hasNext()) {
			if(iter.next().equals(o)) {
				return counter;
			}
			counter++;
		}	
		return counter;
	}
		
	/**
	 * That method removes the first occurrence of object
	 */
	@Override
	public boolean removeFirstOccurrence(Object o) {
		int index = findFirstIndex(deque,o);
		removeOccurence(deque,index);
		return true;
	}

	/**
	 * That method removes the last occurrence of object
	 */
	@Override
	public boolean removeLastOccurrence(Object o) {
		int index = findLastIndex(deque,o,0);
		removeOccurence(deque,index);
		return false;
	}
	
	/**
	 * That method add the data to the last node of linked list which is given as a parameter.
	 * @param list list which linked list we are checking
	 * @param dataItem data which we will be add
	 * @return returns true if offering process is successful,otherwise false.
	 */
	public boolean offer(MyLinkedList<E> list,E dataItem) {
		return offerLast(list,dataItem);
	}
	
	/**
	 * That method add the data to the last node of deque.
	 */
	@Override
	public boolean offer(E dataItem) {
		return offer(deque,dataItem);
	}
	
	/**
	 * That method removes the first element of given list.
	 * @param list list which linked list we are checking
	 * @return returns the removed node's data;
	 */
	public E remove(MyLinkedList<E> list) {
		return removeFirst(list);
	}
	
	/**
	 * That method removes the first element of deque.
	 */
	@Override
	public E remove() {
		return remove(deque);
	}

	/**
	 * That method  removes the first element of given list.
	 * @param list list which linked list we are checking
	 * @return returns the removed element's data.
	 */
	public E poll(MyLinkedList<E> list) {
		return pollFirst(list);
	}
	
	/**
	 * That method  removes the first element of deque
	 */
	@Override
	public E poll() {
		return poll(deque);
	}

	/**
	 * That method returns the first element of given list.
	 * @param list list which linked list we are checking
	 * @return returns the first element of list.
	 */
	public E element(MyLinkedList<E> list) {
		return getFirst(list);
	}
	
	/**
	 * That method returns the first element of deque.
	 */
	@Override
	public E element() {
		return element(deque);
	}

	/**
	 * That method returns the first element of given list.
	 * @param list list which linked list we are checking
	 * @return returns the first element of list.
	 */
	public E peek(MyLinkedList<E> list) {
		return peekFirst(list);
	}
	
	/**
	 * That method returns the first element of deque
	 */
	@Override
	public E peek() {
		return peek(deque);
	}

	/**
	 * That method add the data to the given list's first node.
	 * @param list list which linked list we are checking
	 * @param dataItem pushed element's data.
	 */
	public void push(MyLinkedList<E> list,E dataItem) {
		addFirst(list,dataItem);
	}

	/**
	 * That method add the data to the deque's first node.
	 */
	@Override
	public void push(E dataItem) {
		push(deque,dataItem);
	}

	/**
	 * That method removes the first node of the given list.
	 * @param list list which linked list we are checking
	 * @return returns the removed node's data.
	 */
	public E pop(MyLinkedList<E> list) {
		return removeFirst(list);
	}
	
	/**
	 * That method removes the first node of the given list.
	 */
	@Override
	public E pop() {
		return pop(deque);
	}

	/**
	 * That method returns the iterator of given list which begins the end.
	 * @param list list which linked list we are checking
	 * @return the iterator which is begin the end
	 */
	public Iterator<E> descendingIterator(MyLinkedList<E> list) {
		if(list == deque)
			return deque.iterator(deque.DequeSize);
		return removedList.iterator(deque.DequeSize);
	}
	
	/**
	 * That method returns the iterator of deque which begins the end.
	 */
	@Override
	public Iterator<E> descendingIterator() {
		return descendingIterator(deque);
	}

	/**
	 * That method returns the iterator which's index is given
	 * @param list list which linked list we are checking
	 * @param index iterator's currentIndex.
	 * @return returns iterator.
	 */
	public Iterator<E> iterator(MyLinkedList<E> list,int index){
		if(list == deque)
			return deque.iterator(index);
		return removedList.iterator(index);
	}
	
	/**
	 * That method return the iterator of the given list 
	 * @param list list which linked list we are checking
	 * @return returns iterator.
	 */
	public Iterator<E> iterator(MyLinkedList<E> list){
		if(list == deque)
			return deque.iterator();
		return removedList.iterator();
	}
	
	/**
	 * That method return the iterator of deque.
	 */
	@Override
	public Iterator<E> iterator() {
		return deque.iterator();
	}
		
	/**
	 * That method returns the size of given list
	 * @param list list which linked list we are checking
	 * @return size
	 */
	public int size(MyLinkedList<E> list) {
		if(list == deque)
			return deque.getDequeSize();
		return removedList.getDequeSize();
	}
	
	/**
	 * that method returns the size of deque.
	 */
	@Override
	public int size() {
		return size(deque);
	}

}
