import java.util.Scanner;

public class UI {
    private static final String WELCOME_MESSAGE = "Welcome to the University of South Carolina DegreeWorks";
    private String[] menuOptions = { "Create Account", "Login", "Exit" };
    private String[] advisorOptions = { "Add Major", "Add Course", "Add Advisee", "List Advisees", "Logout" };
    private String[] studentOptions = { "Logout" };
    private Scanner scanner;
    private FACADE facade;
    private User user;

    UI() {
        scanner = new Scanner(System.in);
        facade = new FACADE();
    }

    public void run() {
        // Display welcome message
        System.out.println(WELCOME_MESSAGE);

        while (true) {
            // Display first menu until user logs in
            displayMenu();

            // Ask for command from user
            int command = getCommand(menuOptions.length);
            if (command < 0) {
                System.out.println("Invalid command.");
            }
            if (command == menuOptions.length - 1) {
                facade.logout();
            }
            switch (command) {
                case (0):
                    createAccount();
                    break;
                case (1):
                    user = login();
                    break;
            }

            if (user != null) {
                System.out.println(user.getUserType());
                break;
            }
        }
        while (true) {
            if (user.getUserType().equals("Advisor")) {
                // Display advisor menu
                displayAdvisorMenu();
                // Ask for command from user
                int command = getCommand(advisorOptions.length);
                if (command < 0) {
                    System.out.println("Invalid command.");
                }
                if (command == advisorOptions.length - 1) {
                    facade.logout();
                }
                switch (command) {
                    case (0):
                        addMajor();
                        break;
                    case (1):
                        addCourse();
                        break;
                    case (2):
                        addAdvisee();
                        break;
                    case (3):
                        listAdvisees();
                        break;
                }
            } else if (user.getUserType().equals("Student")) {
                displayStudentMenu();
                // Ask for command from user
                int command = getCommand(studentOptions.length);
                if (command < 0) {
                    System.out.println("Invalid command.");
                }
                if (command == studentOptions.length - 1) {
                    facade.logout();
                }
                switch (command) {
                    case (0):
                        createAccount();
                        break;
                    case (1):
                        user = login();
                        break;
                }
            } else {
                System.out.println("Unknown User Type.");
                break;
            }
        }
    }

    private void displayMenu() {
        System.out.println("\n********** Main Menu **********");
        for (int i = 0; i < menuOptions.length; i++) {
            System.out.println((i + 1) + ". " + menuOptions[i]);
        }
        System.out.println("\n");
    }

    private void displayAdvisorMenu() {
        System.out.println("\n********** Advisor Menu **********");
        for (int i = 0; i < advisorOptions.length; i++) {
            System.out.println((i + 1) + ". " + advisorOptions[i]);
        }
        System.out.println("\n");
    }

    private void displayStudentMenu() {
        System.out.println("\n********** Student Menu **********");
        for (int i = 0; i < studentOptions.length; i++) {
            System.out.println((i + 1) + ". " + studentOptions[i]);
        }
        System.out.println("\n");
    }

    private int getCommand(int numCommands) {
        System.out.print("Please enter an option: ");

        String input = scanner.nextLine();
        int command = Integer.parseInt(input) - 1;

        if (command >= 0 && command <= numCommands - 1)
            return command;

        return -1;
    }

    private void createAccount() {
        String username = getField("Username");
        String firstName = getField("First Name");
        String lastName = getField("Last Name");
        String userType = getField("User Type");

        if (facade.registerUser(username, firstName, lastName, userType)) {
            System.out.println("You have successfully created an account.");
        } else {
            System.out.println("Sorry an account with that username already exists.");
        }
    }

    private User login() {
        User user = null;
        String username = getField("Username");

        if (facade.login(username)) {
            user = facade.getUser();
            System.out.println("Welcome " + user.getFirstName() + " " + user.getLastName());
        } else {
            System.out.println("Invalid username.");
        }
        return user;
    }

    private void addMajor() {
        String majorName = getField("Major Name");

        if (facade.addMajor(majorName, null, null, null, 129)) {
            System.out.println("You have successfully added a major.");
        } else {
            System.out.println("The major already exists.");
        }
    }

    private void addCourse() {
        String courseName = getField("Course Name");
        String courseID = getField("Course ID");

        if (facade.addCourse(courseName, courseID, null, null, null, null, null, 3, 70, false)) {
            System.out.println("You have successfully added a course.");
        } else {
            System.out.println("The course already exists");
        }
    }

    private void addAdvisee() {
        System.out.println("Enter the Student's ID: ");
        String studentID = scanner.nextLine();
        facade.addAdvisee(studentID);
    }

    private void listAdvisees() {
        facade.listAdvisees();
    }

    private String getField(String prompt) {
        System.out.print(prompt + ": ");
        return scanner.nextLine();
    }

    public static void main(String[] args) {
        UI uiInterface = new UI();
        uiInterface.run();
    }
}
