/**
 * The abstract class contains constants for JSON file
 */
public abstract class DataConstants {
    // USER
    protected static final String USER_FILE_NAME = "./src/users.json";
    protected static final String USER_ID = "id";
    protected static final String USER_USERNAME = "username";
    protected static final String USER_FIRST_NAME = "firstName";
    protected static final String USER_LAST_NAME = "lastName";
    protected static final String USER_USER_TYPE = "userType";

    // STUDENT
    protected static final String STUDENT_STUDENT_ID = "studentID";
    protected static final String STUDENT_ADVISOR = "advisor";
    protected static final String STUDENT_MAJOR = "major";
    protected static final String STUDENT_CLASS_YEAR = "classYear";

    // ADVISOR
    protected static final String ADVISOR_ADVISEES = "advisees";

    // MAJOR
    protected static final String MAJOR_FILE_NAME = "./src/majors.json";
    protected static final String MAJOR_ID = "id";
    protected static final String MAJOR_MAJOR_NAME = "majorName";
    protected static final String MAJOR_REQUIRED_COURSES = "requiredCourses";
    protected static final String MAJOR_HOURS_NEEDED = "hoursNeeded";

    // COURSE
    protected static final String COURSE_FILE_NAME = "./src/courses.json";
    protected static final String COURSE_ID = "id";
    protected static final String COURSE_COURSE_NAME = "courseName";
    protected static final String COURSE_COURSE_ID = "courseID";
    protected static final String COURSE_REQUIREMENT = "requirement";
    protected static final String COURSE_CREDIT_HOURS = "creditHours";
}
