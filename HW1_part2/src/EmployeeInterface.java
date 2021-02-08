/**
 * Interface of Employee
 * @author Elif Goral
 * 		    171044003
 *
 */
public interface EmployeeInterface {
	/**
	 * That method sets the parameter name to the employee's name.
	 * @param Name name which will be assign to employee's name.
	 */
	void setName(String Name);
	
	/**
	 * That method returns employee's name.
	 * @return Name employee's name.
	 */
	String getName();
	
	/**
	 * That method sets the parameter surname to the employee's surname.
	 * @param Surname surname which will be assign to employee's surname.
	 */
	void setSurname(String Surname);
	
	/**
	 * That method returns employee's surname.
	 * @return employee's surname.
	 */
	String getSurname();
	
	/**
	 * That method sets the parameter ID to the employee's ID.
	 * @param ID ID which will be assign to employee's ID.
	 */
	void setEmployeeID(String ID);
	
	/**
	 * That method returns employee's ID.
	 * @return employee's ID.
	 */
	String getEmployeeID();
	
}
