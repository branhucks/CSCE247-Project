public class Admin extends User {

    public Admin(String username, String firstName, String lastName, String userType) {
        super(username, firstName, lastName, userType);
    }

    public void addStudentInformation() {

    }

    public void removeStudent(Student student) {

    }

    public void grantAccess(Guardian guardian, Student student) {

    }

    public void flagUser(Student student, String warning) {

    }

    public User registerUser(String firstName, String lastName, String password) {
        return null;
    }
}
