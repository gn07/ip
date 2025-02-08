package grass;
// handles storing tasks in text file

import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    protected String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    public ArrayList<Task> loadFromTxt() throws GrassException {
        ArrayList<Task> inputList = new ArrayList<Task>();

        try {
            File f = new File(this.filePath);
            Scanner s = new Scanner(f);

            while (s.hasNextLine()) {
                String line = s.nextLine();
                String[] lineArray = line.split(" \\| ");

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
            return inputList;
        }
        catch (FileNotFoundException e) {
            throw new GrassException("File not found.");
        }
    
    }

    public void writeToTxt(ArrayList<Task> inputList) throws GrassException{
        try {
            File f = new File(this.filePath);
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
            throw new GrassException("An error occurred.");
            // e.printStackTrace();
        }
        return;
    }
}