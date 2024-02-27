import java.util.ArrayList;

public class CourseList {
    private static CourseList courses;
    private ArrayList<Course> courseList;

    private CourseList() {
        courseList = DataLoader.getCourses();
    }

    public static CourseList getInstance() {
        if (courses == null) {
            courses = new CourseList();
        }
        return courses;
    }

    public boolean haveCourse(String courseID) {
        for (Course course : courseList) {
            if (course.getCourseID().equals(courseID)) {
                return true;
            }
        }
        return false;
    }

    public Course getCourse(String courseID) {
        for (Course course : courseList) {
            if (course.getCourseID().equals(courseID)) {
                return course;
            }
        }
        return null;
    }

    public ArrayList<Course> getCourses() {
        return courseList;
    }

    public boolean addCourse(String courseName, String courseID, String requirement,
            int creditHours) {
        if (haveCourse(courseID))
            return false;
        courseList.add(new Course(courseName, courseID, requirement,
                creditHours));
        return true;
    }

    public void saveCourses() {
        DataWriter.saveCourses();
    }
}
