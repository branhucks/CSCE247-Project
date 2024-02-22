public class SemesterPlan extends Course {
    private ArrayList<Course> courses;

    public SemesterPlan(ArrayList<Course> courses) {
        super();
        this.courses = courses;
    }

    public ArrayList<Course> listCompletedCourses() {
        return courses;
    }

    public ArrayList<Course> listInProgressCourses() {
        return courses;
    }

    public ArrayList<Course> listIncompleteCourses() {
        return courses;
    }

    public SemesterPlan viewSemesterPlan() {
        return semesterPlan;
    }
}
