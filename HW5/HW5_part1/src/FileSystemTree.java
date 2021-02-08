
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @author  Elif Goral
 * 			171044003
 */
public class FileSystemTree {
	 
    private FileNode root;
 
    /**
     * constructor which takes a root
     * @param root root
     */
    public FileSystemTree(FileNode root) {
        this.root = root;
    }
    
    /**
     * constructor which takes a data and create a root with that data.
     * @param data root's data.
     */
    public FileSystemTree(String data) {
    	root = new FileNode(data);
    }
     
    /**
     * constuctor which has no parameter and it assign null to the root.
     */
    public FileSystemTree() {
    	root = null;
    }
         
    /**
     * That method returns root.
     * @return returns root.
     */
    public FileNode getRoot() {
        return root;
    }
 
    /**
     * That method set given root as a parameter to our root.
     * @param root our new root.
     */
    public void setRoot(FileNode root) {
        this.root = root;
    }
 
    /**
     * That method checks tree is empty or not.
     * @return if tree is empty,return true,otherwise false.
     */
    public boolean isEmpty() {
        return (root == null) ? true : false;
    }
 
    /**
     * That method controls key which is given as a parameter is exist or not.
     * @param key element's data which is looking for.
     * @return returns true if the key is found,otherwise returns false.
     */
    public boolean exists(String key) {
        return find(root, key);
    }
 
    /**
     * That method returns number of nodes.
     * @return returns number of nodes.
     */
    public int getNumberOfNodes() {
        return getNumberOfDescendants(root) + 1;
    }
 
    /**
     * That method returns number of descendants.
     * @param node node
     * @return returns number of descendats of root.
     */
    public int getNumberOfDescendants(FileNode node) {
        int numberOfChild = node.getChildren().size();
        for(FileNode child : node.getChildren())
        	numberOfChild += getNumberOfDescendants(child);
        return numberOfChild;
    }
 
    /**
     * That method checks the keyNode is exist or not
     * @param node node
     * @param keyNode data which we will looking for.
     * @return if key is found returns true,otherwise false.
     */
    private boolean find(FileNode node, String keyNode) {
        if(node.getData().equals(keyNode))
            return true;
        else {
            for(FileNode child : node.getChildren())
                if(find(child, keyNode))
                	return true;
        }
        return false;
    }
 
    /**
     * That method find the node which is given that node's data as a parameter
     * @param node node
     * @param keyNode data which we will looking for.
     * @return if node which is looking for found, returns the node,otherwise returns null.
     */
    public FileNode findNode(FileNode node, String keyNode) {
        if(node == null)
            return null;
        if(node.getData().equals(keyNode))
            return node;
        else {
        	FileNode cnode = null;
            for(FileNode child : node.getChildren()) {
                if((cnode = findNode(child, keyNode)) != null) {
                	return cnode;
                }
            }
        } 
        return null;
    }

    /**
     * That method traverse the tree as a preorder traversal and assign to a arraylist and return it.
     * @return returns the arrayList which is tree's preorder traversal version.
     */
    public ArrayList<FileNode> getPreOrderTraversal() {
        ArrayList<FileNode> preOrder = new ArrayList<FileNode>();
        buildPreOrder(root, preOrder);
        return preOrder;
    }
    
    /**
     * That method search the string which is given as a parameter.
     * @param str string which is looking for.
     */
    public void search(String str) {
    	  FileNode node = root;
    	  searchHelper(node,(String) str);	  
    	  System.out.println();
    }
    
    /**
     * That method is helper of search method. That method travels all the descendants and if find the string which is given as a parameter,it search node's path and prints.
     * For doing that used helper methods.
     * @param node node
     * @param name name which is we are looking for.
     */
    public void searchHelper(FileNode node,String name) {
    	String temp = "";
    	for(int i = 0 ; i < node.getChildNum(); i++) {		    		
			if(searchHelperFindOrNot(node.getChildAt(i),name)) {
				temp = searchWord(node.getChildAt(i),temp);
				temp += root.getData();
				String output="";
				output = reverseString(temp,output);
		   		String[] buffer = output.split("/");		
				if(isFile(buffer[buffer.length-1]) == true)
					System.out.printf("file -");
				else
					System.out.printf("dir -");

				System.out.println(output);
			}
			searchHelper(node.getChildAt(i),name);
    	}
    }
    

