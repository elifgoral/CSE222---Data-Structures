
/**
 * @author Elif Goral
 * 		   171044003
 */
public class BranchEmployee extends User {
  private String branch;

  /**
   *  used number of customer array.
   */
  private int usedCustomer =  0;

  /**
   *  capacity of customer array.
   */
  private int capacityCustomer =  20;

  private Customer[] customer;

  /**
   *  used number of receiver customer array.
   */
  private int usedReceiver =  0;

  /**
   *  capacity of receiver customer array.
   */
  private int capacityReceiver =  20;

  private Customer[] receiver;

  /**
   *  used number of sender customer array.
   */
  private int usedSender =  0;

  /**
   *  capacity number of sender customer array.
   */
  private int capacitySender =  20;

  private Customer[] sender;

  public BranchEmployee(String NameBE, String SurnameBE, String branch) {
		//this.NameBE = NameBE;
		//this.SurnameBE = SurnameBE;
		Name = NameBE;
		Surname = SurnameBE;
		this.branch = branch;
		customer = new Customer[capacityCustomer];
		for(int i = 0; i < capacityCustomer ; i++) {
			customer[i] = new Customer("","",0);
		}	
		int TrackNum = (int) (Math.random() * (10000 - 1000)) + 1000;
		receiver = new Customer[capacityReceiver];
		for(int i = 0; i < capacityReceiver ; i++) {
			receiver[i] = new Customer("","",TrackNum);
		}
		sender = new Customer[capacitySender];
		for(int i = 0; i < capacitySender ; i++) {
			sender[i] = new Customer("","",TrackNum);
		}
  }

  /**
   *  That function add a new customer to the company data base.
   * @param Name That parameter will assign to Customer's Name.
   * @param Surname That parameter will assign to Customer's Surname.
   * @param TrackingNumber That parameter will assign to Customer's Tracking Number.
   */
  public void addCustomer(String Name, String Surname, int TrackingNumber) {
		int i;
		boolean isExist = false;
		for(i = 0 ; i < usedCustomer ; i++) {
			if(customer[i].Name == Name && customer[i].Surname == Surname && customer[i].getTrackingNumberCustomer() == TrackingNumber ) {
				System.out.println( Name + " " + Surname + " " + TrackingNumber +" has already exist.");
				isExist = true;
			}
		}	
		if(isExist == false) {
			if(usedCustomer < capacityCustomer -1) {
				customer[usedCustomer].setTrackingNumberCustomer(TrackingNumber);
				customer[usedCustomer].Name = Name;
				customer[usedCustomer].Surname = Surname;
				usedCustomer++;
			}
			else{
				capacityCustomer *= 2;
				Customer temp[] = new Customer[capacityCustomer]; 
				
				for(i = 0 ; i < usedCustomer ; i++) {
					temp[i].Name = customer[i].Name;
					temp[i].Surname = customer[i].Surname;
					temp[i].setTrackingNumberCustomer(customer[i].getTrackingNumberCustomer());
				}
				temp[i].Name = Name;
				temp[i].Surname = Surname;
				temp[i].setTrackingNumberCustomer(TrackingNumber);
				usedCustomer++;
				for(i = 0 ; i < usedCustomer ; i++)
					customer[i].Name = temp[i].Name;
					customer[i].Surname = temp[i].Surname;
					customer[i].setTrackingNumberCustomer(temp[i].getTrackingNumberCustomer());
			}	
		}
  }

  /**
   * That function prints Customers.
   */
  public void printCustomer() {
		for(int i = 0 ; i < usedCustomer ; i++) {
			System.out.println(i+1 + ": "  + customer[i].Name + "  " + customer[i].Surname + "  " + customer[i].getTrackingNumberCustomer() );
		}
  }

