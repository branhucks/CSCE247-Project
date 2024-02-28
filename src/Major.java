import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

/**
 * The Major class represents a major in the system.
 * 
 */
public class Major {
    private UUID id;
    private String majorName;
    private ArrayList<Course> requiredCourses;
    private ArrayList<Course> finishedCourses;
    private HashMap<ElectiveType, Electives> electiveCourses;
    private ApplicationArea applicationArea;
    private int hoursNeeded;
    private int hoursCompleted;

    /**
     * Creates a new Major instance
     * 
     * @param majorName       | the major's name
     * @param requiredCourses | the major's required courses
     * @param hoursNeeded     | the major's required hours
     */
    public Major(String majorName, ArrayList<Course> requiredCourses, int hoursNeeded) {
        this.majorName = majorName;
        this.requiredCourses = new ArrayList<Course>();
        this.hoursNeeded = hoursNeeded;
    }

    /**
     * Creats a new Major instance (OVERLOADED)
     * 
     * @param id              | the major's UUID
     * @param majorName
     * @param requiredCourses
     * @param hoursNeeded
     */
    public Major(UUID id, String majorName, ArrayList<Course> requiredCourses, int hoursNeeded) {
        this.id = id;
        this.majorName = majorName;
        this.requiredCourses = new ArrayList<Course>();
        this.hoursNeeded = hoursNeeded;
    }

    /**
     * Calculates the student's progress within their major
     * 
     * @param finishedCourses | a list of completed courses
     * @return | an integer representation of the progress
     */
    public int getProgress(ArrayList<Course> finishedCourses) {
        double total = 0;
        for (Course course : finishedCourses)
            total += course.getCreditHours();
        total = this.hoursCompleted;
        int ret = (int) ((total / this.hoursNeeded) * 100);
        return ret;
    }

    /**
     * Adding a course to the major
     * 
     * @param course | the course to be added
     */
    public void addCourse(Course course) {
        requiredCourses.add(course);
    }

    /**
     * Removing a course from the major
     * 
     * @param course | the course to be removed
     */
    public void removeCourse(Course course) {
        requiredCourses.remove(course);
    }

    // Getters and Setters
    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getMajorName() {
        return majorName;
    }

    public UUID getID() {
        return this.id;
    }

    public void setID(UUID id) {
        this.id = id;
    }

    public ArrayList<Course> getRequiredCourses() {
        return this.requiredCourses;
    }

    public void setRequiredCourses(ArrayList<Course> requiredCourses) {
        this.requiredCourses = requiredCourses;
    }

    public ArrayList<Course> getFinishedCourses() {
        return this.finishedCourses;
    }

    public void setFinishedCourses(ArrayList<Course> finishedCourses) {
        this.finishedCourses = finishedCourses;
    }

    public HashMap<ElectiveType, Electives> getElectiveCourses() {
        return this.electiveCourses;
    }

    public void setElectiveCourses(HashMap<ElectiveType, Electives> electiveCourses) {
        this.electiveCourses = electiveCourses;
    }

    public ApplicationArea getApplicationArea() {
        return this.applicationArea;
    }

    public void setApplicationArea(ApplicationArea applicationArea) {
        this.applicationArea = applicationArea;
    }

    public int getHoursNeeded() {
        return this.hoursNeeded;
    }

    public void setHoursNeeded(int hoursNeeded) {
        this.hoursNeeded = hoursNeeded;
    }

    public int getHoursCompleted() {
        return this.hoursCompleted;
    }

    public void setHoursCompleted(int hoursCompleted) {
        this.hoursCompleted = hoursCompleted;
    }
}
