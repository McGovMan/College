import org.joda.time.DateTime;
import ie.mcgov.ct417.Course;
import ie.mcgov.ct417.Student;
import ie.mcgov.ct417.Module;
import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        // Create testing data
        // Create test students
        Student s1 = new Student(18123456, "Conor Mc Govern", DateTime.parse("2000-03-13"));
        Student s2 = new Student(18123457, "Joe Kelly", DateTime.parse("2001-03-13"));
        Student s3 = new Student(18123458, "Shane Brennan", DateTime.parse("1999-03-13"));
        ArrayList<Student> students = new ArrayList<Student>(List.of(s1, s2, s3));
        // Create test modules
        Module m1 = new Module("Software Engineering", "CT417");
        Module m2 = new Module("Machine Learning", "CT4101");
        Module m3 = new Module("Professional Skills", "CT436");
        ArrayList<Module> modules = new ArrayList<Module>(List.of(m1, m2, m3));
        // Create test courses
        Course c1 = new Course("CSIT", new ArrayList<>(), new ArrayList<>(), DateTime.parse("2020-09-01"), DateTime.parse("2021-04-30"));
        Course c2 = new Course("BIS", new ArrayList<>(), new ArrayList<>(), DateTime.parse("2020-09-01"), DateTime.parse("2021-04-30"));
        Course c3 = new Course("ENG", new ArrayList<>(), new ArrayList<>(), DateTime.parse("2020-09-01"), DateTime.parse("2021-04-30"));
        ArrayList<Course> courses = new ArrayList<Course>(List.of(c1, c2, c3));

        // Add courses and modules for each student
        s1.setCourses(new ArrayList<Course>(List.of(c1, c2)));
        s2.setCourses(new ArrayList<Course>(List.of(c2, c3)));
        s3.setCourses(new ArrayList<Course>(List.of(c1, c3)));
        s1.setModules(new ArrayList<Module>(List.of(m1, m2)));
        s2.setModules(new ArrayList<Module>(List.of(m2, m3)));
        s3.setModules(new ArrayList<Module>(List.of(m1, m3)));

        // Add students and courses for each module
        m1.setStudents(new ArrayList<Student>(List.of(s1, s3)));
        m2.setStudents(new ArrayList<Student>(List.of(s1, s2)));
        m3.setStudents(new ArrayList<Student>(List.of(s2, s3)));
        m1.setCourses(new ArrayList<Course>(List.of(c1, c2)));
        m2.setCourses(new ArrayList<Course>(List.of(c2, c3)));
        m3.setCourses(new ArrayList<Course>(List.of(c1, c3)));

        // Add students and modules for each course
        c1.setStudents(new ArrayList<Student>(List.of(s1, s3)));
        c2.setStudents(new ArrayList<Student>(List.of(s1, s2)));
        c3.setStudents(new ArrayList<Student>(List.of(s2, s3)));
        c1.setModules(new ArrayList<Module>(List.of(m1, m3)));
        c2.setModules(new ArrayList<Module>(List.of(m1, m2)));
        c3.setModules(new ArrayList<Module>(List.of(m2, m3)));

        // Print out the student data, their associated courses and modules
        System.out.println("--| Student Data |--");
        for(Student s: students) {
            System.out.println("Name: " + s.getName());
            System.out.println("Age: " + s.getAge());
            System.out.println("DOB: " + s.getDob().toString("yyyy-MM-dd"));
            System.out.println("ID: " + s.getID());
            System.out.println("Username: " + s.getUsername());
            System.out.println("Courses: ");
            for(Course c: s.getCourses()) {
                System.out.println("  " + c.getName());
            }
            System.out.println("Modules: ");
            for(Module m: s.getModules()) {
                System.out.println("  " + m.getName());
            }
            System.out.println("");
        }

        // Print out the module data, their associated courses and students
        System.out.println("--| Module Data |--");
        for(Module m: modules) {
            System.out.println("Name: " + m.getName());
            System.out.println("ID: " + m.getID());
            System.out.println("Courses: ");
            for(Course c: m.getCourses()) {
                System.out.println("  " + c.getName());
            }
            System.out.println("Students: ");
            for(Student s: m.getStudents()) {
                System.out.println("  " + s.getName());
            }
            System.out.println("");
        }

        // Print out the course data, their associated modules and students
        System.out.println("--| Course Data |--");
        for(Course c: courses) {
            System.out.println("Name: " + c.getName());
            System.out.println("Modules: ");
            for(Module m: c.getModules()) {
                System.out.println("\t" + m.getName());
            }
            System.out.println("Students: ");
            for(Student s: c.getStudents()) {
                System.out.println("\t" + s.getName());
            }
            System.out.println("Start date: " + c.getStartDate().toString("yyyy-MM-dd"));
            System.out.println("End date: " + c.getEndDate().toString("yyyy-MM-dd"));
            System.out.println("");
        }
    }
}