	/**
	 * That method throw the words to the buffer array. If the string is empty, I throw an exception for that.
	 * @param input string which will be reverse
	 * @param output string which is reversed.
	 * @return output
	 */
	public String reverseString(String input,String output) {
     	try {
     		if(input == "")
   	    	 throw new Exception("String is empty");
     		
   		  String[] buffer = input.split("/");
   		  output = helperReversing(buffer,buffer.length-1,output);
   	      return output;	
     	}
     	catch(Exception e) {
     		System.out.println(e);
     	}
		return output;	
	
	}		
	
	/**
	 * That method helper of reverseString function. That method adds the words to the output with decreasing index. When the index is 0, returns the output.
	 * @param buffer words of the input string 
	 * @param index which word as a index we are adding to output on word list.
	 * @param output reverse of input
	 * @return output
	 */
	public String helperReversing(String[] buffer,int index,String output) {
		if(index == 0) {
			output += buffer[index] + "/";
			return output;
		}
		output += buffer[index] + "/";
		return helperReversing(buffer,index-1,output);
	}
	
    /**
     * That method search the word's path and add the path elements and return the addition of paths.
     * @param node node
     * @param output output of all the path.
     * @return return all the path
     */
    public String searchWord(FileNode node,String output){
    	if(node.getParent() != null) {
      		output += node.getData();
    		output += "/";
    		return searchWord(node.getParent(),output);
    	}
    	return output;
    }
    
    
    /**
     * That method checks the string is inside the node's data or not which is given as a parameter .
     * @param node node
     * @param name string which is looking for.
     * @return if node's data has contains the name which is given as parameter, returns true,otherwise false.
     */
    public boolean searchHelperFindOrNot(FileNode node,String name) {
        String data = (String) node.getData();	
    	if(data.contains(name))
    		return true;
        return false;    	
    }
        
    /**
     * That method converts our tree to arrayList as a preorder traversal.
     * @param node node
     * @param preOrder arrayList which is listed by preorder traversal.
     */
    private void buildPreOrder(FileNode node, ArrayList<FileNode> preOrder) {
        preOrder.add(node);
        for(FileNode child : node.getChildren()) {
            buildPreOrder(child, preOrder);
        }
    }
 
    /**
     *	That method prints the tree as a preorder traversal. 
     */
    public void printTree() {
	   	 ArrayList<FileNode> preorder = new ArrayList<FileNode>();
	     preorder = getPreOrderTraversal();
	     Iterator<FileNode> iterator = preorder.iterator();
	     while(iterator.hasNext()){
	         System.out.println(iterator.next());
	     }
    }

    /**
     * That method removes the element of tree which is given as a parameter.
     * @param name name of the will removed file/directory.
     */
    public void remove(String name) {
    	try {
    	   	if(root == null) {
    	   		throw new Exception("there is no file or directory.");
        	}
        	else if(name.equals("root")) {
        		throw new Exception("root can not be remove!");
        	}
        	else {
            	FileNode node = root;
            	String[] path = ((String) name).split("/"); 
            	removeHelper(node, path,0,path.length-1);
           	}    	
    	}
    	catch(Exception e) {
    		System.out.println(e);
    	} 
    }
        
    /**
     * That method checks the node has a child or not.
     * @param node node
     * @return if node has a child returns true,otherwise false.
     */
    public boolean hasChild(FileNode node) {
    	if(node.getChildNum() != 0)
    		return true;
    	return false;
    }

