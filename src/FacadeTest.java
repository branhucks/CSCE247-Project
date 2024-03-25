

import java.util.ArrayList;
import java.util.UUID;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class FacadeTest {
    private FACADE facade;

    @BeforeEach
    public void loginTest(){
        //Boolean check = facade.login("klong");
        System.out.println(facade.login("klong"));
    }

    @AfterEach
    public void logoutTest(){
        facade.logout();
    }
    
    @Test
    public void getMajorUUID(){
        Major UUIDMajor = facade.getMajorByUUID("nipNorp");
    }

    @Test
    public void getCourseUUID(){
        Course UUIDcourse = facade.getCourseByUUID(null);
        UUIDcourse.courseID();
    }

    @Test
    public void saveUsersTest(){
        facade.saveUsers();
    }

    @Test
    public void regAdvisorTest(){
        System.out.println( facade.registerAdvisor(null, null, null, null, null));
    }

    @Test
    public void regStudentTest(){
        System.out.println(facade.registerStudent(null, null, null, null, null, null));
    }

    @Test
    public void addCourseTest(){
        System.out.println(facade.addCourse(null, null, null, null, null, null, 0, 0))
    }

    @Test
    public void addMajorTest() {
        Boolean check = facade.addMajor(null, null, null, null, 0);
        System.out.println(check);
    }


    @Test
    public void getStudentCoursesTest(){
        ArrayList<String> stuCourses = facade.getStudentCourses();
        for (String course : stuCourses) {
            System.out.println(course);
        }
    }

    @Test
    public void listAdviseesTest(){
        facade.listAdvisees();
    }

    @Test
    public void addAdviseeTest(){
        facade.addAdvisee(null);
    }

    @Test
    public void viewStudentProgressTest(){
        facade.viewStudentProgress(null);
    }

    @Test
    public void makeNoteTest(){
        facade.makeNote(null, null);
    }

    @Test
    public void viewProgressTest(){
        facade.viewProgress();
    }
}


