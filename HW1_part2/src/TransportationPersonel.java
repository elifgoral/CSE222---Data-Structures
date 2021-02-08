/**
 * Class of Transporatiton personel
 * @author Elif Goral
 * 		    171044003
 *
 */
public class TransportationPersonel extends Employee{
	
	public TransportationPersonel(String Name,String Surname,String EmployeeID, String BranchName) {
		super(Name,Surname,EmployeeID,BranchName);
	}
	
	/**
	 *That method updates the cargo's current state.
	 */
	public void UpdateCurrentCargoState(int TrackingNumber,String cargoCurrentState) {
		cargo.get(TrackingNumber).setCargoCurrentState(cargoCurrentState);
		if(cargoCurrentState == "Delivered") 
			System.out.println("Cargo "+  TrackingNumber + " is delivered.");
		
		else 
			System.out.println("Cargo "+  TrackingNumber + " is on way.");
		
	}

}
