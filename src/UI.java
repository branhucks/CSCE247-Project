import java.util.ArrayList;
import java.util.Scanner;

public class UI {
    private static final String WELCOME_MESSAGE = "Welcome to the University of South Carolina DegreeWorks";
    private String[] menuOptions = { "Create Account", "Login", "Exit" };
    private String[] advisorOptions = { "Add Major", "Add Course", "Add Advisee", "List Advisees", "Make Note",
            "Logout" };
    private String[] studentOptions = { "View Degree Progress", "View Notes", "Print Eight Semester Plan",
            "Pick GFL Elective", "Pick Application Area", "Logout" };
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
            displayMenu();

            // Ask for command from user
            int command = getCommand(menuOptions.length);
            if (command < 0) {
                System.out.println("Invalid command.");
            }
            if (command == menuOptions.length - 1) {
                System.out.println("Exiting program. Goodbye!");
                break;
            }
            switch (command) {
                case 0:
                    createAccount();
                    break;
                case 1:
                    user = login();
                    if (user != null) {
                        break;
                    }
            }

            while (user != null) {
                if (user.getUserType().equalsIgnoreCase("Advisor")) {
                    // Display advisor menu
                    displayAdvisorMenu();
                    // Ask for command from user
                    command = getCommand(advisorOptions.length);
                    if (command < 0) {
                        System.out.println("Invalid command.");
                    }
                    if (command == advisorOptions.length - 1) {
                        facade.logout();
                        user = null;
                        break;
                    }
                    switch (command) {
                        case 0:
                            addMajor();
                            break;
                        case 1:
                            addCourse();
                            break;
                        case 2:
                            addAdvisee();
                            break;
                        case 3:
                            listAdvisees();
                            break;
                        case 4:
                            makeNote();
                            break;
                    }
                } else if (user.getUserType().equalsIgnoreCase("Student")) {
                    displayStudentMenu();
                    // Ask for command from user
                    command = getCommand(studentOptions.length);
                    if (command < 0) {
                        System.out.println("Invalid command.");
                    }
                    if (command == studentOptions.length - 1) {
                        facade.logout();
                        user = null;
                        break;
                    }
                    switch (command) {
                        case 0:
                            viewProgress();
                            break;
                        case 1:
                            viewNote();
                            break;
                        case 2:
                            printEightSemesterPlan();
                            break;
                        case 3:
                            pickGFLElective();
                            break;
                        case 4:
                            pickApplicationArea();
                            break;

                    }
                } else {
                    System.out.println("Unknown User Type.");
                    user = null;
                    break;
                }
            }
        }
        scanner.close();
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
        if (userType.equals("Advisor")) {
            String department = getField("Department");
            if (facade.registerAdvisor(username, firstName, lastName, userType, department)) {
                System.out.println("You have successfully created an Advisor account.");
            } else {
                System.out.println("Sorry an account with that username already exists.");
            }
        } else if (userType.equals("Student")) {
            String major = getField("Major");
            String classYear = getField("Class Year");
            if (facade.registerStudent(username, firstName, lastName, userType, major, classYear)) {
                System.out.println("You have successfully created a Student account.");
            } else {
                System.out.println("Sorry an account with that username already exists.");
            }
        }
        facade.saveUsers();
    }

    private User login() {
        User user = null;
        String username = getField("Username");

        if (facade.login(username)) {
            user = facade.getUser();
            System.out.println("\nWelcome " + user.getFirstName() + " " + user.getLastName());
        } else {
            System.out.println("Invalid username.");
        }
        return user;
    }

    private void addMajor() {
        String majorName = getField("Major Name");

        if (facade.addMajor(majorName, null, null, null, 125)) {
            System.out.println("You have successfully added a major.");
        } else {
            System.out.println("The major already exists.");
        }
    }

    private void addCourse() {
        String courseName = getField("Course Name");
        String subject = getField("Subject");
        String number = getField("Number");
        int creditHours = getIntField("Credit Hours");
        int passingGrade = getIntField("Passing Grade");

        if (facade.addCourse(courseName, subject, number, null, null, null, creditHours, passingGrade)) {
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

    private void makeNote() {
        System.out.println("Enter the Student's ID: ");
        String studentID = scanner.nextLine();
        System.out.println("Enter Note: ");
        String note = scanner.nextLine();
        facade.makeNote(studentID, note);
    }

    private void viewProgress() {
        facade.viewProgress();
    }

    private void viewNote() {
        System.out.println(facade.viewNote());
    }

    private void pickGFLElective() {
        /*
         * gets the GFL elective
         * first it gets the students major
         * next it gets the list of electives
         * then it loops though to find the GFL elective
         * then it prints out each of the courses in the GFL
         * then it asks the user for their choice
         * then it adds that course to the taken courses of the student
         */
        Major studentsMajor = facade.getMajorByUUID(facade.getStudent().getMajor());
        ArrayList<Electives> electives = studentsMajor.getElectives();
        ArrayList<String> GFLElective = new ArrayList<String>(); // list of strings of possible classes to take
        System.out.println("Please choose an elective:");

        // loops though the electives to find the GFL elective
        for (int i = 0; i < electives.size(); i++) {
            // Stores the elective to a varible
            Electives elective = studentsMajor.getElectives().get(i);

            if (elective.getElectiveType().equals(ElectiveType.GFL)) {
                // Loops through the courses to print out each option
                for (int j = 0; j < elective.getCourses().size(); j++) {
                    // Gets an instance of the course that the elective holds
                    String GFLCourse = elective.getCourses().get(j);

                    Boolean taken = false; // Boolean to see if the course was taken

                    // loops though the list of courses taken to see if it has been taken
                    for (int k = 0; k < facade.getStudentCourses().size(); k++) {
                        if (facade.getStudentCourses().get(k).equals(GFLCourse)) {
                            taken = true;
                        }
                    }
                    // if it wasn't taken it prints it as a choice and adds it to the list
                    if (!taken) {
                        GFLElective.add(GFLCourse);
                        System.out.println((j + 1) + " " + facade.getCourseByUUID(GFLCourse).getCourseName());
                    }

                }
            }
        }
        // adds the choice to the semesterplan2

        int choice = getCommand(GFLElective.size());
        // This is the UUID of the selected elective
        Course selectedCourse = facade.getCourseByUUID(GFLElective.get((choice)));
        addCourse(selectedCourse);

    }

    private void pickApplicationArea() {
        /*
         * You browse through the sample Application area topics.
         * You see topic areas of Science, Math, Digital Design, Robotics, and Speech.
         * You select that you want to take the Digital Design option,
         * and pick your classes.
         */
        // Application area topics,
        // see the topics and pick one then pick classes
        // TODO
        Student student = facade.getStudent();
        Major major = facade.getMajorByUUID(student.getMajor());
        ArrayList<ApplicationArea> majorAppAreas = major.getApplicationAreas();

        // Prints List of options
        System.out.println("Possible application areas for your major:");
        for (int i = 0; i < majorAppAreas.size(); i++) {
            System.out.println((i + 1) + ": " + majorAppAreas.get(i).getType().name());
        }

        int choice = (scanner.nextInt() - 1);
        scanner.nextLine();
        ApplicationArea studentAppArea = majorAppAreas.get(choice);
        facade.setApplicationType(studentAppArea.getType());

        // Prints the List of courses in the selected application area
        System.out.println("Please slelect a class that fits your applicaation area:");
        for (int i = 0; i < studentAppArea.getCourses().size(); i++) {
            System.out.println((i + 1) + ": " + facade.getCourseByUUID(studentAppArea.getCourses().get(i)));
        }

        // Gets the users choice and allows them to add any number of classes from the
        // list
        boolean checker = true;
        while (checker) {
            choice = (scanner.nextInt() - 1);
            scanner.nextLine();
            Course selectedCourse = facade.getCourseByCode(studentAppArea.getCourses().get(choice));
            addCourse(selectedCourse);
            System.out.println("Add another class? (Y/N)");
            String selectedString = scanner.nextLine();
            if (!(selectedString.equalsIgnoreCase("Y"))) {
                checker = false;
            }
        }
    }

    private void addCourse(Course course) {
        System.out.println("What Semester number do you plan to take " + course.getCourseName() + "?");
        String input = scanner.nextLine();
        int choice = Integer.parseInt(input);
        facade.getEightSemesterPlan().addCourse(course.getSubject(), course.getNumber(), choice);
    }

    private void printEightSemesterPlan() {
        facade.printEightSemesterPlan();
    }

    private String getField(String prompt) {
        System.out.print(prompt + ": ");
        return scanner.nextLine();
    }

    private int getIntField(String prompt) {
        System.out.print(prompt + ": ");
        int toReturn = scanner.nextInt();
        scanner.nextLine();
        return toReturn;
    }

    public static void main(String[] args) {
        UI uiInterface = new UI();
        uiInterface.run();
    }
}
