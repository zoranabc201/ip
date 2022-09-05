package Duke;

public abstract class Task {
    public boolean isMarked() {
        return isMarked;
    }
    public void setMarked(boolean marked) {
        isMarked = marked;
    }
     abstract void initializeMessage();
    abstract void displayMessage();
    boolean isMarked;
}
