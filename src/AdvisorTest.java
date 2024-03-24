import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AdvisorTest {
    
    private Advisor advisor;

    @BeforeEach
	public void setup() {
        advisor = new Advisor("073b875b-dd00-482a-b708-08ea0809d1c1", "klong", "Kyle", "Long", "Advisor", new ArrayList<String>(), "klong");
	}
	
    @Test
    void testAddAdvisee() {
        advisor.addAdvisee("8b07eebc-d677-4336-8df7-67368a3730be");
        assertEquals(advisor.getAdvisees().get(0), "8b07eebc-d677-4336-8df7-67368a3730be");
    }
    @Test
    void testAddAdviseeEmpty() {
        advisor.addAdvisee("");
        assertNull(advisor.getAdvisees().get(0));
    }
    @Test
    void testAddAdviseeNull() {
        advisor.addAdvisee(null);
        assertNull(advisor.getAdvisees().get(0));
    }
}