package Duke;

import java.util.Scanner;

public class Duke {
    void printWelcome() {
        System.out.println("Hello I'm Duke\nWhat can I do for you?");
    }

    void acceptInput() {
        Scanner SC = new Scanner(System.in);
        TaskManager TM = new TaskManager();
        String input;
        while (true) {
            input = SC.nextLine();
            input.trim();
            if (input.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                break;
            } else if(input.equals("list")) {
                TM.addTask("list", "");
            } else {
                TM.acceptTask(input);
            }
        }
    }
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        Duke duke = new Duke();
        duke.printWelcome();
        duke.acceptInput();
    }
}
