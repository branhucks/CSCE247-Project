import java.util.ArrayList;

public class FACADE {
    private User user;
    private UserList userList;
    private CourseList courseList;
    private MajorList majorList;

    FACADE() {
        userList = UserList.getInstance();
        userList.loadAdvisors();
        courseList = CourseList.getInstance();
        majorList = MajorList.getInstance();
    }

    /**
     * Getter for the CourseList
     * 
     * @return | the CourseList
     */
    public CourseList getCourseList() {
        return this.courseList;
    }

    /**
     * Getter for the UserList
     * 
     * @return | the UserList
     */
    public UserList getUserList() {
        return this.userList;
    }

    /**
     * Getter for the MajorList
     * 
     * @return | the MajorList
     */
    public MajorList getMajorList() {
        return this.majorList;
    }

    /**
     * Login to the system with given username
     * 
     * @param username |username of the user logging in
     * @return | true or false depending on if login is successful
     */
    public boolean login(String username) {
        if (!userList.haveUser(username))
            return false;
        user = userList.getUser(username);
        return true;
    }

    /**
     * Logout and save all user objects
     */
    public void logout() {
        userList.saveUsers();
    }

    /**
     * Register a user to the system
     * 
     * @param username  | username of the user
     * @param firstName | first name of the user
     * @param lastName  | last name of the user
     * @param userType  | user type of the user
     * @return | true or false depending on if the user was successfully registered
     */
    public boolean registerUser(String username, String firstName, String lastName, String userType) {
        return userList.addUser(username, firstName, lastName, userType);
    }

    /**
     * Getter for User
     * 
     * @return | a User
     */
    public User getUser() {
        return user;
    }

    /**
     * Get all courses
     * 
     * @return | list of all courses
     */
    public ArrayList<Course> getAllCourses() {
        return this.courseList.getCourses();
    }

    /**
     * Get a course from the list of courses by the course ID
     * 
     * @param courseID | the course's ID to search
     * @return | the course
     */
    public Course getCourseByCode(String courseID) {
        return this.courseList.getCourse(courseID);
    }

    /**
     * Gets the courses the student has selected
     * 
     * @return | a list of courses
     */
    public ArrayList<Course> getStudentCourses() {
        return null;
    }

    /**
     * Gets all of the majors
     * 
     * @return | a list of majors
     */
    public ArrayList<Major> getMajors() {
        return null;
    }

    /**
     * Gets the student's major progress
     * 
     * @return | an integer representation of the user's progress
     */
    public int getStudentProgress() {
        return 0;
    }

    /**
     * Gets the student's eight semester plan
     * 
     * @return | a Semester Plan
     */
    public SemesterPlan getEightSemesterPlan() {
        return null;
    }

    /**
     * Creates a transcript of the student's data
     */
    public void makeTranscript() {

    }

    /*
     * public SemesterPlan viewSemesterPlan() {
     * // TODO
     * return null;
     * }
     * 
     * public Student searchStudent(String studentID) {
     * // TODO
     * return null;
     * }
     * 
     * public String viewCourseDetails(String courseID) {
     * // TODO
     * return null;
     * }
     * 
     * public Course findCourse(String courseID) {
     * // TODO
     * return null;
     * }
     * 
     * public SemesterPlan createSemesterPlan(ArrayList<Course> courses) {
     * // TODO
     * return null;
     * }
     * 
     * public String makeNote(Student student) {
     * // TODO
     * return null;
     * }
     * 
     * public SemesterPlan viewWhatIf(Major major) {
     * // TODO
     * return null;
     * }
     * 
     * public void viewMajorProgression() {
     * // TODO
     * }
     * 
     * public void printTranscript() {
     * // TODO
     * }
     * 
     * public ArrayList<Course> selectCourses() {
     * // TODO
     * return null;
     * }
     * 
     * public ArrayList<Student> viewAdvisees() {
     * // TODO
     * return null;
     * }
     * 
     * public void enterGrades(Student student, ArrayList<Course> courses) {
     * // TODO
     * }
     * 
     * public ArrayList<Course> viewCompletedCourses() {
     * // TODO
     * return null;
     * }
     * 
     * public ArrayList<Course> viewInProgressCourses() {
     * // TODO
     * return null;
     * }
     * 
     * public ArrayList<Course> viewIncompleteCourses() {
     * // TODO
     * return null;
     * }
     * 
     * public ArrayList<PrereqOptions> viewPrerequisites(String courseID) {
     * // TODO
     * return null;
     * }
     * 
     * public Student selectStudentProfile(String studentID) {
     * // TODO
     * return null;
     * }
     * 
     * public boolean riskOfFailure(int gpa) {
     * if (gpa > 3.0)
     * return false;
     * else
     * return true;
     * }
     */

}
