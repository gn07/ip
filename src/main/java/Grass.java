import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Integer;

class GrassException extends Exception {
    public GrassException(String m) {
        super(m);
    }
}

public class Grass {
    public static void main(String[] args) {
        String logo = "  ___  ____   __   ____  ____ \n"
                    + " / __)(  _ \\ / _\\ / ___)/ ___) \n"
                    + "( (_ \\ )   //    \\\\___ \\\\___ \\ \n"
                    + " \\___/(__\\_)\\_/\\_/(____/(____/ \n";
        
        System.out.println("____________________________________________________________");
        System.out.println("Hello! I'm\n" + logo);
        System.out.println("What can I do for you?");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        ArrayList<Task> inputList = new ArrayList<Task>();
        while (!input.equals("bye")) {
            System.out.println("____________________________________________________________");
            System.out.println(input);
            if (input.equals("list")) {
                for(int i = 0; i < inputList.size(); i++) {
                    System.out.println(i + 1 + ". " + inputList.get(i));
                }
            }
            else if (input.startsWith("mark")) {
                try {
                    if (input.length() < 6) {
                        throw new GrassException("Please specify the task number to mark.");
                    }
                    int taskNumber = Integer.parseInt(input.substring(5));

                    try{
                        if (taskNumber > inputList.size()) {
                            throw new GrassException("Task number out of range.");
                        }
                        inputList.get(taskNumber - 1).markAsDone();
                        System.out.println("Nice! I've marked this task as done:");
                        System.out.println(inputList.get(taskNumber - 1));
                    }
                    catch (GrassException e) {
                        System.out.println(e.getMessage());
                        System.out.println("____________________________________________________________");
                        input = sc.nextLine();
                        continue;
                    }
                }
                catch (GrassException e) {
                    System.out.println(e.getMessage());
                    System.out.println("____________________________________________________________");
                    input = sc.nextLine();
                    continue;
                }

                
            }
            else if (input.startsWith("unmark")) {
                try {
                    if (input.length() < 7) {
                        throw new GrassException("Please specify the task number to unmark.");
                    }
                    int taskNumber = Integer.parseInt(input.substring(7));
                    try {
                        if (taskNumber > inputList.size()) {
                            throw new GrassException("Task number out of range.");
                        }
                        inputList.get(taskNumber - 1).markAsUndone();
                    }
                    catch (GrassException e) {
                        System.out.println(e.getMessage());
                        System.out.println("____________________________________________________________");
                        input = sc.nextLine();
                        continue;
                    }
                    
                    System.out.println("OK, I've marked this task as not done yet:");
                    System.out.println(inputList.get(taskNumber - 1));
                }
                catch (GrassException e) {
                    System.out.println(e.getMessage());
                    System.out.println("____________________________________________________________");
                    input = sc.nextLine();
                    continue;
                }

                
            }
            else if (input.startsWith("todo")) {
                try {
                    if (input.length() < 5) {
                        throw new GrassException("Please specify the description of a todo.");
                    }
                    inputList.add(new Todo(input.substring(5)));
                }
                catch (GrassException e) {
                    System.out.println(e.getMessage());
                    System.out.println("____________________________________________________________");
                    input = sc.nextLine();
                    continue;
                }
                System.out.println("Got it. I've added this task:");
                System.out.println(inputList.get(inputList.size() - 1));
                System.out.println("Now you have " + inputList.size() + " tasks in the list.");
            }
            else if (input.startsWith("deadline")) {
                try {
                    if (input.length() < 9) {
                        throw new GrassException("Please specify the description and deadline of a deadline.");
                    }
                    String inputed = input.substring(9);
                    try {
                        if (!inputed.contains(" /by ")) {
                            throw new GrassException("Please specify by when the deadline ends (add /by behind the description).");
                        }
                        String[] inputArray = inputed.split(" /by ");
                        inputList.add(new Deadline(inputArray[0], inputArray[1]));
                        System.out.println("Got it. I've added this task:");
                        System.out.println(inputList.get(inputList.size() - 1));
                        System.out.println("Now you have " + inputList.size() + " tasks in the list.");
                    }
                    catch (GrassException e) {
                        System.out.println(e.getMessage());
                        System.out.println("____________________________________________________________");
                        input = sc.nextLine();
                        continue;
                    }
                    
                }
                catch (GrassException e) {
                    System.out.println(e.getMessage());
                    System.out.println("____________________________________________________________");
                    input = sc.nextLine();
                    continue;
                }

            }
            else if (input.startsWith("event")) {
                try {
                    if (input.length() < 6) {
                        throw new GrassException("Please specify the description and time of an event.");
                    }
                    String inputed = input.substring(6);
                    try {
                        if (!inputed.contains(" /from ")) {
                            throw new GrassException("Please specify the start time of an event (add /from behind the description).");
                        }
                        String[] inputArray = inputed.split(" /from ");
                        try {
                            if (!inputArray[1].contains(" /to ")) {
                                throw new GrassException("Please specify the end time of an event (add /to behind the start time).");
                            }
                            String[] leftovers = inputArray[1].split(" /to ");
                            inputList.add(new Event(inputArray[0], leftovers[0], leftovers[1]));
                            System.out.println("Got it. I've added this task:");
                            System.out.println(inputList.get(inputList.size() - 1));
                            System.out.println("Now you have " + inputList.size() + " tasks in the list.");
                        }
                        catch (GrassException e) {
                            System.out.println(e.getMessage());
                            System.out.println("____________________________________________________________");
                            input = sc.nextLine();
                            continue;
                        }

                        
                    }
                    catch (GrassException e) {
                        System.out.println(e.getMessage());
                        System.out.println("____________________________________________________________");
                        input = sc.nextLine();
                        continue;
                    }

                }
                catch (GrassException e) {
                    System.out.println(e.getMessage());
                    System.out.println("____________________________________________________________");
                    input = sc.nextLine();
                    continue;
                }
                
            }
            else {
                System.out.println("What do you want...?");
            }
            System.out.println("____________________________________________________________");
            input = sc.nextLine();
        }
        System.out.println("____________________________________________________________");
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("____________________________________________________________");
    }
}
