import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SemesterPlanTest {
    private SemesterPlan semesterPlan;

    @BeforeEach
    public void setUp() {
        semesterPlan = new SemesterPlan(new ArrayList<StudentCourse>());
    }
    @AfterEach
public void tearDown() {
   
}
    @Test
    public void testAddCourseTrue() {
        semesterPlan.addCourse("MATH", "141", 1);
        assertTrue(semesterPlan.getStudentCourses().contains(new StudentCourse("MATH 141", 1, "Planned", 0, false)));
    }

    @Test
    public void testAddCourseEmptySubject() {
        semesterPlan.addCourse("", "141", 1);
        assertTrue(semesterPlan.getStudentCourses().contains(new StudentCourse(" 141", 1, "Planned", 0, false)));
    }

    @Test
    public void testAddCourseNullSubject() {
        semesterPlan.addCourse(null, "141", 1);
        assertTrue(semesterPlan.getStudentCourses().contains(new StudentCourse(" 141", 1, "Planned", 0, false)));
    }

    @Test
    public void testAddCourseEmptyNumber() {
        semesterPlan.addCourse("MATH", "", 1);
        assertTrue(semesterPlan.getStudentCourses().contains(new StudentCourse("MATH ", 1, "Planned", 0, false)));
    }

    @Test
    public void testAddCourseNullNumber() {
        semesterPlan.addCourse("MATH", null, 1);
        assertTrue(semesterPlan.getStudentCourses().contains(new StudentCourse("MATH ", 1, "Planned", 0, false)));
    }


    @Test
    public void testRemoveCourse() {
        semesterPlan.addCourse("MATH", "141", 1);
        semesterPlan.removeCourse("MATH", "141");
        assertFalse(semesterPlan.getStudentCourses().contains(new StudentCourse("MATH 141", 1, "Planned", 0, false)));
    }

}