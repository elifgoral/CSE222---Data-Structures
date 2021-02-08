/**
 * Class of company
 * 
 * @author Elif Goral
 * 		    171044003
 *
 */
import java.util.ArrayList;

public class Company {
	
	private String CompanyName;

	public ArrayList<Branch> branch = new ArrayList<Branch>() ;
	public ArrayList<Cargo> cargo = new ArrayList<Cargo>() ;
	public ArrayList<Administrator> admin = new ArrayList<Administrator>() ;
	public ArrayList<Customer> customer = new ArrayList<Customer>() ;
	
	public Company() {
		setCompanyName("Elif's Cargo Company");
	}
	
	/**
	 * That method returns Company's Name.
	 * @return CompanyName 
	 */
	public String getCompanyName() {
		return CompanyName;
	}

	/**
	 * That method sets the function's name to the parameter companyName.
	 * @param companyName Company's Name
	 */
	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}
	
	/**
	 * That method adds a new admin to the administrator arrayList.
	 * @param Name name of the admin which will be added
	 * @param Surname surname of the admin which will be added
	 * @throws Exception if the admin we want to add is already on arrayList, System says Admin has already exists and throws an exception.
	 */
	public void AddAdministrator(String Name,String Surname)throws Exception {
		boolean isFind = false;
		// if any admin has not added, we add that admin directly without scanning.
		if(admin.size() == 0) {
			admin.add(new Administrator(Name,Surname));		
		}
		else {
			//if administrator size is not zero, we are scanning if there is same admin in the list.
			for(int i = 0 ; i < admin.size() ; i++) {
				if(admin.get(i).getName() == Name && admin.get(i).getSurname() == Surname)
					isFind = true;	
			}	
			// if I did not find that admin, now I add to list.
			if(isFind == false) 
				admin.add(new Administrator(Name,Surname));	
			// if the admin I want to add is already on arrayList, System says Admin has already exists and throws an exception.
			else
				throw new Exception("Admin " + Name + "has already exists.");			
		}
	}

	/**
	 * That method removes an administrator from the administrator arrayList
	 * @param Name name of the administrator which will be removed.
	 * @param Surname surname of the administrator which will be removed.
	 * @throws Exception if administrator arrayList's size is zero, which means there is no administrator and we can not remove any administrator and we throw an exception for this. Second exception:if we did not find that administrator, we throw an exception.
	 */
	public void removeAdministrator(String Name,String Surname) throws Exception{
		boolean isFind = false;
		// if administrator arrayList's size is zero, which means there is no administrator and we can not remove any administrator and we throw an exception for this.
		if(admin.size() == 0)
			throw new Exception("There is no administrator.");
		else {
			// we are scanning the list. if we find that administrator, we remove that.
			for(int i = 0 ; i < admin.size() ; i++) {
				if(admin.get(i).getName() == Name && admin.get(i).getSurname() == Surname) {
					isFind = true;
					admin.remove(i);
				}
			}
			//if we did not find that administrator, we throw an exception.
			if(isFind == false)
				throw new Exception("Customer " + Name + " " + Surname + " not found.");
		}	
	}
	
	/**
	 * That method prints Administrator arrayList.
	 */
	public void printAdministrator() {
		for(int i = 0 ; i < admin.size() ; i++) {
			Object currentAdmin = admin.get(i);
			System.out.println(((Administrator) currentAdmin).getName() + " " + ((Administrator) currentAdmin).getSurname());
		}
	}
}
