/*
*
* Author: Troy
* Author: Diego
* Author: Rayed
* Author: Chris
*---------------
* Used to create Student objects with names and IDs.
*/
public class Student{

	private String firstName;
	private String lastName;
	private int studentID;
	private char studentgrade;
	
	public Student(String fN, String lN, int iD){
		firstName = fN;
		lastName = lN;
		studentID = iD;
	}
	public String getFN(){
		return(firstName);
	}
	public String getLN(){
		return(lastName);
	}
	public int getID(){
		return(studentID);
	}
	public char calculateGrade()
	{
	}
	// this a test
}