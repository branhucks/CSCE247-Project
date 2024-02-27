import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class Major {
    private UUID id;
    private String majorName;
    private ArrayList<Course> requiredCourses;
    private ArrayList<Course> finishedCourses;
    private HashMap<ElectiveType, Electives> electiveCourses;
    private ApplicationArea applicationArea;
    private int hoursNeeded;
    private int hoursCompleted;

    public Major(String majorName, ArrayList<Course> requiredCourses, int hoursNeeded) {

    }

    public Major(UUID id, String majorName, ArrayList<Course> requiredCourses, int hoursNeeded) {

    }

    public int getProgress(ArrayList<Course> finishedCourses) {
        return 0;
    }

    public void addCourse() {

    }

    public void editCourse() {

    }

    public void removeCourse() {

    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getMajorName() {
        return majorName;
    }
}