  /**
   * That function remove a customer from the company data base.
   * @param Name That parameter which is Name, will be remove from the customer's array list.
   * @param Surname That parameter which is Surname, will be remove from the customer's array list.
   * @param TrackingNumber That parameter which is Tracking Number, will be remove from the customer's array list.
   */
  public void removeCustomer(String Name, String Surname, int TrackingNumber) {
		Customer [] temp = new Customer[capacityCustomer];
		for(int i = 0; i < capacityCustomer ; i++) {
			temp[i] = new Customer("","",0);
		}
		int i, counter = 0;
		boolean isFind = false;
		for(i = 0 ; i < usedCustomer ; i++) {
			if(customer[i].Name != Name || customer[i].Surname != Surname || customer[i].getTrackingNumberCustomer() != TrackingNumber) {
				temp[counter].Name = customer[i].Name;
				temp[counter].Surname = customer[i].Surname;
				temp[counter].setTrackingNumberCustomer(customer[i].getTrackingNumberCustomer());
				counter++;
			}
			else if(customer[i].Name == Name && customer[i].Surname == Surname && customer[i].getTrackingNumberCustomer() == TrackingNumber) {
				isFind = true;
				temp[counter].Name = customer[i+1].Name;
				temp[counter].Surname = customer[i+1].Surname;
				temp[counter].setTrackingNumberCustomer(customer[i+1].getTrackingNumberCustomer());
				counter++;
				i++;
			}			
		}
		System.out.println();

		if(isFind == true) {
			usedCustomer--;
			for(i = 0 ; i < usedCustomer ; i++) {
				customer[i].Name = temp[i].Name;
				customer[i].Surname = temp[i].Surname;
				customer[i].setTrackingNumberCustomer(temp[i].getTrackingNumberCustomer());
			}
		}
		
		else if(isFind == false) {
			System.out.println( Name + " " + Surname + " " + TrackingNumber +" not found.");

		}
	
  }

  /**
   * That function records the information about receiver to the company data base.
   * @param Name That parameter use for recording Receiver's name. 
   * @param Surname That parameter use for recording Receiver's surname. 
   * @param TrackingNumber  That parameter use for recording Receiver's tracking number. 
   */
  public void recordInfoAboutReceiver(String Name, String Surname, int TrackingNumber) {
		if(usedReceiver < capacityReceiver -1) {
			receiver[usedReceiver].setTrackingNumberCustomer(TrackingNumber);
			receiver[usedReceiver].Name = Name;
			receiver[usedReceiver].Surname = Surname;
			usedReceiver++;
		}
		else{
			capacityReceiver *= 2;
			Customer temp[] = new Customer[capacityReceiver]; 
			int i;
			for(i = 0 ; i < usedReceiver ; i++) {
				temp[i].Name =receiver[i].Name;
				temp[i].Surname = receiver[i].Surname;
				temp[i].setTrackingNumberCustomer(receiver[i].getTrackingNumberCustomer());
			}
			temp[i].Name = Name;
			temp[i].Surname = Surname;
			temp[i].setTrackingNumberCustomer(TrackingNumber);
			usedReceiver++;
			for(i = 0 ; i < usedReceiver ; i++)
				receiver[i].Name = temp[i].Name;
				receiver[i].Surname = temp[i].Surname;
				receiver[i].setTrackingNumberCustomer(temp[i].getTrackingNumberCustomer());
		}	
  }

  /**
   * That function prints information of receiver customers' list.
   */
  public void printReceiver() {
		System.out.println("Receiver:");
		for(int i = 0 ; i < usedReceiver ; i++) {
			System.out.println(i+1 + ": "  + receiver[i].Name + "  " + receiver[i].Surname + "  " + receiver[i].getTrackingNumberCustomer() );
		}
		System.out.println();
  }

