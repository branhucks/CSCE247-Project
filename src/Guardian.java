public class Guardian extends User{

    private Student student;

    public Guardian(Student student, String firstName, String lastName, String username, String password)
    {
        super(firstName, lastName, username, password);
        this.student = student;
    }

    public SemesterPlan viewSemesterPlan()
    {
        return SemesterPlan;
    }
}
