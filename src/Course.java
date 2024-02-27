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

    public Course(String courseName, String courseID, String requirement, int creditHours) {
        this.courseName = courseName;
        this.courseID = courseID;
        this.requirement = requirement;
        this.creditHours = creditHours;
    }

    public Course(UUID id, String courseName, String courseID, String requirement, int creditHours) {
        this.id = id;
        this.courseName = courseName;
        this.courseID = courseID;
        this.requirement = requirement;
        this.creditHours = creditHours;
    }

    public Course getCourse()
    {
        return this;
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
    
    public String toString() {
        return "UUID: "+id+"\nCourse Name: "+courseName+"\nCourse ID: "+courseID+"\nRequirement: "+requirement+"\nSemester: "+semester+"\nCourse Description: "+description+"\nCredit Hours: "+creditHours+"\nPassing Grade: "+passingGrade;
    }
}