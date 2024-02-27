import java.io.FileReader;
import java.util.ArrayList;
import java.util.UUID;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class DataLoader extends DataConstants {

    public static ArrayList<User> getUsers() {
        ArrayList<User> userList = new ArrayList<User>();

        try {
            FileReader reader = new FileReader(USER_FILE_NAME);
            JSONArray peopleJSON = (JSONArray) new JSONParser().parse(reader);

            for (int i = 0; i < peopleJSON.size(); i++) {
                JSONObject personJSON = (JSONObject) peopleJSON.get(i);
                UUID id = UUID.fromString((String) personJSON.get(USER_ID));
                String username = (String) personJSON.get(USER_USERNAME);
                String firstName = (String) personJSON.get(USER_FIRST_NAME);
                String lastName = (String) personJSON.get(USER_LAST_NAME);
                String userType = (String) personJSON.get(USER_USER_TYPE);
                userList.add(new User(id, username, firstName, lastName, userType));
                // studentList.add(Student )
                // Additional attributes
            }
            return userList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<User> getStudents() {
        ArrayList<User> studentList = new ArrayList<>();

        ArrayList<User> userList = getUsers();
        if (userList != null) {
            for (User user : userList) {
                if (user.getUserType().equalsIgnoreCase("Student")) {
                    studentList.add(user);
                }
            }
        }
        return studentList;
    }

    public static ArrayList<User> getAdvisors() {
        ArrayList<User> advisorList = new ArrayList<>();

        ArrayList<User> userList = getUsers();
        if (userList != null) {
            for (User user : userList) {
                if (user.getUserType().equalsIgnoreCase("Advisor")) {
                    advisorList.add(user);
                }
            }
        }
        return advisorList;
    }

    public static ArrayList<Major> getMajors() {
        ArrayList<Major> majorList = new ArrayList<Major>();

        try {
            FileReader reader = new FileReader(MAJOR_FILE_NAME);
            JSONArray majorsJSON = (JSONArray) new JSONParser().parse(reader);

            for (int i = 0; i < majorsJSON.size(); i++) {
                JSONObject majorJSON = (JSONObject) majorsJSON.get(i);
                UUID id = UUID.fromString((String) majorJSON.get(MAJOR_ID));
                String majorName = (String) majorJSON.get(MAJOR_MAJOR_NAME);
                // RETURNS JSONARRAY HAVE TO DEAL WITH THAT
                ArrayList<Course> requiredCourses = (ArrayList<Course>) majorJSON.get(MAJOR_REQUIRED_COURSES);
                int hoursNeeded = (int) majorJSON.get(MAJOR_HOURS_NEEDED);
                majorList.add(new Major(id, majorName, requiredCourses, hoursNeeded));
            }
            return majorList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ArrayList<Course> getCourses() {
        ArrayList<Course> courseList = new ArrayList<Course>();

        try {
            FileReader reader = new FileReader(COURSE_FILE_NAME);
            JSONArray coursesJSON = (JSONArray) new JSONParser().parse(reader);

            for (int i = 0; i < coursesJSON.size(); i++) {
                JSONObject courseJSON = (JSONObject) coursesJSON.get(i);
                UUID id = UUID.fromString((String) courseJSON.get(COURSE_ID));
                String courseName = (String) courseJSON.get(COURSE_COURSE_NAME);
                String courseID = (String) courseJSON.get(COURSE_COURSE_ID);
                String requirement = (String) courseJSON.get(MAJOR_HOURS_NEEDED);
                int creditHours = (int) courseJSON.get(COURSE_CREDIT_HOURS);
                courseList.add(new Course(id, courseName, courseID, requirement, creditHours));
            }
            return courseList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}