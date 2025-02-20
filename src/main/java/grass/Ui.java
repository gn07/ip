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
    public String commandSeparator(String command) {
        return LINE + command;
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
    public String printLine() {
        return LINE;
    }

    /** 
     * <p>print application startup message</p>
     * @since 1.0
     */
    public String startup() {
        return "Hello! I'm" + LOGO + "What can I do for you?" ;
    }

    /** 
     * <p>print application shutdown message</p>
     * @since 1.0
     */
    public String shutdown() {
        return "Bye. Hope to see you again soon!" ;
    }

    /** 
     * <p>print error message</p>
     * @param message error message to print
     * @since 1.0
     */
    public String errorMessage(String message) {
        return message;
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
    public String printList() {
        try {
//            String message = parser.parseList();
            return parser.parseList();
        }catch (GrassException e) {
            return errorMessage(e.getMessage());
        }
    }

    /** 
     * <p>print outputs for 'mark' command</p>
     * @param input string user input
     * @since 1.0
     */
    public String markTask(String input) {
        try {
//            String message = parser.parseMark(input);
            return parser.parseMark(input);
        } catch (GrassException e) {
            return errorMessage(e.getMessage());
        }
    }

    /** 
     * <p>print outputs for 'unmark' command</p>
     * @param input string user input
     * @since 1.0
     */
    public String unmarkTask(String input) {
        try {
//            String message = parser.parseUnmark(input);
            return parser.parseUnmark(input);
        } catch (GrassException e) {
            return errorMessage(e.getMessage());
        }
    }
    
    /** 
     * <p>print outputs for 'delete' command</p>
     * @param input string user input
     * @since 1.0
     */
    public String deleteTask(String input) {
        try {
//            String message = parser.parseDelete(input);
            return parser.parseDelete(input);
        } catch (GrassException e) {
            return errorMessage(e.getMessage());
        }
    }

    /** 
     * <p>print outputs for 'todo' command</p>
     * @param input string user input
     * @since 1.0
     */
    public String todoTask(String input) {
        try {
//            String message = parser.todoTask(input);
            return parser.todoTask(input);
        } catch (GrassException e) {
            return errorMessage(e.getMessage());
        }
    }

    /** 
     * <p>print outputs for 'deadline' command</p>
     * @param input string user input
     * @since 1.0
     */
    public String deadlineTask(String input) {
        try {
//            String message = parser.deadlineTask(input);
            return parser.deadlineTask(input);
        } catch (GrassException e) {
            return errorMessage(e.getMessage());
        }
    }

    /** 
     * <p>print outputs for 'event' command</p>
     * @param input string user input
     * @since 1.0
     */
    public String eventTask(String input) {
        try {
//            String message = parser.eventTask(input);
            return parser.eventTask(input);
        } catch (GrassException e) {
            return errorMessage(e.getMessage());
        }
    }

    /** 
     * <p>print outputs for 'find' command</p>
     * @param input string user input
     * @since 1.0
     */
    public String findTask(String input) {
//        String message = parser.findTask(input);
        return parser.findTask(input);
    }
    
    /** 
     * <p>print invalid command message</p>
     * @since 1.0
     */
    public String invalidCommand() {
        return INVALID;
    }


}