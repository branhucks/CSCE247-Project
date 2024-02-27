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

    public void setId(UUID id) {
        this.id = id;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    
    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrerequisites(ArrayList<PrereqOptions> prerequisites) {
        this.prerequisites = prerequisites;
    }

    public void setCorequisites(ArrayList<Course> corequisites) {
        this.corequisites = corequisites;
    }

    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }

    public void setPassingGrade(char passingGrade) {
        this.passingGrade = passingGrade;
    }

    private boolean checkComplete()
    {
        if (id!=null&&courseName!=null&&courseID!=null&&requirement!=null&&semester!=null&&description!=null&&creditHours!=null&&passingGrade!=null) {
            
        }
    }

    public ArrayList<PrereqOptions> printPrerequisites(Course course) {
        return null;
    }

    public String getCourseID() {
        return courseID;
    } 
    
    public String toString() {
        return "UUID: "+id+"\nCourse Name: "+courseName+"\nCourse ID: "+courseID+"\nRequirement: "+requirement+"\nSemester: "+semester+"\nCourse Description: "+description+"\nCredit Hours: "+creditHours+"\nPassing Grade: "+passingGrade;
    }
}