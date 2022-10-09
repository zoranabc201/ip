package Duke;

import java.io.IOException;

public class Duke {
    void run() throws IOException {
        UI ui = new UI();
        Storage storage = new Storage();
        ui.welcomeMessage();
        TaskList taskList = new TaskList();
        storage.initializeFile(taskList);
        ui.acceptCommands(taskList, storage);
    }
    public static void main(String[] args) throws IOException {
        Duke duke = new Duke();
        duke.run();
    }
}
