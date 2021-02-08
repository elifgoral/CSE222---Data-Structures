import java.io.Serializable;
import java.util.Scanner;

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
		if(data instanceof String) {
			String strData = (String) data;
			root = new Node(strData);
			root.left = null;
			root.right = null;
		}
	}
		
	public BinaryTree(E data,BinaryTree<E> leftTree, BinaryTree<E> rightTree) {
		if(data instanceof String) {
			String strData = (String) data;
			root = new Node(strData);
			if(leftTree != null)
				root.left = leftTree.root;
			else
				root.left = null;
			if(rightTree != null)
				root.right = rightTree.root;
			else
				root.right = null;	
		}
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
	
	/**
	 * Preordered traversal of tree.
	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		preOrderTraverse(root,sb);
		return sb.toString();	
	}
	
	/**
	 * That method traverse the tree as a preorder.
	 * @param node node.
	 * @param sb output string.
	 */
	private void preOrderTraverse(Node<E> node,StringBuilder sb) {
		if(node == null)
			sb.append("");
		else {
			sb.append(node.toString() + " ");
			preOrderTraverse(node.left,sb);
			preOrderTraverse(node.right,sb);
		}		
	}
			
	/**
	 * That method reads the expression and assign to tree.
	 * @param scan scan expression.
	 * @return return the binary tree.
	 */
	public static BinaryTree<String> readBinaryTree(Scanner scan) {
		if(scan.hasNext()) {
			String data = scan.next();
			if(data.equals("null")) {
				return null;
			}
			else {
				BinaryTree<String> leftTree = readBinaryTree(scan);
				BinaryTree<String> rightTree = readBinaryTree(scan);
				return new BinaryTree<String>(data,leftTree,rightTree);
			}
		}	
		return null;	
	}	
	
	protected static class Node<E> implements Serializable{
		protected E data;
		protected Node<E> left;
		protected Node<E> right;

		public Node(E data) {
			this.data = data;
			left = null;
			right = null;
		}
		
		public String toString(){
			return data.toString();
		}		
	}
	
	
}
