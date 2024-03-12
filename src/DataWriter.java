import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * This class is responsible for writing the data to the JSON files.
 * The class is composed of three major methods: saving the list of Students and
 * Advisors to the users JSON file, saving the list of Courses to the courses
 * JSON file, and saving the list of Majors to the majors JSON file.
 */
public class DataWriter extends DataConstants {

    /**
     * Saves the list of users (composed of Students and Advisors) to a JSON file.
     */
    public static void saveUsers(ArrayList<Student> students, ArrayList<Advisor> advisors) {
        JSONArray jsonUsers = new JSONArray();

        // Creation of Objects in JSON
        for (Student student : students) {
            jsonUsers.add(getStudentJSON(student));
        }
        for (Advisor advisor : advisors) {
            jsonUsers.add(getAdvisorJSON(advisor));
        }

        // Write to the JSON file
        try (FileWriter file = new FileWriter(USER_FILE_NAME)) {
            file.write(jsonUsers.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates a JSONObject from the given User object
     * 
     * @param student | the Student object to create the JSONObect from
     * @return | the JSONObject created from the User object
     */
    public static JSONObject getStudentJSON(Student student) {
        JSONObject userDetails = new JSONObject();
        userDetails.put(USER_ID, student.getUUID());
        userDetails.put(USER_USERNAME, student.getUsername());
        userDetails.put(USER_FIRST_NAME, student.getFirstName());
        userDetails.put(USER_LAST_NAME, student.getLastName());
        userDetails.put(USER_USER_TYPE, student.getUserType());
        userDetails.put(STUDENT_STUDENT_ID, student.getStudentID());
        userDetails.put(STUDENT_ADVISOR, student.getAdvisor());
        userDetails.put(STUDENT_MAJOR, student.getMajor());
        userDetails.put(STUDENT_CLASS_YEAR, student.getClassYear());
        userDetails.put(STUDENT_GPA, student.getGPA());
        userDetails.put(STUDENT_HAS_SCHOLARSHIP, student.getHasScholarship());
        userDetails.put(STUDENT_MAJOR_PROGRESS, student.getMajorProgress());
        userDetails.put(STUDENT_SEMESTER_PLAN, student.getSemesterPlan());
        return userDetails;
    }

    /**
     * Creates a JSONObject from the given User object
     * 
     * @param advisor | the Advisor object to create the JSONObect from
     * @return | the JSONObject created from the User object
     */
    public static JSONObject getAdvisorJSON(Advisor advisor) {
        JSONObject userDetails = new JSONObject();
        userDetails.put(USER_ID, advisor.getUUID());
        userDetails.put(USER_USERNAME, advisor.getUsername());
        userDetails.put(USER_FIRST_NAME, advisor.getFirstName());
        userDetails.put(USER_LAST_NAME, advisor.getLastName());
        userDetails.put(USER_USER_TYPE, advisor.getUserType());
        JSONArray adviseesArray = new JSONArray();
        for (String uuid : advisor.getAdvisees()) {
            JSONObject adviseeObject = new JSONObject();
            adviseeObject.put(USER_ID, uuid);
            adviseesArray.add(adviseeObject);
        }
        userDetails.put(ADVISOR_ADVISEES, adviseesArray);
        return userDetails;
    }

    /**
     * Saves the list of courses to a JSON file.
     */
    public static void saveCourses() {
        CourseList courses = CourseList.getInstance();
        ArrayList<Course> courseList = courses.getCourses();
        JSONArray jsonCourses = new JSONArray();

        // Creation of Objects in JSON
        for (int i = 0; i < courseList.size(); i++) {
            jsonCourses.add(getCourseJSON(courseList.get(i)));
        }

        // Write the JSON file
        try (FileWriter file = new FileWriter(COURSE_FILE_NAME)) {
            file.write(jsonCourses.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates a JSONObject from the given Course object
     * 
     * @param course | the Course object to create the JSONObject from
     * @return | the JSONObject created from the Course object
     */
    public static JSONObject getCourseJSON(Course course) {
        JSONObject courseDetails = new JSONObject();
        courseDetails.put(COURSE_ID, course.getUUID());
        courseDetails.put(COURSE_COURSE_NAME, course.getCourseName());
        courseDetails.put(COURSE_COURSE_ID, course.getCourseID());
        courseDetails.put(COURSE_SEMESTER, course.getSemester());
        courseDetails.put(COURSE_PREREQUISITES, course.getPrerequisites());
        courseDetails.put(COURSE_CREDIT_HOURS, course.getCreditHours());
        courseDetails.put(COURSE_PASSING_GRADE, course.getPassingGrade());
        return courseDetails;
    }

    /**
     * Saves the list of majors to a JSON file.
     */
    public static void saveMajors() {
        MajorList majors = MajorList.getInstance();
        ArrayList<Major> majorList = majors.getMajors();
        JSONArray jsonMajors = new JSONArray();

        // Creation of Objects in JSON
        for (int i = 0; i < majorList.size(); i++) {
            jsonMajors.add(getMajorJSON(majorList.get(i)));
        }

        // Write the JSON file
        try (FileWriter file = new FileWriter(MAJOR_FILE_NAME)) {
            file.write(jsonMajors.toJSONString());
            file.flush();
        } catch (IOException e) {
            System.out.println("Error writing to majors.json");
            e.printStackTrace();
        }
    }

    /**
     * Creates a JSONObject from the given Major object
     * 
     * @param major | the Major object to create the JSONObject from
     * @return | the JSONObject created from the Major object
     */
    public static JSONObject getMajorJSON(Major major) {
        JSONObject majorDetails = new JSONObject();
        majorDetails.put(MAJOR_ID, major.getUUID());
        majorDetails.put(MAJOR_MAJOR_NAME, major.getMajorName());
        JSONArray coursesArray = new JSONArray();
        for (String uuid : major.getRequiredCourses()) {
            JSONObject courseObject = new JSONObject();
            courseObject.put(COURSE_ID, uuid);
            coursesArray.add(courseObject);
        }
        majorDetails.put(MAJOR_REQUIRED_COURSES, coursesArray);
        majorDetails.put(MAJOR_ELECTIVES, major.getElectives());
        majorDetails.put(MAJOR_APPLICATION_AREA, major.getApplicationArea());
        majorDetails.put(MAJOR_CREDITS_REQUIRED, major.getCreditsRequired());
        return majorDetails;
    }
}