    /**
     * That method remove method's helpler method.
     * @param node node
     * @param buffer that keeps the paths.
     * @param index that counts the buffer array's element number.
     * @param size buffer array's size.
     */
    public void removeHelper(FileNode node ,String buffer[],int index,int size) {
    	if(node.getData().equals(buffer[index])) {
    		for(int i = 0 ; i < node.getChildNum(); i++) {
    			if(node.getChildAt(i).getData().equals(buffer[index+1])) {
    				if(index + 1 == size) {
    					if(!hasChild(node.getChildAt(i))) {
    						node.removeThisIfItsAChild(node.getChildAt(i));
        					break;
    					}
    					else {
    						System.out.println("Directory which you want to delete has child file or directories");
    						System.out.println("Do you want to continue the delete process?");
    						System.out.println("y: yes");
    						System.out.println("n: no");
    						Scanner reader = new Scanner(System.in);
    						char c = reader.next().charAt(0);
    						System.out.println("input: "+ c);
    						if(c == 'y')
    							node.removeChildren();
    						else if (c == 'n')
    							System.out.println("delete process is canceled.");
     						else 
    							System.out.println("incorrect choice.");
    						
    						reader.close();
							break;
    					}
       				}
    				removeHelper(node.getChildAt(i),buffer,index+1,size);
    			}	
    		}
    	}
    }
    
    
    /**
     * That method add a file to the tree.
     * @param name file's name
     */
    public void addFile(String name) {
    	try {
    	 	String[] path = name.split("/"); 
        	// If the previous element is txt or doc file, that method do not add the file to the tree.
    	 	if(isFile(path[path.length-2])) {
        		throw new Exception("we can not add file after txt/doc file");
        	}
    	 	else {
    	 		if(root == null) {
            		root = new FileNode(path[0]);
                	FileNode node = root;
                	addEmptyTreeHelper(node,path,1,path.length);
            	}
            	else {
            		FileNode node = root;
            		addNotEmptyTreeHelper(node, path,0,path.length-1,getNumberOfNodes());
            	} 		
    	 	}
    	}
    	catch(Exception e) {
    		System.out.println(e);
    	}
    }
    
    /**
     * That method add a directory to the tree. 
     * @param name directory's name.
     */
    public void addDir(String name) {
    	try {
    		String[] path = name.split("/"); 
        	// If the previous element is txt or doc file, that method do not add the directory to the tree.
        	if(isFile(path[path.length-2])) {
        		throw new Exception("we can not add directory after txt/doc file");
        	}
        	else {
        		// if the root is null,which means tree is empty.
                if(root == null) {
                	root = new FileNode(path[0]);
                	FileNode node = root;
                	addEmptyTreeHelper(node, path,1,path.length);
                }
                //That method for tree is not empty.
                else {
                	FileNode node = root;
                	addNotEmptyTreeHelper(node, path,0,path.length-1,getNumberOfNodes());
                }	
        	}
    	}
    	catch(Exception e) {
    		System.out.println(e);
    	}
    }

    /**
     * That method checks the string is file or directory.
     * @param str string which will be check
     * @return if string express the file returns true,otherwise false.
     */
    public boolean isFile(String str) {
    	if(str.contains(".txt") || str.contains(".doc"))
    		return true;
    	return false;
    }
    
    /**
     * That method add file or directory to the empty tree.
     * @param node node
     * @param buffer buffer array is keeps the all path.
     * @param index buffer array's index.
     * @param size buffer array's size.
     */
    public void addEmptyTreeHelper(FileNode node,String[] buffer,int index,int size) {
    	if(index < size) {
			FileNode temp = new FileNode(buffer[index]);
			node.addChild(temp);
			addEmptyTreeHelper(node.getChildAt(0),buffer,index+1,size);
		}
    }
    
    /**
     * That method add file or directory to the not empty tree.
     * @param node node
     * @param buffer buffer array is keeps the all path.
     * @param index buffer array's index.
     * @param size buffer array's size.
     * @param counter counter.
     */
    public void addNotEmptyTreeHelper(FileNode node, String[] buffer,int index,int size,int counter) {
    	if(index == size-1) {
    		FileNode temp = new FileNode(buffer[index+1]);
    		node.addChild(temp);	
    	}
    	else {
        	if(node.getData().equals(buffer[index])) {
        		for(int i = 0 ; i < node.getChildNum(); i++) {
        			if(node.getChildAt(i).getData().equals(buffer[index+1])) {
        				addNotEmptyTreeHelper(node.getChildAt(i),buffer,index+1,size,counter+1);
        			}	
        		}
        		if(counter == size) {
        			FileNode temp = new FileNode(buffer[index]);
            		node.addChild(temp);
        		}
        	}
    	}
    }
 
}