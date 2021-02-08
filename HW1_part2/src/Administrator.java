/**
 * Class of administrator.
 * @author Elif Goral
 * 		    171044003
 *
 */
public class Administrator extends User {

	public Administrator(String Name,String Surname) {
		setName(Name);
		setSurname(Surname);
	}
		
	/**
	 * That method add a new Branch to the Company.
	 * @param BranchName name of the new Branch.
	 * @throws Exception if the branch I want to add is already on branch arrayList, System says Branch has already exists and throws an exception.
	 */
	public void AddBranch(String BranchName) throws Exception {
		boolean isFind = false;
		//if the branch arrayList's size is zero, we add that branch directly to the list.
		if(branch.size() == 0) {
			branch.add(new Branch(BranchName));		
		}
		else {
			//if branch arrayList size is not zero, we are scanning if there is same branch in the list.
			for(int i = 0 ; i < branch.size(); i++) {
				if(BranchName.equals(branch.get(i).getBranchName()) == true)
					isFind = true;	
			}	
			// if I did not find that branch, now I add to list.
			if(isFind == false) 
				branch.add(new Branch(BranchName));		
			// if the branch I want to add is already on branch arrayList, System says Branch has already exists and throws an exception.
			else
				throw new Exception("Branch " + BranchName + " has already exist.");				
		}
	}
	
	/**
	 * That method prints branches and those branches' branch employees and transportation personels.
	 */
	public void printBranch() {
		for(int i = 0 ; i < branch.size() ; i++) {
			Object currentBranch = branch.get(i);
			System.out.println("-------------");
			System.out.println("BRANCH  " + ((Branch) currentBranch).getBranchName());
			System.out.println("Branch Employees: ");
			for(int j = 0 ; j < branch.get(i).BranchEmp.size() ; j++) {
				Object currentBranchEmp = branch.get(i).BranchEmp.get(j);		
				System.out.println(((BranchEmployee) currentBranchEmp).getName() + " " + ((BranchEmployee) currentBranchEmp).getSurname() + " " + ((BranchEmployee) currentBranchEmp).getEmployeeID());
			}
			if(branch.get(i).BranchEmp.size() == 0) {
				System.out.println("There is no branch employee.");
				System.out.println();			
			}
			else
				System.out.println();			
			
			System.out.println("Transportation Personels: ");
			for(int j = 0 ; j < branch.get(i).TransPer.size() ; j++) {
				Object currentTransPer = branch.get(i).TransPer.get(j);		
				System.out.println(((TransportationPersonel) currentTransPer).getName() + " " + ((TransportationPersonel) currentTransPer).getSurname() + " " + ((TransportationPersonel) currentTransPer).getEmployeeID());
			}
			if(branch.get(i).TransPer.size() == 0) {
				System.out.println("There is no transportation personel.");
				System.out.println();			
			}
			else
				System.out.println();
		}
		System.out.println("-------------");

	}
		
	/**
	 * That method removes an branch from the branch arrayList
	 * @param BranchName name of the branch which will be removed.
	 * @throws Exception first:if branch arrayList's size is zero, which means there is no branch and we can not remove any branch and we throw an exception for this. second: if we did not find that branch, we throw an exception.
	 */
	public void removeBranch(String BranchName) throws Exception{
		boolean isFind = false;
		// if branch arrayList's size is zero, which means there is no branch and we can not remove any branch and we throw an exception for this.
		if(branch.size() == 0) {
			throw new Exception("There is no branch");
		}
		else {
			// we are scanning the list. if we find that branch, we remove that.
			for(int i = 0 ; i < branch.size() ; i++) {
				if(BranchName.equals(branch.get(i).getBranchName()) == true){
					isFind = true;
					branch.remove(i);
				}
			}
			//if we did not find that branch, we throw an exception.
			if(isFind == false)
				throw new Exception("Branch " + BranchName + " not found.");	
		}
	}
	
