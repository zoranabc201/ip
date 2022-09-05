import java.util.Scanner;

public class TaskManager {
    static int noOfTasks;
    final int maxTasks = 100;
    DukeException e = new DukeException();

    TaskManager() {
        noOfTasks = 0;
    }

    void acceptTask(String input) {
        input = input.trim();
        int endOfCommand = input.indexOf(' ');
        if (endOfCommand == -1) {
            e.notRecognizedException();
        } else {
            String command = input.substring(0, endOfCommand);
            String parameter = input.substring(endOfCommand);
            parameter = parameter.trim();
            addTask(command, parameter);
        }
    }

    Task[] tasks = new Task[maxTasks];

    void addTask(String command, String parameter) {
        switch (command) {
        case "list":
            showTasks();
            break;
        case "todo":
            if (parameter.equals("")) {
                e.todoException();
                break;
            }
            addTodo(parameter);
            break;
        case "mark":
            if (parameter.equals("") || !containsNumber(parameter)) {
                e.markException();
                break;
            } else if (Integer.parseInt(parameter) > noOfTasks) {
                e.taskOutOfBounds();
                break;
            }
            markTask(Integer.parseInt(parameter));
            break;
        case "unmark":
            if (parameter.equals("") || !containsNumber(parameter)) {
                e.unmarkException();
                break;
            } else if (Integer.parseInt(parameter) > noOfTasks) {
                e.taskOutOfBounds();
                break;
            }
            unmarkTask(Integer.parseInt(parameter));
            break;
        case "deadline":
            if (parameter.equals("")) {
                e.deadlineException();
                break;
            }
            addDeadline(parameter);
            break;
        case "event":
            if (parameter.equals("")) {
                e.eventException();
                break;
            }
            addEvent(parameter);
            break;
        default:
            e.notRecognizedException();
        }

    }

    boolean containsNumber(String parameter) {
        for (int i = 0; i < parameter.length(); i++) {
            if (!Character.isDigit(parameter.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    void showTasks() {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < noOfTasks; i++) {
            System.out.print(i + 1 + ".");
            tasks[i].displayMessage();
        }
    }

    void markTask(int n) {
        tasks[n - 1].setMarked(true);
        System.out.println("Nice I've marked this task as done:");
        tasks[n - 1].displayMessage();
    }

    void unmarkTask(int n) {
        tasks[n - 1].setMarked(false);
        System.out.println("OK, I've marked this task as not done yet");
        tasks[n - 1].displayMessage();
    }

    void addTodo(String parameter) {
        tasks[noOfTasks] = new Todo(parameter);
        tasks[noOfTasks++].initializeMessage();
    }

    void addDeadline(String parameter) {
        int descriptionEnd = parameter.indexOf("/by");
        if (descriptionEnd < 1) {
            e.deadlineException();
        } else {
            String description = parameter.substring(0, descriptionEnd);
            String by = parameter.substring(descriptionEnd + 3).trim();
            tasks[noOfTasks] = new Deadline(description, by);
            tasks[noOfTasks++].initializeMessage();
        }
    }

    void addEvent(String parameter) {
        int descriptionEnd = parameter.indexOf("/at");
        if (descriptionEnd < 1) {
            e.eventException();
        } else {
            String description = parameter.substring(0, descriptionEnd);
            String at = parameter.substring(descriptionEnd + 3).trim();
            tasks[noOfTasks] = new Event(description, at);
            tasks[noOfTasks++].initializeMessage();
        }
    }
}
