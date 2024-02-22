public class User {
    
    protected UUID id;
    protected String firstName;
    protected String lastName;
    protected String username;
    protected String password;

    public User(String firstName, String lastName, String username, String password)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }

    public User(UUID id, String firstName, String lastName, String username, String password)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }
    public User login()
    {
        return new User("firstName", "lastName", "username", "password");
    }
    public void logout()
    {

    }
}
