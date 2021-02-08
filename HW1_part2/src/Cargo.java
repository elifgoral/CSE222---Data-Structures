/**
 * Class of cargo.
 * @author Elif Goral
 * 		    171044003
 *
 */
public class Cargo {
	private String SenderName;
	private String SenderSurname;
	private String ReceiverName;
	private String ReceiverSurname;
	private int TrackingNumber;
	private String cargoCurrentState;
	
	public Cargo(String SenderName,String SenderSurname , String ReceiverName ,String ReceiverSurname,int TrackingNumber) {
		setSenderName(SenderName);
		setReceiverName(ReceiverName);
		setSenderSurname(SenderSurname);
		setReceiverSurname(ReceiverSurname);
		setTrackingNumber(TrackingNumber);
	}
	
	/**
	 * That method returns cargo's current state.
	 * @return cargoCurrentState
	 */
	public String getCargoCurrentState() {
		return cargoCurrentState;
	}

	/**
	 * That method sets the cargo's current state.
	 * @param cargoCurrentState cargoCurrentState parameter will assign to cargo's current state.
	 */
	public void setCargoCurrentState(String cargoCurrentState) {
		this.cargoCurrentState = cargoCurrentState;
	}
	
	/**
	 * That method returns sender customer's name.
	 * @return SenderName 
	 */
	public String getSenderName() {
		return SenderName;
	}
	
	/**
	 * That method sets the Sender customer's name.
	 * @param senderName  senderName parameter will assign to sender customer's name.
	 */
	public void setSenderName(String senderName) {
		SenderName = senderName;
	}
	
	/**
	 * That method returns Sender customer's surname.
	 * @return SenderSurname
	 */
	public String getSenderSurname() {
		return SenderSurname;
	}
	
	/**
	 * That method sets the Sender customer's surname.
	 * @param senderSurname senderSurname parameter will assign to sender customer's surname.
	 */
	public void setSenderSurname(String senderSurname) {
		SenderSurname = senderSurname;
	}
	
	/**
	 * That method returns the receiver customer's name.
	 * @return ReceiverName
	 */
	public String getReceiverName() {
		return ReceiverName;
	}
	
	/**
	 * That method sets the receiver customer's name.
	 * @param receiverName  receiverName parameter will assign to sender customer's name.
	 */
	public void setReceiverName(String receiverName) {
		ReceiverName = receiverName;
	}
	
	/**
	 * That method returns the receiver customer's surname.
	 * @return ReceiverSurname
	 */
	public String getReceiverSurname() {
		return ReceiverSurname;
	}
	
	/**
	 * That method sets the receiver customer's surname.
	 * @param receiverSurname receiverSurname parameter will assign to sender customer's name.
	 */
	public void setReceiverSurname(String receiverSurname) {
		ReceiverSurname = receiverSurname;
	}
	
	/**
	 * That method returns tracking number.
	 * @return TrackingNumber
	 */
	public int getTrackingNumber() {
		return TrackingNumber;
	}

	/**
	 * That method sets the tracking number of cargo.
	 * @param trackingNumber Tracking number
	 */
	public void setTrackingNumber(int trackingNumber) {
		TrackingNumber = trackingNumber;
	}
}
