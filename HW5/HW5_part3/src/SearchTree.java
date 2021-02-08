
/**
 * @author  Elif Goral
 *			171044003
 * @param <E> generic parameter
 */
public interface SearchTree<E> {
	/**
	 * That method add a data to the tree.
	 * @param data added data
	 * @return return true,if add process is successfull,otherwise returns false.
	 */
	public boolean add(E data);
	/**
	 * That method removes data from tree.
	 * @param data removed data
	 * @return return true,if remove process is successfull,otherwise returns false.
	 */
	public boolean remove(E data);
	/**
	 * That method removes data from tree.
	 * @param data deleted data.
	 * @return returns deleted data,if delete process is unsuccessfull returns null.
	 */
	public E delete(E data);
	/**
	 * That method finds the data
	 * @param data looked data.
	 * @return returns found data
	 */
	public E find(E data);
	/**
	 * That method checks the tree contains the data or not.
	 * @param data looked data.
	 * @return if tree does not contains the data,returns false,otherwise true.
	 */
	public boolean contains(E data);
}
