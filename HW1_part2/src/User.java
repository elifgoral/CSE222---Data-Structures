/**
 * Class of User
 * @author Elif Goral
 * 		    171044003
 *
 */
public abstract class User extends Company implements UserInterface{
	private String Name;
	private String Surname;
	
	
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

	public abstract void welcomeMessage();
	
}
