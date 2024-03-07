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
     * @param courseName     | the name of the course
     * @param courseID       | the course's identifier
     * @param requirement    | the requirement type
     * @param semester       | the semester it is available
     * @param description    | the course's description
     * @param prerequisites  | the course's prerequisites
     * @param corequisites   | the course's corequisites
     * @param creditHours    | credit hours for the course
     * @param passingGrade   | the passing grade for the course
     * @param completedClass | if the class is completed
     * @return | true or false depending on if the course was added successfully
     */
    public boolean addCourse(String courseName, String courseID, String requirement, Semester semester,
            String description,
            ArrayList<PrereqOptions> prerequisites, ArrayList<Course> corequisites, int creditHours, int passingGrade,
            boolean completedClass) {
        if (haveCourse(courseID))
            return false;
        courseList.add(new Course((UUID.randomUUID()).toString(), courseName, courseID, requirement, semester,
                description, prerequisites, corequisites, creditHours, passingGrade, completedClass));
        return true;
    }

    /**
     * Save the courses in the list to the data file
     */
    public void saveCourses() {
        DataWriter.saveCourses();
    }
}
