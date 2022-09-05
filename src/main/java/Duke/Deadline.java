package Duke;

class Deadline extends Task {
    String description;
    String by;
    Deadline(String description, String by) {
        this.description = description;
        this.by = by;
    }

    @Override
    void initializeMessage() {
        System.out.println("Got it! I've added this task:");
        displayMessage();
        System.out.println("Now you have "+ TaskManager.noOfTasks +" tasks in the list.");
    }

    @Override
    void displayMessage() {
        System.out.print("[D]");
        if(isMarked()) {
            System.out.print("[X]");
        } else {
            System.out.print("[ ]");
        }
        System.out.println(description + "(by: " + by + ")");
    }
}
