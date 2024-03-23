import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.UUID;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataWriterTest {
	private UserList users = UserList.getInstance();
	private MajorList majors = MajorList.getInstance();
	private CourseList courses = CourseList.getInstance();
	private ArrayList<Student> students = users.getStudents();
	private ArrayList<Advisor> advisors = users.getAdvisors();
	private ArrayList<Major> majorList = majors.getMajors();
	private ArrayList<Course> courseList = courses.getCourses();

	@BeforeEach
	public void setup() {
		UserList.getInstance().getStudents().clear();
		UserList.getInstance().getAdvisors().clear();
		DataWriter.saveUsers(students, advisors);
	}

	@AfterEach
	public void tearDown() {
		UserList.getInstance().getStudents().clear();
		UserList.getInstance().getAdvisors().clear();
		DataWriter.saveUsers(students, advisors);
	}

	// UserList Testing
	@Test
	void testWritingZeroStudents() {
		students = DataLoader.getStudents();
		assertEquals(0, students.size());
	}

	@Test
	void testWritingZeroAdvisors() {
		advisors = DataLoader.getAdvisors();
		assertEquals(0, advisors.size());
	}

	@Test
	void testWritingOneStudent() {
		students.add(new Student((UUID.randomUUID()).toString(), "bhucks", "Brandon", "Hucks", "Student",
				users.generateStudentID(), null, users.getMajorUUIDByName("Computer Science"),
				null, 0.0, false, 0, null, null, null));
		DataWriter.saveUsers(students, advisors);
		assertEquals("bhucks", DataLoader.getStudents().get(0).getUsername());
	}

	@Test
	void testWritingOneAdvisor() {
		advisors.add(new Advisor((UUID.randomUUID()).toString(), "klong", "Kyle", "Long", "Advisor",
				new ArrayList<String>(), null));
		DataWriter.saveUsers(students, advisors);
		assertEquals("klong", DataLoader.getAdvisors().get(0).getUsername());
	}

	@Test
	void testWritingFiveStudents() {
		students.add(new Student((UUID.randomUUID()).toString(), "bhucks", "Brandon", "Hucks", "Student",
				users.generateStudentID(), null, users.getMajorUUIDByName("Computer Science"),
				null, 0.0, false, 0, null, null, null));
		students.add(new Student((UUID.randomUUID()).toString(), "tshrank", "Thomas", "Schrank", "Student",
				users.generateStudentID(), null, users.getMajorUUIDByName("Computer Science"),
				null, 0.0, false, 0, null, null, null));
		students.add(new Student((UUID.randomUUID()).toString(), "jpope", "Jason", "Pope", "Student",
				users.generateStudentID(), null, users.getMajorUUIDByName("Computer Science"),
				null, 0.0, false, 0, null, null, null));
		students.add(new Student((UUID.randomUUID()).toString(), "ajacobson", "Ash", "Jacobson", "Student",
				users.generateStudentID(), null, users.getMajorUUIDByName("Computer Science"),
				null, 0.0, false, 0, null, null, null));
		students.add(new Student((UUID.randomUUID()).toString(), "klong", "Kyle", "Long", "Student",
				users.generateStudentID(), null, users.getMajorUUIDByName("Computer Science"),
				null, 0.0, false, 0, null, null, null));
		DataWriter.saveUsers(students, advisors);
		assertEquals("klong", DataLoader.getStudents().get(5).getUsername());
	}

	@Test
	void testWritingFiveAdvisors() {
		advisors.add(new Advisor((UUID.randomUUID()).toString(), "klong", "Kyle", "Long", "Advisor",
				new ArrayList<String>(), "Computer Information Systems"));
		advisors.add(new Advisor((UUID.randomUUID()).toString(), "bhucks", "Brandon", "Hucks", "Advisor",
				new ArrayList<String>(), "Computer Information Systems"));
		advisors.add(new Advisor((UUID.randomUUID()).toString(), "tschrank", "Thomas", "Schrank", "Advisor",
				new ArrayList<String>(), "Computer Information Systems"));
		advisors.add(new Advisor((UUID.randomUUID()).toString(), "jpope", "Jason", "Pope", "Advisor",
				new ArrayList<String>(), "Computer Information Systems"));
		advisors.add(new Advisor((UUID.randomUUID()).toString(), "ajacobson", "Ash", "Jacobson", "Advisor",
				new ArrayList<String>(), "Computer Information Systems"));
		DataWriter.saveUsers(students, advisors);
		assertEquals("ajacobson", DataLoader.getAdvisors().get(5).getUsername());
	}

	@Test
	void testWritingEmptyStudent() {
		students.add(new Student("", "", "", "", "Student",
				"", "", "", "", 0.0, false, 0, null, "", null));
		DataWriter.saveUsers(students, advisors);
		assertEquals("", DataLoader.getStudents().get(0).getUsername());
	}

	@Test
	void testWritingEmptyAdvisor() {
		advisors.add(new Advisor("", "", "", "", "Advisor",
				new ArrayList<String>(), ""));
		DataWriter.saveUsers(students, advisors);
		assertEquals("", DataLoader.getAdvisors().get(0).getUsername());
	}

	// MajorList Testing
	@Test
	void testWritingZeroMajors() {
		students = DataLoader.getStudents();
		assertEquals(0, students.size());
	}

	@Test
	void testWritingOneMajor() {
		majorList.add(new Major((UUID.randomUUID()).toString(), "Computer Science", new ArrayList<String>(),
				new ArrayList<Electives>(), new ArrayList<ApplicationArea>(), 125));
		DataWriter.saveMajors();
		assertEquals("Computer Science", DataLoader.getMajors().get(0).getMajorName());
	}

	@Test
	void testWritingFiveMajors() {
		majorList.add(new Major((UUID.randomUUID()).toString(), "Computer Science", new ArrayList<String>(),
				new ArrayList<Electives>(), new ArrayList<ApplicationArea>(), 125));
		majorList.add(new Major((UUID.randomUUID()).toString(), "Computer Information Systems", new ArrayList<String>(),
				new ArrayList<Electives>(), new ArrayList<ApplicationArea>(), 125));
		majorList.add(new Major((UUID.randomUUID()).toString(), "Test Major 1", new ArrayList<String>(),
				new ArrayList<Electives>(), new ArrayList<ApplicationArea>(), 125));
		majorList.add(new Major((UUID.randomUUID()).toString(), "Test Major 2", new ArrayList<String>(),
				new ArrayList<Electives>(), new ArrayList<ApplicationArea>(), 125));
		majorList.add(new Major((UUID.randomUUID()).toString(), "Test Major 3", new ArrayList<String>(),
				new ArrayList<Electives>(), new ArrayList<ApplicationArea>(), 125));
		DataWriter.saveMajors();
		assertEquals("Test Major 3", DataLoader.getAdvisors().get(5).getUsername());
	}

	// CourseList Testing
	@Test
	void testWritingZeroCourses() {
		courseList = DataLoader.getCourses();
		assertEquals(0, courseList.size());
	}

	@Test
	void testWritingOneCourse() {
		courseList.add(new Course((UUID.randomUUID()).toString(), "Algorithmic Design I", "CSCE", "145",
				"SPRING,SUMMER,FALL", new ArrayList<PrereqOptions>(), new ArrayList<String>(), 4, 70));
		DataWriter.saveCourses();
		assertEquals("CSCE 145", courseList.get(0).courseID());
	}

	@Test
	void testWritingFiveCourses() {
		courseList.add(new Course((UUID.randomUUID()).toString(), "Algorithmic Design I", "CSCE", "145",
				"SPRING,SUMMER,FALL", new ArrayList<PrereqOptions>(), new ArrayList<String>(), 4, 70));
		courseList.add(new Course((UUID.randomUUID()).toString(), "Algorithmic Design II", "CSCE", "146",
				"SPRING,SUMMER,FALL", new ArrayList<PrereqOptions>(), new ArrayList<String>(), 4, 70));
		courseList.add(new Course((UUID.randomUUID()).toString(), "Software Engineering", "CSCE", "247",
				"SPRING,SUMMER,FALL", new ArrayList<PrereqOptions>(), new ArrayList<String>(), 4, 70));
		courseList.add(new Course((UUID.randomUUID()).toString(), "Digital Logic Design", "CSCE", "211",
				"SPRING,SUMMER,FALL", new ArrayList<PrereqOptions>(), new ArrayList<String>(), 4, 70));
		courseList.add(new Course((UUID.randomUUID()).toString(), "Advanced Programming Techniques", "CSCE", "240",
				"SPRING,SUMMER,FALL", new ArrayList<PrereqOptions>(), new ArrayList<String>(), 4, 70));
		DataWriter.saveCourses();
		assertEquals("CSCE 240", courseList.get(5).courseID());
	}

}