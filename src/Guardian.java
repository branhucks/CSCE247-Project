public class Guardian extends User {

    private Student student;

    public Guardian(String firstName, String lastName, String username, String userType, Student student) {
        super(username, firstName, lastName, userType);
        this.student = student;
    }

    public SemesterPlan viewSemesterPlan() {
        return null;
    }
}
