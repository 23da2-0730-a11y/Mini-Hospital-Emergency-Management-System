package hospital;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    static PatientBST patientBST = new PatientBST();

    static EmergencyQueue emergencyQueue =
            new EmergencyQueue(50);

    static TreatmentStack treatmentStack =
            new TreatmentStack(50);

    public static void main(String[] args) {

        int choice;

        do {

            displayMenu();

            choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    addPatient();
                    break;

                case 2:
                    searchPatient();
                    break;

                case 3:
                    deletePatient();
                    break;

                case 4:
                    patientBST.displayInOrder();
                    break;

                case 5:
                    addEmergencyPatient();
                    break;

                case 6:
                    treatNextPatient();
                    break;

                case 7:
                    emergencyQueue.displayQueue();
                    break;

                case 8:
                    addTreatment();
                    break;

                case 9:
                    removeTreatment();
                    break;

                case 10:
                    treatmentStack.displayStack();
                    break;

                case 11:
                    addVisit();
                    break;

                case 12:
                    removeVisit();
                    break;

                case 13:
                    searchVisit();
                    break;

                case 14:
                    displayVisitHistory();
                    break;

                case 0:
                    System.out.println("Program ended.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);

        scanner.close();
    }

    // MENU
    public static void displayMenu() {

        System.out.println();
        System.out.println("==============================================");
        System.out.println(" MINI HOSPITAL EMERGENCY MANAGEMENT SYSTEM");
        System.out.println("==============================================");

        System.out.println("1. Add Patient");
        System.out.println("2. Search Patient");
        System.out.println("3. Delete Patient");
        System.out.println("4. Display All Patients");

        System.out.println("5. Add Emergency Patient");
        System.out.println("6. Treat Next Patient");
        System.out.println("7. Display Emergency Queue");

        System.out.println("8. Add Treatment");
        System.out.println("9. Remove Latest Treatment");
        System.out.println("10. Display Treatment History");

        System.out.println("11. Add Patient Visit");
        System.out.println("12. Remove Patient Visit");
        System.out.println("13. Search Patient Visit");
        System.out.println("14. Display Visit History");

        System.out.println("0. Exit");

        System.out.println("==============================================");
    }

    // ADD PATIENT
    public static void addPatient() {

        System.out.println("\n===== ADD PATIENT =====");

        int id = readInt("Patient ID: ");

        if (patientBST.search(id) != null) {

            System.out.println("Patient ID already exists.");
            return;
        }

        System.out.print("Patient Name: ");
        String name = scanner.nextLine();

        int age = readInt("Age: ");

        System.out.print("Contact Number: ");
        String contact = scanner.nextLine();

        System.out.print("Medical Condition: ");
        String condition = scanner.nextLine();

        Patient patient = new Patient(
                id,
                name,
                age,
                contact,
                condition
        );

        patientBST.insert(patient);

        System.out.println("Patient added successfully.");
    }

    // SEARCH PATIENT
    public static void searchPatient() {

        int id = readInt("Enter Patient ID: ");

        Patient patient = patientBST.search(id);

        if (patient == null) {

            System.out.println("Patient not found.");

        } else {

            System.out.println("\n===== PATIENT FOUND =====");

            patient.displayPatient();
        }
    }

    // DELETE PATIENT
    public static void deletePatient() {

        int id = readInt("Enter Patient ID: ");

        patientBST.delete(id);
    }

    // ADD EMERGENCY PATIENT
    public static void addEmergencyPatient() {

        int id = readInt(
                "Enter Patient ID for emergency queue: "
        );

        Patient patient = patientBST.search(id);

        if (patient == null) {

            System.out.println("Patient not found.");
            return;
        }

        emergencyQueue.enqueue(patient);
    }

    // TREAT NEXT PATIENT
    public static void treatNextPatient() {

        Patient patient = emergencyQueue.dequeue();

        if (patient == null) {
            return;
        }

        System.out.println(
                "\nNow treating: "
                + patient.getPatientName()
        );

        System.out.println(
                "Patient ID: "
                + patient.getPatientId()
        );
    }

    // ADD TREATMENT
    public static void addTreatment() {

        int id = readInt("Patient ID: ");

        Patient patient = patientBST.search(id);

        if (patient == null) {

            System.out.println("Patient not found.");
            return;
        }

        System.out.print("Doctor Name: ");
        String doctor = scanner.nextLine();

        System.out.print("Treatment: ");
        String treatment = scanner.nextLine();

        String record =
                "Patient ID: " + patient.getPatientId()
                + " | Patient: " + patient.getPatientName()
                + " | Doctor: " + doctor
                + " | Treatment: " + treatment;

        treatmentStack.push(record);
    }

    // REMOVE LATEST TREATMENT
    public static void removeTreatment() {

        String treatment = treatmentStack.pop();

        if (treatment != null) {

            System.out.println(
                    "Removed: " + treatment
            );
        }
    }

    // ADD VISIT
    public static void addVisit() {

        int patientId = readInt("Patient ID: ");

        Patient patient = patientBST.search(patientId);

        if (patient == null) {

            System.out.println("Patient not found.");
            return;
        }

        int visitId = readInt("Visit ID: ");

        System.out.print("Visit Date: ");
        String date = scanner.nextLine();

        System.out.print("Doctor Name: ");
        String doctor = scanner.nextLine();

        System.out.print("Diagnosis: ");
        String diagnosis = scanner.nextLine();

        System.out.print("Treatment: ");
        String treatment = scanner.nextLine();

        Visit visit = new Visit(
                visitId,
                date,
                doctor,
                diagnosis,
                treatment
        );

        patient.getVisitHistory().addVisit(visit);

        System.out.println("Visit added successfully.");
    }

    // REMOVE VISIT
    public static void removeVisit() {

        int patientId = readInt("Patient ID: ");

        Patient patient = patientBST.search(patientId);

        if (patient == null) {

            System.out.println("Patient not found.");
            return;
        }

        int visitId = readInt("Visit ID: ");

        boolean result =
                patient.getVisitHistory()
                       .removeVisit(visitId);

        if (result) {

            System.out.println(
                    "Visit removed successfully."
            );

        } else {

            System.out.println("Visit not found.");
        }
    }

    // SEARCH VISIT
    public static void searchVisit() {

        int patientId = readInt("Patient ID: ");

        Patient patient = patientBST.search(patientId);

        if (patient == null) {

            System.out.println("Patient not found.");
            return;
        }

        int visitId = readInt("Visit ID: ");

        Visit visit =
                patient.getVisitHistory()
                       .searchVisit(visitId);

        if (visit == null) {

            System.out.println("Visit not found.");

        } else {

            System.out.println("\n===== VISIT FOUND =====");

            visit.displayVisit();
        }
    }

    // DISPLAY VISIT HISTORY
    public static void displayVisitHistory() {

        int patientId = readInt("Patient ID: ");

        Patient patient = patientBST.search(patientId);

        if (patient == null) {

            System.out.println("Patient not found.");
            return;
        }

        System.out.println(
                "\nPatient: "
                + patient.getPatientName()
        );

        patient.getVisitHistory().displayHistory();
    }

    // READ INTEGER
    public static int readInt(String message) {

        while (true) {

            try {

                System.out.print(message);

                return Integer.parseInt(
                        scanner.nextLine()
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Please enter a valid number."
                );
            }
        }
    }
}