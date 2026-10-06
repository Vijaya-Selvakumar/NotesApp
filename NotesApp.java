import java.io.*;
import java.util.Scanner;

public class NotesApp {

    static final String FILE_NAME = "Notes.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choice;
        do{
            System.out.println("\n********Notes App**********");

            System.out.println("1.Add Note");
            System.out.println("2.View Note");
            System.out.println("3.Exit");

            System.out.println("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();
            
            switch(choice)
            {
                case 1:
                    addNote(scanner);
                    break;

                case 2:
                    viewNotes();
                    break;

                case 3:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again");

            }

        } while(choice!=3);

        scanner.close();
    }

    // Write a new note to the file.

    static  void addNote(Scanner scanner){
        System.out.println("Enter your note: ");
        String note = scanner.nextLine();

        try
        (FileWriter writer = new FileWriter(FILE_NAME, true))
        {
            writer.write(note + System.lineSeparator());
            System.out.println("Note added Successfully");
        }
        catch(IOException e)
        {
            System.out.println("Error writing to the file: "+ e.getMessage());
        }
           
    }

    //Read and display all notes

    static void viewNotes(){
        try(BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME)))
        {
            String line;
            int noteNumber =1;
            while((line=reader.readLine()) !=null)
            {
                System.out.println(noteNumber + "." + line);
                noteNumber++;

            }
            if(noteNumber==1)
            {
                System.out.println("No notes found.");
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("No notes found. Add your first Note!");
        }
        catch(IOException e)
        {
            System.out.println("Error reading file: " + e.getMessage());
        }

    }
}