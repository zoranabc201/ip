package Duke;

public class Todo extends Task {
    String description;
    Todo(String description) {
        this.description = description;
    }
    @Override
    public void initializeMessage() {
        System.out.println("Got it. I've added this task:");
        displayMessage();
        System.out.println("Now you have " + TaskManager.noOfTasks + " tasks in the list");
    }
    @Override
    void displayMessage() {
        System.out.print("[T]");
        if (isMarked()) {
            System.out.print("[X]");
        } else {
            System.out.print("[ ]");
        }
        System.out.println(description);
    }
}
