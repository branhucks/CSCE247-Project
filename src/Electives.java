import java.util.ArrayList;

/**
 * Electives class
 */
public class Electives {
    private int credits;
    private ArrayList<Course> electiveCourses;

    /**
     * Creates a new instance of Electives
     * 
     * @param credits         | credit hours for each elective
     * @param electiveCourses | the elective courses
     */
    public Electives(int credits, ArrayList<Course> electiveCourses) {

    }

    /**
     * Lists the Elective courses
     * 
     * @param electiveType | the type of elective
     * @return | a list of courses
     */
    public ArrayList<Course> listElectives(ElectiveType electiveType) {
        return this.electiveCourses;
    }
}
