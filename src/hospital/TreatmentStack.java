package hospital;

public class TreatmentStack {

    private String[] stack;
    private int top;

    public TreatmentStack(int size) {

        stack = new String[size];

        top = -1;
    }

    // PUSH
    public void push(String treatment) {

        if (top == stack.length - 1) {

            System.out.println("Treatment stack is full.");
            return;
        }

        top++;

        stack[top] = treatment;

        System.out.println("Treatment record added.");
    }

    // POP
    public String pop() {

        if (isEmpty()) {

            System.out.println("Treatment stack is empty.");
            return null;
        }

        String treatment = stack[top];

        stack[top] = null;

        top--;

        return treatment;
    }

    // DISPLAY
    public void displayStack() {

        if (isEmpty()) {

            System.out.println("Treatment stack is empty.");
            return;
        }

        System.out.println("\n===== TREATMENT HISTORY =====");

        for (int i = top; i >= 0; i--) {

            System.out.println((i + 1) + ". " + stack[i]);
        }
    }

    // CHECK EMPTY
    public boolean isEmpty() {

        return top == -1;
    }
}