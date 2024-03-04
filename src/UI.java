import java.util.Scanner;

public class UI {
    private static final String WELCOME_MESSAGE = "Welcome to the University of South Carolina DegreeWorks";
    private String[] menuOptions = { "Create Account", "Login", "Add Major", "Logout" };
    private Scanner scanner;
    private FACADE facade;

    UI() {
        scanner = new Scanner(System.in);
        facade = new FACADE();
    }

    public void run() {
        System.out.println(WELCOME_MESSAGE);

        // Loop as long as we want to keep interacting
        while (true) {
            displayMenu();

            int command = getCommand(menuOptions.length);

            if (command < 0) {
                System.out.println("Invalid command.");
                continue;
            }

            if (command == menuOptions.length - 1) {
                facade.logout();
                break;
            }

            switch (command) {
                case (0):
                    createAccount();
                    break;
                case (1):
                    login();
                    break;
                case (2):
                    addMajor();
                    break;
            }
        }
        System.out.println("Exiting...");
    }

    private void displayMenu() {
        System.out.println("\n********** Main Menu **********");
        for (int i = 0; i < menuOptions.length; i++) {
            System.out.println((i + 1) + ". " + menuOptions[i]);
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

    private void login() {
        String username = getField("Username");

        if (facade.login(username)) {
            User user = facade.getUser();
            System.out.println("Welcome " + user.getFirstName() + " " + user.getLastName());
        } else {
            System.out.println("Invalid username.");
        }
    }

    private void addMajor() {
        String majorName = getField("Major Name");

        if (facade.addMajor(majorName, null, null, null, 129)) {
            System.out.println("You have successfully added a major.");
        } else {
            System.out.println("The major already exists.");
        }
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
