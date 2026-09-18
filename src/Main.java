
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StudentLinkedList studentList = new StudentLinkedList();
        ActionStack actionStack = new ActionStack();
        ServiceQueue serviceQueue = new ServiceQueue();
        StudentBST studentBST = new StudentBST();
        StudentHashTable hashTable = new StudentHashTable();
        CampusGraph campusGraph = new CampusGraph();

        int choice;

        do {

            System.out.println("\n========================================");
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

            System.out.print("\nEnter your choice: ");

            while (!scanner.hasNextInt()) {
                System.out.println(
                        "Invalid input. Please enter a number from 1 to 16."
                );
                scanner.next();
                System.out.print("Enter your choice: ");
            }

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                // ========================================
                // 1. ADD STUDENT
                // ========================================
                case 1:

                    System.out.println("\n===== Add Student Record =====");

                    System.out.print("Enter Student ID: ");
                    String studentId = scanner.nextLine().trim();

                    if (studentId.isEmpty()) {
                        System.out.println("Student ID cannot be empty.");
                        break;
                    }

                    if (studentList.containsStudent(studentId)) {
                        System.out.println("Student ID already exists.");
                        break;
                    }

                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine().trim();

                    if (name.isEmpty()) {
                        System.out.println("Student name cannot be empty.");
                        break;
                    }

                    System.out.print("Enter Programme: ");
                    String programme = scanner.nextLine().trim();

                    if (programme.isEmpty()) {
                        System.out.println("Programme cannot be empty.");
                        break;
                    }

                    System.out.print("Enter Marks: ");

                    while (!scanner.hasNextDouble()) {
                        System.out.println(
                                "Invalid marks. Please enter a number between 0 and 100."
                        );
                        scanner.next();
                        System.out.print("Enter Marks: ");
                    }

                    double marks = scanner.nextDouble();
                    scanner.nextLine();

                    if (marks < 0 || marks > 100) {
                        System.out.println(
                                "Invalid marks. Marks must be between 0 and 100."
                        );
                        break;
                    }

                    Student student = new Student(
                            studentId,
                            name,
                            programme,
                            marks
                    );

                    studentList.addStudent(student);
                    studentBST.insert(student);
                    hashTable.addStudent(student);

                    actionStack.pushAction(
                            "Added student: " + studentId
                    );

                    System.out.println(
                            "Student added successfully."
                    );

                    break;

                // ========================================
                // 2. UPDATE STUDENT
                // ========================================
                case 2:

                    System.out.println("\n===== Update Student Record =====");

                    System.out.print("Enter Student ID: ");
                    String updateId = scanner.nextLine().trim();

                    Student existingStudent =
                            studentList.findStudent(updateId);

                    if (existingStudent == null) {
                        System.out.println(
                                "Student record not found."
                        );
                        break;
                    }

                    System.out.print("Enter New Name: ");
                    String newName = scanner.nextLine().trim();

                    if (newName.isEmpty()) {
                        System.out.println(
                                "Student name cannot be empty."
                        );
                        break;
                    }

                    System.out.print("Enter New Programme: ");
                    String newProgramme =
                            scanner.nextLine().trim();

                    if (newProgramme.isEmpty()) {
                        System.out.println(
                                "Programme cannot be empty."
                        );
                        break;
                    }

                    System.out.print("Enter New Marks: ");

                    while (!scanner.hasNextDouble()) {
                        System.out.println(
                                "Invalid marks. Please enter a number between 0 and 100."
                        );
                        scanner.next();
                        System.out.print("Enter New Marks: ");
                    }

                    double newMarks = scanner.nextDouble();
                    scanner.nextLine();

                    if (newMarks < 0 || newMarks > 100) {
                        System.out.println(
                                "Invalid marks. Marks must be between 0 and 100."
                        );
                        break;
                    }

                    studentList.updateStudent(
                            updateId,
                            newName,
                            newProgramme,
                            newMarks
                    );

                    /*
                     * The BST and Hash Table store the same Student object.
                     * Therefore, updating the Student object in the
                     * Linked List also updates the same object in
                     * BST and Hash Table.
                     */

                    actionStack.pushAction(
                            "Updated student: " + updateId
                    );

                    System.out.println(
                            "Student updated successfully."
                    );

                    break;

                // ========================================
                // 3. DELETE STUDENT
                // ========================================
                case 3:

                    System.out.println("\n===== Delete Student Record =====");

                    System.out.print("Enter Student ID: ");
                    String deleteId = scanner.nextLine().trim();

                    Student studentToDelete =
                            studentList.findStudent(deleteId);

                    if (studentToDelete == null) {
                        System.out.println(
                                "Student record not found."
                        );
                        break;
                    }

                    studentList.deleteStudent(deleteId);

                    hashTable.removeStudent(deleteId);

                    studentBST.delete(deleteId);

                    actionStack.pushAction(
                            "Deleted student: " + deleteId
                    );

                    System.out.println(
                            "Student deleted successfully."
                    );

                    break;

                // ========================================
                // 4. DISPLAY LINKED LIST
                // ========================================
                case 4:

                    studentList.displayStudents();

                    break;

                // ========================================
                // 5. ADD SERVICE REQUEST
                // ========================================
                case 5:

                    System.out.println("\n===== Add Service Request =====");

                    System.out.print("Enter service request: ");
                    String request = scanner.nextLine().trim();

                    if (request.isEmpty()) {
                        System.out.println(
                                "Service request cannot be empty."
                        );
                        break;
                    }

                    serviceQueue.addRequest(request);

                    actionStack.pushAction(
                            "Added service request"
                    );

                    System.out.println(
                            "Service request added successfully."
                    );

                    break;

                // ========================================
                // 6. PROCESS SERVICE REQUEST
                // ========================================
                case 6:

                    System.out.println(
                            "\n===== Process Next Service Request ====="
                    );

                    String processedRequest =
                            serviceQueue.processRequest();

                    if (processedRequest == null) {

                        System.out.println(
                                "No service requests available."
                        );

                    } else {

                        System.out.println(
                                "Processed request: "
                                        + processedRequest
                        );

                        actionStack.pushAction(
                                "Processed service request"
                        );
                    }

                    break;

                // ========================================
                // 7. DISPLAY STACK
                // ========================================
                case 7:

                    actionStack.displayActions();

                    break;

                // ========================================
                // 8. DISPLAY BST
                // ========================================
                case 8:

                    studentBST.displayStudents();

                    break;

                // ========================================
                // 9. HASHING SEARCH
                // ========================================
                case 9:

                    System.out.println(
                            "\n===== Search Student using Hashing ====="
                    );

                    System.out.print("Enter Student ID: ");
                    String searchId = scanner.nextLine().trim();

                    Student foundStudent =
                            hashTable.searchStudent(searchId);

                    if (foundStudent == null) {

                        System.out.println(
                                "Student not found."
                        );

                    } else {

                        System.out.println(
                                "\nStudent found:"
                        );
                        System.out.println(foundStudent);
                    }

                    break;

                // ========================================
                // 10. ADD CAMPUS LOCATION
                // ========================================
                case 10:

                    System.out.println(
                            "\n===== Add Campus Location ====="
                    );

                    System.out.print("Enter location name: ");
                    String location =
                            scanner.nextLine().trim();

                    if (location.isEmpty()) {
                        System.out.println(
                                "Location name cannot be empty."
                        );
                        break;
                    }

                    if (campusGraph.addLocation(location)) {

                        actionStack.pushAction(
                                "Added campus location: "
                                        + location
                        );

                        System.out.println(
                                "Campus location added successfully."
                        );

                    } else {

                        System.out.println(
                                "Location already exists."
                        );
                    }

                    break;

                // ========================================
                // 11. REMOVE CAMPUS LOCATION
                // ========================================
                case 11:

                    System.out.println(
                            "\n===== Remove Campus Location ====="
                    );

                    System.out.print("Enter location name: ");
                    String removeLocation =
                            scanner.nextLine().trim();

                    if (campusGraph.removeLocation(
                            removeLocation)) {

                        actionStack.pushAction(
                                "Removed campus location: "
                                        + removeLocation
                        );

                        System.out.println(
                                "Campus location removed successfully."
                        );

                    } else {

                        System.out.println(
                                "Location not found."
                        );
                    }

                    break;

                // ========================================
                // 12. ADD CAMPUS CONNECTION
                // ========================================
                case 12:

                    System.out.println(
                            "\n===== Add Campus Connection ====="
                    );

                    System.out.print("Enter first location: ");
                    String from =
                            scanner.nextLine().trim();

                    System.out.print("Enter second location: ");
                    String to =
                            scanner.nextLine().trim();

                    if (campusGraph.addConnection(from, to)) {

                        actionStack.pushAction(
                                "Added campus connection: "
                                        + from + " - " + to
                        );

                        System.out.println(
                                "Campus connection added successfully."
                        );

                    } else {

                        System.out.println(
                                "Unable to add connection. "
                                        + "Check locations or duplicate connection."
                        );
                    }

                    break;

                // ========================================
                // 13. REMOVE CAMPUS CONNECTION
                // ========================================
                case 13:

                    System.out.println(
                            "\n===== Remove Campus Connection ====="
                    );

                    System.out.print("Enter first location: ");
                    String removeFrom =
                            scanner.nextLine().trim();

                    System.out.print("Enter second location: ");
                    String removeTo =
                            scanner.nextLine().trim();

                    if (campusGraph.removeConnection(
                            removeFrom,
                            removeTo)) {

                        actionStack.pushAction(
                                "Removed campus connection: "
                                        + removeFrom
                                        + " - "
                                        + removeTo
                        );

                        System.out.println(
                                "Campus connection removed successfully."
                        );

                    } else {

                        System.out.println(
                                "Connection not found."
                        );
                    }

                    break;

                // ========================================
                // 14. DISPLAY CAMPUS CONNECTIONS
                // ========================================
                case 14:

                    campusGraph.displayConnections();

                    break;

                // ========================================
                // 15. BFS TRAVERSAL
                // ========================================
                case 15:

                    System.out.println(
                            "\n===== BFS Campus Traversal ====="
                    );

                    System.out.print(
                            "Enter starting location: "
                    );

                    String startLocation =
                            scanner.nextLine().trim();

                    campusGraph.bfs(startLocation);

                    break;

                // ========================================
                // 16. EXIT
                // ========================================
                case 16:

                    System.out.println(
                            "\nThank you for using the system!"
                    );

                    break;

                // ========================================
                // INVALID CHOICE
                // ========================================
                default:

                    System.out.println(
                            "Invalid choice. "
                                    + "Please select a number from 1 to 16."
                    );
            }

        } while (choice != 16);

        scanner.close();
    }
}

