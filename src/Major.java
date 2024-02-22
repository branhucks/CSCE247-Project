import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class Major {
    private UUID id;
    private ArrayList<Course> requiredCourses;

    private ArrayList<Course> finishedCourses;
    private HashMap<ElectiveType, Electives> electiveCourses; 
    private applicationArea applicationArea;
    private int hoursNeeded;
    private int hoursCompleted;

    public Major(ArrayList<Course> requiredCourses, int hoursNeeded){

    }
    public Major(UUID id, ArrayList<Course> requiredCourses, int hoursNeeded){

    }
    public int getProgress(ArrayList<Courses> finishedCourses){
        return 0;
    } 
    public void addCourse(){

    }
    public void editCourse(){
        
    }
    public void removeCourse(){
        
    }
}
