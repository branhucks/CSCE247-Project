import java.util.ArrayList;

/**
 * SemesterPlan class
 */
public class SemesterPlan {
    private ArrayList<StudentCourse> studentCourses;

    /**
     * Creates a new SemesterPlan instance
     * 
     * @param courses | the courses in the semester plan
     */
    public SemesterPlan(ArrayList<StudentCourse> courses) {
        this.studentCourses = courses;
    }

    public void addCourse(String courseID, int semester) {
        StudentCourse newCourse = new StudentCourse(courseID, semester, "Planned", 0, false);
        studentCourses.add(newCourse);
    }

    public void removeCourse(String courseID) {
        for (StudentCourse course : studentCourses) {
            if (course.getCourseID() == courseID)
                studentCourses.remove(course);
        }
    }

    public SemesterPlan getSemesterPlan() {
        return null;
    }

    /**
     * View semester plan
     * 
     * @return | a semester plan
     */
    public String toString() {
        return "";
    }
}
