import java.util.Scanner;
public class Grass {
    public static void main(String[] args) {
        String logo = "  ___  ____   __   ____  ____ \n"
                    + " / __)(  _ \\ / _\\ / ___)/ ___) \n"
                    + "( (_ \\ )   //    \\\\___ \\\\___ \\ \n"
                    + " \\___/(__\\_)\\_/\\_/(____/(____/ \n";
        
        // " ____        _        \n"
        //         + "|  _ \\ _   _| | _____ \n"
        //         + "| | | | | | | |/ / _ \\\n"
        //         + "| |_| | |_| |   <  __/\n"
        //         + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("____________________________________________________________");
        System.out.println("Hello! I'm\n" + logo);
        System.out.println("What can I do for you?");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        while (!input.equals("bye")) {
            System.out.println("____________________________________________________________");
            System.out.println(input);
            System.out.println("____________________________________________________________");
            input = sc.nextLine();
        }
        System.out.println("____________________________________________________________");
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("____________________________________________________________");
    }
}
