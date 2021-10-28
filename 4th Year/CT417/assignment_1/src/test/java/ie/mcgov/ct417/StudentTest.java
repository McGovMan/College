package ie.mcgov.ct417;

import org.joda.time.DateTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentTest {
    Student s;

    public StudentTest() {
        s = new Student(18123456, "Conor Mc Govern", DateTime.parse("2000-03-13"));
    }

    @DisplayName("Test Student.getUsername()")
    @Test
    void testGetUsername() {
        assertEquals("conor_mc_govern_21", s.getUsername());
    }

}