package mdi;

import library.Library;
import library.Publication;
import library.Video;

import java.util.Scanner;

public class LibraryManager {
    private Library library;

    public LibraryManager(Library library){
        this.library = library;
    }
    
    public void listPublication(){
        System.out.println(library);
    }
    
    public void addPublication(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the title: ");
        String title = input.nextLine();
        System.out.print("Enter the author: ");
        String author = input.nextLine();
        System.out.print("Enter the year: ");
        int year = input.nextInt();
        input.nextLine(); // Consume newline

        library.addPublication(new Publication(title, author, year));
        System.out.println("Publication added.");  
    }

    public void addVideo(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the title: ");
        String title = input.nextLine();
        System.out.print("Enter the author: ");
        String author = input.nextLine();
        System.out.print("Enter the year: ");
        int year = input.nextInt();
        input.nextLine(); // Consume newline
        System.out.print("Enter the runtime: ");
        int runtime = input.nextInt();
        input.nextLine();
        library.addPublication(new Video(title, author, year, runtime));
        System.out.println("Publication added.");

    }
    
    public void checkOutPublication(){

    }

    public void checkInPublication(){

    }

    
    
    
    public static void main(String[] args) {
        Library library = new Library("The Library at Alexandria (Texas)");
        LibraryManager manager = new LibraryManager(library);
        
        System.out.println("===========");
        System.out.println("Main Menu");
        System.out.println("===========");
        System.out.println("0) Exit");
        System.out.println("1) List");
        System.out.println("2) Add");
        System.out.println("3) Check out");
        System.out.println("4) Check in");

        Scanner input = new Scanner(System.in);
        System.out.print("Selection: ");
        int choice = input.nextInt();
        input.nextLine();

        while(choice != 0){
            switch(choice){
                case 1: 
                    manager.listPublication();
                break;
                case 2:
                    System.out.print("Do you want to add Book or Video?\nEnter 1 for Book or 2 for video: ");
                    int choice2 = input.nextInt();
                    input.nextLine();
                    switch(choice2){
                        case 1:
                        manager.addPublication();
                        break;
                        case 2:
                        manager.addVideo();
                        break;
                    } 
                break;
                case 3: 
                    // check out
                break;
                case 4: 
                    // check in
                break;
                default:
                    System.out.println("You enter wrong option.\n Please enter option 0-4");

            }
            System.out.print("Selection: ");
            choice = input.nextInt();
            input.nextLine();
        } 
    }
}
