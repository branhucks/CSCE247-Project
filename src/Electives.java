import java.util.ArrayList;

public class Electives {
    private int credits;
    private ArrayList<Course> electiveCourses;
    
    public Electives(int credits, ArrayList<Course> electiveCourses){

    }

    public ArrayList<Course> listElectives(ElectiveType electiveType){
        return this.electiveCourses;
    }
}
