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

    public void addCourse(String subject, String number, int semester) {
        StudentCourse newCourse = new StudentCourse(subject + " " + number, semester, "Planned", 0, false);
        studentCourses.add(newCourse);
    }

    public void removeCourse(String subject, String number) {
        for (StudentCourse course : studentCourses) {
            if (course.getCourseID().equals(subject + " " + number))
                studentCourses.remove(course);
        }
    }

    public void setStudentCourses(ArrayList<StudentCourse> courses) {
        this.studentCourses = courses;
    }

    public ArrayList<StudentCourse> getStudentCourses() {
        return studentCourses;
    }
}
