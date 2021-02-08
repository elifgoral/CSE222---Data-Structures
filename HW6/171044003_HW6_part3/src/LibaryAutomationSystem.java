import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class LibaryAutomationSystem {
	private String libaryName;
	
	public static ArrayList<Administrator> admin = new ArrayList<Administrator>();
	public static ArrayList<User> user = new ArrayList<User>();
	
	public static Map<String, Map<String,Set<String> > > outer = new HashMap<>();
	public static Map<String, Set<String> > inner = new HashMap<>();
	
	protected int numberOfAdministrator;
	protected int numberOfUser;
	protected static int numberOfBook;
	
	protected int maxNumberOfBook;
	protected int shelf;
	protected int corridor;
	protected int number; // it express the max book number for every shelf.

	protected static int [][][] location; // location array which express the which location is free,which location is full.

	
	/**
	 * Optional you can change the shelf corridor and number in constructor.
	 */
	public LibaryAutomationSystem() {
		libaryName = "Elif's Libary Automation System";
		numberOfAdministrator = 0;
		numberOfUser = 0;
		shelf = 5;
		corridor = 2;
		number = 3;
		maxNumberOfBook = shelf * corridor * number;
		location = new int [corridor][shelf][number];
		fillLocationArrayAsEmpty();
	}
	
	/**
	 * Optional you can change the shelf corridor and number in constructor.
	 * @param libaryName libary's name
	 */
	public LibaryAutomationSystem(String libaryName) {
		this.libaryName = libaryName;
		numberOfAdministrator = 0;
		numberOfUser = 0;
		shelf = 5;
		corridor = 2;
		number = 10;
		maxNumberOfBook = shelf * corridor * number;
		location = new int [corridor][shelf][number];
		fillLocationArrayAsEmpty();
	}

	/**
	 * That method returns the book capacity of libary.
	 * @return returns the book capacity of libary.
	 */
	public int getMaxNumberOfBook() {
		return maxNumberOfBook;
	}
	
	/**
	 * That method fill the location array as a empty. we assign 0 to all elements which means there are empty.
	 * If we assign 1 for any element,which means there is filled.
	 */
	public void fillLocationArrayAsEmpty() {
		for(int i = 0 ; i < corridor ; i++) {
			for(int j = 0 ; j < shelf ; j++) {
				for(int k = 0 ; k < number ; k++) {
					location[i][j][k] = 0;
				}
			}
		}
	}

	/**
	 * That methods prints the books.
	 */
	public void printBooks() {
		int k = 0 ;
		for (String author : outer.keySet()) {
			   System.out.println("author: "+ author);
		       System.out.println("--------------------------");
		       for (String title : outer.get(author).keySet()) {
		            System.out.println("title: "+ title);
		            System.out.println("location: "+ outer.get(author).get(title));	 
		            System.out.println();
		            k += outer.get(author).get(title).size();
		       }
		       System.out.println();	
		}
		numberOfBook = k;
		System.out.println("number of books : " + numberOfBook);
        System.out.println();
	}	
	
	/**
	 * That method returns the number of corridors.
	 * @return returns the number of corridors.
	 */
	public int getCorridor() {
		return corridor;
	}
	
	/**
	 * That method returns the number of shelfs.
	 * @return returns the number of shelfs.
	 */
	public int getShelf() {
		return shelf;
	}
	
	/**
		 * That method add the user. if any user has not added, we add that user directly without scanning.
		 * if user size is not zero, we are scanning if there is same user in the arrayList.
		 * if I did not find that user, now I add to arrayList.
		 * if the user I want to add is already on arrayList, System says user has already exists and throws an exception.
	 * @param Name user's name
	 * @param Surname user's surname
	 */
	public void addUser(String Name,String Surname){
		try {
			boolean isFind = false;
			// if any user has not added, we add that user directly without scanning.
			if(user.size() == 0) {
				user.add(new User(Name,Surname));		
				numberOfUser++;
			}
			else {
				//if user size is not zero, we are scanning if there is same user in the map.
				for(int i = 0 ; i < user.size() ; i++) {
					if(user.get(i).getName().equals(Name) && user.get(i).getSurname().equals(Surname))
						isFind = true;	
				}	
				// if I did not find that user, now I add to list.
				if(isFind == false) {
					user.add(new User(Name,Surname));
					numberOfUser++;
				}
				// if the user I want to add is already on arrayList, System says user has already exists and throws an exception.
				else
					throw new Exception("User " + Name + " " + Surname + " has already exists.");			
			}	
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 * That method add the administrator. if any admin has not added, we add that admin directly without scanning.
	 * if administrator size is not zero, we are scanning if there is same admin in the arrayList.
	 * if I did not find that admin, now I add to arrayList.
	 * if the admin I want to add is already on arrayList, System says Admin has already exists and throws an exception.
	 * @param Name admin's name
	 * @param Surname admin's surname
	 * @param Password admin's password
	 */
	public void addAdministrator(String Name,String Surname,String Password){
		try {
			boolean isFind = false;
			// if any admin has not added, we add that admin directly without scanning.
			if(admin.size() == 0) {
				admin.add(new Administrator(Name,Surname,Password));		
				numberOfAdministrator++;
			}
			else {
				//if administrator size is not zero, we are scanning if there is same admin in the list.
				for(int i = 0 ; i < admin.size() ; i++) {
					if(admin.get(i).getName().equals(Name) && admin.get(i).getSurname().equals(Surname))
						isFind = true;	
				}	
				// if I did not find that admin, now I add to list.
				if(isFind == false) {
					admin.add(new Administrator(Name,Surname,Password));
					numberOfAdministrator++;
				}
				// if the admin I want to add is already on arrayList, System says Admin has already exists and throws an exception.
				else
					throw new Exception("Admin " + Name + " " + Surname + " has already exists.");			
			}	
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	/**
	 * That method prints the administrator arrayList
	 */
	public void printAdministrator() {
		for(int i = 0 ; i < admin.size() ; i++) {
			System.out.println(admin.get(i).getName() + " - " + admin.get(i).getSurname() + " - " + admin.get(i).getPassword());
		}
	}
	
	/**
	 * that method prints the user arrayList
	 */
	public void printUser(){
		for(int i = 0 ; i < user.size() ; i++) {
			System.out.println(user.get(i).getName() + " - " + user.get(i).getSurname());
		}
	}
		
	/**
	 * That method returns the current number of book.
	 * @return returns current number of book
	 */
	public int getNumberOfBook() {
		return numberOfBook;
	}
	
	/**
	 * That method returns the libary's name.
	 * @return returns the libary's name.
	 */
	public String getLibaryName() {
		return libaryName;
	}
	
	/**
	 * That method sets the libary's name.
	 * @param libaryName new libary name.
	 */
	public void setLibaryName(String libaryName) {
		this.libaryName = libaryName;
	}
	
	/**
	 * That method returns the number of admin.
	 * @return returns the number of admin.
	 */
	public int getNumberOfAdministrator() {
		return numberOfAdministrator;
	}
	
	/**
	 * Returns the number of user.
	 * @return returns the number of user.
	 */
	public int getNumberOfUser() {
		return numberOfUser;
	}
	
	/**
	 * That method prints the book's status. if method find the book, prints avaliable; otherwise not avaliable.
	 * @param AuthorName book's author's name
	 * @param BookTitle book's title
	 */
	public void getStatus(String AuthorName,String BookTitle) {
		boolean isFind = false;
		for (String author : outer.keySet()) {	
			if(author.equals(AuthorName)) {
				for (String title : outer.get(author).keySet()) {
					if(title.equals(BookTitle)) {
						isFind = true;
					}
				}

			}	
		}
		if(isFind == true)
			System.out.println("Avaliable");
		else
			System.out.println("Not avaliable");	
	}
	
	/**
	 * That method search the author. If methods can not find the author, throws an exception.
	 * Otherwise, prints all book of author.
	 * @param AuthorName author's name.
	 */
	public void searchAuthor(String AuthorName) {
		try {
			boolean isFind = false;
			for (String author : outer.keySet()) {
				if(author.equals(AuthorName)) {
					isFind = true;
		              System.out.println("author: "+ author);
		              System.out.println("--------------------------");
					 for (String title : outer.get(author).keySet()) {
			              System.out.println("title: "+ title);
			              System.out.println("location: "+ outer.get(author).get(title));	                
					         System.out.println();	
					 }
			         System.out.println();	
				}        
			}
			if(isFind == false) {
				throw new Exception("Author ( " + AuthorName + " ) not found in libary.");
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}	
	}
	
	/**
	 * That method search the title of book. If methods can not find the title, throws an exception.
	 * Otherwise, prints all author and title couple (which include given title).
	 * @param titleName title of book which will be searched.
	 */
	public void searchBookTitle(String titleName) {	
		try {
			boolean isFind = false;
			for (String author : outer.keySet()) {	
				for (String title : outer.get(author).keySet()) {
					if(title.equals(titleName)) {
						 isFind = true;
			             System.out.println("author: "+ author);
						 System.out.println("title: "+ title);
				         System.out.println("location: "+ outer.get(author).get(title));	                
						 System.out.println();	
					}    	
				}
			    System.out.println();		       
			}
			if(isFind == false) {
				throw new Exception("Book ( " + titleName + " ) not found in libary.");
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}		
	}
	
	/**
	 * That method for administrator login screen. I asked the user's name,surname and password.
	 * If this informations match with someone from administrator arraylist, I give an
	 * access ability and throw the login method from administrator.java
	 */
	public void login() {
		try (Scanner input = new Scanner(System.in)) {
			System.out.println("Please be carrefull about capital the letters! ");
			System.out.println("Name    : ");
			String name = input.nextLine();	

			System.out.println("Surname : ");
			String surname = input.nextLine();	

			System.out.println("Password: ");
			String password = input.nextLine();	
			
			
			System.out.println("Name    : " + name);
			System.out.println("Surname : " + surname);
			System.out.println("Password: " + password);
			
			System.out.println("we are controlling the login process...");
			for(int i = 0 ; i < admin.size() ; i++) {
				if(admin.get(i).getName().equals(name) && admin.get(i).getSurname().equals(surname) && admin.get(i).getPassword().equals(password)) {
					System.out.println("log in process succesfull");
					admin.get(i).login();
					return ;
				}
			}
			System.out.println("log in process unsuccesfull");

			input.close();
		}
	}
	
	
}
