/*
 * Main class Grade
 * @author Conor Mc Govern (18343763)
 */

// Java core packages
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.time.LocalDate;

public class Grade {

    private final String moduleCode;
    private final LocalDate date;
    private final Short percentage;

    // constructor
    public Grade(String moduleCode, LocalDate date, Short percentage) {
        this.moduleCode = moduleCode;
        this.date = date;
        this.percentage = percentage;
    }

    /*
     * Name: writeObject
     * Writes student ref and all grade information to file
     * @param FileOutputStream fos
     * @param int id - student ref
     * @throws IOException
     * @return FileOutputStream
     */
    public void writeObject(FileOutputStream fos, int id) throws IOException {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
            bw.write(id + "," + moduleCode + "," + date.toString() + "," + percentage);
            bw.newLine();
            bw.flush();
        } catch (IOException ex) {
            ex.getStackTrace();
        }
    }

    /*
     * Name: readObject
     * Creates a Grade object from CSV line
     * @param String str - a single line of a CSV file
     * @return Grade
     */
    public static Grade readObject(String str) {
        String[] att = str.split(",");

        String moduleCode = att[1];
        LocalDate dateOfBirth = LocalDate.parse(att[2]);
        Short percentage = Short.parseShort(att[3]);

        return new Grade(moduleCode, dateOfBirth, percentage);
    }

    // get module code
    public String getModuleCode() {
        return moduleCode;
    }

    // get date
    public LocalDate getDate() {
        return date;
    }

    // get percentage
    public Short getPercentage() {
        return percentage;
    }

    public String toString() {
        return percentage + "% in " + moduleCode + " on " + date.toString();
    }
}
