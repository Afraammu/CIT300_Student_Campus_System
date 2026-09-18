public class StudentLinkedList {

    // Node class
    private class Node {
        Student student;
        Node next;

        Node(Student student) {
            this.student = student;
            this.next = null;
        }
    }

    private Node head;

    // Add student
    public void addStudent(Student student) {
        Node newNode = new Node(student);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }
    }

    // Find student by ID
    public Student findStudent(String studentId) {
        Node current = head;

        while (current != null) {
            if (current.student.getStudentId().equalsIgnoreCase(studentId)) {
                return current.student;
            }

            current = current.next;
        }

        return null;
    }

    // Update student
    public boolean updateStudent(String studentId, String name,
                                 String programme, double marks) {

        Student student = findStudent(studentId);

        if (student != null) {
            student.setName(name);
            student.setProgramme(programme);
            student.setMarks(marks);
            return true;
        }

        return false;
    }

    // Delete student
    public boolean deleteStudent(String studentId) {

        if (head == null) {
            return false;
        }

        // If first node needs to be deleted
        if (head.student.getStudentId().equalsIgnoreCase(studentId)) {
            head = head.next;
            return true;
        }

        Node current = head;

        while (current.next != null) {

            if (current.next.student.getStudentId()
                    .equalsIgnoreCase(studentId)) {

                current.next = current.next.next;
                return true;
            }

            current = current.next;
        }

        return false;
    }

    // Display all students
    public void displayStudents() {

        if (head == null) {
            System.out.println("No student records available.");
            return;
        }

        Node current = head;

        System.out.println("\n===== Student Records =====");

        while (current != null) {
            System.out.println(current.student);
            current = current.next;
        }
    }

    // Check duplicate student ID
    public boolean containsStudent(String studentId) {
        return findStudent(studentId) != null;
    }
}