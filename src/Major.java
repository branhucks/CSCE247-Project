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
    private HashMap<ElectiveType, Electives> electives;
    private ApplicationArea applicationArea;
    private int creditsRequired;

    /**
     * Creates a new Major instance
     * 
     * @param majorName       | the major's name
     * @param requiredCourses | the major's required courses
     * @param hoursNeeded     | the major's required hours
     */
    public Major(String majorName, ArrayList<Course> requiredCourses, HashMap<ElectiveType, Electives> electives,
            ApplicationArea applicationArea,
            int creditsRequired) {
        this.majorName = majorName;
        this.requiredCourses = new ArrayList<Course>();
        this.electives = new HashMap<ElectiveType, Electives>();
        this.applicationArea = applicationArea;
        this.creditsRequired = creditsRequired;
    }

    /**
     * Creats a new Major instance (OVERLOADED)
     * 
     * @param id              | the major's UUID
     * @param majorName
     * @param requiredCourses
     * @param hoursNeeded
     */
    public Major(UUID id, String majorName, ArrayList<Course> requiredCourses,
            HashMap<ElectiveType, Electives> electives, ApplicationArea applicationArea,
            int creditsRequired) {
        this.id = id;
        this.majorName = majorName;
        this.requiredCourses = new ArrayList<Course>();
        this.electives = new HashMap<ElectiveType, Electives>();
        this.applicationArea = applicationArea;
        this.creditsRequired = creditsRequired;
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

    public HashMap<ElectiveType, Electives> getElectives() {
        return this.electives;
    }

    public void setElectives(HashMap<ElectiveType, Electives> electives) {
        this.electives = electives;
    }

    public ApplicationArea getApplicationArea() {
        return this.applicationArea;
    }

    public void setApplicationArea(ApplicationArea applicationArea) {
        this.applicationArea = applicationArea;
    }

    public int getCreditsRequired() {
        return this.creditsRequired;
    }

    public void setCreditsRequired(int creditsRequired) {
        this.creditsRequired = creditsRequired;
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
        total = this.creditsRequired;
        int ret = (int) ((total / this.creditsRequired) * 100);
        return ret;
    }
}
