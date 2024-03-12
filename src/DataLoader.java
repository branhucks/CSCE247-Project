import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * This class loads the data from the JSON files and converts them into
 * corresponding objects (i.e., Student, Advisor, Course, Major).
 */
public class DataLoader extends DataConstants {

    /**
     * Loads the students from the users JSON file
     * 
     * @return | an ArrayList of Student objects
     */
    public static ArrayList<Student> getStudents() {
        ArrayList<Student> studentList = new ArrayList<>();

        try {
            FileReader reader = new FileReader(USER_FILE_NAME);
            JSONArray peopleJSON = (JSONArray) new JSONParser().parse(reader);

            for (int i = 0; i < peopleJSON.size(); i++) {
                JSONObject personJSON = (JSONObject) peopleJSON.get(i);

                if (personJSON.get(USER_USER_TYPE).equals("Student")) {
                    String id = (String) personJSON.get(USER_ID);
                    String username = (String) personJSON.get(USER_USERNAME);
                    String firstName = (String) personJSON.get(USER_FIRST_NAME);
                    String lastName = (String) personJSON.get(USER_LAST_NAME);
                    String userType = (String) personJSON.get(USER_USER_TYPE);
                    String studentID = (String) personJSON.get(STUDENT_STUDENT_ID);
                    String major = (String) personJSON.get(STUDENT_MAJOR);
                    String classYear = (String) personJSON.get(STUDENT_CLASS_YEAR);
                    double gpa = (double) personJSON.get(STUDENT_GPA);
                    boolean hasScholarship = (boolean) personJSON.get(STUDENT_HAS_SCHOLARSHIP);
                    int majorProgress = ((Long) personJSON.get(STUDENT_MAJOR_PROGRESS)).intValue();
                    SemesterPlan semesterPlan = (SemesterPlan) personJSON.get(STUDENT_SEMESTER_PLAN);
                    String noteFromAdvisor = (String) personJSON.get(STUDENT_NOTE);
                    studentList.add(
                            new Student(id, username, firstName, lastName, userType, studentID, major, classYear,
                                    gpa, hasScholarship, majorProgress, semesterPlan, noteFromAdvisor));
                }
            }
            return studentList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Loads the advisors from the users JSON file
     * 
     * @return | an ArrayList of Advisor objects
     */
    public static ArrayList<Advisor> getAdvisors() {
        ArrayList<Advisor> advisorList = new ArrayList<>();

        try {
            FileReader reader = new FileReader(USER_FILE_NAME);
            JSONArray peopleJSON = (JSONArray) new JSONParser().parse(reader);

            for (int i = 0; i < peopleJSON.size(); i++) {
                JSONObject personJSON = (JSONObject) peopleJSON.get(i);

                if (personJSON.get(USER_USER_TYPE).equals("Advisor")) {
                    String id = (String) personJSON.get(USER_ID);
                    String username = (String) personJSON.get(USER_USERNAME);
                    String firstName = (String) personJSON.get(USER_FIRST_NAME);
                    String lastName = (String) personJSON.get(USER_LAST_NAME);
                    String userType = (String) personJSON.get(USER_USER_TYPE);
                    JSONArray adviseesJSON = (JSONArray) personJSON.get(ADVISOR_ADVISEES);
                    ArrayList<String> advisees = new ArrayList<>();
                    for (int j = 0; j < adviseesJSON.size(); j++) {
                        JSONObject studentJSON = (JSONObject) adviseesJSON.get(j);
                        String studentID = (String) studentJSON.get(USER_ID);
                        advisees.add(studentID);
                    }
                    String department = (String) personJSON.get(ADVISOR_DEPARTMENT);
                    Advisor advisor = new Advisor(id, username, firstName, lastName, userType, advisees, department);
                    // loop through students array and add the advisor to the student
                    for (Student student : DataLoader.getStudents()) {
                        student.setAdvisor(advisor);
                    }
                    advisorList.add(advisor);
                }
            }
            return advisorList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Loads the majors from the majors JSON file
     * 
     * @return | an ArrayList of Major objects
     */
    public static ArrayList<Major> getMajors() {
        ArrayList<Major> majorList = new ArrayList<Major>();

        try {
            FileReader reader = new FileReader(MAJOR_FILE_NAME);
            JSONArray majorsJSON = (JSONArray) new JSONParser().parse(reader);

            for (int i = 0; i < majorsJSON.size(); i++) {
                JSONObject majorJSON = (JSONObject) majorsJSON.get(i);
                String id = (String) majorJSON.get(MAJOR_ID);
                String majorName = (String) majorJSON.get(MAJOR_MAJOR_NAME);
                JSONArray coursesJSON = (JSONArray) majorJSON.get(MAJOR_REQUIRED_COURSES);
                ArrayList<String> requiredCourses = new ArrayList<>();
                for (int j = 0; j < coursesJSON.size(); j++) {
                    JSONObject courseJSON = (JSONObject) coursesJSON.get(j);
                    String courseUUID = (String) courseJSON.get(COURSE_ID);
                    requiredCourses.add(courseUUID);
                }
                HashMap<ElectiveType, Electives> electives = (HashMap<ElectiveType, Electives>) majorJSON
                        .get(MAJOR_ELECTIVES);
                ApplicationArea applicationArea = (ApplicationArea) majorJSON.get(MAJOR_APPLICATION_AREA);
                int creditsRequired = ((Long) majorJSON.get(MAJOR_CREDITS_REQUIRED)).intValue();
                majorList.add(new Major(id, majorName, requiredCourses, electives, applicationArea, creditsRequired));
            }
            return majorList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Loads the courses from the courses JSON file
     * 
     * @return | an ArrayList of Course objects
     */
    public static ArrayList<Course> getCourses() {
        ArrayList<Course> courseList = new ArrayList<Course>();

        try {
            FileReader reader = new FileReader(COURSE_FILE_NAME);
            JSONArray coursesJSON = (JSONArray) new JSONParser().parse(reader);

            for (int i = 0; i < coursesJSON.size(); i++) {
                JSONObject courseJSON = (JSONObject) coursesJSON.get(i);
                String id = (String) courseJSON.get(COURSE_ID);
                String courseName = (String) courseJSON.get(COURSE_COURSE_NAME);
                String courseID = (String) courseJSON.get(COURSE_COURSE_ID);
                Semester semester = (Semester) courseJSON.get(COURSE_SEMESTER);
                ArrayList<PrereqOptions> prerequisites = (ArrayList<PrereqOptions>) courseJSON
                        .get(COURSE_PREREQUISITES);
                int creditHours = ((Long) courseJSON.get(COURSE_CREDIT_HOURS)).intValue();
                int passingGrade = ((Long) courseJSON.get(COURSE_PASSING_GRADE)).intValue();
                courseList
                        .add(new Course(id, courseName, courseID, semester, prerequisites, creditHours, passingGrade));
            }
            return courseList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}