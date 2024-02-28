import java.util.ArrayList;

public class UserList {
    private static UserList users;
    private ArrayList<Student> students;
    private ArrayList<Advisor> advisors;

    private UserList() {
        students = DataLoader.getStudents();
        advisors = DataLoader.getAdvisors();
    }

    public static UserList getInstance() {
        if (users == null) {
            users = new UserList();
        }
        return users;
    }

    public boolean haveUser(String username) {
        for (Student student : students) {
            if (student.getUsername().equals(username)) {
                return true;
            }
        }
        for (Advisor advisor : advisors) {
            if (advisor.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public User getUser(String username) {
        for (Student student : students) {
            if (student.getUsername().equals(username)) {
                return student;
            }
        }
        for (Advisor advisor : advisors) {
            if (advisor.getUsername().equals(username)) {
                return advisor;
            }
        }
        return null;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public ArrayList<Advisor> getAdvisors() {
        return advisors;
    }

    public boolean addUser(String username, String firstName, String lastName, String userType) {
        if (haveUser(username)) {
            return false;
        }
        if (userType.equalsIgnoreCase("Student")) {
            students.add(new Student(username, firstName, lastName, userType, null, null, null, null));
        } else if (userType.equalsIgnoreCase("Advisor")) {
            advisors.add(new Advisor(username, firstName, lastName, userType, null));
        }
        return true;
    }

    public void saveUsers() {
        DataWriter.saveUsers(students, advisors);
    }
}
