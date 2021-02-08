/**
 * Class of Customer
 * @author Elif Goral
 * 		    171044003
 *
 */
public class Customer extends User {

	public Customer(String Name,String Surname) {
		setName(Name);
		setSurname(Surname);
	}
	
	/**
	 * That method prints the information about Sender customer and Receiver customer when tracking number entered the system.
	 * @param TrackingNumber Cargo's tracking number.
	 * @throws Exception if that tracking number is not found, system throws an exception.
	 */
	public void printInformation(int TrackingNumber) throws Exception{
		boolean isFind = false;
		for(int i = 0 ; i < cargo.size() ; i++) {
			if(cargo.get(i).getTrackingNumber() == TrackingNumber) {
				isFind = true;
				System.out.println("-------------");
				System.out.println("Tracking Number: " + TrackingNumber);
				System.out.println("About Sender Customer: ");
				System.out.println("Name: " + cargo.get(i).getSenderName());
				System.out.println("Surname: " + cargo.get(i).getSenderSurname());
				System.out.println("About Receiver Customer: ");
				System.out.println("Name: " + cargo.get(i).getReceiverName());
				System.out.println("Surname: " + cargo.get(i).getReceiverSurname());
				System.out.println();
				System.out.println("-------------");
			}
		}
		if(isFind == false) {
			throw new Exception("Cargo number " + TrackingNumber + " not found.");
		}
	}

	
	/**
	 *That method prints a welcome message to customer.
	 */
	@Override
	public void welcomeMessage() {
		System.out.println("You are entering the system as a Customer...");
	}
}
