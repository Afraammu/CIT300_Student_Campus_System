import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    private static final StudentLinkedList studentList = new StudentLinkedList();
    private static final StudentBST studentBST = new StudentBST();
    private static final StudentHashTable studentHashTable = new StudentHashTable();
    private static final ActionStack actionStack = new ActionStack();
    private static final ServiceQueue serviceQueue = new ServiceQueue();
    private static final CampusGraph campusGraph = new CampusGraph();

    public static void main(String[] args) {

        boolean running = true;

        while (running) {

            displayMenu();

            int choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    updateStudent();
                    break;

                case 3:
                    deleteStudent();
                    break;

                case 4:
                    displayStudents();
                    break;

                case 5:
                    addServiceRequest();
                    break;

                case 6:
                    processServiceRequest();
                    break;

                case 7:
                    displayRecentActions();
                    break;

                case 8:
                    displayBST();
                    break;

                case 9:
                    searchStudentHashing();
                    break;

                case 10:
                    addCampusLocation();
                    break;

                case 11:
                    removeCampusLocation();
                    break;

                case 12:
                    addCampusConnection();
                    break;

                case 13:
                    removeCampusConnection();
                    break;

                case 14:
                    displayCampusConnections();
                    break;

                case 15:
                    traverseCampusBFS();
                    break;

                case 16:
                    running = false;
                    System.out.println("\nThank you for using the system!");
                    break;

                default:
                    System.out.println("Invalid choice. Please select 1-16.");
            }

            System.out.println();
        }

        scanner.close();
    }

    private static void displayMenu() {

        System.out.println("========================================");
        System.out.println(" University Student & Campus Management");
        System.out.println("========================================");

        System.out.println("1. Add Student Record");
        System.out.println("2. Update Student Record");
        System.out.println("3. Delete Student Record");
        System.out.println("4. Display All Records using Linked List");
        System.out.println("5. Add Service Request to Queue");
        System.out.println("6. Process Next Service Request");
        System.out.println("7. Display Recent Actions using Stack");
        System.out.println("8. Display Students using BST");
        System.out.println("9. Search Student using Hashing");
        System.out.println("10. Add Campus Location");
        System.out.println("11. Remove Campus Location");
        System.out.println("12. Add Campus Connection/Road");
        System.out.println("13. Remove Campus Connection/Road");
        System.out.println("14. Display Campus Connections");
        System.out.println("15. Traverse Campus Locations using BFS");
        System.out.println("16. Exit");
        System.out.println();
    }

    // ==============================
    // STUDENT RECORDS
    // ==============================

    private static void addStudent() {

        System.out.println("===== Add Student Record =====");

        String studentId = readStudentId("Enter Student ID: ");

        if (studentList.containsStudent(studentId)) {
            System.out.println("Error: Student ID already exists.");
            return;
        }

        String name = readNonEmptyString("Enter Student Name: ");
        String programme = readNonEmptyString("Enter Programme: ");
        double marks = readMarks("Enter Marks: ");

        Student student = new Student(
                studentId,
                name,
                programme,
                marks
        );

        studentList.addStudent(student);
        studentBST.insert(student);
        studentHashTable.addStudent(student);

        actionStack.pushAction("Added student: " + studentId);

        System.out.println("Student added successfully.");
    }

    private static void updateStudent() {

        System.out.println("===== Update Student Record =====");

        String studentId = readStudentId("Enter Student ID: ");

        Student student = studentList.findStudent(studentId);

        if (student == null) {
            System.out.println("Student record not found.");
            return;
        }

        String name = readNonEmptyString("Enter New Student Name: ");
        String programme = readNonEmptyString("Enter New Programme: ");
        double marks = readMarks("Enter New Marks: ");

        studentList.updateStudent(
                studentId,
                name,
                programme,
                marks
        );

        actionStack.pushAction("Updated student: " + studentId);

        System.out.println("Student updated successfully.");
    }

    private static void deleteStudent() {

        System.out.println("===== Delete Student Record =====");

        String studentId = readStudentId("Enter Student ID: ");

        Student student = studentList.findStudent(studentId);

        if (student == null) {
            System.out.println("Student record not found.");
            return;
        }

        studentList.deleteStudent(studentId);
        studentBST.delete(studentId);
        studentHashTable.removeStudent(studentId);

        actionStack.pushAction("Deleted student: " + studentId);

        System.out.println("Student deleted successfully.");
    }

    private static void displayStudents() {

        System.out.println("===== Student Records - Linked List =====");

        studentList.displayStudents();
    }

    // ==============================
    // QUEUE
    // ==============================

    private static void addServiceRequest() {

        System.out.println("===== Add Service Request =====");

        String request = readNonEmptyString("Enter Service Request: ");

        serviceQueue.addRequest(request);

        actionStack.pushAction("Added service request: " + request);

        System.out.println("Service request added successfully.");
    }

    private static void processServiceRequest() {

        System.out.println("===== Process Service Request =====");

        if (serviceQueue.isEmpty()) {
            System.out.println("No service requests available.");
            return;
        }

        String request = serviceQueue.processRequest();

        actionStack.pushAction("Processed service request: " + request);

        System.out.println("Processed request: " + request);
    }

    // ==============================
    // STACK
    // ==============================

    private static void displayRecentActions() {

        System.out.println("===== Recent System Actions - Stack =====");

        actionStack.displayActions();
    }

    // ==============================
    // BST
    // ==============================

    private static void displayBST() {

        System.out.println("===== Students - Binary Search Tree =====");

        studentBST.displayStudents();
    }

    // ==============================
    // HASHING
    // ==============================

    private static void searchStudentHashing() {

        System.out.println("===== Search Student using Hashing =====");

        String studentId = readStudentId("Enter Student ID: ");

        Student student = studentHashTable.searchStudent(studentId);

        if (student == null) {
            System.out.println("Student not found.");
        } else {
            System.out.println("Student found:");
            System.out.println(student);
        }
    }

    // ==============================
    // CAMPUS GRAPH
    // ==============================

    private static void addCampusLocation() {

        System.out.println("===== Add Campus Location =====");

        String location = readNonEmptyString("Enter Location Name: ");

        if (campusGraph.containsLocation(location)) {
            System.out.println("Error: Location already exists.");
            return;
        }

        campusGraph.addLocation(location);

        actionStack.pushAction(
                "Added campus location: " + location
        );

        System.out.println("Campus location added successfully.");
    }

    private static void removeCampusLocation() {

        System.out.println("===== Remove Campus Location =====");

        String location = readNonEmptyString("Enter Location Name: ");

        if (!campusGraph.containsLocation(location)) {
            System.out.println("Location not found.");
            return;
        }

        campusGraph.removeLocation(location);

        actionStack.pushAction(
                "Removed campus location: " + location
        );

        System.out.println("Campus location removed successfully.");
    }

    private static void addCampusConnection() {

        System.out.println("===== Add Campus Connection =====");

        String location1 =
                readNonEmptyString("Enter First Location: ");

        String location2 =
                readNonEmptyString("Enter Second Location: ");

        if (!campusGraph.containsLocation(location1)) {
            System.out.println("First location does not exist.");
            return;
        }

        if (!campusGraph.containsLocation(location2)) {
            System.out.println("Second location does not exist.");
            return;
        }

        if (location1.equalsIgnoreCase(location2)) {
            System.out.println(
                    "A location cannot connect to itself."
            );
            return;
        }

        campusGraph.addConnection(location1, location2);

        actionStack.pushAction(
                "Added campus connection: "
                        + location1 + " - " + location2
        );

        System.out.println(
                "Campus connection added successfully."
        );
    }

    private static void removeCampusConnection() {

        System.out.println("===== Remove Campus Connection =====");

        String location1 =
                readNonEmptyString("Enter First Location: ");

        String location2 =
                readNonEmptyString("Enter Second Location: ");

        if (!campusGraph.containsLocation(location1)
                || !campusGraph.containsLocation(location2)) {

            System.out.println(
                    "One or both locations do not exist."
            );
            return;
        }

        campusGraph.removeConnection(location1, location2);

        actionStack.pushAction(
                "Removed campus connection: "
                        + location1 + " - " + location2
        );

        System.out.println(
                "Campus connection removed successfully."
        );
    }

    private static void displayCampusConnections() {

        System.out.println(
                "===== Campus Connections - Adjacency List ====="
        );

        campusGraph.displayConnections();
    }

    private static void traverseCampusBFS() {

        System.out.println("===== BFS Campus Traversal =====");

        String startLocation =
                readNonEmptyString(
                        "Enter Starting Location: "
                );

        if (!campusGraph.containsLocation(startLocation)) {
            System.out.println("Location not found.");
            return;
        }

        System.out.println("BFS Traversal:");

        campusGraph.bfs(startLocation);
    }

    // ==============================
    // INPUT VALIDATION
    // ==============================

    private static String readNonEmptyString(String message) {

        while (true) {

            System.out.print(message);

            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println(
                        "Input cannot be empty. Please try again."
                );
            } else {
                return input;
            }
        }
    }

    private static String readStudentId(String message) {

        while (true) {

            System.out.print(message);

            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println(
                        "Student ID cannot be empty."
                );
                continue;
            }

            if (input.matches("\\d{4}")) {
                input = "23DA2-" + input;
            }

            if (!input.matches("23DA2-\\d{4}")) {
                System.out.println(
                        "Invalid Student ID. Use format 23DA2-0992 "
                                + "or enter the last 4 digits."
                );
                continue;
            }

            return input;
        }
    }

    private static double readMarks(String message) {

        while (true) {

            System.out.print(message);

            String input = scanner.nextLine().trim();

            try {

                double marks = Double.parseDouble(input);

                if (marks < 0 || marks > 100) {
                    System.out.println(
                            "Invalid marks. Marks must be between 0 and 100."
                    );
                    continue;
                }

                return marks;

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid marks. Please enter a number."
                );
            }
        }
    }

    private static int readInt(String message) {

        while (true) {

            System.out.print(message);

            String input = scanner.nextLine().trim();

            try {

                return Integer.parseInt(input);

            } catch (NumberFormatException e) {

                System.out.println(
                        "Invalid input. Please enter a number."
                );
            }
        }
    }
}