import java.util.ArrayList;
import java.util.HashMap;

/**
 * The Major class represents a major in the system.
 * 
 */
public class Major {
    private String uuid;
    private String majorName;
    private ArrayList<String> requiredCourses;
    private ArrayList<Electives> electives;
    private ApplicationArea applicationArea;
    private int creditsRequired;

    /**
     * Creates a new Major instance
     * 
     * @param majorName       | the major's name
     * @param requiredCourses | the major's required courses
     * @param electives       | the list of electives
     * @param applicationArea | the chosen application area
     * @param creditsRequired | the total number of required credits
     */
    public Major(String majorName, ArrayList<String> requiredCourses, ArrayList<Electives> electives,
            ApplicationArea applicationArea,
            int creditsRequired) {
        this.majorName = majorName;
        this.requiredCourses = requiredCourses;
        this.electives = electives;
        this.applicationArea = applicationArea;
        this.creditsRequired = creditsRequired;
    }

    /**
     * Creates a new Major instance (OVERLOADED)
     * 
     * @param uuid            | the major's UUID
     * @param majorName
     * @param requiredCourses
     * @param electives
     * @param applicationArea
     * @param creditsRequired
     */
    public Major(String uuid, String majorName, ArrayList<String> requiredCourses,
            ArrayList<Electives> electives, ApplicationArea applicationArea,
            int creditsRequired) {
        this.uuid = uuid;
        this.majorName = majorName;
        this.requiredCourses = requiredCourses;
        this.electives = electives;
        this.applicationArea = applicationArea;
        this.creditsRequired = creditsRequired;
    }

    /**
     * Adding a course to the major
     * 
     * @param course | the course to be added
     */
    public void addRequiredCourse(String uuid) {
        requiredCourses.add(uuid);
    }

    /**
     * Removing a course from the major
     * 
     * @param course | the course to be removed
     */
    public void removeRequiredCourse(String uuid) {
        requiredCourses.remove(uuid);
    }

    // Getters and Setters
    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getMajorName() {
        return majorName;
    }

    public String getUUID() {
        return this.uuid;
    }

    public ArrayList<String> getRequiredCourses() {
        return this.requiredCourses;
    }

    public void setRequiredCourses(ArrayList<String> requiredCourses) {
        this.requiredCourses = requiredCourses;
    }

    public ArrayList<Electives> getElectives() {
        return this.electives;
    }

    public void setElectives(ArrayList<Electives> electives) {
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
}
