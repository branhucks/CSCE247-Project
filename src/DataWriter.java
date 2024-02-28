import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants {

    public static void saveUsers(ArrayList<Student> students, ArrayList<Advisor> advisors) {
        JSONArray jsonUsers = new JSONArray();

        for (Student student : students) {
            jsonUsers.add(getStudentJSON(student));
        }
        for (Advisor advisor : advisors) {
            jsonUsers.add(getAdvisorJSON(advisor));
        }

        try (FileWriter file = new FileWriter(USER_FILE_NAME)) {
            file.write(jsonUsers.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject getStudentJSON(Student student) {
        JSONObject userDetails = new JSONObject();
        userDetails.put(USER_ID, student.getID().toString());
        userDetails.put(USER_USERNAME, student.getUsername());
        userDetails.put(USER_FIRST_NAME, student.getFirstName());
        userDetails.put(USER_LAST_NAME, student.getLastName());
        userDetails.put(USER_USER_TYPE, student.getUserType());
        userDetails.put(STUDENT_STUDENT_ID, student.getStudentID());
        userDetails.put(STUDENT_ADVISOR, student.getAdvisor());
        userDetails.put(STUDENT_MAJOR, student.getMajor());
        userDetails.put(STUDENT_CLASS_YEAR, student.getClassYear());
        return userDetails;
    }

    public static JSONObject getAdvisorJSON(Advisor advisor) {
        JSONObject userDetails = new JSONObject();
        userDetails.put(USER_ID, advisor.getID().toString());
        userDetails.put(USER_USERNAME, advisor.getUsername());
        userDetails.put(USER_FIRST_NAME, advisor.getFirstName());
        userDetails.put(USER_LAST_NAME, advisor.getLastName());
        userDetails.put(USER_USER_TYPE, advisor.getUserType());
        userDetails.put(ADVISOR_ADVISEES, advisor.getAdvisees());
        return userDetails;
    }

    public static void saveCourses() {
        CourseList courses = CourseList.getInstance();
        ArrayList<Course> courseList = courses.getCourses();
        JSONArray jsonCourses = new JSONArray();

        for (int i = 0; i < courseList.size(); i++) {
            jsonCourses.add(getCourseJSON(courseList.get(i)));
        }

        try (FileWriter file = new FileWriter(COURSE_FILE_NAME)) {
            file.write(jsonCourses.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject getCourseJSON(Course course) {
        JSONObject courseDetails = new JSONObject();
        courseDetails.put(COURSE_ID, course.getID().toString());
        courseDetails.put(COURSE_COURSE_NAME, course.getCourseName());
        courseDetails.put(COURSE_COURSE_ID, course.getCourseID());
        courseDetails.put(COURSE_REQUIREMENT, course.getRequirement());
        courseDetails.put(COURSE_CREDIT_HOURS, course.getCreditHours());
        return courseDetails;
    }

    public static void saveMajors() {
        MajorList majors = MajorList.getInstance();
        ArrayList<Major> majorList = majors.getMajors();
        JSONArray jsonMajors = new JSONArray();

        for (int i = 0; i < majorList.size(); i++) {
            jsonMajors.add(getMajorJSON(majorList.get(i)));
        }

        try (FileWriter file = new FileWriter(MAJOR_FILE_NAME)) {
            file.write(jsonMajors.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject getMajorJSON(Major major) {
        JSONObject majorDetails = new JSONObject();
        majorDetails.put(MAJOR_ID, major.getID().toString());
        majorDetails.put(MAJOR_MAJOR_NAME, major.getMajorName());
        majorDetails.put(MAJOR_REQUIRED_COURSES, major.getRequiredCourses());
        majorDetails.put(MAJOR_HOURS_NEEDED, major.getHoursNeeded());
        return majorDetails;
    }
}