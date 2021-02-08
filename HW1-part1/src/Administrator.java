
/**
 * @author Elif Goral
 * 		   171044003
 * 
 */
public class Administrator extends User {
  /**
   * used number of branch array
   * 
   */
  private int usedBranch =   0;

  /**
   *  capacity of branch array
   * 
   */
  private int capacityBranch =   20;

  /**
   *  used number of branch employee array
   * 
   */
  public int usedBranchEmp =   0;

  /**
   *  capacity of branch employee array
   * 
   */
  public int capacityBranchEmp =   20;

  /**
   *  used number of transportation personel array.
   * 
   */
  public int usedTransPer =   0;

  /**
   *  capacity of transportation personel array.
   * 
   */
  public int capacityTransPer =   20;

  private Branch[] branch;

  public BranchEmployee[] BranchEmp;

  public TransportationPersonel[] TransPer;

  /**
   * That constructor generates the branch, branch employee and transportation personel array.
   * @param name That parameter will assign to Admin's name
   * @param surname That parameter will assign to Admin's surname
   */
  public Administrator(String name, String surname) {

		Name = name;
		Surname = surname;
		branch = new Branch[capacityBranch];
		for(int i = 0; i < capacityBranch ; i++) {
			branch[i] = new Branch("");
		}
		BranchEmp = new BranchEmployee[capacityBranchEmp];
		for(int i = 0; i < capacityBranchEmp ; i++) {
			BranchEmp[i] = new BranchEmployee("","","");
		}
		TransPer = new TransportationPersonel[capacityTransPer];
		for(int i = 0; i < capacityTransPer ; i++) {
			TransPer[i] = new TransportationPersonel("","");
		}			
  }

  /**
   *  That function adds a new Branch to the company database.
   * @param BranchName That parameter will assign to Branch's name.
   */
  public void addBranch(String BranchName) {
		int i;
		boolean isExist = false;
		for(i = 0 ; i < usedBranch ; i++) {
			if(branch[i].getBranchName() == BranchName) {
				System.out.println( BranchName +" has already exist.");
				isExist = true;
			}
		}	
		if(isExist == false) {
			if(usedBranch < capacityBranch) {
				branch[usedBranch].setBranchName(BranchName);
				usedBranch++;

			}
			else{
				capacityBranch *= 2;
				String temp[] = new String[capacityBranch]; 
				for(i = 0 ; i < usedBranch ; i++)
					temp[i] = branch[i].getBranchName();
				
				temp[i] = BranchName;
				usedBranch++;
				for(i = 0 ; i < usedBranch ; i++)
					branch[usedBranch].setBranchName(temp[i]);
				}	
		}
  }

  /**
   * That function prints Branchs.
   */
  public void printBranch() {
		for(int i = 0 ; i < usedBranch ; i++) {
			System.out.println(i+1 + ": "  + branch[i].getBranchName());
		}
  }

  /**
   * That function removes a Branch from the company database.
   * @param BranchName That parameter which is Branch Name, will be remove from the branch array list.
   */
  public void removeBranch(String BranchName) {
			String [] temp = new String[capacityBranch];
			int i, counter = 0;
			boolean isFind = false;
			for(i = 0 ; i < usedBranch ; i++) {
				if(branch[i].getBranchName() != BranchName) {
					temp[counter] = branch[i].getBranchName();
					counter++;
				}
				else if(branch[i].getBranchName() == BranchName) {
					isFind = true;
					temp[counter] = branch[i+1].getBranchName();
					counter++;
					i++;
				}			
			}
			System.out.println();

			if(isFind == true) {
				usedBranch--;
				for(i = 0 ; i < usedBranch ; i++) {
					branch[i].setBranchName(temp[i]);		
				}
			}
			else if(isFind == false) {
				System.out.println( BranchName + " not found.");
			}
					
  }

