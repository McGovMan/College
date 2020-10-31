/*
 * Base class Student
 * @author Conor Mc Govern (18343763)
 */

// Java core packages
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Student implements Serializable {

    private Integer id;
    private String name;
    private String address;
    private String course;
    private LocalDate dateOfBirth;
    private List<Grade> grades = new ArrayList<>();
    private static Integer counter = 1;

    // default constructor - used to we can set attributes using setters and not have to set grades
    public Student() {

    }

    // constructor
    public Student(String name, String address, String course, LocalDate dateOfBirth, List<Grade> grades) {
        this.name = name;
        this.address = address;
        this.course = course;
        this.dateOfBirth = dateOfBirth;
        this.grades = grades;
        id = counter;
        counter++;
    }

    /*
     * Name: writeObject
     * Writes all student info to file bar grades
     * @param ObjectOutputStream fos
     * @throws IOException
     * @return ObjectOutputStream
     */
    public void writeObject(ObjectOutputStream oos) {
        try {
            oos.writeInt(id);
            oos.writeUTF(name);
            oos.writeUTF(address);
            oos.writeUTF(course);
            oos.writeUTF(dateOfBirth.toString());
            oos.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /*
     * Name: readObject
     * Reads all student info from file and reads in llines from grade file and passes the line to readObject in Grade to form the object
     * @param ObjectInputStream ois
     * @param BufferedReader gradeReader
     * @throws IOException
     * @return Student
     */
    public static Student readObject(ObjectInputStream ois, BufferedReader gradeReader) throws IOException {
        Student student = new Student();

        student.setID(ois.readInt());
        student.setName(ois.readUTF());
        student.setAddress(ois.readUTF());
        student.setCourse(ois.readUTF());
        student.setDateOfBirth(LocalDate.parse(ois.readUTF()));

        String line = gradeReader.readLine();
        // Read in all grades line by line and check if the UID (student ID) matches the current student ID.
        while (line != null) {
            // If the UID does match the current student ID then read in that line as a Grade Object and add it to this student's list of grades
            if (Integer.parseInt(String.valueOf(line.charAt(0))) == student.getID()) {
                student.appendGrade(Grade.readObject(line));
            }
            // read in next line
            line = gradeReader.readLine();
        }

        return student;
    }

    public void appendGrade(Grade grade) {
        grades.add(grade);
    }

    /*
     * Getter Methods
     */
    // get first name
    public String getName() {
        return name;
    }

    // get address
    public String getAddress() {
        return address;
    }

    // get course
    public String getCourse() {
        return course;
    }

    // get date of birth
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    // get grades
    public List<Grade> getGrades() {
        return grades;
    }

    // get id
    public Integer getID() {
        return id;
    }

    /*
     * Setter Methods
     */
    // set first name
    public void setName(String name) {
        this.name = name;
    }

    // set address
    public void setAddress(String address) {
        this.address = address;
    }

    // set course
    public void setCourse(String course) {
        this.course = course;
    }

    // set date of birth
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    // set grades
    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    // set id
    public void setID(Integer id) {
        this.id = id;
    }

    public String toString() {
        String oGrades = "";
        for (Grade grade : grades) {
            oGrades += grade.toString() + "\t|\t";
        }

        return id + "\t|\t" + name + "\t|\t" + address + "\t|\t" + course + "\t|\t" + dateOfBirth + "\t|\t" + oGrades;
    }
}
