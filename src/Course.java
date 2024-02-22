import java.util.ArrayList;
import java.util.UUID;

public class Course{

    private UUID id;
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
     Semester semester, String description, ArrayList<PrereqOptions> prerequisites,
     ArrayList<Course> corequisisteList, int creditHours, char passingGrade){

    }
    public Course(UUID id, String courseName, String courseID, String requirement, 
    Semester semester, String description, ArrayList<PrereqOptions> prerequisites, 
    ArrayList<Course> corequisisteList, int creditHours, char passingGrade){

    }
    public String viewCourseDetails(String courseID){
        String ret;
        return ret;
    }
    public ArrayList<PrereqOptions> printPrerequisites(Course course){
        return this.course.prerequisites;
    } 
}