import java.util.Comparator;

/**
 * @author 	Elif Goral
 *			171044003
 */
public class AgeData implements Comparator<AgeData> {
	private int age;
	private int numberOfPerson;
	
	/**
	 * One parameter constructor which assign age with given age.
	 * @param age AgeData object's age.
	 */
	public AgeData(int age) {
		this.age = age;	
		this.numberOfPerson = 1;
	}
	
	/**
	 * That method returns object's age.
	 * @return Returns object's age.
	 */
	public int getAge() {
		return age;
	}

	/**
	 * That method set the object's age with given age.
	 * @param age our object's new age.
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * That method returns number of person whose ages same.
	 * @return returns number of person whose ages same.
	 */
	public int getNumberOfPerson() {
		return numberOfPerson;
	}

	/**
	 * That method sets the number of person with given number as a parameter.
	 * @param numberOfPerson our object's new number of person variable.
	 */
	public void setNumberOfPerson(int numberOfPerson) {
		this.numberOfPerson = numberOfPerson;
	}
	
	/**
	 *That method returns the age - numberOfPerson
	 */
	public String toString() {
		String temp = Integer.toString(age) + " - " + Integer.toString(numberOfPerson);
		return temp;
	}

	/**
	 *That method compares 2 AgeData object. If first object's number of person field's greater than second object's, return 1;
	 *first object's field less than second's, return -1; other wise return 0.
	 */
	@Override
	public int compare(AgeData o1, AgeData o2) {
		if(o1.numberOfPerson > o2.numberOfPerson)
			return 1;
		else if(o1.numberOfPerson < o2.numberOfPerson)
			return -1;
		return 0;
	}
}
