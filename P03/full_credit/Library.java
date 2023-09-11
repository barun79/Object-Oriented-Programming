import java.util.ArrayList;

public class Library {
    private String name;
    private ArrayList<Publication>publications;

    public Library (String name){
        this.name = name;
        publications = new ArrayList<>();
    }

    public void addPublication(Publication publication){
        publications.add(publication);
    }

    public void checkout(int publicationIndex, String patron){
        try {
            Publication publication = publications.get(publicationIndex);
            publication.checkOut(patron);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid publication index. Please choose a valid index.\n");
        }
    }

    public String display() {
        StringBuilder displayString = new StringBuilder();
        int i = 0;
        for (Publication item : publications) {
            displayString.append(i).append(") ").append(item).append("\n");
            i++;
        }
        return displayString.toString();
    }


    public String toString(){
         return name + "\n\n" + display()  + "\n" ;
    }
    
}
