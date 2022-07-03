Created by Cian Martyn

This is a little program used to take specific rows of data from a CSV file and feed them into an employee object using buffered reader. I got rid of the headers because they often differed from the data type of the rest of the column e.g. emp id is followed then by a column of int. 

I created a string array for each line of data and then converted the data into the correct data type for the employee object. Using an arraylist of Employee, the data for each employee is added to a list. This list is then updated to remove all employees over 35 as of New Year's day 2022 using removeIf and creating a variable to determine age of that date.

I used Comparator for sorting the list first by surname and then by first name, keeping the surname as the main sort method. Comparator allows for the sorting of attributes of an object and also that we can have multiple sort queries.

Final steps were to convert the sorted arraylist into a jsonarray and then add this to a jsonfile.

---------------------------------------------------------------------------------------------------------------------------------------------------

Some improvements that I would make to the program would be:

- Allow for file selection for the input file
- Allow for the json file to be named by the user
- Give the user choice over what employee attributes are selected
- Make the age on new years part a decision on whether its needed or to change the age

----------------------------------------------------------------------------------------------------------------------------------------------------

General Requirements
● Use git for source control and push to a public github repository
● Java 11 or above should be used

Specific Requirements
● Read in the supplied CSV file containing details of 1,000 employees
● Map each record in the file to a Employee Java Object containing only data from the following
columns:
○ Emp ID
○ Name Prefix
○ First Name
○ Last Name
○ Gender
○ E Mail
○ Date of Birth
● The fields in the Employee class should be of an appropriate data type
● There must be an additional field in the Employee class called age, which is calculated from the Date
of Birth, based on the current date
● Produce an output file in JSON format containing only the Employees who were <= 35 years only on
01/01/2022.
● The filtered list of employees should be sorted by Last Name, First Name in the output JSON file
● All fields (including age) from the Employee object should be in the JSON file.

----------------------------------------------------------------------------------------------------------------------------------------------------

References

https://www.w3schools.com/java/java_arraylist.asp
https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html
https://www.programiz.com/java-programming/library/arraylist/removeif
https://howtodoinjava.com/java/library/json-simple-read-write-json-examples/
