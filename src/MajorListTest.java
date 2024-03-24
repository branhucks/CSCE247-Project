
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MajorListTest {
	
private MajorList majors = MajorList.getInstance();
private ArrayList<Major> majorList = majors.getMajors();
	
	@BeforeEach
	public void setup() {
        majorList.clear();
        majorList.add(new Major("Computer Science", new ArrayList<String>(), new ArrayList<Electives>(), new ArrayList<ApplicationArea>(), 125));
		DataWriter.saveMajors();
	}
	
	@AfterEach
	public void tearDown() {
        MajorList.getInstance().getMajors().clear();
		DataWriter.saveMajors();
	}

    @Test
    void testGetMajorByUUID() {
        Major temp = majors.getMajorByUUID("9f367eb1-4970-4c43-bae2-d08897eedf06");
        assertEquals(temp.getMajorName(), "Computer Science");
    }
    @Test
    void testGetMajorByUUIDEmpty() {
        Major temp = majors.getMajorByUUID("");
        assertNull(temp);
    }
    @Test
    void testGetMajorByUUIDNull() {
        Major temp = majors.getMajorByUUID(null);
        assertNull(temp);
    }
    @Test
    void testGetMajorByName() {
		Major temp = majors.getMajor("Computer Science");
        assertEquals(temp.getMajorName(), "Computer Science");
	}
    @Test
    void testGetMajorByNameEmpty() {
        Major temp = majors.getMajor("");
        assertNull(temp);
    }
    @Test
    void testGetMajorByNameNull() {
        Major temp = majors.getMajor(null);
        assertNull(temp);
    }
    @Test
    void testHaveMajorTrue() {
        boolean temp = majors.haveMajor("Computer Science");
        assertTrue(temp);
    }
    @Test
    void testHaveMajorFalse() {
        boolean temp = majors.haveMajor("Computer Engineering");
        assertFalse(temp);
    }
    @Test
    void testHaveMajorEmpty() {
        boolean temp = majors.haveMajor("");
        assertNull(temp);
    }
    @Test
    void testHaveMajorNull() {
        boolean temp = majors.haveMajor(null);
        assertNull(temp);
    }
    @Test
    void testGetMajors() {
        ArrayList<Major> temp = majors.getMajors();
        assertEquals(temp.get(0).getMajorName(), "Computer Science");
    }
    @Test
    void testAddMajorTrue() {
        assertTrue(majors.addMajor("Computer Information Systems", new ArrayList<String>(), new ArrayList<Electives>(), new ArrayList<ApplicationArea>(), 120));
    }
    @Test
    void testAddMajorEmptyMajorName() {
        assertFalse(majors.addMajor("", new ArrayList<String>(), new ArrayList<Electives>(), new ArrayList<ApplicationArea>(), 120));
    }
    @Test
    void testAddMajorNullMajorName() {
        assertFalse(majors.addMajor(null, new ArrayList<String>(), new ArrayList<Electives>(), new ArrayList<ApplicationArea>(), 120));
    }
    @Test
    void testAddMajorNullRequiredCourses() {
        assertFalse(majors.addMajor("Computer Information Systems", null, new ArrayList<Electives>(), new ArrayList<ApplicationArea>(), 120));
    }
    @Test
    void testAddMajorNullElectives() {
        assertFalse(majors.addMajor("Computer Information Systems", new ArrayList<String>(), null, new ArrayList<ApplicationArea>(), 120));
    }
    @Test
    void testAddMajorNullApplicationAreas() {
        assertFalse(majors.addMajor("Computer Information Systems", new ArrayList<String>(), new ArrayList<Electives>(), null, 120));
    }
    @Test
    void testAddMajorEmptyCreditsRequired() {
        assertFalse(majors.addMajor("Computer Information Systems", new ArrayList<String>(), new ArrayList<Electives>(), new ArrayList<ApplicationArea>(), 0));
    }
}
	
	//assertEquals(val1,val2)
	//assertFalse(val)
	//assertTrue(val)
	//assertSame(val1,val2)
	//assertNotSame(val1,val2)
	//assertNull(val)
	//assertNotNull(val)