  /**
   * That function adds a new Branch Employee to company the database.
   * @param Name That parameter will assign to Branch Employee's Name.
   * @param Surname That parameter will assign to Branch Employee's Surname.
   * @param Branch That parameter will assign to Branch Employee's Branch name.
   */
  public void addBranchEmployee(String Name, String Surname, String Branch) {
		int i;
		boolean isExist = false;
		for(i = 0 ; i < usedBranchEmp ; i++) {
			if(BranchEmp[i].Name == Name && BranchEmp[i].Surname == Surname && BranchEmp[i].getBranch() == Branch ) {
				System.out.println( Name + " " + Surname + " " + Branch +" has already exist.");
				isExist = true;
			}
		}	
		if(isExist == false) {
			if(usedBranchEmp < capacityBranchEmp -1) {
				BranchEmp[usedBranchEmp].setBranch(Branch);
				BranchEmp[usedBranchEmp].Name = Name;
				BranchEmp[usedBranchEmp].Surname = Surname;
				usedBranchEmp++;
			}
			else{
				capacityBranchEmp *= 2;
				BranchEmployee temp[] = new BranchEmployee[capacityBranchEmp]; 
				
				for(i = 0 ; i < usedBranchEmp ; i++) {
					temp[i].Name = BranchEmp[i].Name;
					temp[i].Surname = BranchEmp[i].Surname;
					temp[i].setBranch(BranchEmp[i].getBranch());
				}
				temp[i].Name = Name;
				temp[i].Surname = Surname;
				temp[i].setBranch(Branch);
				usedBranchEmp++;
				for(i = 0 ; i < usedBranchEmp ; i++)
					BranchEmp[i].setBranch(temp[i].getBranch());
					BranchEmp[i].Name = temp[i].Name;
					BranchEmp[i].Surname = temp[i].Surname;
				}	
		}
  }

  /**
   * That function prints Branch Employees
   */
  public void printBranchE() {
		for(int i = 0 ; i < usedBranchEmp ; i++) {
			System.out.println(i+1 + ": "  + BranchEmp[i].Name + "  " + BranchEmp[i].Surname + "  " + BranchEmp[i].getBranch() );
		}
  }

  /**
   * That function removes a Branch Employee from the company database.
   * @param Name That parameter which is Name, will be remove from the branch employee array list.
   * @param Surname That parameter which is Surname, will be remove from the branch employee array list.
   * @param Branch That parameter which is Branch, will be remove from the branch employee array list.
   */
  public void removeBranchEmployee(String Name, String Surname, String Branch) {
		BranchEmployee [] temp = new BranchEmployee[capacityBranchEmp];
		for(int i = 0; i < capacityBranchEmp ; i++) {
			temp[i] = new BranchEmployee("","","");
		}
		int i, counter = 0;
		boolean isFind = false;
		for(i = 0 ; i < usedBranchEmp ; i++) {
			if(BranchEmp[i].Name != Name || BranchEmp[i].Surname != Surname || BranchEmp[i].getBranch() != Branch) {
				temp[counter].Name = BranchEmp[i].Name;
				temp[counter].Surname = BranchEmp[i].Surname;
				temp[counter].setBranch(BranchEmp[i].getBranch());
				counter++;
			}
			else if(BranchEmp[i].Name == Name && BranchEmp[i].Surname == Surname && BranchEmp[i].getBranch() == Branch) {
				isFind = true;
				temp[counter].Name = BranchEmp[i+1].Name;
				temp[counter].Surname = BranchEmp[i+1].Surname;
				temp[counter].setBranch(BranchEmp[i+1].getBranch());
				counter++;
				i++;
			}			
		}
		System.out.println();

		if(isFind == true) {
			usedBranchEmp--;
			for(i = 0 ; i < usedBranchEmp ; i++) {
				BranchEmp[i].setBranch(temp[i].getBranch());
				BranchEmp[i].Name = temp[i].Name;
				BranchEmp[i].Surname = temp[i].Surname;
			}
		}
		else if(isFind == false) {
			System.out.println( Name + " " + Surname + " " + Branch +" not found.");
		}
		
  }

