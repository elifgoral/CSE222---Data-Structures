/**
 * Test class
 * @author Elif Goral
 * 		    171044003
 *
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Company comp = new Company();
			System.out.println("Welcome to " + comp.getCompanyName());
			System.out.println("Adding Elif Goral as a administrator...");
			comp.AddAdministrator("Elif", "Goral");
			comp.admin.get(0).welcomeMessage();
			System.out.println("Adding Levent Goral as a administrator...");
			comp.AddAdministrator("Levent", "Goral");
			comp.admin.get(1).welcomeMessage();

			System.out.println("Administrators:");
			comp.printAdministrator();
			System.out.println("Admin size: " + comp.admin.size());

			System.out.println("ADDING BRANCHES WITH OUR FIRST ADMIN "+ comp.admin.get(0).getName() + " " + comp.admin.get(0).getSurname());
			comp.admin.get(0).AddBranch("Maltepe");
			comp.admin.get(0).AddBranch("Küçükyalý");
			comp.admin.get(0).AddBranch("Bostancý");
			comp.admin.get(0).AddBranch("Kadýköy");
			/*
			//that line throws an exception
			//comp.admin.get(0).AddBranch("Kadýköy");
			*/
			comp.admin.get(0).printBranch();
		
			System.out.println("Removing branch Maltepe: ");
			comp.admin.get(0).removeBranch("Maltepe");
			comp.admin.get(0).printBranch();

			System.out.println("Removing branch Kadýköy: ");
			comp.admin.get(0).removeBranch("Kadýköy");
			comp.admin.get(0).printBranch();
			/*
  			//exception verdiren kýsým
			System.out.println("Removing branch Kadýköy: ");
			comp.admin.get(0).removeBranch("Kadýköy");
			comp.admin.get(0).printBranch();
	*/
			
			System.out.println("ADDING BRANCHES WITH OUR SECOND ADMIN "+ comp.admin.get(1).getName() + " " + comp.admin.get(1).getSurname());
			comp.admin.get(1).AddBranch("Küçükçekmece");
			comp.admin.get(1).AddBranch("Gebze");
			comp.admin.get(1).AddBranch("Büyükçekmece");
			comp.admin.get(1).printBranch();
			System.out.println("Our first administrator's branch size: " + comp.admin.get(0).branch.size());
			System.out.println("Our second administrator's branch size: " + comp.admin.get(1).branch.size());
			System.out.println("-------------");

			System.out.println("Adding branch employees to our first admin...");
			System.out.println("Adding B1 - E1 - 12 - MALTEPE...");
			comp.admin.get(0).AddBranchEmployee("B1", "E1", "12","Maltepe");
			System.out.println("Adding B2 - E2 - 13 - MALTEPE...");
			comp.admin.get(0).AddBranchEmployee("B2", "E2", "13","Maltepe");
			System.out.println("Adding B3 - E3 - 14 - KÜÇÜKYALI...");
			comp.admin.get(0).AddBranchEmployee("B3", "E3", "14","Küçükyalý");
			System.out.println("Adding B4 - E4 - 15 - KÜÇÜKYALI...");
			comp.admin.get(0).AddBranchEmployee("B4", "E4", "15","Küçükyalý");
			System.out.println("Adding B5 - E5 - 16 - BOSTANCI...");
			comp.admin.get(0).AddBranchEmployee("B5", "E5", "16","Bostancý");
			System.out.println("Adding B6 - E6 - 17 - BOSTANCI...");
			comp.admin.get(0).AddBranchEmployee("B6", "E6", "17","Bostancý");
			System.out.println("Adding B7 - E7 - 18 - KADIKÖY...");
			comp.admin.get(0).AddBranchEmployee("B7", "E7", "18","Kadýköy");
			System.out.println("Adding B8 - E8 - 19 - KADIKÖY...");
			comp.admin.get(0).AddBranchEmployee("B8", "E8", "19","Kadýköy");
			comp.admin.get(0).printBranchEmp();
			System.out.println("-------------");
			
			/*
			// those lines throws an exception.
			System.out.println("Adding B8 - E8 - 19 - KADIKÖY...");
			comp.admin.get(0).AddBranchEmployee("B8", "E8", "19","Kadýköy");
			comp.admin.get(0).printBranchEmp();
*/
			
			System.out.println("Removing B5 - E5 - 16 - Bostancý ");
			comp.admin.get(0).removeBranchEmployee("B5", "E5", "16","Bostancý");
			comp.admin.get(0).printBranchEmp();
			System.out.println("-------------");

			/*
			 * Those lines throws an exception.
			 * 	System.out.println("Removing aa -bb - cc - Bostancý ");
				comp.admin.get(0).removeBranchEmployee("aa", "bb", "cc","Bostancý");
				comp.admin.get(0).printBranchEmp();
				System.out.println("-------------");
			 */
			System.out.println("Adding transporation personnel to our first admin...");
			System.out.println("Adding T1 - P1 - 20 - MALTEPE...");
			comp.admin.get(0).AddTransportationPersonel("T1", "P1", "20", "Maltepe");
			System.out.println("Adding T2 - P2 - 21 - MALTEPE...");
			comp.admin.get(0).AddTransportationPersonel("T2", "P2", "21", "Maltepe");
			System.out.println("Adding T3 - P3 - 22 - KÜÇÜKYALI...");
			comp.admin.get(0).AddTransportationPersonel("T3", "P3", "22", "Küçükyalý");
			System.out.println("Adding T4 - P4 - 23 - KÜÇÜKYALI...");
			comp.admin.get(0).AddTransportationPersonel("T4", "P4", "23", "Küçükyalý");
			System.out.println("Adding T5 - P5 - 24 - BOSTANCI...");
			comp.admin.get(0).AddTransportationPersonel("T5", "P5", "24", "Bostancý");
			System.out.println("Adding T6 - P6 - 25 - BOSTANCI...");
			comp.admin.get(0).AddTransportationPersonel("T6", "P6", "25", "Bostancý");
			System.out.println("Adding T7 - P7 - 26 - KADIKÖY...");
			comp.admin.get(0).AddTransportationPersonel("T7", "P7", "26", "Kadýköy");
			System.out.println("Adding T8 - P8 - 27 - KADIKÖY...");
			comp.admin.get(0).AddTransportationPersonel("T8", "P8", "27", "Kadýköy");
			comp.admin.get(0).printTransportationPersonel();
			System.out.println("-------------");

			comp.admin.get(0).printBranch();
			
			System.out.println("-------------");
			System.out.println("Removing T5 - P5 - 24 - Bostancý ");
			comp.admin.get(0).removeTransportationPersonel("T5","P5","24","Bostancý");
			comp.admin.get(0).printBranch();

			
			/*
			 // those lines throws an exception.
			  	System.out.println("Removing dd - yy - qq - Bostancý ");
				comp.admin.get(0).removeTransportationPersonel("dd","yy","qq","Bostancý");
				comp.admin.get(0).printBranch();
			 */
			
			System.out.println("-------------");
			System.out.println();
			
			System.out.println("Now we are adding customers with branch employee:");
			System.out.println("Branch employee's name:" + comp.admin.get(0).branch.get(0).BranchEmp.get(0).getName());
			System.out.println("Branch employee's surname:" + comp.admin.get(0).branch.get(0).BranchEmp.get(0).getSurname());
			System.out.println();
			
			System.out.println("Adding customer Abdullah Goral..");
			comp.admin.get(0).branch.get(0).BranchEmp.get(0).AddCustomer("Abdullah", "Goral");
			System.out.println("Adding customer Neslihan Goral..");
			comp.admin.get(0).branch.get(0).BranchEmp.get(0).AddCustomer("Neslihan", "Goral");
			System.out.println("Adding customer Murat Goral..");
			comp.admin.get(0).branch.get(0).BranchEmp.get(0).AddCustomer("Murat", "Goral");
			System.out.println("Adding customer Ela Goral..");
			comp.admin.get(0).branch.get(0).BranchEmp.get(0).AddCustomer("Ela", "Goral");

			comp.admin.get(0).branch.get(0).BranchEmp.get(0).printCustomer();
			
			/*
			 those lines throws an exception.
			 	System.out.println("Adding customer Ela Goral..");
			 	comp.admin.get(0).branch.get(0).BranchEmp.get(0).AddCustomer("Ela", "Goral");
				comp.admin.get(0).branch.get(0).BranchEmp.get(0).printCustomer();

			 */
					
			System.out.println();
			System.out.println("-------------");
			System.out.println();
			
			System.out.println("Removing Murat Goral from customer arrayList...");
			comp.admin.get(0).branch.get(0).BranchEmp.get(0).removeCustomer("Murat", "Goral");
			comp.admin.get(0).branch.get(0).BranchEmp.get(0).printCustomer();
						
			/*
			 //those lines throws an exception.
			  System.out.println("Removing Murat Goral from customer arrayList...");
				comp.admin.get(0).branch.get(0).BranchEmp.get(0).removeCustomer("Murat", "Goral");
				comp.admin.get(0).branch.get(0).BranchEmp.get(0).printCustomer();			  
			 */
			
			System.out.println("-------------");
			System.out.println();
			System.out.println("Adding cargo to the cargo ArrayList.");
			System.out.println("Adding SName1 - SSurname1 - RName1 - RSurname1 - 123...");
			comp.admin.get(0).branch.get(0).BranchEmp.get(0).AddCargo("SName1", "SSurname1", "RName1", "RSurname1", 123);
			System.out.println("Adding SName2 - SSurname2 - RName2 - RSurname2 - 456...");
			comp.admin.get(0).branch.get(0).BranchEmp.get(0).AddCargo("SName2", "SSurname2", "RName2", "RSurname2", 456);
			System.out.println("Adding SName3 - SSurname3 - RName3 - RSurname3 - 789...");
			comp.admin.get(0).branch.get(0).BranchEmp.get(0).AddCargo("SName3", "SSurname3", "RName3", "RSurname3", 789);
			comp.admin.get(0).branch.get(0).BranchEmp.get(0).printCargo();
		
			/*
			 * those lines throws an exception
			 * 	System.out.println("-------------");
			System.out.println();	
			 * System.out.println("Adding SName3 - SSurname3 - RName3 - RSurname3 - 789...");
				comp.admin.get(0).branch.get(0).BranchEmp.get(0).AddCargo("SName3", "SSurname3", "RName3", "RSurname3", 789);
			 * 
			 */
			System.out.println("-------------");
			System.out.println();
			
			System.out.println("Removing cargo SName3 - SSurname3 - RName3 - RSurname3 - 789");
			comp.admin.get(0).branch.get(0).BranchEmp.get(0).removeCargo("SName3", "SSurname3", "RName3", "RSurname3", 789);
			comp.admin.get(0).branch.get(0).BranchEmp.get(0).printCargo();
						
			/*
			 * those lines throws an exception
			  	System.out.println("Removing cargo aa - bb - cc - dd - 144");
				comp.admin.get(0).branch.get(0).BranchEmp.get(0).removeCargo("aa", "bb", "cc", "dd", 144);
				comp.admin.get(0).branch.get(0).BranchEmp.get(0).printCargo();
			 */
			System.out.println("-------------");
			System.out.println();
			
			//comp.admin.get(0).branch.get(0).BranchEmp.get(0).customer.get(0).printInformation(1256);
						
		}
		catch(Exception e) {
			System.out.println(e);
		}
			
	}

}
