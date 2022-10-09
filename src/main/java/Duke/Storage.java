package Duke;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Storage {
    final String path = "duke.txt";

    public void initializeFile(TaskList taskList) throws IOException {
        File duke = new File(path);
        loadFromFile(taskList, duke);
    }

    public void loadFromFile(TaskList taskList, File duke) throws IOException {
        Scanner SC = new Scanner(duke);
        String lineOfData;
        while (SC.hasNextLine()) {
            taskList.noOfTasks++;
            lineOfData = SC.nextLine();
            translateLineOfData(lineOfData, taskList);
        }
    }

    public void translateLineOfData(String lineOfData, TaskList taskList) {
        char type = lineOfData.charAt(0);
        char marked = lineOfData.charAt(1);
        boolean isMarked;
        if (marked == 'X') {
            isMarked = true;
        } else {
            isMarked = false;
        }
        String description;
        String time;
        if (type == 'E') {
            description = getEventDescription(lineOfData.substring(2));
            time = getEventTime(lineOfData.substring(2));
            taskList.tasks.add(new Event(description, time, isMarked));
        } else if (type == 'D') {
            description = getDeadlineDescription(lineOfData.substring(2));
            time = getDeadlineTime(lineOfData.substring(2));
            taskList.tasks.add(new Deadline(description, time, isMarked));
        } else if (type == 'T') {
            description = getTodoDescription(lineOfData.substring(2));
            taskList.tasks.add(new Todo(description, isMarked));
        }
    }

    public String getEventDescription(String input) {
        String event = input.substring(0, input.indexOf("/at"));
        return event.trim();
    }

    public String getDeadlineDescription(String input) {
        String event = input.substring(0, input.indexOf("/by"));
        return event.trim();
    }

    public String getTodoDescription(String input) {
        String event = input;
        return event.trim();
    }

    public String getEventTime(String input) {
        String time = input.substring(input.indexOf("/at") + 3);
        return time.trim();
    }

    public String getDeadlineTime(String input) {
        String time = input.substring(input.indexOf("/by") + 3);
        return time.trim();
    }

    public void writeAllEvents(TaskList taskList) throws IOException {
        File duke = new File(path);
        FileWriter fw = new FileWriter(duke, false);
        String description;
        String time;
        String type;
        boolean isMarked;
        for (int i = 0; i < taskList.noOfTasks; i++) {
            type = taskList.tasks.get(i).getType();
            description = taskList.tasks.get(i).getDescription();
            time = taskList.tasks.get(i).getTime();
            isMarked = taskList.tasks.get(i).isMark();
            addOneTask(type, description, time, isMarked, fw);
            fw.write('\n');
        }
        fw.close();
    }

    public void addOneTask(String type, String description, String time, boolean isMarked, FileWriter fw) throws IOException {
        if (type.equals("[E]")) {
            fw.write('E');
        } else if (type.equals("[T]")) {
            fw.write('T');
        } else if (type.equals("[D]")) {
            fw.write('D');
        }
        if (isMarked) {
            fw.write('X');
        } else {
            fw.write(' ');
        }
        fw.write(description);
        if (type.equals("[E]")) {
            fw.write("/at");
        } else if (type.equals("[D]")) {
            fw.write("/by");
        }
        if (type.equals("[E]") || type.equals("[D]"))
            fw.write(time);
    }
}
