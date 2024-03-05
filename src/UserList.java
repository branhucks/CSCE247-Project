import java.util.ArrayList;
import java.util.UUID;

/**
 * A UserList class (Singeton Design Pattern)
 * Provides method to access and modify users in the list
 */
public class UserList {
    public static UserList users;
    public ArrayList<Student> students;
    public ArrayList<Advisor> advisors;

    /**
     * Creates a new CourseList instance
     */
    public UserList() {
        students = DataLoader.getStudents();
        advisors = DataLoader.getAdvisors();
    }

    /**
     * Get student by UUID
     * 
     * @param uuid | the student's UUID
     * @return | the student retrived
     */
    public Student getStudentByUUID(String uuid) {
        for (Student student : students) {
            if (student.getUUID().equals(uuid))
                return student;
        }
        return null;
    }

    /**
     * Get advisor by UUID
     * 
     * @param uuid | the advisor's UUID
     * @return | the advisor retrieved
     */
    public Advisor getAdvisorByUUID(String uuid) {
        for (Advisor advisor : advisors) {
            if (advisor.getUUID().equals(uuid))
                return advisor;
        }
        return null;
    }

    /**
     * Gets an instance of the UserList
     * 
     * @return | UserList instance
     */
    public static UserList getInstance() {
        if (users == null) {
            users = new UserList();
        }
        return users;
    }

    /**
     * Validates whether the user exists
     * 
     * @param username | the users's username to search
     * @return | true or false depending on if it exists
     */
    public boolean haveUser(String username) {
        for (Student student : students) {
            if (student.getUsername().equals(username)) {
                return true;
            }
        }
        for (Advisor advisor : advisors) {
            if (advisor.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Get a User by the user's username
     * 
     * @param username | the user's username to search
     * @return | the User object with given username
     */
    public User getUser(String username) {
        for (Student student : students) {
            if (student.getUsername().equals(username)) {
                return student;
            }
        }
        for (Advisor advisor : advisors) {
            if (advisor.getUsername().equals(username)) {
                return advisor;
            }
        }
        return null;
    }

    /**
     * Get all students
     * 
     * @return | list of all students
     */
    public ArrayList<Student> getStudents() {
        return students;
    }

    /**
     * Get all advisors
     * 
     * @return | list of all advisors
     */
    public ArrayList<Advisor> getAdvisors() {
        return advisors;
    }

    /**
     * Adds a User to the list
     * 
     * @param username  | username of the user
     * @param firstName | first name of the user
     * @param lastName  | last name of the user
     * @param userType  | user type of the user
     * @return | true or flase whether it was added successfully
     */
    public boolean addUser(String username, String firstName, String lastName, String userType) {
        if (haveUser(username)) {
            return false;
        }
        if (userType.equalsIgnoreCase("Student")) {
            students.add(new Student((UUID.randomUUID()).toString(), username, firstName, lastName, userType, null,
                    null, null, 0.0, false, 0, null));
        } else if (userType.equalsIgnoreCase("Advisor")) {
            advisors.add(new Advisor((UUID.randomUUID()).toString(), username, firstName, lastName, userType, null));
        }
        return true;
    }

    /**
     * Save the courses in the list to the data file
     */
    public void saveUsers() {
        DataWriter.saveUsers(students, advisors);
    }
}
