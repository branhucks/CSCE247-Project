import java.util.ArrayList;

/**
 * The Course class represents a course in the system.
 */
public class Course {
    private String uuid;
    private String courseName;
    private String courseID;
    private Semester semester;
    private ArrayList<PrereqOptions> prerequisites;
    private int creditHours;
    private int passingGrade;

    /**
     * Creates a new Course instance
     * 
     * @param courseName    | the name of the course
     * @param courseID      | the course's identifier
     * @param requirement   | the requirement type
     * @param semester      | the semester it is available
     * @param description   | the course's description
     * @param prerequisites | the course's prerequisites
     * @param corequisites  | the course's corequisites
     * @param creditHours   | credit hours for the course
     * @param passingGrade  | the passing grade for the course
     */
    public Course(String courseName, String courseID, Semester semester,
            ArrayList<PrereqOptions> prerequisites, int creditHours, int passingGrade) {
        this.courseName = courseName;
        this.courseID = courseID;
        this.semester = semester;
        this.prerequisites = new ArrayList<PrereqOptions>();
        this.creditHours = creditHours;
        this.passingGrade = passingGrade;
    }

    /**
     * Creates a new Course instance (OVERLOADED)
     * 
     * @param uuid          | the course's UUID
     * @param courseName
     * @param courseID
     * @param semester
     * @param prerequisites
     * @param creditHours
     * @param passingGrade
     */
    public Course(String uuid, String courseName, String courseID, Semester semester,
            ArrayList<PrereqOptions> prerequisites, int creditHours, int passingGrade) {
        this.uuid = uuid;
        this.courseName = courseName;
        this.courseID = courseID;
        this.semester = semester;
        this.prerequisites = new ArrayList<PrereqOptions>();
        this.creditHours = creditHours;
        this.passingGrade = passingGrade;
    }

    // Getters and Setters
    public Course getCourse() {
        return this;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public void setPrerequisites(ArrayList<PrereqOptions> prerequisites) {
        this.prerequisites = prerequisites;
    }

    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }

    public void setPassingGrade(char passingGrade) {
        this.passingGrade = passingGrade;
    }

    public String getUUID() {
        return uuid;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseID() {
        return courseID;
    }

    public Semester getSemester() {
        return semester;
    }

    public ArrayList<PrereqOptions> getPrerequisites() {
        return prerequisites;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public int getPassingGrade() {
        return passingGrade;
    }

    /**
     * Prints all required prerequisites
     * 
     * @param course | the course to be identified
     * @return | a list of prerequisites
     */
    public ArrayList<PrereqOptions> printPrerequisites(Course course) {
        return null;
    }

    /**
     * Display the course's information
     * 
     * @return | a String representation of the course's information
     */
    public String toString() {
        return "UUID: " + uuid + "\nCourse Name: " + courseName + "\nCourse ID: " + courseID + "\nSemester: " + semester
                + "\nCredit Hours: " + creditHours + "\nPassing Grade: " + passingGrade;
    }
}