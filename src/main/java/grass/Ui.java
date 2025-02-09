package grass;

import java.util.Scanner;

/**
* handles input and output of the program
* 
* @author gn07
* 
*/
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

    /**
     * <p>reads new user input</p>
     * @return string containing user input
     * @since 1.0
     */
    public String readCommand() {
        this.command = sc.nextLine();
        return command;
    }

    /**
     * <p>prints command recieved and a sperator</p>
     * @param command string containing user input
     * @since 1.0
     */
    public void commandSeparator(String command) {
        System.out.println(LINE);
        System.out.println(command);
    }

    /**
     * <p>get user input</p>
     * @return string containing user input
     * @since 1.0
     */
    public String getCommand() {
        return this.command;
    }

    /**
     * <p>prints seperation line</p>
     * @since 1.0
     */
    public void printLine() {
        System.out.println(LINE);
    }

    /** 
     * <p>print application startup message</p>
     * @since 1.0
     */
    public void startup() {
        System.out.println(LINE);
        System.out.println("Hello! I'm");
        System.out.println(LOGO);
        System.out.println("What can I do for you?");
        System.out.println(LINE);
    }

    /** 
     * <p>print application shutdown message</p>
     * @since 1.0
     */
    public void shutdown() {
        System.out.println(LINE);
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println(LINE);
    }

    /** 
     * <p>print error message</p>
     * @param message error message to print
     * @since 1.0
     */
    public void errorMessage(String message) {
        System.out.println(LINE);
        System.out.println(message);
    }

    /** 
     * <p>close scanner</p>
     * @since 1.0
     */
    public void closeScanner() {
        sc.close();
    }

    /** 
     * <p>print outputs for 'list' command</p>
     * @since 1.0
     */
    public void printList() {
        try {
            String message = parser.parseList();
            System.out.println(LINE);
            System.out.println(message);
        }catch (GrassException e) {
            errorMessage(e.getMessage());
        }
    }

    /** 
     * <p>print outputs for 'mark' command</p>
     * @param input string user input
     * @since 1.0
     */
    public void markTask(String input) {
        try {
            String message = parser.parseMark(input);
            System.out.println(LINE);
            System.out.println(message);
        } catch (GrassException e) {
            errorMessage(e.getMessage());
        }
    }

    /** 
     * <p>print outputs for 'unmark' command</p>
     * @param input string user input
     * @since 1.0
     */
    public void unmarkTask(String input) {
        try {
            String message = parser.parseUnmark(input);
            System.out.println(LINE);
            System.out.println(message);
        } catch (GrassException e) {
            errorMessage(e.getMessage());
        }
    }
    
    /** 
     * <p>print outputs for 'delete' command</p>
     * @param input string user input
     * @since 1.0
     */
    public void deleteTask(String input) {
        try {
            String message = parser.parseDelete(input);
            System.out.println(LINE);
            System.out.println(message);
        } catch (GrassException e) {
            errorMessage(e.getMessage());
        }
    }

    /** 
     * <p>print outputs for 'todo' command</p>
     * @param input string user input
     * @since 1.0
     */
    public void todoTask(String input) {
        try {
            String message = parser.todoTask(input);
            System.out.println(LINE);
            System.out.println(message);
        } catch (GrassException e) {
            errorMessage(e.getMessage());
        }
    }

    /** 
     * <p>print outputs for 'deadline' command</p>
     * @param input string user input
     * @since 1.0
     */
    public void deadlineTask(String input) {
        try {
            String message = parser.deadlineTask(input);
            System.out.println(LINE);
            System.out.println(message);
        } catch (GrassException e) {
            errorMessage(e.getMessage());
        }
    }

    /** 
     * <p>print outputs for 'event' command</p>
     * @param input string user input
     * @since 1.0
     */
    public void eventTask(String input) {
        try {
            String message = parser.eventTask(input);
            System.out.println(LINE);
            System.out.println(message);
        } catch (GrassException e) {
            errorMessage(e.getMessage());
        }
    }

    /** 
     * <p>print outputs for 'find' command</p>
     * @param input string user input
     * @since 1.0
     */
    public void findTask(String input) {
        String message = parser.findTask(input);
        System.out.println(LINE);
        System.out.println(message);
    }
    
    /** 
     * <p>print invalid command message</p>
     * @since 1.0
     */
    public void invalidCommand() {
        System.out.println(LINE);
        System.out.println(INVALID);
    }


}