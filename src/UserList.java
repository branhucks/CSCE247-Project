import java.util.ArrayList;

public class UserList {
    private static UserList users;
    private ArrayList<User> userList;

    private UserList() {
        userList = DataLoader.getUsers();
    }

    public static UserList getInstance() {
        if (users == null) {
            users = new UserList();
        }
        return users;
    }

    public boolean haveUser(String username) {
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public User getUser(String username) {
        for (User user : userList) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public ArrayList<User> getUsers() {
        return userList;
    }

    public boolean addUser(String username, String password, String firstName, String lastName) {
        if (haveUser(username))
            return false;
        userList.add(new User(firstName, lastName, username, password));
        return true;
    }

    public void saveUsers() {
        DataWriter.saveUsers();
    }
}