/**
 * Class of Employee
 * @author Elif Goral
 * 		    171044003
 *
 */
public abstract class Employee extends Branch implements EmployeeInterface{
	private String Name;
	private String Surname;
	private String EmployeeID;

	public Employee(String Name,String Surname, String EmployeeID, String BranchName) {
		super(BranchName);
		this.Name = Name;
		this.Surname = Surname;
		this.EmployeeID = EmployeeID;
	}
	
	public void setName(String Name){
		this.Name = Name;
	}
	
	public void setSurname(String Surname) {
		this.Surname = Surname;
	}
	
	public String getName() {
		return Name;
	}
	
	public String getSurname() {
		return Surname;
	}
	
	public String getEmployeeID() {
		return EmployeeID;
	}

	public void setEmployeeID(String EmployeeID) {
		this.EmployeeID = EmployeeID;
	}
	
	public abstract void UpdateCurrentCargoState(int TrackingNumber,String cargoCurrentState);
}
