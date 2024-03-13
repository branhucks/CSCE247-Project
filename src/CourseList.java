import java.util.ArrayList;
import java.util.UUID;

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
    public CourseList() {
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
     * Get course by UUID
     * 
     * @param uuid | the course's UUID
     * @return | the course retrieved
     */
    public Course getCourseByUUID(String uuid) {
        for (Course course : courseList) {
            if (course.getUUID().equals(uuid))
                return course;
        }
        return null;
    }

    /**
     * Get course by Course ID
     * 
     * @param courseID | the course's course ID
     * @return | the Course retrieved
     */
    public Course getCourseByCourseID(String courseID) {
        for (Course course : courseList) {
            if (course.courseID().equals(courseID)) {
                return course;
            }
        }
        return null;
    }

    /**
     * Validates whether the course exists
     * 
     * @param courseID | the course's ID to search
     * @return | true or false depending on if it exists
     */
    public boolean haveCourse(String courseID) {
        for (Course course : courseList) {
            if (course.courseID().equals(courseID)) {
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
            if (course.courseID().equals(courseID)) {
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
     * @param courseName    | the name of the course
     * @param courseID      | the course's identifier
     * @param requirement   | the requirement type
     * @param semester      | the semester it is available
     * @param prerequisites | the course's prerequisites
     * @param creditHours   | credit hours for the course
     * @param passingGrade  | the passing grade for the course
     * @return | true or false depending on if the course was added successfully
     */
    public boolean addCourse(String courseName, String subject, String number, String semester,
            ArrayList<PrereqOptions> prerequisites, ArrayList<String> corequisites, int creditHours, int passingGrade) {
        if (haveCourse(subject + " " + number))
            return false;
        courseList.add(new Course((UUID.randomUUID()).toString(), courseName, subject, number, semester, prerequisites,
                corequisites, creditHours, passingGrade));
        return true;
    }

    /**
     * Save the courses in the list to the data file
     */
    public void saveCourses() {
        DataWriter.saveCourses();
    }
}
