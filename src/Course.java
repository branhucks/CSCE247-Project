import java.util.ArrayList;
import java.util.UUID;

public class Course {

    private UUID id;
    private String courseName;
    private String courseID;
    private String requirement;
    private Semester semester;
    private String description;
    private ArrayList<PrereqOptions> prerequisites;
    private ArrayList<Course> corequisites;
    private int creditHours;
    private char passingGrade;
    private boolean completedClass;

    public Course(String courseName, String courseID, String requirement,
            int creditHours) {

    }

    public Course(UUID id, String courseName, String courseID, String requirement,
            int creditHours) {

    }

    public String viewCourseDetails(String courseID) {
        return null;
    }

    public ArrayList<PrereqOptions> printPrerequisites(Course course) {
        return null;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getCourseID() {
        return courseID;
    }
}