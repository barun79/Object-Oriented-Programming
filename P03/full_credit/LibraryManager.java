import java.util.Scanner;

public class LibraryManager {
    
    public static void main(String [] args){
        Library library = new Library("The Library at Alexandraia (Texas)");
        Publication first = new Publication("The Cat in the Hat", "Dr Suess", 1957);
        Publication second = new Publication("The firm", "John Grishman", 1992);
        Publication third = new Publication("The Firm", "Issac Asimov", 1951);
        library.addPublication(first);
        library.addPublication(second);
        library.addPublication(third);
        System.out.println(library);

        Scanner input = new Scanner(System.in);
        System.out.print("Which book to checkout? ");
        int publicationIndex = input.nextInt();
        input.nextLine();
        System.out.print("Who are you?");
        String name = input.nextLine();
        library.checkout(publicationIndex, name);
        System.out.println(library);

    }
   
}
