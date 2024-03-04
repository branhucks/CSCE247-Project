import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

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
                    Major major = (Major) personJSON.get(STUDENT_MAJOR);
                    Year classYear = (Year) personJSON.get(STUDENT_CLASS_YEAR);
                    double gpa = (double) personJSON.get(STUDENT_GPA);
                    boolean hasScholarship = (boolean) personJSON.get(STUDENT_HAS_SCHOLARSHIP);
                    int majorProgress = ((Long) personJSON.get(STUDENT_MAJOR_PROGRESS)).intValue();
                    SemesterPlan semesterPlan = (SemesterPlan) personJSON.get(STUDENT_SEMESTER_PLAN);
                    studentList.add(
                            new Student(id, username, firstName, lastName, userType, studentID, major, classYear,
                                    gpa, hasScholarship, majorProgress, semesterPlan));
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
                    Advisor advisor = new Advisor(id, username, firstName, lastName, userType, advisees);
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
                // ArrayList<Course> requiredCourses = (ArrayList<Course>)
                // majorJSON.get(MAJOR_REQUIRED_COURSES);
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
                String requirement = (String) courseJSON.get(COURSE_REQUIREMENT);
                Semester semester = (Semester) courseJSON.get(COURSE_SEMESTER);
                String description = (String) courseJSON.get(COURSE_DESCRIPTION);
                ArrayList<PrereqOptions> prerequisites = (ArrayList<PrereqOptions>) courseJSON
                        .get(COURSE_PREREQUISITES);
                ArrayList<Course> corequisites = (ArrayList<Course>) courseJSON.get(COURSE_COREQUISITES);
                int creditHours = (int) courseJSON.get(COURSE_CREDIT_HOURS);
                int passingGrade = (int) courseJSON.get(COURSE_PASSING_GRADE);
                boolean completedClass = (boolean) courseJSON.get(COURSE_COMPLETED_CLASS);
                courseList.add(new Course(id, courseName, courseID, requirement, semester, description, prerequisites,
                        corequisites, creditHours, passingGrade, completedClass));
            }
            return courseList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}