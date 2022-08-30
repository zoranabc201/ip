import java.util.Scanner;
public class Duke {
    void printWelcome() {
        System.out.println("Hello I'm Duke\nWhat can I do for you?");
    }
    void acceptCommands() {
        Scanner input = new Scanner(System.in);
        String command;
        String commandList[] = new String[100];
        int noOfCommands = 0;
        do {
            command = input.nextLine();
            if(command.equals("list")) {
                displayList(commandList, noOfCommands);
                continue;
            }
            System.out.println("added: "+command);
            commandList[noOfCommands++] = command;
        }
        while(!command.equals("bye"));
        System.out.println("Bye. Hope to see you again soon!");
    }
    void displayList(String[] commandList, int noOfCommands) {
        for(int i = 0; i < noOfCommands; i++ ) {
            System.out.println((i+1)+". "+commandList[i]);
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
        duke.acceptCommands();
    }
}
