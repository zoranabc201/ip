import java.util.Scanner;
public class Duke {
    void printWelcome() {
        System.out.println("Hello I'm Duke\nWhat can I do for you?");
    }
    void echocommands() {
        Scanner input = new Scanner(System.in);
        String command = input.nextLine();
        while(!command.equals("bye")) {
            System.out.println(command);
            command = input.nextLine();
        }
        System.out.println("Bye. Hope to see you again soon!");
    }
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        Duke duke = new Duke();
        duke.printWelcome();//comment
        duke.echocommands();
    }
}