	/**
	 * That method add a new Branch Employee to the Branch.
	 * @param Name name of the new Branch employee.
	 * @param Surname surname of the new Branch employee.
	 * @param PersonelID Employee ID of the new Branch employee.
	 * @param BranchName the branch where the branch employee will work
	 * @throws Exception if the branch employee has already in list,system throws an exception.
	 */
	public void AddBranchEmployee(String Name,String Surname,String PersonelID,String BranchName) throws Exception {
		boolean isFindBranch = false;
		boolean isFindBranchEmp = false;
		for(int i = 0 ; i < branch.size() ; i++) {
			// if we found the branch that we want to put that employee, System put the employee in the branch.
			if(BranchName.equals(branch.get(i).getBranchName()) == true) {
				isFindBranch = true;
				//if there is no branch employee, we add that branch employee directly.
				if(branch.get(i).BranchEmp.size() == 0)
					branch.get(i).BranchEmp.add(new BranchEmployee(Name,Surname,PersonelID,BranchName));
				else {
					// we are scanning the list. if we find that branch employee,we throw an exception.
					for(int j = 0 ; j < branch.get(i).BranchEmp.size() ; j++) {
						//if the same branch employee in the list,we throw an exception. 
						if(branch.get(i).BranchEmp.get(j).getEmployeeID() == PersonelID ) {
							isFindBranchEmp = true;
							throw new Exception(" Branch employee "+ branch.get(i).BranchEmp.get(j).getName() + " " + branch.get(i).BranchEmp.get(j).getSurname() + " has already exist.");
						}
					}
					//if we could not find that branch employee, we add that branch employee.
					if(isFindBranchEmp == false)
						branch.get(i).BranchEmp.add(new BranchEmployee(Name,Surname,PersonelID,BranchName));	
				}
			}
		}
		//If the branch where the employee will work is not found, I create such a branch and throw it there
		if(isFindBranch == false) {
			branch.add(new Branch(BranchName));		
			branch.get(branch.size()-1).BranchEmp.add(new BranchEmployee(Name,Surname,PersonelID,BranchName));
		}		
	}
	
	/**
	 * That method remove a Branch employee from the Branch.
	 * @param Name name of the branch employee which will be removed.
	 * @param Surname surname of the branch employee which will be removed.
	 * @param PersonelID personel ID of the branch employee which will be removed.
	 * @param BranchName the branch where the branch employee was working. 
	 * @throws Exception if we did not find that branch employee, we throw an exception.
	 */
	public void removeBranchEmployee(String Name,String Surname,String PersonelID,String BranchName) throws Exception{
		boolean isFindBranchEmp = false;	
		//firstly we scanning the branch where the branch employee was working.
		for(int i = 0 ; i < branch.size() ; i++) {
			if(BranchName.equals(branch.get(i).getBranchName()) == true) {
				for(int j = 0 ; j < branch.get(i).BranchEmp.size() ; j++) {
					// we are scanning the branch employee list on that branch. If we find that branch employee,we remove that from list.
					if(PersonelID.equals(branch.get(i).BranchEmp.get(j).getEmployeeID()) == true) {
						isFindBranchEmp = true;
						branch.get(i).BranchEmp.remove(j);
					}
				}
			}		
		}
		//if we did not find that branch employee, we throw an exception.
		if(isFindBranchEmp == false) {
			throw new Exception("Branch Employee " + Name + " "+ Surname + " not found.");
		}	
	}
		
	/**
	 * That method prints Branch Employees
	 */
	public void printBranchEmp() {
		System.out.println();
		for(int i = 0 ; i < branch.size() ; i++) {
			System.out.println("branch employees of Branch " + branch.get(i).getBranchName());
			for(int j = 0 ; j < branch.get(i).BranchEmp.size() ; j++) {
				Object currentBranchEmp = branch.get(i).BranchEmp.get(j);		
				System.out.println(((BranchEmployee) currentBranchEmp).getName() + " " + ((BranchEmployee) currentBranchEmp).getSurname() + " " + ((BranchEmployee) currentBranchEmp).getEmployeeID());
			}	
			System.out.println();
		}
	}
	
