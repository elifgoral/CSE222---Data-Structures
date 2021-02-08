import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author  Elif Goral
 *			171044003
 * @param <E> generic parameter
 */
public class MaxHeap<E> {

	private ArrayList<E> heap;
	Comparator<E> comparator = null;
	
	public MaxHeap() {
		heap = new ArrayList<E>();
	}
	
	/**
	 * That method compare the two data which is given as a parameter.
	 * @param left left side of comparison 
	 * @param right right side of comparison
	 * @return returns the comparison result.
	 */
	private int compare(E left, E right) {
		if(comparator != null)
			return comparator.compare(left, right);
		return 0;
	}
	
	/**
	 * That method checks the tree is empty or not.
	 * @return if the tree is empty,returns true; otherwise return false.
	 */
	public boolean isEmpty(){
	    return heap.isEmpty();
    }
	
	/**
	 * That method returns the parent index of given current index
	 * @param currentIndex current index.
	 * @return	return the parent index of current index.
	 */
	private int parentIndex(int currentIndex) {
		return (currentIndex - 1) / 2;
	}
	
	/**
	 * That method returns the left child index of current index
	 * @param currentIndex current index.
	 * @return returns the left child index of current index
	 */
	private int leftChildIndex(int currentIndex) {
		return (2 * currentIndex) + 1;
	}
	
	/**
	 * That method returns the right child index of current index
	 * @param currentIndex current index.
	 * @return returns the right child index of current index
	 */
	private int rightChildIndex(int currentIndex) {
		return (2 * currentIndex) + 2;
	}
	
	/**
	 * That method checks the current index of tree is leaf or not.
	 * @param currentIndex current index.
	 * @return if the current index is leaf,return true; otherwise return false.
	 */
	private boolean isLeaf(int currentIndex) {
		if((2 * currentIndex) + 1 > heap.size() && (2 * currentIndex) + 2 > heap.size())
			return true;
		return false;		
	}
	
	/**
	 * That method swap the values of given two index.
	 * @param firstIndex will swaped first index.
	 * @param secondIndex will swaped second index.
	 */
	private void swap(int firstIndex,int secondIndex) {
		E temp;
		temp = heap.get(firstIndex);
		heap.set(firstIndex, heap.get(secondIndex));
		heap.set(secondIndex, temp);		
	}
	
	/**
	 * That method find the data which is given as a parameter.
	 * @param data data which is looked for.
	 * @return return the found data.
	 */
	public E find(E data) {
		try {
			for(int i = 0 ; i < heap.size() ; i++) {
				AgeData hData = (AgeData) heap.get(i);
				AgeData aData = (AgeData) data;
				if(hData.getAge() == aData.getAge()) {
					return heap.get(i);
				}
			}
			throw new Exception(data + " is not on heap.");
		}
		catch(Exception e) {
			System.out.println(e);
			return data;
		}
	}
	
	/**
	 * That method checks data is on the tree or not
	 * @param data checked element
	 * @return if tree contains the data,return true,otherwise false.
	 */
	public boolean contains(E data) {
		for(int i = 0 ; i < heap.size() ; i++) {
			AgeData hData = (AgeData) heap.get(i);
			AgeData aData = (AgeData) data;
			if(hData.getAge() == aData.getAge())
				return true;		
		}
		return false;
	}
	
	/**
	 * That method add a element data to the tree.
	 * if tree contains the given data, method just increase the number of person at that age.
	 * If tree does not contains the given data, add that element to the arraylist's end. and start to comparison until
	 * the comparison is not equal to 1. while in that processes if is equals to 1,swap the values.
	 * @param data  added element.
	 */
	public void add(E data) {
		if(data instanceof AgeData) {
			if(heap.size() == 0)		
				heap.add(data);
				
			else if(contains(data)) {
				AgeData aData = (AgeData) data;
				for(int i = 0 ; i < heap.size() ; i++) {
					AgeData hData = (AgeData) heap.get(i);
					if(aData.getAge() == hData.getAge()) {
						aData.setNumberOfPerson(aData.getNumberOfPerson()+1);
						heap.set(i, (E) aData);
						break;
					}				
				}
			}
			else {
				heap.add(data);
				int current = heap.size() - 1;
				if(compare(heap.get(current),heap.get(parentIndex(current))) == 1) {
					while(compare(heap.get(current),heap.get(parentIndex(current))) == 1) {
						swap(current,parentIndex(current));
						current = parentIndex(current);
					}
				}
			}
		}
	}	
	
	
	/**
	 * Firstly we control the tree contains the data or not which is given as a parameter.
	 * If tree does not contains the data, we scan the tree until find the data.
	 * After found the data, if number of person is greater than 1, we just decrease the number of person.
	 * If the number of person is equal to 1, we put the most right bottom  data to the removed node of tree,
	 * and comparing the data to the upward. If compare result is 1, swap the values.
	 * @param data data which will be removed.
	 * @return returns removed data.
	 */
	public int remove(E data) {
		try {
			if(data instanceof AgeData) {
				if(!contains(data)) {
					throw new Exception(data + " is not on tree.");
				}
				else {
					int removedData = 0;
					AgeData aData = (AgeData) data;
					for(int i = 0 ; i < heap.size() ; i++) {
						AgeData hData = (AgeData) heap.get(i);
						if(aData.getAge() == hData.getAge()) {
							removedData = hData.getAge();
							if(hData.getNumberOfPerson() > 1) {
								int num = hData.getNumberOfPerson();
								aData.setNumberOfPerson(num-1);
								heap.set(i, (E) aData);
							}
							else if(hData.getNumberOfPerson() == 1) {
								AgeData tempData = (AgeData) heap.get(heap.size() -1);
								heap.set(i, (E) tempData);
								if(compare(heap.get(i),heap.get(parentIndex(i))) == 1) {
									while(compare(heap.get(i),heap.get(parentIndex(i))) == 1) {
										swap(i,parentIndex(i));
										i = parentIndex(i);
									}
								}
								heap.remove(heap.size() -1);
								return removedData;
							}						
						}				
					}	
				}			
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return 0;
	}
	
	
	/**
	 * That method calculates tree has how many element younger than given parameter data's age.
	 * @param data comparison age
	 * @return returns how many element younger than given parameter data's age.
	 */
	public int youngerThan(int data) {
		int counter = 0;
		for(int i = 0; i < heap.size() ; i++) {
			AgeData hData = (AgeData) heap.get(i);
			if(hData.getAge() < data)
				counter += hData.getNumberOfPerson();				
		}
		return counter;
	}
	
	/**
	 * That method calculates tree has how many element older than given parameter data's age.
	 * @param data comparison age
	 * @return returns how many element older than given parameter data's age.
	 */
	public int olderThan(int data) {
		int counter = 0;
		for(int i = 0; i < heap.size() ; i++) {
			AgeData hData = (AgeData) heap.get(i);
			if(hData.getAge() > data)
				counter += hData.getNumberOfPerson();				
		}
		return counter;
	}
	
	/**
	 *That method returns String which has tree.
	 */
	public String toString() {
		String output="";
		for(int i = 0 ; i < heap.size() ; i++) {
			output += heap.get(i);
			output += "\n";
		}
		return output;
	}
	
	 
}
