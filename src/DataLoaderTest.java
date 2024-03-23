import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataLoaderTest {
    private UserList users = UserList.getInstance();
    private MajorList majors = MajorList.getInstance();
    private CourseList courses = CourseList.getInstance();
    private ArrayList<Student> students = users.getStudents();
    private ArrayList<Advisor> advisors = users.getAdvisors();
    private ArrayList<Major> majorList = majors.getMajors();
    private ArrayList<Course> courseList = courses.getCourses();

    @BeforeEach
    public void setup() {
        students.clear();
        advisors.clear();
        majorList.clear();
        courseList.clear();
        students.add(new Student((UUID.randomUUID()).toString(), "bhucks", "Brandon", "Hucks", "Student",
                users.generateStudentID(), null, users.getMajorUUIDByName("Computer Science"),
                null, 0.0, false, 0, null, null, null));
        advisors.add(new Advisor((UUID.randomUUID()).toString(), "klong", "Kyle", "Long", "Advisor",
                new ArrayList<String>(), null));
        majorList.add(new Major((UUID.randomUUID()).toString(), "Computer Science", new ArrayList<String>(),
                new ArrayList<Electives>(), new ArrayList<ApplicationArea>(), 125));
        courseList.add(new Course((UUID.randomUUID()).toString(), "Algorithmic Design I", "CSCE", "145",
                "SPRING,SUMMER,FALL", new ArrayList<PrereqOptions>(), new ArrayList<String>(), 4, 70));
        DataWriter.saveUsers(students, advisors);
        DataWriter.saveMajors();
        DataWriter.saveCourses();
    }

    @AfterEach
    public void tearDown() {
        UserList.getInstance().getStudents().clear();
        UserList.getInstance().getAdvisors().clear();
        MajorList.getInstance().getMajors().clear();
        CourseList.getInstance().getCourses().clear();
        DataWriter.saveUsers(students, advisors);
        DataWriter.saveMajors();
        DataWriter.saveCourses();
    }

    /**
     * We understand that there is no error checking for null arguments,
     * therefore, we will not be testing null cases in the tests.
     */

    // UserList Testing
    @Test
    void testGetStudentsSize() {
        students = DataLoader.getStudents();
        assertEquals(1, students.size());
    }

    @Test
    void testGetStudentsSizeZero() {
        UserList.getInstance().getStudents().clear();
        DataWriter.saveUsers(students, advisors);
        assertEquals(0, students.size());
    }

    @Test
    void testGetStudentFirstUserName() {
        students = DataLoader.getStudents();
        assertEquals("bhucks", students.get(0).getUsername());
    }

    @Test
    void testGetStudentMajor() {
        students = DataLoader.getStudents();
        assertEquals("Computer Science", majors.getMajorByUUID(students.get(0).getMajor()).getMajorName());
    }

    @Test
    void testGetStudentNoteFromAdvisor() {
        students = DataLoader.getStudents();
        assertEquals("Testing note to student", students.get(0).getNoteFromAdvisor());
    }

    @Test
    void testGetStudentStudentID() {
        students = DataLoader.getStudents();
        assertEquals("I74913108", students.get(0).getStudentID());
    }

    @Test
    void testGetAdvisorsSize() {
        advisors = DataLoader.getAdvisors();
        assertEquals(1, advisors.size());
    }

    @Test
    void testGetAdvisorsSizeZero() {
        UserList.getInstance().getAdvisors().clear();
        DataWriter.saveUsers(students, advisors);
        assertEquals(0, advisors.size());
    }

    @Test
    void testGetAdvisorFirstUserName() {
        advisors = DataLoader.getAdvisors();
        assertEquals("klong", advisors.get(0).getUsername());
    }

    @Test
    void testGetAdvisorAdvisees() {
        advisors = DataLoader.getAdvisors();
        ArrayList<String> advisees = advisors.get(0).getAdvisees();
        assertEquals("bhucks", users.getStudentByUUID(advisees.get(0)).getUsername());
    }

    // MajorList Testing
    @Test
    void testGetMajorListSize() {
        majorList = DataLoader.getMajors();
        assertEquals(1, majorList.size());
    }

    @Test
    void testGetMajorListSizeZero() {
        MajorList.getInstance().getMajors().clear();
        DataWriter.saveMajors();
        assertEquals(0, majorList.size());
    }

    @Test
    void testGetMajorName() {
        majorList = DataLoader.getMajors();
        assertEquals("Computer Science", majorList.get(0).getMajorName());
    }

    @Test
    void testGetMajorFirstRequiredCourse() {
        majorList = DataLoader.getMajors();
        String courseUUID = majorList.get(0).getRequiredCourses().get(0);
        assertEquals("ENGL 101", courses.getCourseByUUID(courseUUID).getCourseName());
    }

    @Test
    void testGetMajorFirstElective() {
        majorList = DataLoader.getMajors();
        Electives electives = majorList.get(0).getElectives().get(0);
        assertEquals("AIU", electives.getElectiveType());
    }

    @Test
    void testGetMajorApplicationArea() {
        majorList = DataLoader.getMajors();
        ApplicationArea applicationArea = majorList.get(0).getApplicationAreas().get(0);
        assertEquals("DigitalDesign", applicationArea.getType());
    }

    @Test
    void testGetMajorCreditsRequired() {
        majorList = DataLoader.getMajors();
        assertEquals(125, majorList.get(0).getCreditsRequired());
    }

    // CourseList Testing
    @Test
    void testGetCoursesSize() {
        courseList = DataLoader.getCourses();
        assertEquals(1, courseList.size());
    }

    @Test
    void testGetCoursesSizeZero() {
        CourseList.getInstance().getCourses().clear();
        DataWriter.saveCourses();
        assertEquals(0, courseList.size());
    }

    @Test
    void testGetCourseFirstName() {
        courseList = DataLoader.getCourses();
        assertEquals("Algorithmic Design I", courseList.get(0).getCourseName());
    }

    @Test
    void testGetCourseSubject() {
        courseList = DataLoader.getCourses();
        assertEquals("CSCE", courseList.get(0).getSubject());
    }

    @Test
    void testGetCourseFirstPrerequisite() {
        courseList = DataLoader.getCourses();
        String courseUUID = courseList.get(0).getPrerequisites().get(0).getCourses().get(0);
        assertEquals("MATH 122", courses.getCourseByUUID(courseUUID).courseID());
    }

    @Test
    void testGetCourseFirstCorequisite() {
        courseList = DataLoader.getCourses();
        String courseUUID = courseList.get(0).getCorequisites().get(0);
        assertEquals(null, courseUUID);
    }
}