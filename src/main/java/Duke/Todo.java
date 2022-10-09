package Duke;

public class Todo extends Task{
    public Todo(String description, boolean mark) {
        this.description = description;
        this.mark = mark;
    }
    @Override
    public String getType() {
        return "[T]";
    }
}
