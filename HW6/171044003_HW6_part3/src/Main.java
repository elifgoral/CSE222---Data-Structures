
public class Main {

	public static void main(String[] args) {
		LibaryAutomationSystem libary = new LibaryAutomationSystem();
		System.out.println("libary's name: " + libary.getLibaryName());
		
		LibaryAutomationSystem libary2 = new LibaryAutomationSystem("GTU libary");
		System.out.println("libary 2's name: " + libary2.getLibaryName());
		
		System.out.println("Add administrator(Elif,Goral,1234);");
		libary.addAdministrator("Elif", "Goral" , "1234");
		System.out.println();
		
		System.out.println("printing administrator array...");
		libary.printAdministrator();
		System.out.println();
				
		System.out.println("Add administrator(Levent,Goral,5678);");
		libary.addAdministrator("Levent", "Goral" , "5678");
		System.out.println();
		
		System.out.println("printing administrator array...");
		libary.printAdministrator();
		System.out.println();	
		
		System.out.println("Add administrator(Abdullah,Goral,12);");
		libary.addAdministrator("Abdullah", "Goral" , "12");
		System.out.println();
		
		System.out.println("printing administrator array...");
		libary.printAdministrator();
		System.out.println();

		System.out.println("Add administrator(Abdullah,Goral,12)");
		libary.addAdministrator("Abdullah", "Goral" , "12");
		System.out.println();
		
		System.out.println("printing administrator array...");
		libary.printAdministrator();
		System.out.println();

		System.out.println("Setting libary's name to 'Libary 5' ..");
		libary.setLibaryName("Libary 5");
		
		System.out.println("libary's name: " + libary.getLibaryName());
		System.out.println();

		System.out.println("admin number: "+ libary.getNumberOfAdministrator());
		System.out.println();
		
		System.out.println("Add user(aa,bb)");
		libary.addUser("aa", "bb");
		libary.printUser();
		System.out.println();
		
		System.out.println("Add user(cc,dd)");
		libary.addUser("cc", "dd");
		libary.printUser();
		System.out.println();
		
		System.out.println("Add user(ee,ff)");
		libary.addUser("ee", "ff");
		libary.printUser();
		System.out.println();
		
		System.out.println("Add user(ee,ff)");
		libary.addUser("ee", "ff");
		libary.printUser();
		System.out.println();
		
		System.out.println("user number: "+ libary.getNumberOfUser());
		System.out.println();
		
		System.out.println("Login process for administrator:");
		libary.login();		
		System.out.println();
		
		System.out.println("printing books...");
		libary.printBooks();
		
		System.out.println("searching author 'aa' ...");
		libary.searchAuthor("aa");
		System.out.println();
		
		System.out.println("searching title 'bb' ...");
		libary.searchBookTitle("bb");
		System.out.println();
		
		System.out.println("searching author 'xx' ...");
		libary.searchAuthor("xx");
		System.out.println();
		
		System.out.println("searching title 'elif' ...");
		libary.searchBookTitle("elif");
		System.out.println();
			
		System.out.println("getStatus(aa,bb)");
		libary.getStatus("aa","bb");
		
		System.out.println();

		System.out.println("getStatus(xx,yy)");
		libary.getStatus("xx","yy");
	}

}
