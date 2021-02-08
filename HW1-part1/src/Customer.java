
/**
 * @author Elif Goral
 * 		   171044003
 * 
 */
public class Customer extends User {
  private int TrackingNumber;

  private String CargoCurrentState;

  public Customer(String Name, String Surname, int TrackingNumber) {
		this.Name = Name;
		this.Surname = Surname;
		this.TrackingNumber = TrackingNumber;
  }

  /**
   * That function prints customer's information.
   */
  public void printCustomerInfo() {
		System.out.println("name: "+ Name);
		System.out.println("Surname: "+ Surname);
		System.out.println("TrackingNumber: "+ TrackingNumber);
  }

  /**
   * That function returns tracking number of customer.
   * @return Returns TrackingNumber
   */
  public int getTrackingNumberCustomer() {
		return TrackingNumber;
  }

  /**
   * 	That function sets the parameter to tracking number.
   * @param trackingNumber trackingNumber which will be set to customer's Tracking Number
   */
  public void setTrackingNumberCustomer(int trackingNumber) {
		TrackingNumber = trackingNumber;
  }

  /**
   * That function returns Cargo's current state.
   * @return CargoCurrentState Cargo's current state
   */
  public String getCargoCurrentState() {
		return CargoCurrentState;
  }

  /**
   * That function sets the cargo's current state.
   * @param cargoCurrentState parameter cargoCurrentState will set to Cargo's Current State
   */
  public void setCargoCurrentState(String cargoCurrentState) {
		CargoCurrentState = cargoCurrentState;
  }

}
