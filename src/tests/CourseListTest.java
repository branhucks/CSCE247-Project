package tests;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*
 * import Course;
 * import CourseList;
 * import DataWriter;
 * import PrereqOptions;
 * 
 * class CourseListTest {
 * 
 * private CourseList courses = CourseList.getInstance();
 * private ArrayList<Course> courseList = courses.getCourses();
 * 
 * @BeforeEach
 * public void setup() {
 * courseList.clear();
 * courseList.add(new Course("4bd274cb-260e-47a5-9893-203a3943d704",
 * "Calculus I", "Math", "141",
 * "SPRING,SUMMER,FALL", new ArrayList<PrereqOptions>(),
 * new ArrayList<String>(), 4, 70));
 * DataWriter.saveCourses();
 * }
 * 
 * @AfterEach
 * public void tearDown() {
 * CourseList.getInstance().getCourses().clear();
 * DataWriter.saveCourses();
 * }
 * 
 * @Test
 * void testGetCourseByUUID() {
 * Course temp =
 * courses.getCourseByUUID("4bd274cb-260e-47a5-9893-203a3943d704");
 * assertEquals(temp.courseID(), "Math 141");
 * }
 * 
 * @Test
 * void testGetCourseByUUIDEmpty() {
 * Course temp = courses.getCourseByUUID("");
 * assertNull(temp);
 * }
 * 
 * @Test
 * void testGetCourseByUUIDNull() {
 * Course temp = courses.getCourseByUUID(null);
 * assertNull(temp);
 * }
 * 
 * @Test
 * void testGetCourseByCourseID() {
 * Course temp = courses.getCourseByCourseID("Math 141");
 * assertEquals(temp.courseID(), "Math 141");
 * }
 * 
 * @Test
 * void testGetCourseByCourseIDEmpty() {
 * Course temp = courses.getCourseByCourseID("");
 * assertNull(temp);
 * }
 * 
 * @Test
 * void testGetCourseByCourseIDNull() {
 * Course temp = courses.getCourseByCourseID(null);
 * assertNull(temp);
 * }
 * 
 * @Test
 * void testGetCourseIDByCourseUUID() {
 * String temp =
 * courses.getCourseIDByCourseUUID("4bd274cb-260e-47a5-9893-203a3943d704");
 * assertEquals(temp, "Math 141");
 * }
 * 
 * @Test
 * void testGetCourseIDByCourseUUIDEmpty() {
 * String temp = courses.getCourseIDByCourseUUID("");
 * assertNull(temp);
 * }
 * 
 * @Test
 * void testGetCourseIDByCourseUUIDNull() {
 * String temp = courses.getCourseIDByCourseUUID(null);
 * assertNull(temp);
 * }
 * 
 * @Test
 * void testHaveCourseTrue() {
 * boolean temp = courses.haveCourse("Math 141");
 * assertTrue(temp);
 * }
 * 
 * @Test
 * void testHaveCourseFalse() {
 * boolean temp = courses.haveCourse("CSCE 247");
 * assertFalse(temp);
 * }
 * 
 * @Test
 * void testHaveCourseEmpty() {
 * boolean temp = courses.haveCourse("");
 * assertNull(temp);
 * }
 * 
 * @Test
 * void testHaveCourseNull() {
 * boolean temp = courses.haveCourse(null);
 * assertNull(temp);
 * }
 * 
 * @Test
 * void testGetCourses() {
 * ArrayList<Course> temp = courses.getCourses();
 * assertEquals(temp.get(0).courseID(), "Math 141");
 * }
 * 
 * @Test
 * void testAddCourseTrue() {
 * assertTrue(
 * courses.addCourse("Software Engineering", "CSCE", "247", "SPRING,FALL", new
 * ArrayList<PrereqOptions>(),
 * new ArrayList<String>(), 3, 70));
 * }
 * 
 * @Test
 * void testAddCourseEmptyName() {
 * assertFalse(courses.addCourse("", "CSCE", "247", "SPRING,FALL", new
 * ArrayList<PrereqOptions>(),
 * new ArrayList<String>(), 3, 70));
 * }
 * 
 * @Test
 * void testAddCourseNullName() {
 * assertFalse(courses.addCourse(null, "CSCE", "247", "SPRING,FALL", new
 * ArrayList<PrereqOptions>(),
 * new ArrayList<String>(), 3, 70));
 * }
 * 
 * @Test
 * void testAddCourseEmptySubject() {
 * assertFalse(courses.addCourse("Software Engineering", "", "247",
 * "SPRING,FALL", new ArrayList<PrereqOptions>(),
 * new ArrayList<String>(), 3, 70));
 * }
 * 
 * @Test
 * void testAddCourseNullSubject() {
 * assertFalse(
 * courses.addCourse("Software Engineering", null, "247", "SPRING,FALL", new
 * ArrayList<PrereqOptions>(),
 * new ArrayList<String>(), 3, 70));
 * }
 * 
 * @Test
 * void testAddCourseEmptyNumber() {
 * assertFalse(courses.addCourse("Software Engineering", "CSCE", "",
 * "SPRING,FALL", new ArrayList<PrereqOptions>(),
 * new ArrayList<String>(), 3, 70));
 * }
 * 
 * @Test
 * void testAddCourseNullNumber() {
 * assertFalse(
 * courses.addCourse("Software Engineering", "CSCE", null, "SPRING,FALL", new
 * ArrayList<PrereqOptions>(),
 * new ArrayList<String>(), 3, 70));
 * }
 * 
 * @Test
 * void testAddCourseEmptySemester() {
 * assertFalse(courses.addCourse("Software Engineering", "CSCE", "247", "", new
 * ArrayList<PrereqOptions>(),
 * new ArrayList<String>(), 3, 70));
 * }
 * 
 * @Test
 * void testAddCourseNullSemester() {
 * assertFalse(courses.addCourse("Software Engineering", "CSCE", "247", null,
 * new ArrayList<PrereqOptions>(),
 * new ArrayList<String>(), 3, 70));
 * }
 * 
 * @Test
 * void testAddCourseNullPrereqs() {
 * assertFalse(courses.addCourse("Software Engineering", "CSCE", "247",
 * "SPRING,FALL", null,
 * new ArrayList<String>(), 3, 70));
 * }
 * 
 * @Test
 * void testAddCourseNullCoreqs() {
 * assertFalse(
 * courses.addCourse("Software Engineering", "CSCE", "247", "SPRING,FALL", new
 * ArrayList<PrereqOptions>(),
 * null, 3, 70));
 * }
 * }
 * 
 * // assertEquals(val1,val2)
 * // assertFalse(val)
 * // assertTrue(val)
 * // assertSame(val1,val2)
 * // assertNotSame(val1,val2)
 * // assertNull(val)
 * // assertNotNull(val)
 */