
/**
 * @author  Elif Goral
 * 			171044003
 */
public class Main {
	 
    public static void main(String[] args) {

    	System.out.println("constructing with a root...");
    	FileSystemTree myFileSystem = new FileSystemTree("root");
    	System.out.println("printing the tree...");
    	myFileSystem.printTree();
    	System.out.println();
    	
    	System.out.println("add directory method with argument 'root/first_directory' ");
    	myFileSystem.addDir("root/first_directory");
    	System.out.println("printing the tree...");
    	myFileSystem.printTree();
    	System.out.println();
    	
    	System.out.println("add directory method with argument 'root/second_directory' ");
    	myFileSystem.addDir("root/second_directory");
    	System.out.println("printing the tree...");
    	myFileSystem.printTree();    	
    	System.out.println();
    	
    	System.out.println("add file method with argument 'root/first_directory/new_file.txt' ");
    	myFileSystem.addFile("root/first_directory/new_file.txt");
    	System.out.println("printing the tree...");
    	myFileSystem.printTree();
    	System.out.println();
    	
    	System.out.println("add directory method with argument 'root/second_directory/new_directory' ");
    	myFileSystem.addDir("root/second_directory/new_directory");
    	System.out.println("printing the tree...");
    	myFileSystem.printTree();
    	System.out.println();
    	
    	System.out.println("add file method with argument 'root/second_directory/new_directory/new_file.doc' ");
    	myFileSystem.addFile("root/second_directory/new_directory/new_file.doc");
    	System.out.println("printing the tree...");
    	myFileSystem.printTree();
    	System.out.println();
    	    	
    	System.out.println("add directory method with argument 'root/first_directory/new_file/aa_directory' ");
    	myFileSystem.addDir("root/first_directory/new_file.txt/aa_directory");
    	System.out.println("printing the tree...");
    	myFileSystem.printTree();
    	System.out.println();
    	
    	System.out.println("add file method with argument 'root/second_directory/new_directory/new_file.doc/aa.txt' ");
    	myFileSystem.addFile("root/second_directory/new_directory/new_file.doc/aa.txt");
    	System.out.println("printing the tree...");
    	myFileSystem.printTree();
    	System.out.println();
    	    	
    	System.out.println("searching new...");
    	myFileSystem.search("new");
    	System.out.println();
    	System.out.println("printing the tree...");
       	myFileSystem.printTree();
    	System.out.println();
    	
    	System.out.println("removing root..");
    	myFileSystem.remove("root");
    	System.out.println("printing the tree...");
    	myFileSystem.printTree();
    	System.out.println();
    	
    	System.out.println("removing root/first_directory/new_file.txt");
    	myFileSystem.remove("root/first_directory/new_file.txt");
    	System.out.println("printing the tree...");
    	myFileSystem.printTree();
    	System.out.println();
    	
    	System.out.println("removing root/second_directory/new_directory");
    	myFileSystem.remove("root/second_directory/new_directory");        
    	System.out.println("printing the tree...");
    	myFileSystem.printTree();
    	System.out.println(); 	
    	
    	
    	
    	
    }
 
}