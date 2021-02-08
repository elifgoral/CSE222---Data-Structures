
/**
 * @author  Elif Goral
 *			171044003
 * @param <E> generic parameter
 */
public class AgeSearchTree<E extends Comparable<E> >  extends BinarySearchTree<E> {

	public AgeSearchTree() {
		root = null;
	}	
	
	/**
	 * That method removes the data which is given as a parameter.
	 * @param data object which will be removed.
	 * @return return the object's removed element.
	 */
	@Override
	public boolean remove(E data){
		root = remove(root, data);
		if(root != null)
			return true;
		return false;
	}
	
	/**
	 * That method helper of remove method which is travel all tree and find the data and remove.
	 * If data is not on tree,throw an exception.
	 * @param node node
	 * @param data object which will be removed.
	 * @return return the our new tree's root.;
	 */
	private Node<E> remove(Node<E> node,E data){
		try {
			if(node == null) {
				deleteReturn = null;
				AgeData aData = (AgeData) data;				
				throw new Exception(aData.getAge() + " is not on tree.");
			}
			int compResult = data.compareTo(node.data);
			if(compResult < 0) {
				node.left = remove(node.left,data);
				return node;
			}
			else if(compResult > 0) {
				node.right = remove(node.right,data);
				return node;
			}
			else {
				AgeData aData = (AgeData) node.data;
				if(aData.getNumberOfPerson() == 1) {
					if(node.left == null) {
						return node.right;
					}
					else if(node.right == null) {
						return node.left;
					}
					else {
						if(node.left.right == null) {
							node.data = node.left.data;
							node.left = node.left.left;
							return node;
						}
						else {
							node.data = findLargestChild(node.left);
							return node;
						}
					}
				}
				else {
					aData.setNumberOfPerson(aData.getNumberOfPerson()-1);
					return node;
				}
							
			}
		}
		catch(Exception e) {
			System.out.println(e);
			return node;
		}
	
	}
	
	/**
	 * That method find the largest child of age search tree.
	 * @param parent current node's parent node.
	 * @return return the largest child.
	 */
	private E findLargestChild(Node<E> parent) {
		if(parent.right.right == null) {
			E returnValue = parent.right.data;
			parent.right = parent.right.left;
			return returnValue;
		}
		else {
			return findLargestChild(parent.right);
		}	
	}
	
	/**
	 *That method add a data which is given as a parameter.
	 */
	@Override
	public boolean add(E data) {
		root = add(root,data);
		return addReturn;
	}
		
	/**
	 *That method is helper method of add method. 
	 */
	public Node<E> add(Node<E> node, E ageData){
		if(ageData instanceof AgeData) {
			if(node == null) {
				addReturn = true;
				return new Node<E>(ageData);
			}
			else if(ageData.compareTo(node.data) == 0) {
				addReturn = false;
				AgeData aData = (AgeData) node.data;
				aData.setNumberOfPerson(aData.getNumberOfPerson()+1);
				return node;
			}
			else if(ageData.compareTo(node.data) < 0) {
				node.left = add(node.left,ageData);
				return node;
			}
			else {
				node.right = add(node.right,ageData);
				return node;
			}			
		}
		return null;
	}
		
	/**
	 * That method controls the given age is greater then our object's age or not.
	 * @param age comparison age.
	 * @return returns the how many children's age is younger than the given age.
	 */
	public int youngerThan(int age) {
		return youngerThanHelper(root,age,0);
	}
	
	/**
	 * That method youngerThan method's helper method.
	 * @param node node
	 * @param age comparison age.
	 * @param youngerCounter that data fields keeps the number of younger children. 
	 * @return returns the how many children's age is younger than the given age.
	 */
	public int youngerThanHelper(Node<E> node,int age,int youngerCounter) {
		if(node != null) {
			if(node.data instanceof AgeData) {
				AgeData aData = (AgeData) node.data;
				int data = aData.getAge();	
				int number = aData.getNumberOfPerson();
				if(data < age) {
					youngerCounter = youngerThanHelper(node.left,age,youngerCounter+number);
					youngerCounter = youngerThanHelper(node.right,age,youngerCounter);
				}
				else {
					youngerCounter = youngerThanHelper(node.left,age,youngerCounter);
					youngerCounter = youngerThanHelper(node.right,age,youngerCounter);
				}
			}
		}
		return youngerCounter;
	}
	
	/**
	 * That method controls the given age is greater then our object's age or not.
	 * @param age comparison age.
	 * @return returns the how many children's age is older than the given age.
	 */
	public int olderThan(int age) {
		return olderThanHelper(root,age,0);
	}
	
	/**
	 * That method older than method's helper method.
	 * @param node node
	 * @param age comparison age.
	 * @param olderCounter that data fields keeps the number of older children. 
	 * @return returns the how many children's age is older than the given age.
	 */
	public int olderThanHelper(Node<E> node,int age,int olderCounter) {
		if(node != null) {
			if(node.data instanceof AgeData) {
				AgeData aData = (AgeData) node.data;
				int data = aData.getAge();	
				int number = aData.getNumberOfPerson();
		
				if(data > age) {
					olderCounter = olderThanHelper(node.left,age,olderCounter+number);
					olderCounter = olderThanHelper(node.right,age,olderCounter);
				}
				else {
					olderCounter = olderThanHelper(node.left,age,olderCounter);
					olderCounter = olderThanHelper(node.right,age,olderCounter);
				}
			}
		}
		return olderCounter;
	}

	/**
	 *That method finds the data which is given as a parameter.
	 */
	@Override
	public E find(E data) {
		return find(root,data);
	}
	
	/**
	 *If data is not on tree,throw an exception.
	 *That method helper method of find method. It compares the datas,and returns found object's data.
	 */
	public E find(Node<E> localRoot,E data) {
		try {
			if(localRoot == null) {
				throw new Exception(data + " is not on tree.");
			}
			int compResult = data.compareTo(localRoot.data);
			if(compResult == 0)
				return localRoot.data;
			else if(compResult < 0)
				return find(localRoot.left,data);
			else
				return find(localRoot.right,data);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return data;
	}

	/**
	 *That method prints the tree as a preorder traversal.
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		preOrderTraverse(root,sb);
		return sb.toString();	
	}
	
	/**
	 * @param node node
	 * @param sb our output string.
	 */
	private void preOrderTraverse(Node<E> node,StringBuilder sb) {
		if(node == null)
			sb.append("null\n");
		else {
			sb.append(node.toString() + "\n");
			preOrderTraverse(node.left,sb);
			preOrderTraverse(node.right,sb);
		}		
	}
		
}
