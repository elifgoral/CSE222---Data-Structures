import java.util.ArrayList;
import java.util.List;

/**
 * @author  Elif Goral
 * 			171044003
 */
public class FileNode {
	 
    private String data;
    private List<FileNode> children;
    private FileNode parent;
    private int childNum = 0;
 
	public FileNode(String data) {
        this.data = data;
        this.children = new ArrayList<FileNode>();
    }
 
    public FileNode(FileNode node) {
        this.data = node.getData();
        children = new ArrayList<FileNode>();
    }
 
    /**
     * That method returns the children number.
     * @return returns the children number.
     */
    public int getChildNum() {
		return childNum;
	}
    
    /**
     * That method returns node's data.
     * @return returns node's data
     */
    public String getData() {
        return this.data;
    }
 
    /**
     * That method set the node's data with data which is given as a parameter
     * @param data node's new data.
     */
    public void setData(String data) {
        this.data = data;
    } 
     
    /**
     * That methods return the node's parent node.
     * @return return the node's parent node
     */
    public FileNode getParent() {
        return this.parent;
    }
 
    /**
     * That method sets the node's parent with given parent node.
     * @param parent out node's new parent.
     */
    public void setParent(FileNode parent) {
        this.parent = parent;
    }
 
    
    /**
     * That method returns node's children.
     * @return  returns node's children.
     */
    public List<FileNode> getChildren() {
        return this.children;
    }
 
    /**
     * That method add a child to the tree.
     * @param child child node
     */
    public void addChild(FileNode child) {
        child.setParent(this);
        children.add(child);
        childNum++;
    }
 
    /**
     * That method add a child to the tree which is given as parameter to specified index.
     * @param index index which child be added.
     * @param child our new child node.
     */
    public void addChildAt(int index, FileNode child) {
        child.setParent(this);
        this.children.add(index, child);
        childNum++;
    }
 
    /**
     * That method set the children to node which is given as a parameter
     * @param children our new children.
     */
    public void setChildren(List<FileNode> children) {
        for(FileNode child : children)
            child.setParent(this);
        this.children = children;
    }
 
    /**
     * That method removes the children.
     */
    public void removeChildren() {
        this.children.clear();
        childNum = 0;
    }
 
    /**
     * That method removes child at specified index.
     * @param index index which child be removed.
     * @return removed child's data.
     */
    public FileNode removeChildAt(int index) {
        childNum--;
    	return children.remove(index);
    }
 
    /**
     * That method removes the node if it is a child.
     * @param childToBeDeleted child which will be delete.
     */
    public void removeThisIfItsAChild(FileNode childToBeDeleted) {
        List<FileNode> list = getChildren();
        list.remove(childToBeDeleted);
        childNum--;
    }
 
    /**
     * That method returns the child which is specified index.
     * @param index specified index which is given as a parameter.
     * @return child
     */
    public FileNode getChildAt(int index) {
        return children.get(index);
    }
 
    /**
     *That method checks the objects are equal ot not
     */
    @Override
    public boolean equals(Object obj) {
        if(obj == null)
            return false;
        if(obj instanceof FileNode) {
            if(((FileNode) obj).getData().equals(this.data)) 
                return true;
        }
        return false;
    }
 
  
    @Override
    public String toString() {
        return this.data.toString();
    }
 
}
