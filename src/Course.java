import java.util.ArrayList;
import java.util.UUID;

/**
 * The Course class represents a course in the system.
 */
public class Course {
    private UUID id;
    private String courseName;
    private String courseID;
    private String requirement;
    private Semester semester;
    private String description;
    private ArrayList<PrereqOptions> prerequisites;
    private ArrayList<Course> corequisites;
    private int creditHours;
    private int passingGrade;
    private boolean completedClass;

    /**
     * Creates a new Course instance
     * 
     * @param courseName     | the name of the course
     * @param courseID       | the course's identifier
     * @param requirement    | the requirement type
     * @param semester       | the semester it is available
     * @param description    | the course's description
     * @param prerequisites  | the course's prerequisites
     * @param corequisites   | the course's corequisites
     * @param creditHours    | credit hours for the course
     * @param passingGrade   | the passing grade for the course
     * @param completedClass | if the class is completed
     */
    public Course(String courseName, String courseID, String requirement, Semester semester, String description,
            ArrayList<PrereqOptions> prerequisites, ArrayList<Course> corequisites, int creditHours, int passingGrade,
            boolean completedClass) {
        this.courseName = courseName;
        this.courseID = courseID;
        this.requirement = requirement;
        this.semester = semester;
        this.description = description;
        this.prerequisites = prerequisites;
        this.corequisites = corequisites;
        this.creditHours = creditHours;
        this.passingGrade = passingGrade;
        this.completedClass = completedClass;
    }

    /**
     * Creates a new Course instance (OVERLOADED)
     * 
     * @param id             | the course's UUID
     * @param courseName
     * @param courseID
     * @param requirement
     * @param semester
     * @param description
     * @param prerequisites
     * @param corequisites
     * @param creditHours
     * @param passingGrade
     * @param completedClass
     */
    public Course(UUID id, String courseName, String courseID, String requirement, Semester semester,
            String description,
            ArrayList<PrereqOptions> prerequisites, ArrayList<Course> corequisites, int creditHours, int passingGrade,
            boolean completedClass) {
        this.id = id;
        this.courseName = courseName;
        this.courseID = courseID;
        this.requirement = requirement;
        this.semester = semester;
        this.description = description;
        this.prerequisites = prerequisites;
        this.corequisites = corequisites;
        this.creditHours = creditHours;
        this.passingGrade = passingGrade;
        this.completedClass = completedClass;
    }

    // Getters and Setters
    public Course getCourse() {
        return this;
    }

    public void setID(UUID id) {
        this.id = id;
        checkComplete();
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
        checkComplete();
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
        checkComplete();
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
        checkComplete();
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
        checkComplete();
    }

    public void setDescription(String description) {
        this.description = description;
        checkComplete();
    }

    public void setPrerequisites(ArrayList<PrereqOptions> prerequisites) {
        this.prerequisites = prerequisites;
        checkComplete();
    }

    public void setCorequisites(ArrayList<Course> corequisites) {
        this.corequisites = corequisites;
        checkComplete();
    }

    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
        checkComplete();
    }

    public void setPassingGrade(char passingGrade) {
        this.passingGrade = passingGrade;
        checkComplete();
    }

    public void setCompletedClass(boolean completedClass) {
        this.completedClass = completedClass;
    }

    public UUID getID() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseID() {
        return courseID;
    }

    public String getRequirement() {
        return requirement;
    }

    public Semester getSemester() {
        return semester;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<PrereqOptions> getPrerequisites() {
        return prerequisites;
    }

    public ArrayList<Course> getCorequisites() {
        return corequisites;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public int getPassingGrade() {
        return passingGrade;
    }

    public boolean getCompletedClass() {
        return completedClass;
    }

    /**
     * Checks if the course has been completed
     */
    private void checkComplete() {
        if (id != null && courseName != null && courseID != null && requirement != null && semester != null
                && description != null && creditHours != 0 && passingGrade != ' ') {
            setCompletedClass(false);
        } else {
            setCompletedClass(true);
        }
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
        return "UUID: " + id + "\nCourse Name: " + courseName + "\nCourse ID: " + courseID + "\nRequirement: "
                + requirement + "\nSemester: " + semester + "\nCourse Description: " + description + "\nCredit Hours: "
                + creditHours + "\nPassing Grade: " + passingGrade;
    }
}