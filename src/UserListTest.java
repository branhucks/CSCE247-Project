import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserListTest {
    private UserList userList;

    @BeforeEach
    public void setUp() {
        userList = new UserList(); 
    }

    @Test
    public void testGetStudentByUUID() {
        String knownStudentUUID = "2097e146-b527-4d39-a596-6f2a538ad19e";
        Student student = userList.getStudentByUUID(knownStudentUUID);
        Assertions.assertNotNull(student, "Student should not be null");
        Assertions.assertEquals(knownStudentUUID, student.getUUID(), "Student UUID should match the known UUID");
    }

    @Test
    public void testGetStudentByStudentID() {
        String knownStudentID = "E08578583";
        Student student = userList.getStudentByStudentID(knownStudentID);
        Assertions.assertNotNull(student, "Student should not be null");
        Assertions.assertEquals(knownStudentID, student.getStudentID(), "Student ID should match the known student ID");
    }

    @Test
    public void testAddStudent() {
        String username = "johndoe";
        String firstName = "John";
        String lastName = "Doe";
        String userType = "Student";
        String major = "Computer Science";
        String classYear = "Junior";

        boolean result = userList.addStudent(username, firstName, lastName, userType, major, classYear);
        Assertions.assertTrue(result, "Student should be added successfully");

        ArrayList<Student> students = userList.getStudents();
        Assertions.assertFalse(students.isEmpty(), "Students list should not be empty after adding a student");

        Student addedStudent = userList.getStudentByStudentID(username); 
        Assertions.assertNotNull(addedStudent, "Added student should be retrievable");
        Assertions.assertEquals(username, addedStudent.getUsername(), "Added student's username should match");
        Assertions.assertEquals(firstName, addedStudent.getFirstName(), "Added student's first name should match");
        Assertions.assertEquals(lastName, addedStudent.getLastName(), "Added student's last name should match");
        Assertions.assertEquals(userType, addedStudent.getUserType(), "Added student's user type should match");
        Assertions.assertEquals(major, addedStudent.getMajor(), "Added student's major should match");
        Assertions.assertEquals(classYear, addedStudent.getClassYear(), "Added student's class year should match");
    }

    @Test
    public void testGetAdvisorByUUID() {
        String knownAdvisorUUID = "99368d8a-bbcf-4a29-a0bb-77ab99e38be0";
        Advisor advisor = userList.getAdvisorByUUID(knownAdvisorUUID);
        Assertions.assertNotNull(advisor, "Advisor should not be null");
        Assertions.assertEquals(knownAdvisorUUID, advisor.getUUID(), "Advisor UUID should match the known UUID");
    }

    @Test
    public void testAddAdvisor() {
        String username = "janedoe";
        String firstName = "Jane";
        String lastName = "Doe";
        String userType = "Advisor";
        String department = "Computer Science";

        boolean result = userList.addAdvisor(username, firstName, lastName, userType, department);
        Assertions.assertTrue(result, "Advisor should be added successfully");

        ArrayList<Advisor> advisors = userList.getAdvisors();
        Assertions.assertFalse(advisors.isEmpty(), "Advisors list should not be empty after adding an advisor");

        Advisor addedAdvisor = userList.getAdvisorByUUID(username); 
        Assertions.assertNotNull(addedAdvisor, "Added advisor should be retrievable");
        Assertions.assertEquals(username, addedAdvisor.getUsername(), "Added advisor's username should match");
        Assertions.assertEquals(firstName, addedAdvisor.getFirstName(), "Added advisor's first name should match");
        Assertions.assertEquals(lastName, addedAdvisor.getLastName(), "Added advisor's last name should match");
        Assertions.assertEquals(userType, addedAdvisor.getUserType(), "Added advisor's user type should match");
        Assertions.assertEquals(department, addedAdvisor.getDepartment(), "Added advisor's department should match");
    }
}