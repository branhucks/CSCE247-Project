import java.util.ArrayList;

/**
 * SemesterPlan class
 */
public class SemesterPlan {
    private ArrayList<String> courses;
    private String student;
    private String classYear;
    private String semester;

    /**
     * Creates a new SemesterPlan instance
     * 
     * @param courses | the courses in the semester plan
     */
    public SemesterPlan(ArrayList<String> courses, String student, String classYear, String semester) {
        this.courses = new ArrayList<String>();
        this.student = student;
        this.classYear = classYear;
        this.semester = semester;
    }

    /**
     * Lists all completed courses
     * 
     * @return | a list of completed courses
     */
    public ArrayList<Course> listCompletedCourses() {
        // TODO
        return null;
    }

    /**
     * Lists all in-progress courses
     * 
     * @return | a list of in-progress courses
     */
    public ArrayList<Course> listInProgressCourses() {
        // TODO
        return null;
    }

    /**
     * Lists all incompleted courses
     * 
     * @return | a list of incompleted courses
     */
    public ArrayList<Course> listIncompleteCourses() {
        // TODO
        return null;
    }

    /**
     * View semester plan
     * 
     * @return | a semester plan
     */
    public SemesterPlan viewSemesterPlan() {
        // TODO
        return null;
    }
}
