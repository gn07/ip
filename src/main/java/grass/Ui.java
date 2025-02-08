// handles input and output of the program
import java.util.Scanner;

public class Ui {
    protected static final String LINE = "____________________________________________________________";
    protected static final String LOGO = "  ___  ____   __   ____  ____ \n"
                    + " / __)(  _ \\ / _\\ / ___)/ ___) \n"
                    + "( (_ \\ )   //    \\\\___ \\\\___ \\ \n"
                    + " \\___/(__\\_)\\_/\\_/(____/(____/ \n";
    protected static final String INVALID = "What do you want...?";
    protected Scanner sc;
    protected String command;
    protected Parser parser;
    
    public Ui(TaskList tasks) {
        this.sc = new Scanner(System.in);
        this.command = "";
        this.parser = new Parser(tasks);
    }

    public String readCommand() {
        this.command = sc.nextLine();
        return command;
    }

    public void commandSeparator(String command) {
        System.out.println(LINE);
        System.out.println(command);
    }

    public String getCommand() {
        return this.command;
    }

    public void printLine() {
        System.out.println(LINE);
    }

    public void startup() {
        System.out.println(LINE);
        System.out.println("Hello! I'm");
        System.out.println(LOGO);
        System.out.println("What can I do for you?");
        System.out.println(LINE);
    }

    public void shutdown() {
        System.out.println(LINE);
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println(LINE);
    }

    public void errorMessage(String message) {
        System.out.println(LINE);
        System.out.println(message);
    }

    public void closeScanner() {
        sc.close();
    }

    public void printList() {
        try {
            String message = parser.parseList();
            System.out.println(LINE);
            System.out.println(message);
        }catch (GrassException e) {
            errorMessage(e.getMessage());
        }
    }

    public void markTask(String input) {
        try {
            String message = parser.parseMark(input);
            System.out.println(LINE);
            System.out.println(message);
        } catch (GrassException e) {
            errorMessage(e.getMessage());
        }
    }

    public void unmarkTask(String input) {
        try {
            String message = parser.parseUnmark(input);
            System.out.println(LINE);
            System.out.println(message);
        } catch (GrassException e) {
            errorMessage(e.getMessage());
        }
    }

    public void deleteTask(String input) {
        try {
            String message = parser.parseDelete(input);
            System.out.println(LINE);
            System.out.println(message);
        } catch (GrassException e) {
            errorMessage(e.getMessage());
        }
    }

    public void todoTask(String input) {
        try {
            String message = parser.todoTask(input);
            System.out.println(LINE);
            System.out.println(message);
        } catch (GrassException e) {
            errorMessage(e.getMessage());
        }
    }

    public void deadlineTask(String input) {
        try {
            String message = parser.deadlineTask(input);
            System.out.println(LINE);
            System.out.println(message);
        } catch (GrassException e) {
            errorMessage(e.getMessage());
        }
    }

    public void eventTask(String input) {
        try {
            String message = parser.eventTask(input);
            System.out.println(LINE);
            System.out.println(message);
        } catch (GrassException e) {
            errorMessage(e.getMessage());
        }
    }

    public void invalidCommand() {
        System.out.println(LINE);
        System.out.println(INVALID);
    }


}