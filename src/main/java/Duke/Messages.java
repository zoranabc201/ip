package Duke;

public class Messages {
    public void welcomeMessage() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("Hello I'm Duke\nWhat can I do for you?");
    }
    public String lineBreak = "------------------------------------------------------------------------------";
    public String initialAddTaskMessage = "Got it. I've added this task:";
    public String finalAddTaskMessageP1 = "Now you have ";
    public String FinalAddTaskMessageP2 = " tasks in the list";
    public String listMessage = "Here are the tasks in your list:";
    public String marked = "[X] ";
    public String unmarked = "[ ] ";
    public String bye = "Bye! Hope to see you again soon!";
    public String markAsDone = "Nice! I've marked this task as done";
    public String unmarkAsNotDone = "OK, I've marked this task as not done";
    public String deleteMessage = "Noted. I've removed this task:";
}
