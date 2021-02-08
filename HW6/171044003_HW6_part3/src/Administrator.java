import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Administrator extends Person {
	
	private String password;

	public Administrator(String Name,String Surname,String Password) {
		setName(Name);
		setSurname(Surname);
		setPassword(Password);
	}
		
	/**
	 * That methods return the password of administrator.
	 * @return return the password of administrator.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * That method sets the password to administrator.
	 * @param password our new password.
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * That methods for administrator login screen. Administrator can add book to libary, remove book from libary
	 * update the information and can view all books. For that purpose, I control in login method
	 * in libaryAutomationSystem.java file. If that login methods give to user access ability,user come this method.
	 * In this method, I ask the what he/she want to do. If user want the exit, we quit from administrator membership.
	 */
	public void login() {
		try {
			int choice;
			Scanner input;
			do {
				System.out.println();
				System.out.println("What do you want?");
				System.out.println("press 1 for adding book");
				System.out.println("press 2 for deleting book");
				System.out.println("press 3 for updating information");
				System.out.println("press 4 for printing all books");
				System.out.println("press 5 for exit.");
				input = new Scanner(System.in);
				choice = input.nextInt();	
				System.out.println(choice);
				
				switch(choice) {
				case 1 :
					System.out.println("Author name   : ");
					String authorName = input.next();	
								
					System.out.println("Title of book : ");
					String title = input.next();
					
					addBook(authorName,title);
					System.out.println();
					printBooks();
					break;
				
				case 2:
					System.out.println("Author name   : ");
					authorName = input.next();	
								
					System.out.println("Title of book : ");
					title = input.next();
					
					deleteBook(authorName,title);
					System.out.println();
					printBooks();
					break;
				
				case 3:
					System.out.println("Author name   : ");
					authorName = input.next();	
								
					System.out.println("Title of book : ");
					title = input.next();
					
					System.out.println("update location");
					updateInfo(authorName,title);
					printBooks();

					break;
					
				case 4:
					printBooks();
					break;
				
				case 5:
					System.out.println("exiting from administrator..");
					break;
					
				default:
					System.out.println("Please press 1,2,3,4 or 5");
					break;
				}			
			}while(choice != 5);	
			
			input.close();	
		}
		
		catch (InputMismatchException e) {
			System.out.println("Please press 1,2,3,4 or 5");
		}
		
		catch(Exception e) {
			System.out.println(e);
		}	
		
	}
	
	/**
	 * That method generate free location and returned it. It controls the all locations.
	 * If it find the free location, firstly turn to String and returned it; otherwise return null.
	 * cXsY.Z : x(corridor),y(shelf),z(general location of books)
	 * @return If it find the free location, firstly turn to String and returned it; otherwise return null.
	 */
	public String generateLocation() {
		String loc = "";
		for(int i = 0 ; i < corridor ; i++) {
			for(int j = 0 ; j < shelf ; j++) {
				for(int k = 0 ; k < number ; k++) {
					if(location[i][j][k] == 0) {
						int num = ((i+1) * j * number) + k;
						loc = loc + "c" + i + "s" + j + "." + num;
						location[i][j][k] = 1;
						return loc;
					}			
				}
			}
		}		
		return null;		
	}

	/**
	 * That method adds the book to the libary. Firstly I control is there any empty space or not.
	 * If there is no empty space, I throw an exception about libary is full. Otherwise I generate location
	 * with my generateLocation() method. And start to search the author name. If the author name and
	 * title name is same,I extend the location set. If the same author's another book already
	 * in libary, put the title to inner map. Otherwise create add directly and turn the location to 1 and 
	 * increase the current number of book.
	 * @param AuthorName the author name of the book to be added
	 * @param title the title of the book to be added
	 */
	public void addBook(String AuthorName, String title) {
		try {
			boolean authorSame = false;
			if(numberOfBook >= maxNumberOfBook) {
				throw new Exception("Libary is full.We can not add any book to libary.");
			}
			else {
				String loc = null;
				loc = generateLocation();
				System.out.println("location: "+ loc);
				 int c,s,n;
				 String cValue = loc.substring(loc.indexOf('c') + 1, loc.indexOf('s'));
				 c = Integer.parseInt(cValue);

				 String sValue = loc.substring(loc.indexOf('s') + 1, loc.indexOf('.'));
				 s = Integer.parseInt(sValue);
				 
				 String nValue = loc.substring(loc.indexOf('.') + 1);
				 n = Integer.parseInt(nValue);
				boolean titleSame = false;
				for (String author : outer.keySet()) {
					if(author.equals(AuthorName)) {
						authorSame = true;
						System.out.println("author name equal");
						for (String titleName : outer.get(author).keySet()) {
							if(titleName.equals(title)) {
								titleSame = true;
								System.out.println("title name equal");
								Set<String> tempLocation = new HashSet<String>();
								tempLocation = outer.get(author).get(title);
								tempLocation.add(loc);
								System.out.println("temp loc:" + tempLocation);
								Map<String,Set<String>> tempInner =  new HashMap<>();
								tempInner = outer.get(author);
								tempInner.put(title, tempLocation);
								outer.put(author, tempInner);
								location[c][s][n] = 1; // I fill that  specified location of location array.
							}				
						}
						if(titleSame == false) {
							Set<String> tempLocation = new HashSet<String>();
							tempLocation.add(loc);
							Map<String,Set<String>> tempInner =  new HashMap<>();
							tempInner = outer.get(author);
							tempInner.put(title, tempLocation);
							outer.put(author, tempInner);
							location[c][s][n] = 1; // I fill that  specified location of location array.
						}
							
					}
				}
				if(authorSame == false) {
					Set<String> tempLocation = new HashSet<String>();
					tempLocation.add(loc);
					System.out.println("temp loc:" + tempLocation);
					Map<String,Set<String>> tempInner =  new HashMap<>();
					tempInner.put(title, tempLocation);
					outer.put(AuthorName, tempInner);
					location[c][s][n] = 1; // I fill that  specified location of location array.
				}		
				numberOfBook++;	

			}			
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println();
		}
		catch(Exception e) {
			System.out.println(e);
		}		
	}
	
	/**
	 * There is one difference between addBook(AuthorName,TitleName) and addBook(AuthorName,TitleName,location) is
	 * location is specified earlier and send as a parameter. 
	 * @param AuthorName the author name of the book to be added
	 * @param title the title of the book to be added
	 * @param loc location of the book to be added.
	 */
	public void addBook(String AuthorName, String title,String loc) {
		try {
			boolean authorSame = false;
			if(numberOfBook >= maxNumberOfBook) {
				throw new Exception("Libary is full.We can not add any book to libary.");
			}
			else {
				 int c,s,n;
				 String cValue = loc.substring(loc.indexOf('c') + 1, loc.indexOf('s'));
				 c = Integer.parseInt(cValue);

				 String sValue = loc.substring(loc.indexOf('s') + 1, loc.indexOf('.'));
				 s = Integer.parseInt(sValue);
				 
				 String nValue = loc.substring(loc.indexOf('.') + 1);
				 n = Integer.parseInt(nValue);
				boolean titleSame = false;
				for (String author : outer.keySet()) {
					if(author.equals(AuthorName)) {
						authorSame = true;
						System.out.println("author name equal");
						for (String titleName : outer.get(author).keySet()) {
							if(titleName.equals(title)) {
								titleSame = true;
								System.out.println("title name equal");
								Set<String> tempLocation = new HashSet<String>();
								tempLocation = outer.get(author).get(title);
								tempLocation.add(loc);
								System.out.println("temp loc:" + tempLocation);
								Map<String,Set<String>> tempInner =  new HashMap<>();
								tempInner = outer.get(author);
								tempInner.put(title, tempLocation);
								outer.put(author, tempInner);
								location[c][s][n] = 1; // I fill that  specified location of location array.
							}				
						}
						if(titleSame == false) {
							Set<String> tempLocation = new HashSet<String>();
							tempLocation.add(loc);
							Map<String,Set<String>> tempInner =  new HashMap<>();
							tempInner = outer.get(author);
							tempInner.put(title, tempLocation);
							outer.put(author, tempInner);
							location[c][s][n] = 1; // I fill that  specified location of location array.
						}
							
					}
				}
				if(authorSame == false) {
					Set<String> tempLocation = new HashSet<String>();
					tempLocation.add(loc);
					System.out.println("temp loc:" + tempLocation);
					Map<String,Set<String>> tempInner =  new HashMap<>();
					tempInner.put(title, tempLocation);
					outer.put(AuthorName, tempInner);
					location[c][s][n] = 1; // I fill that  specified location of location array.
				}		
				
			}			
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println();
		}
		catch(Exception e) {
			System.out.println(e);
		}	
	}
	
	/**
	 * That method delete book from libary. Firstly I control the libary has book or not. If there is no book
	 * in libary,I throw an exception about libary is empty. Otherwise I start to search respectively author name
	 * and title name. When I found both of them, generate location and turn it to String. If author has more
	 * than 1 book, I delete title, but author has only one book, I delete the author. and turn location to 1 
	 * and decrease the current number of book.
	 * @param AuthorName the author name of the book to be deleted
	 * @param TitleName the title name of the book to be deleted
	 */
	public void deleteBook(String AuthorName,String TitleName) {
		try {
			boolean isFind = false;
			if(numberOfBook == 0) {
				throw new Exception("There is no book in libary");
			}
			else {
				for (String author : outer.keySet()) {	
					if(author.equals(AuthorName)) {
						for (String title : outer.get(author).keySet()) {
							if(title.equals(TitleName)) {
								 isFind = true;
								 Set<String> loc = new HashSet<String>();
								 loc = outer.get(author).get(title);
								 List<String> locList = new ArrayList<String>(loc);
								 int c,s,n;
								 String cValue,sValue,nValue;
															
								 if(outer.get(author).size() == 1) {
									 outer.remove(author);
									 numberOfBook--;
								 }
								 else if(outer.get(author).size() > 1) {
									 outer.get(author).remove(title);
									 numberOfBook--;
								 } 								
								 
								 System.out.println("locSize: " + locList.size());
								 for(int i = 0 ; i < locList.size() ; i++) {
									 System.out.println("get(i):" + locList.get(i));
									 cValue = locList.get(i).substring(locList.get(i).indexOf('c') + 1, locList.get(i).indexOf('s'));
									 c = Integer.parseInt(cValue);

									 sValue = locList.get(i).substring(locList.get(i).indexOf('s') + 1, locList.get(i).indexOf('.'));
									 s = Integer.parseInt(sValue);
									 
									 nValue = locList.get(i).substring(locList.get(i).indexOf('.') + 1);
									 n = Integer.parseInt(nValue); 
									
									 location[c][s][n] = 0; // location arrayinin o bölgesini boþaltýyorum.
								 }
							}							
						}
					    System.out.println();	
					}	
				}
				if(isFind == false) {
					throw new Exception("there is no that book( " + AuthorName + " - " + TitleName + " ) in libary.");
				}
			}	
		}
			
		catch(ConcurrentModificationException e) {
			System.out.println();
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println();
		}
		catch(Exception e) {
			System.out.println(e);
		}	
		
	}
	

	/**
	 * change the book's location with next empty place.
	 * @param AuthorName Author's name
	 * @param TitleName Book's title name
	 */
	public void updateInfo(String AuthorName,String TitleName) {
		try {
			if(numberOfBook < maxNumberOfBook) {
				String newLocation = generateLocation();
				deleteBook(AuthorName,TitleName);
				addBook(AuthorName,TitleName,newLocation);		
			}
			else {
				throw new Exception("No more empty space for book. We can not change its place.");
			}
		}
		catch(Exception e) {
			System.out.println();
		}	
	}

}
