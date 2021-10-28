package ie.mcgov.ct417;

import java.util.ArrayList;
import org.joda.time.DateTime;

public class Course {

    private String name;                    // e.g. CS & IT or ECE
    private ArrayList<Module> modules;      // course's modules
    private ArrayList<Student> students;    // enrolled students
    private DateTime startDate;             // academic start date
    private DateTime endDate;               // academic end date

    public Course() {

    } // end default constructor

    public Course(String name) {
        this.name = name;
    } // end constructor

    public Course(String name, ArrayList<Student> students, ArrayList<Module> modules, DateTime startDate, DateTime endDate) {
        this.name = name;
        this.students = students;
        this.modules = modules;
        this.startDate = startDate;
        this.endDate = endDate;
    } // end constructor

    /* Getter methods */
    public String getName() { return name; }
    public ArrayList<Module> getModules() { return modules; }
    public ArrayList<Student> getStudents() { return students; }
    public DateTime getEndDate() { return endDate; }
    public DateTime getStartDate() { return startDate; }

    /* Setter methods */
    public void setName(String name) { this.name = name; }
    public void setStudents(ArrayList<Student> students) { this.students = students; }
    public void addStudent(Student student) { this.students.add(student); }
    public void setModules(ArrayList<Module> modules) { this.modules = modules; }
    public void addModule(Module module) { this.modules.add(module); }
    public void setEndDate(DateTime endDate) { this.endDate = endDate; }
    public void setStartDate(DateTime startDate) { this.startDate = startDate; }
}