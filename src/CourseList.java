import java.util.ArrayList;

public class CourseList {
    private static CourseList courses;
    private ArrayList<Course> courseList;

    private CourseList() {

    }

    public static CourseList getInstance() {
        return null;
    }

    public boolean haveCourse(String courseID) {
        return false;
    }

    public User getCourse(String courseID) {
        return null;
    }

    public ArrayList<Course> getCourses() {
        return courseList;
    }

    public boolean addCourse() {
        return true;
    }

    public void saveCourses() {

    }
}
