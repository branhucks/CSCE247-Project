import java.util.ArrayList;
import java.util.HashMap;

public class FACADE {
    private User user;
    private Student student;
    private Advisor advisor;
    private UserList userList;
    private CourseList courseList;
    private MajorList majorList;

    FACADE() {
        userList = UserList.getInstance();
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
     * Getter for User
     * 
     * @return | a User
     */
    public User getUser() {
        return user;
    }

    /**
     * Getter for Student
     * 
     * @return | a Student
     */
    public Student getStudent() {
        return student;
    }

    /**
     * Getter for Advisor
     * 
     * @return | an Advisor
     */
    public Advisor getAdvisor() {
        return advisor;
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
        if (user instanceof Student) {
            student = (Student) user;
        } else if (user instanceof Advisor) {
            advisor = (Advisor) user;
        }
        return true;
    }

    /**
     * Logout and save all user, major, and course objects
     */
    public void logout() {
        userList.saveUsers();
        majorList.saveMajors();
        courseList.saveCourses();
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
     * Get all courses
     * 
     * @return | list of all courses
     */
    public ArrayList<Course> getAllCourses() {
        return this.courseList.getCourses();
    }

    /**
     * Adds a Major to the system
     * 
     * @param majorName       | the name of the major
     * @param requiredCourses | the major's required courses
     * @param electives       | the major's elective courses
     * @param applicationArea | a possible application area
     * @param creditsRequired | total amount of credits
     * @return | true or false depending on if the major was successfully added
     */
    public boolean addMajor(String majorName, ArrayList<String> requiredCourses,
            HashMap<ElectiveType, Electives> electives,
            ApplicationArea applicationArea,
            int creditsRequired) {
        return majorList.addMajor(majorName, requiredCourses, electives, applicationArea, creditsRequired);
    }

    /**
     * Gets all of the majors
     * 
     * @return | a list of majors
     */
    public ArrayList<Major> getMajors() {
        return this.majorList.getMajors();
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
     * NEEDS COMPLETED
     * Gets the courses the student has selected
     * 
     * @return | a list of courses
     */
    public ArrayList<String> getStudentCourses() {
        return null;
    }

    /**
     * Gets the student's major progress
     * 
     * @return | an integer representation of the user's progress
     */
    public int getStudentProgress() {
        return student.getStudentProgress();
    }

    /**
     * Gets the student's eight semester plan
     * 
     * @return | a Semester Plan
     */
    public SemesterPlan getEightSemesterPlan() {
        return student.getSemesterPlan();
    }

    /**
     * Creates a transcript of the student's data
     */
    public void makeTranscript() {
        student.printTranscript();
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
