package Duke;

public class Todo extends Task{
    public Todo(String description, boolean mark) {
        this.description = description;
        this.isMark = mark;
    }

    /**
     * Returns "[T]" for todo object
     * @return "[T]" which is the type of object
     */
    @Override
    public String getType() {
        return "[T]";
    }
}
