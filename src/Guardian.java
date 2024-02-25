public class Guardian extends User {

    private Student student;

    public Guardian(String firstName, String lastName, String username, Student student) {
        super(username, firstName, lastName);
        this.student = student;
    }

    public SemesterPlan viewSemesterPlan() {
        return null;
    }
}
