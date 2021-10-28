package ie.mcgov.ct417;

import java.util.ArrayList;
import org.joda.time.DateTime;

public class Student{

    private int id;                     // E.g. 18123456
    private String name;                // E.g. Conor Mc Govern
    private DateTime dob;               // Student DOB
    private ArrayList<Course> courses;  // Student's enrolled courses
    private ArrayList<Module> modules;  // Modules for each course enrolled in

    public Student() {

    } // end default constructor

    public Student(int id, String name, DateTime dob) {
        this.id = id;
        this.name = name;
        this.dob = dob;
    } // end constructor

    public Student(int id, String name, short age, DateTime dob, ArrayList<Course> courses, ArrayList<Module> modules) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.courses = courses;
        this.modules = modules;
    } // end constructor

    /* Setter methods */
    public void setID(int id){ this.id = id; }
    public void setName(String name){ this.name = name; }
    public void setDob(DateTime date){ this.dob = date; }
    public void setCourse(Course course){ this.courses.add(course); }
    public void setCourses(ArrayList<Course> courses){ this.courses = courses; }
    public void setModule(Module module){ this.modules.add(module); }
    public void setModules(ArrayList<Module> modules){ this.modules = modules; }

    /* Getter methods */
    public int getID() { return this.id; }
    public String getName() { return this.name; }
    public int getAge() { return DateTime.now().getYear() - this.dob.getYear(); }
    public DateTime getDob() { return this.dob; }
    public String getUsername() { return this.name.toLowerCase().replace(" ", "_") + "_" + this.getAge(); }
    public ArrayList<Course> getCourses() { return this.courses; }
    public ArrayList<Module> getModules() { return this.modules; }
}