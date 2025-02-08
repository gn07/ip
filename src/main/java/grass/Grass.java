// runs main application

public class Grass {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public Grass(String filePath) {
        
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.loadFromTxt());
        } catch (GrassException e) {
            ui.errorMessage(e.getMessage());
            tasks = new TaskList();
        }
        
        ui = new Ui(tasks);
    }

    public void run() {
        ui.startup();
        String input = ui.readCommand();
        while (!input.equals("bye")) {
            ui.commandSeparator(input);
            if (input.equals("list")) {
                ui.printList();
            }
            else if (input.startsWith("mark")) {
                ui.markTask(input);
            }
            else if (input.startsWith("unmark")) {
                ui.unmarkTask(input);
            }

            else if (input.startsWith("delete")) {
                ui.deleteTask(input);
            }
            else if (input.startsWith("todo")) {
                ui.todoTask(input);
            }
            else if (input.startsWith("deadline")) {
                ui.deadlineTask(input);
            }
            else if (input.startsWith("event")) {
                ui.eventTask(input);
            }
            else {
               ui.invalidCommand();
            }
            ui.printLine();
            input = ui.readCommand();
            try {
                storage.writeToTxt(tasks.getTasks());
            } catch (GrassException e) {
                ui.errorMessage(e.getMessage());
            }
        }
        ui.shutdown();
    }

    public static void main(String[] args) {
        new Grass("./data/grass.txt").run();
    }
}
