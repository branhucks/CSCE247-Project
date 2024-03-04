
//import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        UserList userList = new UserList();
        for (Advisor advisor : userList.getAdvisors()) {
            System.out.println("Advisor username: " + advisor.getUsername());
            System.out.println("Advisor UUID: " + advisor.getUUID());
            for (String uuid : advisor.getAdvisees()) {
                Student student = userList.getStudentByUUID(uuid);
                System.out.println("Student uuid: " + student.getUUID());
                System.out.println("Student username: " + student.getUsername());
            }
        }
    }

}
