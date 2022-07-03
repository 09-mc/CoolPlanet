package ie.app;

import java.io.BufferedReader;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;
import java.io.*;
import org.json.*;

public class FileParser {

	private String space = "";
	private ArrayList<Employee> employees = new ArrayList<Employee>(); // Setting up an arraylist of Employee objects

	public void createJsonList() {
		/*
		 * Creates a buffered reader taking in the file employees.csv. Header variable
		 * used to remove headers. Creation of string array for each line. Conversion
		 * then to correct data types for each employee variable. Add all employee
		 * objects to the arraylist and then remove any that are over 35 from 01.01.2022
		 */
		try {
			BufferedReader br = new BufferedReader(new FileReader("employees.csv"));
			String header = br.readLine();

			while ((space = br.readLine()) != null) {
				String[] temp = space.split(",");
				int id = Integer.parseInt(temp[0]);
				String prefix = temp[1], name = temp[2], surname = temp[4], email = temp[6], date = temp[10];
				char gender = temp[5].charAt(0);
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/dd/yyyy", Locale.ENGLISH);
				LocalDate dob = LocalDate.parse(date, formatter);
				LocalDate startDate = LocalDate.of(2022, 01, 01);
				int age = Period.between(dob, LocalDate.now()).getYears();
				employees.add(new Employee(id, prefix, name, surname, gender, email, dob, age));
				employees.removeIf(e -> (e.getAgeOnNewYears() >= 35));
			}
			/*
			 * Call sort names for the employees arraylist. Convert the sorted arraylist to
			 * JSONarray. Write JSONarray to JSON file. Close buffered reader.
			 */
			sortNames(employees);
			JSONArray jsArray = new JSONArray(employees);
			jsonFile(jsArray);
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/*
	 * method using collections comparator to first compare surnames of remaining
	 * employees and to sort A->Z. Once this is complete then compare first names
	 * for sorting but maintaining the surname sort
	 */
	public static void sortNames(ArrayList<Employee> sortedList) {
		Collections.sort(sortedList, new Comparator<Employee>() {
			public int compare(Employee e1, Employee e2) {
				int res = e1.getSurname().compareToIgnoreCase(e2.getSurname());
				if (res != 0)
					return res;
				return e1.getName().compareToIgnoreCase(e2.getName());
			}

		});
	}
	/*
	 * Method to take in a JSONarray, write it to a .json file and create the file
	 * named employees.json
	 */

	public void jsonFile(JSONArray jsArray) {
		try (FileWriter file = new FileWriter("employees.json")) {
			file.write(jsArray.toString());
			file.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}