  /**
   * That function records the information about sender to the company data base.
   * @param Name That parameter use for recording Sender's name.
   * @param Surname That parameter use for recording Sender's surname.
   * @param TrackingNumber That parameter use for recording Sender's tracking number.
   */
  public void recordInfoAboutSender(String Name, String Surname, int TrackingNumber) {
		if(usedSender < capacitySender -1) {
			sender[usedSender].setTrackingNumberCustomer(TrackingNumber);
			sender[usedSender].Name = Name;
			sender[usedSender].Surname = Surname;
			usedSender++;
		}
		else{
			capacityReceiver *= 2;
			Customer temp[] = new Customer[capacitySender]; 
			int i;
			for(i = 0 ; i < usedSender ; i++) {
				temp[i].Name = sender[i].Name;
				temp[i].Surname = sender[i].Surname;
				temp[i].setTrackingNumberCustomer(sender[i].getTrackingNumberCustomer());
			}
			temp[i].Name = Name;
			temp[i].Surname = Surname;
			temp[i].setTrackingNumberCustomer(TrackingNumber);
			usedSender++;
			for(i = 0 ; i < usedSender ; i++)
				sender[i].Name = temp[i].Name;
				sender[i].Surname = temp[i].Surname;
				sender[i].setTrackingNumberCustomer(temp[i].getTrackingNumberCustomer());
		}
  }

  /**
   * That function prints information of sender customers' list.
   */
  public void printSender() {
		System.out.println("Sender:");
		for(int i = 0 ; i < usedSender ; i++) {
			System.out.println(i+1 + ": "  + sender[i].Name + "  " + sender[i].Surname + "  " + sender[i].getTrackingNumberCustomer() );
		}
		System.out.println();
  }

  /**
   * That function enters informations about the shipments.
   * @param RName That parameter will assign to Receiver's name.
   * @param RSurname That parameter will assign to Receiver's surname.
   * @param SName That parameter will assign to sender's name.
   * @param SSurname That parameter will assign to sender's surname.
   * @param TrackingNumber That parameter will assign to tracking number.
   */
  public void addCargoInfo(String RName, String RSurname, String SName, String SSurname, int TrackingNumber) {
		recordInfoAboutReceiver(RName,RSurname,TrackingNumber);
		recordInfoAboutSender(SName,SSurname,TrackingNumber);
		System.out.println("---------------------------------------");
		System.out.println("cargo information:");
		System.out.println("Receiver: ");
		System.out.println("Name: " + RName);
		System.out.println("Surname: " + RSurname);
		System.out.println();
		System.out.println("Sender: ");
		System.out.println("Name: " + SName);
		System.out.println("Surname: " + SSurname);
		System.out.println();
		System.out.println("Tracking Number: " + TrackingNumber);		
		System.out.println();
		System.out.println();

  }

  /**
   * That function removes information about the receiver.
   * @param Name That parameter is receiver customer's Name which will be remove soon. 
   * @param Surname That parameter is receiver customer's surname which will be remove soon. 
   * @param TrackingNumber That parameter is receiver customer's tracking number which will be remove soon. 
   */
  public void removeInfoAboutReceiver(String Name, String Surname, int TrackingNumber) {
		Customer [] temp = new Customer[capacityReceiver];
		for(int i = 0; i < capacityReceiver ; i++) {
			temp[i] = new Customer("","",0);
		}
		int i, counter = 0;
		boolean isFind = false;
		for(i = 0 ; i < usedReceiver ; i++) {
			if(receiver[i].Name != Name || receiver[i].Surname != Surname || receiver[i].getTrackingNumberCustomer() != TrackingNumber) {
				temp[counter].Name = receiver[i].Name;
				temp[counter].Surname = receiver[i].Surname;
				temp[counter].setTrackingNumberCustomer(receiver[i].getTrackingNumberCustomer());
				counter++;
			}
			else if(receiver[i].Name == Name && receiver[i].Surname == Surname && receiver[i].getTrackingNumberCustomer() == TrackingNumber) {
				isFind = true;
				temp[counter].Name = receiver[i+1].Name;
				temp[counter].Surname = receiver[i+1].Surname;
				temp[counter].setTrackingNumberCustomer(receiver[i+1].getTrackingNumberCustomer());
				counter++;
				i++;
			}			
		}
		System.out.println();

		if(isFind == true)
			usedReceiver--;
		
		for(i = 0 ; i < usedReceiver ; i++) {
			receiver[i].Name = temp[i].Name;
			receiver[i].Surname = temp[i].Surname;
			receiver[i].setTrackingNumberCustomer(temp[i].getTrackingNumberCustomer());
		}
  }

