package ie.app;

import java.time.LocalDate;
import java.time.Period;

public class Employee { //Declaration of instance variables

	private int empID, id, empAge;
	private int age;
	private String namePrefix, prefix, firstName, name, lastName, surname, empEmail, email;
	private char empGender, gender;
	private LocalDate empDob, dob;

	/*
	 * Creation of Employee object for use in the FileParser class
	 */
	public Employee(int id, String prefix, String name, String surname, char gender, String email, LocalDate dob,
			int age) {
		empID = id;
		namePrefix = prefix;
		firstName = name;
		lastName = surname;
		empGender = gender;
		empEmail = email;
		empDob = dob;
		empAge = age;
	}

	public int getId() { //Getters below allow for the variables of each employee to be retrieved in another class
		return empID;
	}

	public String getPrefix() {
		return namePrefix;
	}

	public String getName() {
		return firstName;
	}

	public String getSurname() {
		return lastName;
	}

	public char getGender() {
		return empGender;
	}

	public String getEmail() {
		return empEmail;
	}

	public LocalDate getDob() {
		return empDob;
	}

	public int getAge() {
		return empAge;
	}

	public int getAgeOnNewYears() { //Method to determine if an employee was over 35 at NYD 2022
		LocalDate startDate = LocalDate.of(2022, 01, 01);
		int ageOnNewYears = Period.between(empDob, startDate).getYears();
		return ageOnNewYears;
	}

}
