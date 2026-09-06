package hospital;

public class PatientBST {

    private class Node {

        Patient patient;
        Node left;
        Node right;

        Node(Patient patient) {
            this.patient = patient;
            left = null;
            right = null;
        }
    }

    private Node root;

    // INSERT
    public void insert(Patient patient) {

        root = insertNode(root, patient);
    }

    private Node insertNode(Node root, Patient patient) {

        if (root == null) {
            return new Node(patient);
        }

        if (patient.getPatientId() < root.patient.getPatientId()) {

            root.left = insertNode(root.left, patient);

        } else if (patient.getPatientId() > root.patient.getPatientId()) {

            root.right = insertNode(root.right, patient);

        } else {

            System.out.println("Patient ID already exists.");
        }

        return root;
    }

    // SEARCH
    public Patient search(int id) {

        Node result = searchNode(root, id);

        if (result != null) {
            return result.patient;
        }

        return null;
    }

    private Node searchNode(Node root, int id) {

        if (root == null) {
            return null;
        }

        if (id == root.patient.getPatientId()) {
            return root;
        }

        if (id < root.patient.getPatientId()) {
            return searchNode(root.left, id);
        }

        return searchNode(root.right, id);
    }

    // DELETE
    public void delete(int id) {

        if (search(id) == null) {

            System.out.println("Patient not found.");
            return;
        }

        root = deleteNode(root, id);

        System.out.println("Patient deleted successfully.");
    }

    private Node deleteNode(Node root, int id) {

        if (root == null) {
            return null;
        }

        if (id < root.patient.getPatientId()) {

            root.left = deleteNode(root.left, id);

        } else if (id > root.patient.getPatientId()) {

            root.right = deleteNode(root.right, id);

        } else {

            // No child
            if (root.left == null && root.right == null) {
                return null;
            }

            // Only right child
            if (root.left == null) {
                return root.right;
            }

            // Only left child
            if (root.right == null) {
                return root.left;
            }

            // Two children
            Node smallest = findSmallest(root.right);

            root.patient = smallest.patient;

            root.right = deleteNode(
                    root.right,
                    smallest.patient.getPatientId()
            );
        }

        return root;
    }

    private Node findSmallest(Node root) {

        while (root.left != null) {
            root = root.left;
        }

        return root;
    }

    // IN-ORDER
    public void displayInOrder() {

        if (root == null) {

            System.out.println("No patients registered.");
            return;
        }

        System.out.println("\n===== ALL PATIENTS =====");

        inOrder(root);
    }

    private void inOrder(Node root) {

        if (root != null) {

            inOrder(root.left);

            root.patient.displayPatient();

            System.out.println("------------------------");

            inOrder(root.right);
        }
    }
}