package Duke;

import java.util.ArrayList;

public class TaskList {
    public int noOfTasks;
    TaskList() {
        noOfTasks = 0;
    }
    ArrayList<Task> tasks = new ArrayList<>();
    public void addEvent(String description, String at, boolean mark) {
        tasks.add(new Event(description, at, mark));
        noOfTasks++;
    }
    public void addDeadline(String description, String by, boolean mark) {
        tasks.add(new Deadline(description, by, mark));
        noOfTasks++;
    }
    public void addTodo(String description, boolean mark) {
        tasks.add(new Todo(description, mark));
        noOfTasks++;
    }
    public void mark(int taskNo, boolean mark) {
        tasks.get(taskNo).mark(mark);
    }
    public void delete(int taskNo) {
        tasks.remove(taskNo);
        noOfTasks--;
    }
    public boolean findTask(int taskNo, String search) {
        if(tasks.get(taskNo).getDescription().contains(search)) {
            return true;
        }
        return false;
    }
}
