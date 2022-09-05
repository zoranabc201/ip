package Duke;

public class Tasks {
    String taskName;
    boolean done;
    public Tasks() {
        taskName = "";
        done = false;
    }
    public String getTaskName() {
        return taskName;
    }

    public String taskDoneStatus() {
        if (this.done) {
            return "[X]";
        } else {
            return "[ ]";
        }
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
