package ie.mcgov.ct417;

import java.util.ArrayList;

public class Module {

    private String id;                      // E.g. CT417
    private String name;                    // E.g. Software Engineering
    private ArrayList<Student> students;    // List of all enrolled students for this module
    private ArrayList<Course> courses;      // List of all courses that use this module

    public Module() {

    } // end default constructor

    public Module(String id, String name) {
        this.id = id;
        this.name = name;
    } // end constructor

    public Module(String id, String name, ArrayList<Student> students, ArrayList<Course> courses) {
        this.id = id;
        this.name = name;
        this.students = students;
        this.courses = courses;
    } // end constructor

    /* Getter methods */
    public String getId() { return id; }
    public String getName() { return name; }
    public ArrayList<Course> getCourses() { return courses; }
    public ArrayList<Student> getStudents() { return students; }

    /* Setter methods */
    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setStudents(ArrayList<Student> students) { this.students = students; }
    public void addStudent(Student student) { this.students.add(student); }
    public void setCourses(ArrayList<Course> courses) { this.courses = courses; }
    public void addCourse(Course course) { this.courses.add(course); }
}