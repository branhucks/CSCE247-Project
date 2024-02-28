import java.util.HashMap;
import java.util.ArrayList;

/**
 * PrereqOptions class
 */
public class PrereqOptions {
    private HashMap<Course, Integer> course;

    /**
     * Creates a new PrereqOptions instance
     * 
     * @param course | the prerequisite course
     */
    public PrereqOptions(HashMap<Course, Integer> course) {
        this.course = course;
    }

    // Getter and setter methods for course HashMap
    public HashMap<Course, Integer> getCourse() {
        return course;
    }

    public void setCourse(HashMap<Course, Integer> course) {
        this.course = course;
    }

    public void addPrerequisite(ArrayList<Course> list) {
        for (Course tempCourse : list) {
            this.course.put(tempCourse, tempCourse.getPassingGrade());
        }
    }
}