  /**
   * That function removes information about the sender.
   * @param Name That parameter is sender customer's Name which will be remove soon. 
   * @param Surname That parameter is sender customer's surname which will be remove soon.
   * @param TrackingNumber That parameter is sender customer's tracking number which will be remove soon. 
   */
  public void removeInfoAboutSender(String Name, String Surname, int TrackingNumber) {
		Customer [] temp = new Customer[capacitySender];
		for(int i = 0; i < capacitySender ; i++) {
			temp[i] = new Customer("","",0);
		}
		int i, counter = 0;
		boolean isFind = false;
		for(i = 0 ; i < usedSender ; i++) {
			if(sender[i].Name != Name || sender[i].Surname != Surname || sender[i].getTrackingNumberCustomer() != TrackingNumber) {
				temp[counter].Name = sender[i].Name;
				temp[counter].Surname = sender[i].Surname;
				temp[counter].setTrackingNumberCustomer(sender[i].getTrackingNumberCustomer());
				counter++;
			}
			else if(sender[i].Name == Name && sender[i].Surname == Surname && sender[i].getTrackingNumberCustomer() == TrackingNumber) {
				isFind = true;
				temp[counter].Name = sender[i+1].Name;
				temp[counter].Surname = sender[i+1].Surname;
				temp[counter].setTrackingNumberCustomer(sender[i+1].getTrackingNumberCustomer());
				counter++;
				i++;
			}			
		}
		System.out.println();

		if(isFind == true)
			usedSender--;
		
		for(i = 0 ; i < usedSender ; i++) {
			sender[i].Name = temp[i].Name;
			sender[i].Surname = temp[i].Surname;
			sender[i].setTrackingNumberCustomer(temp[i].getTrackingNumberCustomer());
		}
  }

  /**
   * That function removes informations about the cargo.
   * @param RName That parameter which is name ,will remove from receiver customer's information.
   * @param RSurname  That parameter which is surname, will remove from receiver customer's information.
   * @param SName  That parameter which is name, will remove from sender customer's information.
   * @param SSurname  That parameter which is surname, will remove from sender customer's information.
   * @param TrackingNumber  That parameter which is tracking number,will remove from receiver customer's information.
   */
  public void removeCargoInfo(String RName, String RSurname, String SName, String SSurname, int TrackingNumber) {
		removeInfoAboutReceiver(RName,RSurname,TrackingNumber);
		printReceiver();
		removeInfoAboutSender(SName,SSurname,TrackingNumber);
		printSender();
  }

  /**
   * That function enters into the system current status, when the package arrives at a branch or leaves from the branch.
   */
  public void updateCurrentCargoStatus() {
  }

  /**
   * That function returns used customer number.
   * @return usedCustomer used number of customer array.
   */
  public int getUsedCustomer() {
		return usedCustomer;
  }

  /**
   * That function that parameter to assign used customer number.
   * @param usedCustomer used number of customer array.
   */
  public void setUsedCustomer(int usedCustomer) {
		this.usedCustomer = usedCustomer;
  }

  /**
   * That function returns capacity of customer array.
   * @return  capacityCustomer capacity of customer array
   */
  public int getCapacityCustomer() {
		return capacityCustomer;
  }

  /**
   * That function assign the parameter to capacity of customer
   * @param capacityCustomer  capacity of customer array
   */
  public void setCapacityCustomer(int capacityCustomer) {
		this.capacityCustomer = capacityCustomer;
  }

  /**
   * That function returns Branch
   * @return branch
   */
  public String getBranch() {
		return branch;
  }

  /**
   * That function assign the parameter to branch.
   * @param branch Branch Name
   */
  public void setBranch(String branch) {
		this.branch = branch;
  }

}
