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

    public String toString(){
        StringBuilder sb = new StringBuilder(name + "\n\n");
        for(int i = 0; i < publications.size(); i++)
        {
            sb.append(i+") " + publications.get(i).toString()+ "\n");
        }
         return sb.toString();
    }
    
}
