import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

/**
 * @author  Elif Goral
 * 			171044003
 *
 */
public class SimpleTextEditor{
	
	private List<Character> list = null;
	
	
	public SimpleTextEditor(char choice) {
		if(choice == 'a') 
			list = new ArrayList<Character>(); 
		
		else if(choice == 'l') 
			list = new LinkedList<Character>(); 			
		
	}	
	
	/**
	 * That function reads the text file which is given as a parameter with Java's iteration and characters which red written to list.
	 * @param fileName that is name of the file which we will read.
	 */
	public void readIter(String fileName){
		try {
			File file = new File(fileName);
			FileReader fread;
			fread = new FileReader(file);
			BufferedReader bread = new BufferedReader(fread);  
			ListIterator<Character> iter = list.listIterator();
			int buf = 0;
			while((buf = bread.read()) != -1) {
				char character = (char) buf;
				iter.add(character);
			}	
			bread.close();
		}
		catch(FileNotFoundException e) {
			System.out.println(e);
		}

		catch(IOException e) {
			System.out.println(e);
		}
	}
	
	/**
	 * That function reads the text file which is given as a parameter without iteration and characters which red written to list.
	 * @param fileName that is name of the file which we will read.
	 */
	public void readWithoutIter(String fileName){	 
		try {
			File file = new File(fileName);
			FileReader fread;
			fread = new FileReader(file);
			BufferedReader bread = new BufferedReader(fread);  
			int buf = 0;
			while((buf = bread.read()) != -1) {
				char character = (char) buf;
				list.add(character);
			}	
			bread.close();
		}
		catch(FileNotFoundException e) {
			System.out.println(e);
		}

		catch(IOException e) {
			System.out.println(e);
		}
	}
	
	/**
	 * That function prints the list.
	 */
	public void printList() {
		ListIterator<Character> iter = list.listIterator();
		while(iter.hasNext()) {
			System.out.printf(iter.next()+" ");
		}		
		System.out.println();
	}
	
	/**
	 * That function add the element which is given as a parameter 'str' to the list's specified index without iterator.
	 * @param str element which will be added to the linked list
	 * @param index list's specified address which we add element to there.
	 */
	public void addWithoutIter(String str,int index) {
		try {
			if(index < 0 || index > list.size())
				throw new IndexOutOfBoundsException(index + "is out of bound.");
			for(int i = 0 ; i < str.length(); i++) 
				list.add(index, str.charAt(str.length()-1-i));
		}
		catch(IndexOutOfBoundsException e) {
			System.out.println(e);
		}
	}
	
	/**
	 * That function add the element which is given as a parameter 'str' to the list's specified index with Java's iteration.
	 * @param str element which will be added to the list
	 * @param index list's specified address which we add element to there.
	 */
	public void addIter(String str,int index) {
		try {
			if(index < 0 || index > list.size())
				throw new IndexOutOfBoundsException(index + "is out of bound.");
			
			ListIterator<Character> iter = list.listIterator();
			for(int i = 0 ; i < index ; i++)
				iter.next();
			for(int j = 0 ; j < str.length(); j++) 
				iter.add(str.charAt(j));			
		}
		catch(IndexOutOfBoundsException e) {
			System.out.println(e);
		}			
	}

	/**
	 * That function find the string or character in the list with Java's iteration and returns the index of that string or character's first occurrence.
	 * @param str string which we are looking for.
	 * @return returns the index of that string or character's first occurrence.
	 */
	public int findIter(String str) {
		try {
			ListIterator<Character> iter = list.listIterator();
			int counter = 0;
			int index = 0;
			while(iter.hasNext()) {		
				if(iter.next() == str.charAt(0)) {
					counter++;
					index = iter.nextIndex()-1;
					for(int i = 1 ; i < str.length() ; i++) {
						if(iter.next() == str.charAt(i)) 
							counter++;
						else
							throw new Exception(" that element is not in this list.");
					}
				}
				if(counter == str.length())
					return index;
			}
			return -1;
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return -1;		
	}

	/**
	 * That function find the string or character in the list without iteration and returns the index of that string or character's first occurrence.
	 * @param str  string which we are looking for.
	 * @return  returns the index of that string or character's first occurrence.
	 */
	public int findWithoutIter(String str) {
		try {
			int counter = 0;
			int index = 0;
			int temp = 0;
			for(int i = 0 ; i < list.size() ; i++) {
				if(list.get(i) == str.charAt(0)) {
					counter++;
					index = i;
					temp = i+1;
					for(int j = 1; j < str.length() ; j++) {
						if(list.get(temp) == str.charAt(j)) {
							counter++;
							temp++;
						}
						else
							throw new Exception(" that element is not in this list.");
					}	
				}
				if(counter == str.length()) 
					return index;
			}
		return -1;			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return -1;	
	}

	/**
	 * That function replace the characters which is given as a parameters in the list without iteration.
	 * @param c1 character1 is the character to change
	 * @param c2 character 2 is the new character.
	 */
	public void replaceWithoutIter(char c1,char c2) {
		try {
			boolean isFind = false;
			for(int i = 0 ; i < list.size() ; i++) {
				if(list.get(i) == c1) {
					list.set(i, c2);
					isFind = true;
				}
			}
			if(isFind == false)
				throw new Exception("Element "+ c1 +" not found.");
		}
		catch(Exception e) {	
			System.out.println(e);
		}
	}
	
	/**
	 * That function replace the characters which is given as a parameters in the list with Java's iteration.
	 * @param c1 character1 is the character to change
	 * @param c2 character 2 is the new character.
	 */
	public void replaceIter(char c1,char c2) {
		try {
			ListIterator<Character> iter = list.listIterator();
			boolean isFind = false;

			while(iter.hasNext()) {
				if(iter.next() == c1) {
					iter.set(c2);
					isFind = true;
				}
			}
			if(isFind == false)
				throw new Exception("Element "+ c1 +" not found.");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
