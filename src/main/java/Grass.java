import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Integer;
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
                int taskNumber = Integer.parseInt(input.substring(5));
                inputList.get(taskNumber - 1).markAsDone();
                System.out.println("Nice! I've marked this task as done:");
                System.out.println(inputList.get(taskNumber - 1));
            }
            else if (input.startsWith("unmark")) {
                int taskNumber = Integer.parseInt(input.substring(7));
                inputList.get(taskNumber - 1).markAsUndone();
                System.out.println("OK, I've marked this task as not done yet:");
                System.out.println(inputList.get(taskNumber - 1));
            }
            else {
                inputList.add(new Task(input));
                System.out.println("added: " + input);
            }
            System.out.println("____________________________________________________________");
            input = sc.nextLine();
        }
        System.out.println("____________________________________________________________");
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("____________________________________________________________");
    }
}
