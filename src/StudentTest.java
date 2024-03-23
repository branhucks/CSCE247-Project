import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class StudentTest {
    private UserList users = UserList.getInstance();
    private ArrayList<Student> students = users.getStudents();

    /**
     * We understand that we need to implement handling for null cases,
     * therefore, we are not including null test cases here
     */

    @Test
    void testGetFirstCompletedCourse() {
        StudentCourse firstCompleted = null;
        Student student = users.getStudentByStudentID("I74913108");
        SemesterPlan semesterPlan = student.getEightSemesterPlan();
        for (StudentCourse course : semesterPlan.getStudentCourses()) {
            if (course.getStatus().equals("Completed")) {
                firstCompleted = course;
                break;
            }
        }
        assertEquals("ENGL 101", firstCompleted.getCourseID());
    }

    @Test
    void testGetFirstPlannedCourse() {
        StudentCourse firstPlanned = null;
        Student student = users.getStudentByStudentID("I74913108");
        SemesterPlan semesterPlan = student.getEightSemesterPlan();
        for (StudentCourse course : semesterPlan.getStudentCourses()) {
            if (course.getStatus().equals("Planned")) {
                firstPlanned = course;
                break;
            }
        }
        assertEquals("CSCE 416", firstPlanned.getCourseID());
    }

    /**
     * This test will be used again when issue #66 is resolved
     */
    /*
     * @Test
     * void testGetStudentApplicationAreaNULL() {
     * ApplicationType applicationType = null;
     * Student student = users.getStudentByStudentID("W19375679");
     * assertEquals(null,
     * student.getApplicationAreaCourses(student.getApplicationType()).get(0).
     * getCourseID())
     * }
     */

    /**
     * This test will be ran again when issue #66 is resolved
     */
    /*
     * @Test testGetStudentApplicationAreaFirstCourse() {
     * ApplicationType applicationType = null;
     * Student student = users.getStudentByStudentID("I74913108");
     * assertEquals("ARTS 102",
     * student.getApplicationAreaCourses(student.getApplicationType()).get(0).
     * getCourseID());
     * }
     */

}