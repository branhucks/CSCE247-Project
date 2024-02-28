/**
 * The Admin class represents an admin in the system.
 */
public class Admin extends User {

    /**
     * Creates a new Admin instance
     * 
     * @param username  | username of admin
     * @param firstName | first name of admin
     * @param lastName  | last name of admin
     * @param userType  | user type of admin
     */
    public Admin(String username, String firstName, String lastName, String userType) {
        super(username, firstName, lastName, userType);
    }

    /**
     * Adds student information to existing student account
     */
    public void addStudentInformation() {

    }

    /**
     * Removes a student from the system
     * 
     * @param student | the student to remove
     */
    public void removeStudent(Student student) {

    }

    /**
     * Grants access to guardian to view student information
     * 
     * @param guardian | the guardian to grant access to
     * @param student  | the student of the guardian
     */
    public void grantAccess(Guardian guardian, Student student) {

    }

    /**
     * Flags the user if they are at risk of failure
     * 
     * @param student | the student to be flagged
     * @param warning | the warning message
     */
    public void flagUser(Student student, String warning) {

    }

    /**
     * Registers a new user into the system
     * 
     * @param firstName | first name of new user
     * @param lastName  | last name of new user
     * @param password  | password of new user
     * @return | the new user
     */
    public User registerUser(String firstName, String lastName, String password) {
        return null;
    }
}
