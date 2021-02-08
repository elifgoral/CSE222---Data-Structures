
public abstract class Person extends LibaryAutomationSystem {
	private String Name;
	private String Surname;
		
	/**
	 * That methods return the person's name.
	 * @return return the person's name.
	 */
	public String getName() {
		return Name;
	}
	
	/**
	 * That method set the name of person with given name.
	 * @param name our new name.
	 */
	public void setName(String name) {
		Name = name;
	}
	
	/**
	 * That methods return the person's surname.
	 * @return return the person's surname.
	 */
	public String getSurname() {
		return Surname;
	}
	
	/**
	 * That method set the surname of person with given surname.
	 * @param surname our new surname
	 */
	public void setSurname(String surname) {
		Surname = surname;
	}
	
}
