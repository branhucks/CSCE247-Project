import java.util.ArrayList;
import java.util.HashMap;

public class FACADE {
    private User user;
    private Student student;
    private Advisor advisor;
    private UserList userList;
    private CourseList courseList;
    private MajorList majorList;

    /**
     * Initializes the JSON instances
     */
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

    public Major getMajorByUUID(String UUID) {
        return this.majorList.getMajorByUUID(UUID);
    }

    public Course getCourseByUUID(String UUID){
        return this.courseList.getCourseByUUID(UUID);
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
        System.out.println("Logging out...");
        userList.saveUsers();
        majorList.saveMajors();
        courseList.saveCourses();
    }

    /**
     * Saves users to the system
     */
    public void saveUsers() {
        userList.saveUsers();
    }

    /**
     * Register an advisor to the system
     * 
     * @param username   | the username of the advisor
     * @param firstName  | the first name of the advisor
     * @param lastName   | the last name of the advisor
     * @param userType   | the type of user
     * @param department | the department the advisor works for
     * @return | true or false depending on if the advisor was successfully added
     */
    public boolean registerAdvisor(String username, String firstName, String lastName, String userType,
            String department) {
        return userList.addAdvisor(username, firstName, lastName, userType, department);
    }

    /**
     * Register an student to the system
     * 
     * @param username  | the username of the student
     * @param firstName | the first name of the student
     * @param lastName  | the last name of the student
     * @param userType  | the type of user
     * @return | true or false depending on if the advisor was successfully added
     */
    public boolean registerStudent(String username, String firstName, String lastName, String userType,
            String major, String classYear) {
        return userList.addStudent(username, firstName, lastName, userType, major, classYear);
    }

    /**
     * Adds a Course to the system
     * 
     * @param courseName     | the course's name
     * @param courseID       | the course's ID
     * @param requirement    | the type of requirement of the course
     * @param semester       | the course's semester availability
     * @param description    | the description of the course
     * @param prerequisites  | the course's prerequisites
     * @param corequisites   | the course's corequisites
     * @param creditHours    | the amount of credit hours of the course
     * @param passingGrade   | the passing grade of the course
     * @param completedClass | if the course has been completed
     * @return | true or false depending on if the course was successfully added
     */
    public boolean addCourse(String courseName, String subject, String number, String semester,
            ArrayList<PrereqOptions> prerequisites, ArrayList<String> corequisites, int creditHours, int passingGrade) {
        return courseList.addCourse(courseName, subject, number, semester, prerequisites, corequisites, creditHours,
                passingGrade);
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
            ArrayList<Electives> electives, ApplicationArea applicationArea,
            int creditsRequired) {
        return majorList.addMajor(majorName, requiredCourses, electives, applicationArea, creditsRequired);
    }

    /**
     * Gets all of the majors
     * 
     * @return | a list of majors
     */
    public ArrayList<Major> getAllMajors() {
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
     * Gets the courses the student has selected
     * 
     * @return | a list of courses
     */
    public ArrayList<String> getStudentCourses() {
        String studentMajorUUID = student.getMajor();
        Major studentsMajor = majorList.getMajorByUUID(studentMajorUUID);
        return studentsMajor.getRequiredCourses();
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
        return student.getEightSemesterPlan();
    }

    /**
     * Creates a transcript of the student's data
     */
    public void printEightSemesterPlan() {
        student.printEightSemesterPlan();
    }

    /**
     * List all students in the Advisor's advisees list
     */
    public void listAdvisees() {
        for (String studentUUID : advisor.getAdvisees()) {
            Student student = userList.getStudentByUUID(studentUUID);
            System.out.println("Name: " + student.getFirstName() + " " + student.getLastName() + " StudentID: "
                    + student.getStudentID());
        }
    }

    /**
     * Add a student by student ID to the Advisor's list of advisees
     * 
     * @param studentID | the student's ID to be added
     */
    public void addAdvisee(String studentID) {
        String studentUUID = userList.getStudentUUIDByStudentID(studentID);
        advisor.addAdvisee(studentUUID);
        for (Student student : userList.getStudents()) {
            if (advisor.getAdvisees().contains(student.getUUID())) {
                student.setAdvisor(advisor.getUUID());
            }
        }
    }

    /**
     * Makes a note to the student
     * 
     * @param studentID | the student to write the note
     */
    public void makeNote(String studentID, String note) {
        Student student = userList.getStudentByStudentID(studentID);
        student.setNoteFromAdvisor(note);

    }

    /**
     * Views the note from the advisor
     * 
     * @return | a string representation of the note from the advisor
     */
    public String viewNote() {
        return student.getNoteFromAdvisor();
    }

}
