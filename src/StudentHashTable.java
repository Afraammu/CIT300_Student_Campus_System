import java.util.HashMap;

public class StudentHashTable {

    private HashMap<String, Student> studentTable;

    public StudentHashTable() {
        studentTable = new HashMap<>();
    }

    // Add student to hash table
    public boolean addStudent(Student student) {

        String studentId = student.getStudentId();

        if (studentTable.containsKey(studentId)) {
            return false;
        }

        studentTable.put(studentId, student);
        return true;
    }

    // Search student by ID
    public Student searchStudent(String studentId) {
        return studentTable.get(studentId);
    }

    // Remove student by ID
    public Student removeStudent(String studentId) {
        return studentTable.remove(studentId);
    }

    // Check whether student exists
    public boolean containsStudent(String studentId) {
        return studentTable.containsKey(studentId);
    }

    // Display all students in hash table
    public void displayStudents() {

        if (studentTable.isEmpty()) {
            System.out.println("Hash table is empty.");
            return;
        }

        System.out.println("\n===== Students in Hash Table =====");

        for (Student student : studentTable.values()) {
            System.out.println(student);
        }
    }
}