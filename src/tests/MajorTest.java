package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/*
 * import ApplicationArea;
 * import Electives;
 * import Major;
 * 
 * public class MajorTest {
 * private Major major;
 * 
 * @BeforeEach
 * public void setUp() {
 * // Major object for testing
 * ArrayList<String> requiredCourses = new ArrayList<>();
 * ArrayList<Electives> electives = new ArrayList<>();
 * ArrayList<ApplicationArea> applicationAreas = new ArrayList<>();
 * major = new Major("Computer Science", requiredCourses, electives,
 * applicationAreas, 120);
 * }
 * 
 * @AfterEach
 * public void tearDown() {
 * 
 * }
 * 
 * @Test
 * public void testAddRequiredCourse() {
 * String courseUUID = "some_course_uuid";
 * major.addRequiredCourse(courseUUID);
 * assertTrue(major.getRequiredCourses().contains(courseUUID));
 * }
 * 
 * @Test
 * public void testRemoveRequiredCourse() {
 * String courseUUID = "some_course_uuid";
 * major.addRequiredCourse(courseUUID);
 * 
 * major.removeRequiredCourse(courseUUID);
 * assertFalse(major.getRequiredCourses().contains(courseUUID));
 * }
 * 
 * @Test
 * public void testSetMajorName() {
 * major.setMajorName("New Major Name");
 * assertEquals("New Major Name", major.getMajorName());
 * }
 * 
 * @Test
 * public void testGetUUID() {
 * assertNull(major.getUUID());
 * 
 * Major majorWithUUID = new Major("some_uuid", "Computer Science", new
 * ArrayList<>(), new ArrayList<>(),
 * new ArrayList<>(), 120);
 * assertEquals("some_uuid", majorWithUUID.getUUID());
 * }
 * }
 */