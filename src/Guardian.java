/**
 * The Guardian class represents a guardian in the system.
 * 
 */
public class Guardian extends User {
    private Student student;

    /**
     * Creates a new Guardian instance
     * 
     * @param firstName | first name of guardian
     * @param lastName  | last name of guardian
     * @param username  | username of guardian
     * @param userType  | user type of guardian
     * @param student   | the guardian's student
     */
    public Guardian(String firstName, String lastName, String username, String userType, Student student) {
        super(username, firstName, lastName, userType);
        this.student = student;
    }

    /**
     * View the semester plan of their student
     * 
     * @return | a Semester Plan
     */
    public SemesterPlan viewSemesterPlan() {
        return null;
    }
}
