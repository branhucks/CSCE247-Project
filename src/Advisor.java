import java.util.ArrayList;
import java.util.UUID;

public class Advisor extends User {
    private ArrayList<Student> advisees;

    public Advisor(ArrayList<Student> advisees) {
        this.advisees = advisees;
    }

    public Student searchStudent(String studentID) {
        // TODO
        return null;
    }

    public ArrayList<Student> viewAdvisees() {
        // TODO
        return this.advisees;
    }

    public Student selectStudentProfile(String studentID) {
        // TODO
        return null;
    }

    public void makeNote(Student student String note) {
        // TODO
    }

    public void enterGrades(Student student, ArrayList<Course> courses) {
        // TODO
    }
}