  /**
   * That function adds a new Transportation Personal to the company database.
   * @param Name  That parameter will assign to Transportation Personel's Name.
   * @param Surname That parameter will assign to Transportation Personel's Surname.
   */
  public void addTransportationPersonal(String Name, String Surname) {
	
		int i;
		boolean isExist = false;
		for(i = 0 ; i < usedTransPer ; i++) {
			if(TransPer[i].Name == Name && TransPer[i].Surname == Surname) {
				System.out.println( Name + " " + Surname + " has already exist.");
				isExist = true;
			}
		}	
		if(isExist == false) {
			if(usedTransPer < capacityTransPer -1) {
				TransPer[usedTransPer].Name = Name;
				TransPer[usedTransPer].Surname = Surname;
				usedTransPer++;
			}
			else{
				capacityTransPer *= 2;
				TransportationPersonel temp[] = new TransportationPersonel[capacityTransPer]; 
				
				for(i = 0 ; i < usedTransPer ; i++) {
					temp[i].Name = TransPer[i].Name;
					temp[i].Surname = TransPer[i].Surname;
				}
				temp[i].Name = Name;
				temp[i].Surname = Surname;
				usedTransPer++;
				for(i = 0 ; i < usedTransPer ; i++)
					TransPer[i].Name = temp[i].Name;
					TransPer[i].Surname = temp[i].Surname;
				}	
		}
  }

  /**
   * That function prints Transportation personal.
   */
  public void printTransportationPersonal() {
		for(int i = 0 ; i < usedTransPer ; i++) {
			System.out.println(i+1 + ": "  + TransPer[i].Name + "  " + TransPer[i].Surname);
		}
  }

  /**
   * That function removes a Transportation Personal from the company database.
   * @param Name That parameter which is Name, will be remove from the transportation personel array list.
   * @param Surname That parameter which is Surname, will be remove from the transportation personel array list.
   */
  public void removeTransportationPersonal(String Name, String Surname) {
		TransportationPersonel [] temp = new TransportationPersonel[capacityBranchEmp];
		for(int i = 0; i < capacityTransPer ; i++) {
			temp[i] = new TransportationPersonel("","");
		}
		int i, counter = 0;
		boolean isFind = false;
		for(i = 0 ; i < usedTransPer ; i++) {
			if(TransPer[i].Name != Name || TransPer[i].Surname != Surname) {
				temp[counter].Name = TransPer[i].Name;
				temp[counter].Surname = TransPer[i].Surname;
				counter++;
			}
			else if(TransPer[i].Name == Name && TransPer[i].Surname == Surname) {
				isFind = true;
				temp[counter].Name = TransPer[i+1].Name;
				temp[counter].Surname = TransPer[i+1].Surname;
				counter++;
				i++;
			}			
		}
		System.out.println();

		if(isFind == true) {
			usedTransPer--;
			for(i = 0 ; i < usedTransPer ; i++) {
				TransPer[i].Name = temp[i].Name;
				TransPer[i].Surname = temp[i].Surname;
			}
		}
		else if(isFind == false) {
			System.out.println( Name + " " + Surname +" not found.");
		}
  }

  /**
   * That function returns used Branch employee.
   * @return usedBranchEmp 
   */
  public int getUsedBranchEmp() {
		return usedBranchEmp;
  }

  /**
   * That function assign that parameter to used Branch employee number.
   * @param usedBranchEmp that parameter will be assign to usedBranchEmp
   */
  public void setUsedBranchEmp(int usedBranchEmp) {
		this.usedBranchEmp = usedBranchEmp;
  }

  /**
   * That function returns capacity of Branch employee.
   * @return capacityBranchEmp
   */
  public int getCapacityBranchEmp() {
		return capacityBranchEmp;
  }

  /**
   * That function assign that parameter to capacity of Branch employee
   * @param capacityBranchEmp that parameter will be assign to capacityBranchEmp
   */
  public void setCapacityBranchEmp(int capacityBranchEmp) {
		this.capacityBranchEmp = capacityBranchEmp;
  }

}
