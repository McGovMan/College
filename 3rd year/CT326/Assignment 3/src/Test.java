/*
 * Main
 * @author Conor Mc Govern (18343763)
 */

// Java core packages
import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class Test {

    /*
     * Name: main
     * This is the entry point for the program. This function will call other functions such as writeTest and readTest.
     * @param args can be used to pass arguments in via the command line
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //System.in is a standard input stream.

        System.out.println("Would you like to do the write or read test? write/read");
        System.out.print("Input: ");

        String input = sc.nextLine();

        if (input.equals("write")) {
            writeTest();
        } else if (input.equals("read")) {
            try {
                readTest();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {
            System.out.println("Input invalid - exiting");
        }

        System.exit(0);
    }

    /*
     * Name: writeTest
     * In this function a list of five student objects are made, all students also have a list of 3 grade objects
     * as well as their own respective attributes such as id, name, address, date of birth. Here we take input from the user on where they want files
     * place on their file system and serialise all students objects to the file bar the grade objects attached to them, we instead opt to write the
     * grade objects to a separate file with the student ID as a UID in the format of a CSV file.
     */
    public static void writeTest() {
        Scanner sc = new Scanner(System.in); //System.in is a standard input stream.

        // Take in directory name where user wants the files to be saved
        System.out.println("Please enter the FQPN (Fully Qualified Path Name) of the directory in which you want to save the student and grade file");
        System.out.println("E.g. /home/conor/Documents/CT326/Assignment 3/ - you can amend the directory with or without a trailing slash.");
        System.out.print("Input: ");

        // Add trailing slash if it wasn't appended
        String directory = sc.nextLine();
        if (directory.charAt(directory.length() - 1) != '/') {
            directory += '/';
        }

        // Take in filename where user wants the student data to be saved
        System.out.println("Please enter the filename for which student data will be serialised into");
        System.out.println("E.g. student.bin");
        System.out.print("Input: ");
        String studentFilename = sc.nextLine();

        // Take in filename where user wants the grades to be saved
        System.out.println("Please enter the filename for which grades of students will be saved into as a CSV format");
        System.out.println("E.g. student_grades.csv");
        System.out.print("Input: ");
        String gradeFilename = sc.nextLine();

        // List of students
        List<Student> studentArray = new ArrayList<>();

        // Assigning all test students
        studentArray.add(new Student("John Smith", randomCounty(), randomCourse(), LocalDate.parse("2000-01-08"), generateListOfGrades(3)));
        studentArray.add(new Student("Sue Jones", randomCounty(), randomCourse(), LocalDate.parse("2002-03-13"), generateListOfGrades(3)));
        studentArray.add(new Student("Bob Lewis", randomCounty(), randomCourse(), LocalDate.parse("2001-05-12"), generateListOfGrades(3)));
        studentArray.add(new Student("Kawren Price", randomCounty(), randomCourse(), LocalDate.parse("1999-07-05"), generateListOfGrades(3)));
        studentArray.add(new Student("Tommy Tiernan", randomCounty(), randomCourse(), LocalDate.parse("2002-06-01"), generateListOfGrades(3)));

        /*
         * Loop over each student object and serialise all attributes except for grades into a file.
         * The attribute grades is instead written to a separate file in CSV format
         */
        try {
            FileOutputStream studentfos = new FileOutputStream(directory + studentFilename);
            FileOutputStream gradesfos = new FileOutputStream(directory + gradeFilename);
            ObjectOutputStream oos = new ObjectOutputStream(studentfos);

            for (Student student : studentArray) {
                // Save the student object using object serialisation...
                student.writeObject(oos);

                // Save all grades for student to file in CSV format
                for (Grade grade : student.getGrades()) {
                    grade.writeObject(gradesfos, student.getID());
                }
            }

            // close the files used
            studentfos.close();
            gradesfos.close();

            System.out.println("Information written successfully");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /*
     * Name: readTest
     * In this function we ask the user for the directory and filenames where the grades and student data are saved to; we then import all of that data
     * into their respective Object classes and print out all data to the terminal to show the user that the data has been saved correctly.
     */
    public static void readTest() throws IOException {
        Scanner sc = new Scanner(System.in); //System.in is a standard input stream.

        // Take in directory name where user wants the files to be saved
        System.out.println("Please enter the FQPN (Fully Qualified Path Name) of the directory in which you want to load the student and grade file from");
        System.out.println("E.g. /home/conor/Documents/CT326/Assignment 3/ - you can amend the directory with or without a trailing slash.");
        System.out.print("Input: ");

        // Add trailing slash if it wasn't appended
        String directory = sc.nextLine();
        if (directory.charAt(directory.length() - 1) != '/') {
            directory += '/';
        }

        // Take in filename where user wants the student data to be read from
        System.out.println("Please enter the filename for which student data will be de-serialised from");
        System.out.println("E.g. student.bin");
        System.out.print("Input: ");
        String studentFilename = sc.nextLine();

        // Take in filename where user wants the grades to be read from
        System.out.println("Please enter the filename for which grades of students will be taken");
        System.out.println("E.g. student_grades.csv");
        System.out.print("Input: ");
        String gradeFilename = sc.nextLine();

        // List of students
        List<Student> studentArray = new ArrayList<>();

        FileInputStream fis = new FileInputStream(directory + studentFilename);
        ObjectInputStream ois = new ObjectInputStream(fis);
        // Reading in lines until we hit the end of the file
        while (fis.available() > 0) {
            try {
                BufferedReader gradeReader = new BufferedReader(new FileReader(directory + gradeFilename));

                // Read in the next student object
                Student student = Student.readObject(ois, gradeReader);

                // Add the student to an array of students after all grades for the student has been read in
                studentArray.add(student);
            } catch (IOException ex) {
                // Should never get this far as fis.available should check for EOF unless the wrong file is specified
                ex.printStackTrace();
            }
        }

        // Print out all student and grade details to user
        System.out.println("\nID\t|\tName\t|\tAddress\t|\tCourse\t|\tDate Of Birth\t|\tGrades\t|");
        for (Student student : studentArray) {
            System.out.println(student.toString());
        }
    }

    /*
    * Name: generateListOfGrades
    * Creates a list grades
    * @param Int amountOfGrades The first and only parameter, this dictates how many grades are returns
    * Should throw NullPointerException when amountOfGrades is 0 or NULL but not going to implement as we can't have a try block as a parameter
    * @return List<Grade>
     */
    public static List<Grade> generateListOfGrades(int amountOfGrades) {
        List<Grade> gradeArray = new ArrayList<>();

        for(int i = 0; i < amountOfGrades; i++) {
            gradeArray.add(new Grade(randomModuleCode(), randomLocalDate(100), randomPercentage()));
        }

        return gradeArray;
    }

    /*
     * Name: randomCounty
     * Returns one of our 32 beautiful county's name
     * @return String
     */
    public static String randomCounty() {
        ArrayList<String> counties = new ArrayList<>();

        counties.add("Antrim");
        counties.add("Armagh");
        counties.add("Carlow");
        counties.add("Cavan");
        counties.add("Clare");
        counties.add("Cork");
        counties.add("Derry");
        counties.add("Donegal");
        counties.add("Down");
        counties.add("Dublin");
        counties.add("Fermanagh");
        counties.add("Galway");
        counties.add("Kerry");
        counties.add("Kildare");
        counties.add("Kilkenny");
        counties.add("Laois");
        counties.add("Leitrim");
        counties.add("Limerick");
        counties.add("Longford");
        counties.add("Louth");
        counties.add("Mayo");
        counties.add("Meath");
        counties.add("Monaghan");
        counties.add("Offaly");
        counties.add("Roscommon");
        counties.add("Sligo");
        counties.add("Tipperary");
        counties.add("Tyrone");
        counties.add("Waterford");
        counties.add("Westmeath");
        counties.add("Wexford");
        counties.add("Wicklow");

        Random r = new Random();
        int countyIndex = r.nextInt(32);

        return "Co. " + counties.get(countyIndex);
    }

    /*
     * Name: randomModuleCode
     * Creates string in format XXYYY, X being an uppercase letter and Y being a number between 0-9
     * @return String
     */
    public static String randomModuleCode() {
        Random r = new Random();

        return String.valueOf((char) (r.nextInt(26) + 'A')) +
                (char) (r.nextInt(26) + 'A') +
                (r.nextInt(9)) +
                (r.nextInt(9)) +
                (r.nextInt(9));
    }

    /*
     * Name: randomCourse
     * Creates string in format YXXX, X being an uppercase letter and Y being a number between 0-9
     * @return String
     */
    public static String randomCourse() {
        Random r = new Random();
        String str = "";

        str += r.nextInt(9);
        str += (char)(r.nextInt(26) + 'A');
        str += (char)(r.nextInt(26) + 'A');
        str += (char)(r.nextInt(26) + 'A');

        return str;
    }

    /*
     * Name: randomPercentage
     * Creates percentage but can't have a decimal point as it is of type short, I think this is an oversight in the assignment
     * @return Short
     */
    public static Short randomPercentage() {
        Random r = new Random();

        return (short) (r.nextInt(100));
    }

    /*
     * Name: randomLocalDate
     * Creates a LocalDate that is within a range of [amountOfDays] from today's date
     * @param amountOfDays The first and only parameter, this dictates the range of nextInt
     * Should throw NullPointerException when amountOfDays is 0 or NULL but not going to implement as we can't have a try block as a parameter
     * @return List<Grade>
     */
    public static LocalDate randomLocalDate(int amountOfDays) throws NullPointerException {
        Random r = new Random();

        return LocalDate.now().minusDays(r.nextInt(amountOfDays));
    }
} // end class Test
