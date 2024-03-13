
public class test {
    private FACADE facade = new FACADE();

    public static void main(String[] args) {
        CourseList courseList = new CourseList();
        for (Course course : courseList.getCourses()) {
            System.out.println(course.getCourseName());
        }
    }
}
