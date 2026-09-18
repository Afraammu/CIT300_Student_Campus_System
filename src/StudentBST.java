
public class StudentBST {

    // Node for BST
    private class Node {
        Student student;
        Node left;
        Node right;

        Node(Student student) {
            this.student = student;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;

    // Insert student into BST
    public boolean insert(Student student) {

        if (root == null) {
            root = new Node(student);
            return true;
        }

        return insertNode(root, student);
    }

    private boolean insertNode(Node current, Student student) {

        int comparison = student.getStudentId()
                .compareToIgnoreCase(current.student.getStudentId());

        if (comparison == 0) {
            return false;
        }

        if (comparison < 0) {

            if (current.left == null) {
                current.left = new Node(student);
                return true;
            }

            return insertNode(current.left, student);

        } else {

            if (current.right == null) {
                current.right = new Node(student);
                return true;
            }

            return insertNode(current.right, student);
        }
    }

    // Search student by ID
    public Student search(String studentId) {

        Node current = root;

        while (current != null) {

            int comparison = studentId
                    .compareToIgnoreCase(current.student.getStudentId());

            if (comparison == 0) {
                return current.student;
            }

            if (comparison < 0) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return null;
    }

    // Delete student from BST
    public boolean delete(String studentId) {

        if (search(studentId) == null) {
            return false;
        }

        root = deleteNode(root, studentId);

        return true;
    }

    private Node deleteNode(Node node, String studentId) {

        if (node == null) {
            return null;
        }

        int comparison = studentId
                .compareToIgnoreCase(node.student.getStudentId());

        if (comparison < 0) {

            node.left = deleteNode(node.left, studentId);

        } else if (comparison > 0) {

            node.right = deleteNode(node.right, studentId);

        } else {

            // Case 1: No left child
            if (node.left == null) {
                return node.right;
            }

            // Case 2: No right child
            if (node.right == null) {
                return node.left;
            }

            // Case 3: Two children
            Node successor = findMinimum(node.right);

            node.student = successor.student;

            node.right = deleteNode(
                    node.right,
                    successor.student.getStudentId()
            );
        }

        return node;
    }

    // Find smallest node in a subtree
    private Node findMinimum(Node node) {

        while (node.left != null) {
            node = node.left;
        }

        return node;
    }

    // Display students using In-Order Traversal
    public void displayStudents() {

        if (root == null) {
            System.out.println("BST is empty.");
            return;
        }

        System.out.println("\n===== Students in BST =====");

        inOrder(root);
    }

    private void inOrder(Node node) {

        if (node == null) {
            return;
        }

        inOrder(node.left);

        System.out.println(node.student);

        inOrder(node.right);
    }
}

