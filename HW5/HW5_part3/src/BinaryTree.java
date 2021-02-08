import java.io.Serializable;


/**
 * @author  Elif Goral
 *			171044003
 * @param <E> generic parameter
 */
public class BinaryTree<E> implements Serializable{
	protected Node<E> root;
	
	public BinaryTree() {
		root = null;
	}
	
	protected BinaryTree(Node<E> root) {
		this.root = root;
	}
	
	public BinaryTree(E data) {
		root = new Node<E>(data);
		root.left = null;
		root.right = null;
	}
		
	public BinaryTree(E data,BinaryTree<E> leftTree, BinaryTree<E> rightTree) {
		root = new Node<E>(data);
		if(leftTree != null)
			root.left = leftTree.root;
		else
			root.left = null;
		if(rightTree != null)
			root.right = rightTree.root;
		else
			root.right = null;
	}
	
	/**
	 * That method set the root.
	 * @param root our new root.
	 */
	public void setRoot(Node<E> root) {
		this.root = root;
	}
	
	/**
	 * That method returns the root.
	 * @return return the tree's root.
	 */
	public BinaryTree<E> getRoot() {
		return new BinaryTree<E>(root);
	}
	
	/**
	 * That method returns tree's left subtree.
	 * @return tree's left subtree.
	 */
	public BinaryTree<E> getLeftSubtree(){
		if(root != null && root.left != null)
			return new BinaryTree<E>(root.left);
		return null;			
	}
	
	/**
	 * That method returns tree's right subtree.
	 * @return tree's right subtree.
	 */
	public BinaryTree<E> getRightSubtree(){
		if(root != null && root.right != null)
			return new BinaryTree<E>(root.right);
		return null;
	}
	
	/**
	 * That method returns root's data.
	 * @return returns root's data.
	 */
	public E getData() {
		return root.data;		
	}
	
	/**
	 * That method checks root is leaf or not.
	 * @return if root is leaf returns true,otherwise false.
	 */
	public boolean isLeaf() {
		return(root.left == null && root.right == null);	
	}
	
	protected static class Node<E> implements Serializable{
		protected E data;
		protected Node<E> left;
		protected Node<E> right;

		public Node(E data) {
			if(data instanceof AgeData) {
				this.data = data;
				this.left = null;
				this.right = null;	
			}			
		}
		/**
		 * That method controls the object is AgeData or not.
		 */
		public String toString() {
			if(data instanceof AgeData) {
				AgeData aData = (AgeData)data;
				return aData.getAge()+ "-" + aData.getNumberOfPerson();
			}
			return null;
		}		
	}
	
}
