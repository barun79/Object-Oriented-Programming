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
        Scanner input = new Scanner(System.in);
        System.out.print("Which publication to checkout? ");
        int selection = input.nextInt();
        input.nextLine();
        System.out.print("Who are you? ");
        String patron = input.nextLine(); 
        library.checkOut(selection, patron);
    }

    public void checkInPublication(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter index you wanted to checkout: ");
        int publicationIndex = input.nextInt();
        input.nextLine();
        library.checkIn(publicationIndex);
    }

    public void menu(){
        System.out.println("===========");
        System.out.println("Main Menu");
        System.out.println("===========");
        System.out.println(library.getname());
        System.out.println("0) Exit");
        System.out.println("1) List");
        System.out.println("2) Add");
        System.out.println("3) Check out");
        System.out.println("4) Check in\n\n");
    }

    public static void main(String[] args) {
        Library library = new Library("The Library at Alexandria (Texas)");
        LibraryManager manager = new LibraryManager(library);
        library.addPublication(new Publication("The Cat in the Hat", "Dr. Suess", 1957));
        library.addPublication(new Publication("The Firm", "John Grisham", 1992));
        library.addPublication(new Publication("Foundation", "Isaac Asimov", 1951));
        library.addPublication(new Video("Citizen Kane", "Orson Welles", 1941, 119));
        library.addPublication(new Video("Star Wars", "George Lucas", 1977, 121));
        library.addPublication(new Video("七人の侍 (Seven Samurai)", "Akira Kurosawa", 1954, 207));

        manager.menu();
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
                    System.out.println("Do you want to add Book or Video?\n1)Book \n2)Video");
                    System.out.print("Selection : ");
                    int choice2 = input.nextInt();
                    input.nextLine();
                    switch(choice2){
                        case 1:
                        manager.addPublication();
                        break;
                        case 2:
                        manager.addVideo();
                        break;
                        default:
                        System.out.println("Invalid input");
                    } 
                break;
                case 3:
                    manager.listPublication();
                    manager.checkOutPublication();
                break;
                case 4:
                    manager.listPublication();
                    manager.checkInPublication();
                break;
                default:
                    System.out.println("You enter wrong option.\n Please enter option 0-4");

            }
            manager.menu();
            System.out.print("Selection: ");
            choice = input.nextInt();
            input.nextLine();
            System.out.println("\n");
        } 
    }
}
