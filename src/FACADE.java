import java.util.ArrayList;
import java.util.UUID;

public class FACADE {
    private User user;
    private UserList userList;
    private CourseList courseList;
    private MajorList majorList;

    FACADE() {
        userList = UserList.getInstance();
        courseList = CourseList.getInstance();
        majorList = MajorList.getInstance();
    }

    public boolean login(String username) {
        if (!userList.haveUser(username))
            return false;
        user = userList.getUser(username);
        return true;
    }

    public void logout() {
        userList.saveUsers();
    }

    public boolean registerUser(String firstName, String lastName, String username, String password) {
        return userList.addUser(username, firstName, lastName, password);
    }

    public CourseList getCourseList() {
        return this.courseList;
    }

    public UserList getUseList() {
        return this.userList;
    }

    public MajorList getMajorList() {
        return this.majorList;
    }

    public SemesterPlan viewSemesterPlan() {
        // TODO
        return null;
    }

    public Student searchStudent(String studentID) {
        // TODO
        return null;
    }

    public String viewCourseDetails(String courseID) {
        // TODO
        return null;
    }

    public Course findCourse(String courseID) {
        // TODO
        return null;
    }

    public SemesterPlan createSemesterPlan(ArrayList<Course> courses) {
        // TODO
        return null;
    }

    public String makeNote(Student student) {
        // TODO
        return null;
    }

    public SemesterPlan viewWhatIf(Major major) {
        // TODO
        return null;
    }

    public void viewMajorProgression() {
        // TODO
    }

    public void printTranscript() {
        // TODO
    }

    public ArrayList<Course> selectCourses() {
        // TODO
        return null;
    }

    public ArrayList<Student> viewAdvisees() {
        // TODO
        return null;
    }

    public void enterGrades(Student student, ArrayList<Course> courses) {
        // TODO
    }

    public ArrayList<Course> viewCompletedCourses() {
        // TODO
        return null;
    }

    public ArrayList<Course> viewInProgressCourses() {
        // TODO
        return null;
    }

    public ArrayList<Course> viewIncompleteCourses() {
        // TODO
        return null;
    }

    public ArrayList<PrereqOptions> viewPrerequisites(String courseID) {
        // TODO
        return null;
    }

    public Student selectStudentProfile(String studentID) {
        // TODO
        return null;
    }

    public boolean riskOfFailure(int gpa) {
        if (gpa > 3.0)
            return false;
        else
            return true;
    }

}
