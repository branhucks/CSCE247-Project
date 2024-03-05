import java.util.ArrayList;

/**
 * The Advisor class represents an advisor in the system.
 */
public class Advisor extends User {
    private String uuid;
    private ArrayList<String> advisees;

    /**
     * Creates a new Advisor instance
     * 
     * @param uuid      | the advisor's uuid
     * @param username  | username of advisor
     * @param firstName | first name of advisor
     * @param lastName  | last name of advisor
     * @param userType  | user type of advisor
     * @param advisees  | list of advisees
     */
    public Advisor(String uuid, String username, String firstName, String lastName, String userType,
            ArrayList<String> advisees) {
        super(uuid, username, firstName, lastName, userType);
        this.advisees = advisees;
    }

    /**
     * Getter for the list of advisees
     * 
     * @return | an ArrayList of students
     */
    public ArrayList<String> getAdvisees() {
        return advisees;
    }

    /**
     * Setter for the list of advisees
     * 
     * @param advisees | list of advisees
     */
    public void setAdvisees(ArrayList<String> advisees) {
        this.advisees = advisees;
    }

    /**
     * Search for a student by student ID
     * 
     * @param studentID | the ID to find the student
     * @return | the student found
     */
    public Student searchStudent(String studentID) {
        // TODO
        return null;
    }

    /**
     * View list of advisees
     * 
     * @return | list of advisees
     */
    public ArrayList<String> viewAdvisees() {
        // TODO
        return this.advisees;
    }

    /**
     * Select a student's profile to view
     * 
     * @param studentID | the ID to find the student
     * @return | the student found
     */
    public Student selectStudentProfile(String studentID) {
        // TODO
        return null;
    }

    /**
     * Make a note on the student's account
     * 
     * @param student | the student to write the note to
     * @param note    | the note to send to the student
     */
    public void makeNote(Student student, String note) {
        // TODO
    }

    /**
     * Enter grades for a student's course(s)
     * 
     * @param student | the student to enter grades for
     * @param courses | the list of courses to enter grades
     */
    public void enterGrades(Student student, ArrayList<Course> courses) {
        // TODO
    }

    /*
     * public void addStudent(String studentID) {
     * for(Student s : advisees) {
     * if(this.searchStudent(s.getStudentID()) != null)
     * this.advisees.add(studentID);
     * }
     * }
     */ // WORK IN PROGRESS
}
