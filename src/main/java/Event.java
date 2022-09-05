class Event extends Task{
    String description;
    String at;
    Event(String description, String at) {
        this.description = description;
        this.at = at;
    }
    @Override
    void initializeMessage() {
        System.out.println("Got it! I've added this task:");
        displayMessage();
        System.out.println("Now you have "+ TaskManager.noOfTasks +" tasks in the list.");
    }

    @Override
    void displayMessage() {
        System.out.print("E");
        if(isMarked()){
            System.out.print("[X]");
        } else {
            System.out.print("[ ]");
        }
        System.out.println(description + "(at: " + at + ")");
    }
}
