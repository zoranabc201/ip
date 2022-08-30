import java.util.Scanner;
public class Duke {
    Tasks taskList[] = new Tasks[100];
    void printWelcome() {
        System.out.println("Hello I'm Duke\nWhat can I do for you?");
    }
    void acceptCommands() {
        Scanner input = new Scanner(System.in);
        String command;
        int noOfCommands = 0;
        do {
            command = input.nextLine();
            if(command.equals("list")) {
                displayList(noOfCommands);
                continue;
            }
            if(command.indexOf(' ') > 0 && command.substring(0,command.indexOf(' ')).equals("mark")) {
                markTasks(Integer.parseInt(command.substring(command.lastIndexOf(' ') + 1)));
                continue;
            }
            if(command.indexOf(' ') > 0 && command.substring(0,command.indexOf(' ')).equals("unmark")) {
                unmarkTasks(Integer.parseInt(command.substring(command.lastIndexOf(' ') + 1)));
                continue;
            }

            System.out.println("added: "+command);
            taskList[noOfCommands] = new Tasks();
            taskList[noOfCommands++].setTaskName(command);
        }
        while(!command.equals("bye"));
        System.out.println("Bye. Hope to see you again soon!");
    }
    void markTasks(int taskNumber) {
        System.out.println("Nice! I've marked this task as done:");
        taskList[taskNumber-1].setDone(true);
        System.out.println((taskNumber)+". "+ taskList[taskNumber-1].taskDoneStatus()+ taskList[taskNumber-1].getTaskName());
    }
    void unmarkTasks(int taskNumber) {
        System.out.println("OK, I've marked this task as not done yet:");
        taskList[taskNumber-1].setDone(false);
        System.out.println((taskNumber)+". "+ taskList[taskNumber-1].taskDoneStatus()+ taskList[taskNumber-1].getTaskName());
    }
    void displayList(int noOfCommands) {
        for(int i = 0; i < noOfCommands; i++ ) {
            System.out.println((i+1)+". "+ taskList[i].taskDoneStatus()+ taskList[i].getTaskName());
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
