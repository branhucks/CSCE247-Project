/**
 * The abstract class contains constants for JSON file
 */
public abstract class DataConstants {
    // USER
    protected static final String USER_FILE_NAME = "./src/json/users.json";
    protected static final String USER_UUID = "id";
    protected static final String USER_USERNAME = "username";
    protected static final String USER_FIRST_NAME = "firstName";
    protected static final String USER_LAST_NAME = "lastName";
    protected static final String USER_USER_TYPE = "userType";

    // STUDENT
    protected static final String STUDENT_STUDENT_ID = "studentID";
    protected static final String STUDENT_ADVISOR = "advisor";
    protected static final String STUDENT_MAJOR = "major";
    protected static final String STUDENT_CLASS_YEAR = "classYear";
    protected static final String STUDENT_GPA = "gpa";
    protected static final String STUDENT_HAS_SCHOLARSHIP = "hasScholarship";
    protected static final String STUDENT_MAJOR_PROGRESS = "majorProgress";
    protected static final String STUDENT_SEMESTER_PLAN = "semesterPlan";
    protected static final String STUDENT_COMPLETED_COURSES = "completedCourses";
    protected static final String STUDENT_NOTE = "noteFromAdvisor";

    // ADVISOR
    protected static final String ADVISOR_ADVISEES = "advisees";
    protected static final String ADVISOR_DEPARTMENT = "department";

    // MAJOR
    protected static final String MAJOR_FILE_NAME = "./src/json/majors.json";
    protected static final String MAJOR_ID = "id";
    protected static final String MAJOR_MAJOR_NAME = "majorName";
    protected static final String MAJOR_REQUIRED_COURSES = "requiredCourses";
    protected static final String MAJOR_ELECTIVES = "electives";
    protected static final String MAJOR_APPLICATION_AREA = "applicationArea";
    protected static final String MAJOR_CREDITS_REQUIRED = "creditsRequired";

    // COURSE
    protected static final String COURSE_FILE_NAME = "./src/json/courses.json";
    protected static final String COURSE_ID = "id";
    protected static final String COURSE_COURSE_NAME = "courseName";
    protected static final String COURSE_SUBJECT = "subject";
    protected static final String COURSE_NUMBER = "number";
    protected static final String COURSE_SEMESTER = "semester";
    protected static final String COURSE_PREREQUISITES = "prerequisites";
    protected static final String COURSE_COREQUISITES = "corequisites";
    protected static final String COURSE_CREDIT_HOURS = "creditHours";
    protected static final String COURSE_PASSING_GRADE = "passingGrade";
}
