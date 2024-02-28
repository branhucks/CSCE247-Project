import java.util.ArrayList;

public class Student extends User {
    private Year classYear;
    private Advisor advisor;
    private double gpa;
    private Major major;
    private String studentID;
    private boolean hasScholarship;
    private int majorProgress;
    private SemesterPlan semesterPlan;

    public Student(String username, String firstName, String lastName, String userType, String studentID,
            Advisor advisor, Major major, Year classYear) {
        super(username, firstName, lastName, userType);
        this.studentID = studentID;
        this.advisor = advisor;
        this.major = major;
        this.classYear = classYear;
    }

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
        this.advisor = advisor;
    }

    public Major getMajor() {
        return major;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public Year getClassYear() {
        return classYear;
    }

    public void setClassYear(Year classYear) {
        this.classYear = classYear;
    }

    public SemesterPlan createSemesterPlan(ArrayList<Course> courses) {
        // TODO
        return null;
    }

    public SemesterPlan viewSemesterPlan() {
        // TODO
        return null;
    }

    public SemesterPlan viewWhatIf(Major major) {
        // TODO
        return null;
    }

    public ArrayList<Course> selectCourses() {
        // TODO
        return null;
    }

    public void printTranscript() {
        // TODO
    }

    public void viewMajorProgression() {
        // TODO
    }

    public boolean setScholarship() {
        // TODO
        return false;
    }

    public Course findCourse(String courseID) {
        // TODO
        return null;
    }

    public Course viewCourseDetails(String courseID) {
        // TODO
        return null;
    }

    public ArrayList<Course> viewCompletedCourses() {
        // TODO
        return null;
    }

    public ArrayList<Course> viewIncompleteCourses() {
        // Implementation here
        return null;
    }

    public ArrayList<Course> viewInProgressCourses() {
        // TODO
        return null;
    }

    public boolean riskOfFailure(double gpa) {
        // TODO
        return false;
    }
}
