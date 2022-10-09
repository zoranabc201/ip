package Duke;

public class Event extends Task {
    @Override
    public String getTime() {
        return at;
    }
    @Override
    public void setTime(String at) {
        this.at = at;
    }

    public String at;
    public Event(String description, String at, boolean marked) {
        this.description = description;
        this.at = at;
        this.mark = marked;
    }
    @Override
    public String getType() {
        return "[E]";
    }
}
