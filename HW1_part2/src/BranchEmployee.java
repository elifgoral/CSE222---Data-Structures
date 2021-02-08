/**
 * Class of Branch Employee
 * @author Elif Goral
 * 		    171044003
 *
 */
public class BranchEmployee extends Employee{

	public BranchEmployee(String Name,String Surname,String EmployeeID,String BranchName) {
		super(Name,Surname,EmployeeID,BranchName);
	}
	
	/**
	 * That method adds a new customer to the customer arrayList.
	 * @param Name name of the customer which will be added
	 * @param Surname surname of the customer which will be added
	 * @throws Exception if the customer we want to add is already on customer arrayList, System says customer has already exists and throws an exception.
	 */
	public void AddCustomer(String Name,String Surname) throws Exception{
		boolean isFind = false;
		// if any customer has not added, we add that customer directly without scanning.
		if(customer.size() == 0) {
			customer.add(new Customer(Name,Surname));		
		}
		else {
			//if customer size is not zero, we are scanning if there is same customer in the list.
			for(int i = 0 ; i < customer.size() ; i++) {
				if(customer.get(i).getName() == Name && customer.get(i).getSurname() == Surname)
					isFind = true;	
			}	
			// if I did not find that customer, now I add to list.
			if(isFind == false) 
				customer.add(new Customer(Name,Surname));			
			// if the customer I want to add is already on customer arrayList, System says customer has already exists and throws an exception.
			else
				throw new Exception("Customer " + Name + " " + Surname + " has already exist.");			
		}
	}
	
	/**
	 * That method removes a customer from the customer arrayList.
	 * @param Name name of the customer which will be removed.
	 * @param Surname surname of the customer which will be removed.
	 * @throws Exception first: if customer arrayList's size is zero, which means there is no customer and we can not remove any customer and we throw an exception for this. second: if we did not find that customer, we throw an exception.
	 */
	public void removeCustomer(String Name,String Surname)throws Exception {
		boolean isFind = false;
		// if customer arrayList's size is zero, which means there is no customer and we can not remove any customer and we throw an exception for this.
		if(customer.size() == 0) 
			throw new Exception("There is no customer.");
		
		else {
			// we are scanning the list. if we find that customer, we remove that.
			for(int i = 0 ; i < customer.size() ; i++) {
				if(customer.get(i).getName() == Name && customer.get(i).getSurname() == Surname) {
					isFind = true;
					customer.remove(i);
				}
			}
			//if we did not find that customer, we throw an exception.
			if(isFind == false)
				throw new Exception("Customer " + Name + " " + Surname + " not found.");		
		}				
	}
	
	/**
	 * That method prints the customers.
	 */
	public void printCustomer() {
		System.out.println("Customers..");
		for(int i = 0 ; i < customer.size() ; i++) {
			Object currentCustomer = customer.get(i);
			System.out.println(((Customer) currentCustomer).getName() + " " + ((Customer) currentCustomer).getSurname());
		}
	}
	
	/**
	 * That method adds a new cargo to the cargo arrayList.
	 * @param SenderName  the name of the customer who sent the cargo.
	 * @param SenderSurname the surname of the customer who sent the cargo.
	 * @param ReceiverName the name of the customer who received the cargo.
	 * @param ReceiverSurname the surname of the customer who received the cargo.
	 * @param TrackingNumber tracking number of cargo.
	 * @throws Exception if the cargo I want to add is already on cargo arrayList, System says cargo has already exists and throws an exception.
	 */
	public void AddCargo(String SenderName,String SenderSurname , String ReceiverName ,String ReceiverSurname,int TrackingNumber) throws Exception{
		boolean isFind = false;
		// if any cargo has not added, we add that customer directly without scanning.
		if(cargo.size() == 0) {
			cargo.add(new Cargo(SenderName,SenderSurname,ReceiverName,ReceiverSurname,TrackingNumber));		
		}
		else {
			//if cargo size is not zero, we are scanning if there is same cargo in the list.
			for(int i = 0 ; i < cargo.size(); i++) {
				if(TrackingNumber == cargo.get(i).getTrackingNumber())
					isFind = true;	
			}	
			// if I did not find that cargo, now I add to list.
			if(isFind == false)
				cargo.add(new Cargo(SenderName,SenderSurname,ReceiverName,ReceiverSurname,TrackingNumber));		
			// if the cargo I want to add is already on cargo arrayList, System says cargo has already exists and throws an exception.
			else
				throw new Exception("Cargo number " + TrackingNumber + " has already exist.");				
		}		
	}
	
	/**
	 * That method removes a cargo from the cargo arrayList.
	 * @param SenderName the name of the customer who sent the cargo.
	 * @param SenderSurname  the surname of the customer who sent the cargo.
	 * @param ReceiverName the name of the customer who received the cargo.
	 * @param ReceiverSurname the name of the customer who received the cargo.
	 * @param TrackingNumber tracking number of cargo.
	 * @throws Exception first:  if cargo arrayList's size is zero, which means there is no cargo and we can not remove any cargo and we throw an exception for this. second:if we did not find that cargo, we throw an exception.
	 */
	public void removeCargo(String SenderName,String SenderSurname , String ReceiverName ,String ReceiverSurname,int TrackingNumber) throws Exception{
		boolean isFind = false;
		// if cargo arrayList's size is zero, which means there is no cargo and we can not remove any cargo and we throw an exception for this.
		if(cargo.size() == 0) 
			throw new Exception("there is no cargo in list.");
		
		// we are scanning the list. if we find that cargo, we remove that.
		for(int i = 0 ; i < cargo.size() ; i++) {
			if(TrackingNumber == cargo.get(i).getTrackingNumber()) {
				isFind = true;
				cargo.remove(i);
			}
		}
		//if we did not find that cargo, we throw an exception.
		if(isFind == false)
			throw new Exception("Cargo number " + TrackingNumber + " not found.");
	}
	
	/**
	 * That method prints Cargo's information.
	 */
	public void printCargo() {
		System.out.println("cargo..");
		for(int i = 0 ; i < cargo.size() ; i++) {
			Object currentCargo = cargo.get(i);
			System.out.println(((Cargo) currentCargo).getSenderName() + " " + ((Cargo) currentCargo).getSenderSurname()+ " " + ((Cargo) currentCargo).getReceiverName() + " " + ((Cargo) currentCargo).getReceiverSurname() + " " + ((Cargo) currentCargo).getTrackingNumber());
		}	
	}
	

	/**
	 * That method updates the cargo's current state.
	 */
	public void UpdateCurrentCargoState(int TrackingNumber ,String cargoCurrentState) {
		cargo.get(TrackingNumber).setCargoCurrentState(cargoCurrentState);
	}
	
}
