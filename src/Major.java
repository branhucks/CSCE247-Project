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
        this.majorName = majorName;
        this.requiredCourses = new ArrayList<Course>();
        this.hoursNeeded = hoursNeeded;
    }

    public Major(UUID id, String majorName, ArrayList<Course> requiredCourses, int hoursNeeded) {
        this.id = id;
        this.majorName = majorName;
        this.requiredCourses = new ArrayList<Course>();
        this.hoursNeeded = hoursNeeded;
    }

    //TODO check to see if error
    public int getProgress(ArrayList<Course> finishedCourses) {
        double total = 0;
        for(Course course: finishedCourses)
            total+=course.getCreditHours();
        total = this.hoursCompleted;
        int ret = (int)((total/this.hoursNeeded)*100);
        return ret;
    }

    public void addCourse(Course course) {
        requiredCourses.add(course);
    }

    public void removeCourse(Course course) {
        requiredCourses.remove(course);
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getMajorName() {
        return majorName;
    }
}
