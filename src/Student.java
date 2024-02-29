import java.util.ArrayList;

/**
 * The Student class represents a student in the system
 */
public class Student extends User {
    private Year classYear;
    private Advisor advisor;
    private double gpa;
    private Major major;
    private String studentID;
    private boolean hasScholarship;
    private int majorProgress;
    private SemesterPlan semesterPlan;

    /**
     * Creates a new Student instance
     * 
     * @param username       | username of the student
     * @param firstName      | first name of the student
     * @param lastName       | last name of the student
     * @param userType       | user type of the student
     * @param studentID      | student's ID
     * @param advisor        | the student's advisor
     * @param major          | the student's major
     * @param classYear      | the student's year
     * @param gpa            | the student's gpa
     * @param hasScholarship | whether the student has a scholarship or not
     * @param majorProgress  | the student's major progress
     * @param semesterPlan   | the student's semester plan
     */
    public Student(String username, String firstName, String lastName, String userType, String studentID,
            Advisor advisor, Major major, Year classYear, double gpa, boolean hasScholarship, int majorProgress,
            SemesterPlan semesterPlan) {
        super(username, firstName, lastName, userType);
        this.studentID = studentID;
        this.advisor = advisor;
        this.major = major;
        this.classYear = classYear;
        this.gpa = gpa;
        this.hasScholarship = hasScholarship;
        this.majorProgress = majorProgress;
        this.semesterPlan = semesterPlan;
    }

    // Getters and Setters
    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public Advisor getAdvisor() {
        return advisor;
    }

    public void setAdvisor(Advisor advisor) {
        if (advisor == null) {
            this.advisor = null;
        }
        this.advisor = advisor;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        if (major == null) {
            this.major = null;
        }
        this.major = major;
    }

    public Year getClassYear() {
        return classYear;
    }

    public void setClassYear(Year classYear) {
        this.classYear = classYear;
    }

    public double getGPA() {
        return gpa;
    }

    public void setGPA(double gpa) {
        this.gpa = gpa;
    }

    public boolean getHasScholarship() {
        return hasScholarship;
    }

    public void setHasScholarship(boolean hasScholarship) {
        this.hasScholarship = hasScholarship;
    }

    public int getMajorProgress() {
        return majorProgress;
    }

    public void setMajorProgress(int majorProgress) {
        this.majorProgress = majorProgress;
    }

    public SemesterPlan getSemesterPlan() {
        return semesterPlan;
    }

    public void setSemesterPlan(SemesterPlan semesterPlan) {
        this.semesterPlan = semesterPlan;
    }

    /**
     * Creates an eight semester plan
     * 
     * @param courses | the courses to create the plan from
     * @return | an eight semester plan
     */
    public SemesterPlan createSemesterPlan(ArrayList<Course> courses) {
        // TODO
        return null;
    }

    /**
     * View the eight semester plan
     * 
     * @return | an eight semester plan
     */
    public SemesterPlan viewSemesterPlan() {
        // TODO
        return null;
    }

    /**
     * View a "What-if" of a major change
     * 
     * @param major | the major to be changed to
     * @return | an eight semester plan
     */
    public SemesterPlan viewWhatIf(Major major) {
        // TODO
        return null;
    }

    /**
     * Select the courses for the plan
     * 
     * @return | a list of courses
     */
    public ArrayList<Course> selectCourses() {
        // TODO
        return null;
    }

    /**
     * Prints a copy of the transcript
     */
    public void printTranscript() {
        // TODO
    }

    /**
     * View the student's major progression
     */
    public void viewMajorProgression() {
        // TODO
    }

    /**
     * Find a course by its ID
     * 
     * @param courseID | the course's ID to be searched
     * @return | a course
     */
    public Course findCourse(String courseID) {
        // TODO
        return null;
    }

    /**
     * Views the details of a course
     * 
     * @param courseID | the course's ID to be searched
     * @return | a course
     */
    public Course viewCourseDetails(String courseID) {
        // TODO
        return null;
    }

    /**
     * View all completed courses
     * 
     * @return | a list of completed courses
     */
    public ArrayList<Course> viewCompletedCourses() {
        // TODO
        return null;
    }

    /**
     * View all incompleted courses
     * 
     * @return | a list of incompleted courses
     */
    public ArrayList<Course> viewIncompleteCourses() {
        // Implementation here
        return null;
    }

    /**
     * View all in-progress courses
     * 
     * @return | a list of in-progress courses
     */
    public ArrayList<Course> viewInProgressCourses() {
        // TODO
        return null;
    }

    /**
     * Whether or not the student is at risk of failure
     * 
     * @param gpa | the student's gpa
     * @return | true or false depending on if the student is at risk
     */
    public boolean riskOfFailure(double gpa) {
        // TODO
        return false;
    }
    public void assignAdvisor() {
        
    }
}
