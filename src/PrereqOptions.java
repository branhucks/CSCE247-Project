import java.util.HashMap;

public class PrereqOptions {
    private HashMap<Course, Integer> course;

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
}