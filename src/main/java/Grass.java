import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Integer;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

class GrassException extends Exception {
    public GrassException(String m) {
        super(m);
    }
}

public class Grass {

    public static void loadFromTxt(ArrayList<Task> inputList) {
        try {
            File f = new File("./data/grass.txt");
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                String[] lineArray = line.split(" \\| ");
                System.out.println("how");
                System.out.println(lineArray.length);
                System.out.println(lineArray[0]);
                System.out.println(lineArray[1]);
                System.out.println(lineArray[2]);
                System.out.println("why");
                if (lineArray[0].equals("T")) {
                    inputList.add(new Todo(lineArray[2]));
                    if (lineArray[1].equals("1")) {
                        inputList.get(inputList.size() - 1).markAsDone();
                    }
                }
                else if (lineArray[0].equals("D")) {
                    inputList.add(new Deadline(lineArray[2], lineArray[3]));
                    if (lineArray[1].equals("1")) {
                        inputList.get(inputList.size() - 1).markAsDone();
                    }
                }
                else if (lineArray[0].equals("E")) {
                    inputList.add(new Event(lineArray[2], lineArray[3], lineArray[4]));
                    if (lineArray[1].equals("1")) {
                        inputList.get(inputList.size() - 1).markAsDone();
                    }
                }
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        return;
    }

    public static void writeToTxt(ArrayList<Task> inputList) {
        try {
            File f = new File("./data/grass.txt");
            FileWriter fw = new FileWriter(f);
            for (Task t : inputList) {
                if (t instanceof Todo) {
                    fw.write("T | " + (t.isDone ? "1" : "0") + " | " + t.description + "\n");
                }
                else if (t instanceof Deadline) {
                    fw.write("D | " + (t.isDone ? "1" : "0") + " | " + t.description + " | " + ((Deadline) t).by + "\n");
                }
                else if (t instanceof Event) {
                    fw.write("E | " + (t.isDone ? "1" : "0") + " | " + t.description + " | " + ((Event) t).from + " | " + ((Event) t).to + "\n");
                }
            }
            fw.close();
        }
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return;
    }

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
        loadFromTxt(inputList);
        while (!input.equals("bye")) {
            System.out.println("____________________________________________________________");
            System.out.println(input);
            if (input.equals("list")) {
                try {
                    if (inputList.isEmpty()) {
                        throw new GrassException("Task list is empty.");
                    }
                    for(Task t : inputList) {
                        System.out.println((inputList.indexOf(t) + 1) + ". " + t);
                    }
                    }
                catch (GrassException e) {
                    System.out.println(e.getMessage());
                    System.out.println("____________________________________________________________");
                    input = sc.nextLine();
                    continue;
                }
            }
            else if (input.startsWith("mark")) {
                try {
                    if (input.length() < 6) {
                        throw new GrassException("Please specify the task number to mark.");
                    }
                    int taskNumber = Integer.parseInt(input.substring(5));

                    try{
                        if (taskNumber == 0 || taskNumber > inputList.size()) {
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
                        if (taskNumber == 0 || taskNumber > inputList.size()) {
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

            else if (input.startsWith("delete")) {
                try {
                    if (input.length() < 7) {
                        throw new GrassException("Please specify the task number to delete.");
                    }
                    int taskNumber = Integer.parseInt(input.substring(7));
                    try{
                        if (taskNumber == 0 || taskNumber > inputList.size()) {
                            throw new GrassException("Task number out of range.");
                        }
                        Task removed = inputList.get(taskNumber - 1);
                        inputList.remove(taskNumber - 1);
                        System.out.println("Noted. I've removed this task:");
                        System.out.println(removed);
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
            writeToTxt(inputList);
        }
        System.out.println("____________________________________________________________");
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("____________________________________________________________");
    }
}
