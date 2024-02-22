public class FACADE {
    private User user;
    private UserList userList;
    private CourseList courseList;
    private MajorList majorList;
    private Course course;
    private SemesterPlan semesterPlan;

    FACADE() {

    }

    public User login(String username, String password) {
        return user;
    }

    public void logout() {

    }

    public User registerUser(String firstName, String lastName, String username, String password) {
        return user;
    }

    public CourseList getCourseList() {
        return courseList;
    }

    public UserList getUseList() {
        return userList;
    }

    public MajorList getMajorList() {
        return majorList;
    }

    public SemesterPlan viewSemesterPlan() {
        return semesterPlan;
    }

    public Student searchStudent(String studentID) {
        return Student;
    }

    public String viewCourseDetails(String courseID) {
        return "Course";
    }

    public Course findCourse(String courseID) {
        return course;
    }

    public SemesterPlan createSemesterPlan(ArrayList<Course>) {
        return semesterPlan;
    }

    public String makeNote(Student student) {
        return "note";
    }

    public SemesterPlan viewWhatIf(Major major) {
        return semesterPlan;
    }

    public void viewMajorProgression() {

    }

    public void printTranscript() {

    }

    public ArrayList<Course> selectCourses() {
        return courses;
    }

    public ArrayList<Student> viewAdvisees() {
        return advisees;
    }

    public void enterGrades(Student student, ArrayList<Course> courses) {

    }

    public ArrayList<Course> viewCompletedCourses() {
        return courses;
    }

    public ArrayList<Course> viewInProgressCourses() {
        return courses;
    }

    public ArrayList<Course> viewIncompleteCourses() {
        return courses;
    }

    public ArrayList<PrereqOptions> viewPrerequisites() {
        return prerequisites;
    }

    public Student selectStudentProfile(String studentID) {
        return student;
    }

    public boolean riskOfFailure(int gpa) {
        if (gpa > 3.0)
            return false;
        else
            return true;
    }

}
