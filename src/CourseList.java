import java.util.ArrayList;

/**
 * A CourseList class (Singeton Design Pattern)
 * Provides method to access and modify courses in the list
 */
public class CourseList {
    private static CourseList courses;
    private ArrayList<Course> courseList;

    /**
     * Creates a new CourseList instance
     */
    private CourseList() {
        courseList = DataLoader.getCourses();
    }

    /**
     * Gets an instance of the CourseList
     * 
     * @return | CourseList instance
     */
    public static CourseList getInstance() {
        if (courses == null) {
            courses = new CourseList();
        }
        return courses;
    }

    /**
     * Validates whether the course exists
     * 
     * @param courseID | the course's ID to search
     * @return | true or false depending on if it exists
     */
    public boolean haveCourse(String courseID) {
        for (Course course : courseList) {
            if (course.getCourseID().equals(courseID)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Get a Course by the course's ID
     * 
     * @param courseID | the course's ID to search
     * @return | the Course object with given ID
     */
    public Course getCourse(String courseID) {
        for (Course course : courseList) {
            if (course.getCourseID().equals(courseID)) {
                return course;
            }
        }
        return null;
    }

    /**
     * Get all courses
     * 
     * @return | list of all courses
     */
    public ArrayList<Course> getCourses() {
        return courseList;
    }

    /**
     * Add a Course to the list
     * 
     * @param courseName  | name of the course
     * @param courseID    | the course's ID
     * @param requirement | the course requirement type
     * @param creditHours | the credit hours for the course
     * @return | true or flase whether it was added successfully
     */
    public boolean addCourse(String courseName, String courseID, String requirement,
            int creditHours) {
        if (haveCourse(courseID))
            return false;
        courseList.add(new Course(courseName, courseID, requirement,
                creditHours));
        return true;
    }

    /**
     * Save the courses in the list to the data file
     */
    public void saveCourses() {
        DataWriter.saveCourses();
    }
}
