
/**
 * @author  Elif Goral
 *			171044003
 * @param <E> generic parameter
 */
public class BinarySearchTree <E extends Comparable<E> > extends BinaryTree<E> implements SearchTree<E>{

	protected boolean addReturn;
	protected E deleteReturn;
		
	/**
	 * @param localRoot local root of subtree.
	 * @param data the object to be inserted.
	 * @return return the new local root that now contains the inserted data.
	 */
	public Node<E> add(Node<E> localRoot,E data){
		if(localRoot == null) {
			addReturn = true;
			return new Node<E>(data);
		}
		else if(data.compareTo(localRoot.data) == 0) {
			addReturn = false;
			return localRoot;
		}
		else if(data.compareTo(localRoot.data) < 0) {
			localRoot.left = add(localRoot.left,data);
			return localRoot;
		}
		else {
			localRoot.right = add(localRoot.right,data);
			return localRoot;
		}	
	}
	
	/**
	 * That method insets the data where it belongs in the tree. Returns true if item is inserted; false if it is not (already in tree.)
	 */
	@Override
	public boolean add(E data) {
		root = add(root,data);
		return addReturn;
	}

	/**
	 * That method removes the data which is given as a parameter.
	 */
	@Override
	public boolean remove(E data) {
		root = delete(root,data);
		if(root != null)
			return true;
		return false;
	}
	
	/**
	 * That method finds the largest child of tree.
	 * @param parent the parent of possible inorder predecessor.
	 * @return that method returns the largest child.
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
	 * That method removes data(if found) from tree and returns it;otherwise returns null.
	 * @param localRoot local root of subtree.
	 * @param data the object to be deleted.
	 * @return return the new local root that now contains the deleted data.
	 */
	private Node<E> delete(Node<E> localRoot,E data){
		if(localRoot == null) {
			deleteReturn = null;
			return localRoot;
		}
		int compResult = data.compareTo(localRoot.data);
		if(compResult < 0) {
			localRoot.left = delete(localRoot.left,data);
			return localRoot;
		}
		else if(compResult > 0) {
			localRoot.right = delete(localRoot.right,data);
			return localRoot;
		}
		else {
			if(localRoot.left == null) {
				return localRoot.right;
			}
			else if(localRoot.right == null) {
				return localRoot.left;
			}
			else {
				if(localRoot.left.right == null) {
					localRoot.data = localRoot.left.data;
					localRoot.left = localRoot.left.left;
					return localRoot;
				}
				else {
					localRoot.data = findLargestChild(localRoot.left);
					return localRoot;
				}
			}			
		}
	}
	
	/**
	 * That method removes data(if found) from tree and returns it;otherwise returns null.
	 */
	@Override
	public E delete(E data) {
		root = delete(root,data);
		return deleteReturn;
	}

	/**
	 * That method is helper method of find method.
	 * That method returns a reference to the data int the node that is equal to target. If no such node is found,return null.
	 * @param localRoot local root of subtree.
	 * @param data the object to be found.
	 * @return return the found object's data.
	 */
	public E find(Node<E> localRoot,E data) {
		if(localRoot == null)
			return null;
		int compResult = data.compareTo(localRoot.data);
		if(compResult == 0)
			return localRoot.data;
		else if(compResult < 0)
			return find(localRoot.left,data);
		else
			return find(localRoot.right,data);
	}
	
	/**
	 * That method returns a reference to the data int the node that is equal to target. If no such node is found,return null.
	 */
	@Override
	public E find(E data) {
		return find(root,data);
	}

	/**
	 * That method returns true if data is found in tree.
	 */
	@Override
	public boolean contains(E data) {
		if(find(data)!= null)
			return true;
		return false;
	}	
}
