public class Advisor extends User {
    private ArrayList<Student> advisees;

    public Advisor(ArrayList<Student> advisees) {
        super();
        this.advisees = advisees;
    }

    public Student searchStudent(String studentID) {
        return student;
    }

    public ArrayList<Student> viewAdvisees() {
        return students;
    }

    public Student selectStudentProfile(String studentID) {
        return student;
    }

    public void makeNote(Student student String note) {
        
    }

    public void enterGrades(Student student, ArrayList<Course> courses) {

    }
}
