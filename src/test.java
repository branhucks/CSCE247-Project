import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        Course testCourse1 = new Course("null", "22", null, 3);
        Course testCourse2 = new Course("ulln", "212", null, 5);

        ArrayList<Course> finsihedCourse = new ArrayList<Course>();
        finsihedCourse.add(testCourse2);

        ArrayList<Course> finsihedCourse2 = new ArrayList<Course>();
        finsihedCourse2.add(testCourse1);

        Major test = new Major("the major", finsihedCourse, 10);
        
        System.out.println(test.getProgress(finsihedCourse2));
    }
}
