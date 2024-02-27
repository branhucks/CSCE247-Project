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
        checkComplete();
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
        checkComplete();
    }
    
    public void setCourseID(String courseID) {
        this.courseID = courseID;
        checkComplete();
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
        checkComplete();
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
        checkComplete();
    }

    public void setDescription(String description) {
        this.description = description;
        checkComplete();
    }

    public void setPrerequisites(ArrayList<PrereqOptions> prerequisites) {
        this.prerequisites = prerequisites;
        checkComplete();
    }

    public void setCorequisites(ArrayList<Course> corequisites) {
        this.corequisites = corequisites;
        checkComplete();
    }

    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
        checkComplete();
    }

    public void setPassingGrade(char passingGrade) {
        this.passingGrade = passingGrade;
        checkComplete();
    }
    
    public void setCompletedClass(boolean completedClass) {
        this.completedClass = completedClass;
    }

    private void checkComplete()
    {
        if (id!=null&&courseName!=null&&courseID!=null&&requirement!=null&&semester!=null&&description!=null&&creditHours!=null&&passingGrade!=null) {
            setCompletedClass(false);
        }
        else 
        {
            setCompletedClass(true);
        }
    }

    public UUID getId() {
        return id;
    }
    public String getCourseName() {
        return courseName;
    }
    public String getCourseID() {
        return courseID;
    } 
    public String getRequirement() {
        return requirement;
    }
    public Semester getSemester() {
        return semester;
    }
    public String getDescription() {
        return description;
    }
    public int getCreditHours() {
        return creditHours;
    }
    public char getPassingGrade() {
        return passingGrade;
    }
    


    public ArrayList<PrereqOptions> printPrerequisites(Course course) {
        return null;
    }

    
    
    public String toString() {
        return "UUID: "+id+"\nCourse Name: "+courseName+"\nCourse ID: "+courseID+"\nRequirement: "+requirement+"\nSemester: "+semester+"\nCourse Description: "+description+"\nCredit Hours: "+creditHours+"\nPassing Grade: "+passingGrade;
    }
}