	/**
	 * That method add a new Transportaton Personel to the Branch.
	 * @param Name name of the new Transportaton Personel.
	 * @param Surname surname of the new Transportaton Personel.
	 * @param PersonelID personel ID of the new Transportaton Personel.
	 * @param BranchName the branch where the Transportaton Personel will work
	 * @throws Exception if the Transportaton Personel has already in list,system throws an exception.
	 */
	public void AddTransportationPersonel(String Name,String Surname,String PersonelID,String BranchName) throws Exception {
		boolean isFindBranch = false;
		boolean isFindTP = false;
		for(int i = 0 ; i < branch.size() ; i++) {
			// if we found the branch that we want to put that transportation personel, System put that transportation personel in the branch.
			if(BranchName.equals(branch.get(i).getBranchName()) == true) {
				isFindBranch = true;
				//if there is no  transportation personel, we add that  transportation personel directly.
				if(branch.get(i).TransPer.size() == 0)
					branch.get(i).TransPer.add(new TransportationPersonel(Name,Surname,PersonelID,BranchName));
				else {
					// we are scanning the list. if we find that transportation personel,we throw an exception.
					for(int j = 0 ; j < branch.get(i).TransPer.size() ; j++) {
						if(branch.get(i).TransPer.get(j).getEmployeeID() == PersonelID ) {
							isFindTP = true;
							throw new Exception("transportation personel "+ branch.get(i).TransPer.get(j).getName() + " " + branch.get(i).TransPer.get(j).getSurname() + " has already exist.");
						}
					}
					//if we could not find that transportation personel, we add that transportation personel.
					if(isFindTP == false)
						branch.get(i).TransPer.add(new TransportationPersonel(Name,Surname,PersonelID,BranchName));	
				}
			}
		}
		//If the branch where the transportation personel will work is not found, I create such a branch and throw it there
		if(isFindBranch == false) {
			branch.add(new Branch(BranchName));		
			branch.get(branch.size()-1).TransPer.add(new TransportationPersonel(Name,Surname,PersonelID,BranchName));
		}				
	}
	
	/**
	 * That method remove a Transportation Personel from the branch.
	 * @param Name name of the transportation personel which will be removed.
	 * @param Surname surname of the transportation personel which will be removed.
	 * @param PersonelID personel ID of the transportation personel which will be removed.
	 * @param BranchName the branch where the transportation personel was working. 
	 * @throws Exception if we did not find that transportation personel, we throw an exception.
	 */
	public void removeTransportationPersonel(String Name,String Surname,String PersonelID,String BranchName)throws Exception {
		boolean isFindBranchEmp = false;
		//firstly we scanning the branch where the transportation personel was working.
		for(int i = 0 ; i < branch.size() ; i++) {
			if(BranchName.equals(branch.get(i).getBranchName()) == true) {
				for(int j = 0 ; j < branch.get(i).TransPer.size() ; j++) {
					// we are scanning the transportation personel list on that branch. If we find that transportation personel,we remove that from list.
					if(PersonelID.equals(branch.get(i).TransPer.get(j).getEmployeeID()) == true) {
						isFindBranchEmp = true;
						branch.get(i).TransPer.remove(j);
					}
				}
			}		
		}
		//if we did not find that transportation personel, we throw an exception.
		if(isFindBranchEmp == false) {
			throw new Exception("Transportation Personel " + Name + " "+ Surname + " not found.");
		}		
	}
	
	/**
	 * That method prints Transportation Personels.
	 */
	public void printTransportationPersonel() {
		System.out.println();
		for(int i = 0 ; i < branch.size() ; i++) {
			System.out.println("Transportation personels of Branch " + branch.get(i).getBranchName());
			for(int j = 0 ; j < branch.get(i).TransPer.size() ; j++) {
				Object currentTransPer = branch.get(i).TransPer.get(j);		
				System.out.println(((TransportationPersonel) currentTransPer).getName() + " " + ((TransportationPersonel) currentTransPer).getSurname() + " " + ((TransportationPersonel) currentTransPer).getEmployeeID());
			}	
			System.out.println();
		}
	}
		
	/**
	 *That method gives an message to the user.
	 */
	@Override
	public void welcomeMessage() {
		System.out.println("Entering the system as a Admin...");
	}
}
