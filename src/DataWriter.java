import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataWriter extends DataConstants {

    public static void saveUsers() {
        UserList users = UserList.getInstance();
        ArrayList<User> userList = users.getUsers();
        JSONArray jsonUsers = new JSONArray();

        for (int i = 0; i < userList.size(); i++) {
            jsonUsers.add(getUserJSON(userList.get(i)));
        }

        try (FileWriter file = new FileWriter(USER_FILE_NAME)) {
            file.write(jsonUsers.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject getUserJSON(User user) {
        JSONObject userDetails = new JSONObject();
        userDetails.put(USER_ID, user.getID().toString());
        userDetails.put(USER_USERNAME, user.getUsername());
        userDetails.put(USER_FIRST_NAME, user.getFirstName());
        userDetails.put(USER_LAST_NAME, user.getLastName());
        userDetails.put(USER_USER_TYPE, user.getUserType());
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