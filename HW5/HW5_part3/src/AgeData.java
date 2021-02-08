
/**
 * @author  Elif Goral
 *			171044003
 */
public class AgeData implements Comparable<AgeData>{

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
	 *That method compare the ages. If parameter object's age greater than our object's age,returns -1, equals returns 0, otherwise returns -1. 
	 */
	@Override
	public int compareTo(AgeData data) {
		if(age < data.age)
			return -1;
		else if(age > data.age)
			return 1;
		return 0;
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
}
