package hospital;

public class EmergencyQueue {

    private Patient[] queue;
    private int front;
    private int rear;
    private int size;

    public EmergencyQueue(int capacity) {

        queue = new Patient[capacity];

        front = 0;
        rear = -1;
        size = 0;
    }

    // ENQUEUE
    public void enqueue(Patient patient) {

        if (size == queue.length) {

            System.out.println("Emergency queue is full.");
            return;
        }

        rear = (rear + 1) % queue.length;

        queue[rear] = patient;

        size++;

        System.out.println(
                patient.getPatientName()
                + " added to emergency queue."
        );
    }

    // DEQUEUE
    public Patient dequeue() {

        if (isEmpty()) {

            System.out.println("Emergency queue is empty.");
            return null;
        }

        Patient patient = queue[front];

        queue[front] = null;

        front = (front + 1) % queue.length;

        size--;

        return patient;
    }

    // DISPLAY
    public void displayQueue() {

        if (isEmpty()) {

            System.out.println("Emergency queue is empty.");
            return;
        }

        System.out.println("\n===== EMERGENCY QUEUE =====");

        for (int i = 0; i < size; i++) {

            int index = (front + i) % queue.length;

            System.out.println(
                    "Patient ID: "
                    + queue[index].getPatientId()
                    + " | Name: "
                    + queue[index].getPatientName()
            );
        }
    }

    // CHECK EMPTY
    public boolean isEmpty() {

        return size == 0;
    }
}