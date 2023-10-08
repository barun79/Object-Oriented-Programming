package library;

import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Models a library containing various publications.
 *
 * @author             Professor George F. Rice
 * @version            1.0
 * @since              1.0
 * @license.agreement  Gnu General Public License 3.0
 */
public class Library {
    /**
     * Creates a Library instance.
     *
     * @param name         the name of the library
     * @since              1.0
     */
    public Library(String name) {
        this.name = name;
        this.publications = new ArrayList<>();
    }

    public Library(BufferedReader br) throws IOException{
        this.name = br.readLine();
        this.publications = new ArrayList<>();
        int size = Integer.parseInt(br.readLine());
        for(int i = 0; i < size; i++){
            String type = br.readLine();
            if("video".equals(type)){
                publications.add(new Video(br));
            }else if ("publication".equals(type)){
                publications.add(new Publication(br));
            }
        }
    }
    /**
     * Adds a publication to this library instance.
     *
     * @param publication  the publication to add to the library
     * @since              1.0
     */
    public void addPublication(Publication publication) {
        publications.add(publication);
    }

    public void save(BufferedWriter br) throws IOException{
        br.write(name+ '\n');
        br.write("" + publications.size() + '\n');
        for (Publication publication : publications) {
            if(publication instanceof Video){
                br.write("video" + '\n');
            }else{
                br.write("publication" + '\n');
            }
            publication.save(br);

        }     

    }
    /**
     * Checks out a publication from this library instance.
     *
     * The due date will be set to 2 weeks from the current date.
     *
     * @param publicationIndex  the index as shown by toString()
     * @param patron            identification of the borrower
     * @since                   1.0
     */
    public void checkOut(int publicationIndex, String patron) {
        try {
            publications.get(publicationIndex).checkOut(patron);
        } catch(Exception e) {
            System.err.println("\nUnable to check out publication #" + publicationIndex 
                + ": " + e.getMessage() + "\n");
        }
    }
    /**
     * Checks in a publication from this library instance.
     *
     * @param publicationIndex  the index as shown by toString()
     * @since                   1.1
     */
    public void checkIn(int publicationIndex) {
        try {
            publications.get(publicationIndex).checkIn();
        } catch(Exception e) {
            System.err.println("\nUnable to check in publication #" + publicationIndex 
                + ": " + e.getMessage() + "\n");
        }
    }
    /**
     * Lists all publications in this library instance.
     *
     * The index shown in the resulting String may be used 
     * to check out a publication using the checkOut() method.
     *
     * @returns     the string representation of all library publications
     * @since       1.0
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(name + "\n\n");
        for(int i=0; i<publications.size(); ++i)
            sb.append("" + i + ") " + publications.get(i).toString() + "\n");
        return sb.toString();
    }
    private String name;
    private ArrayList<Publication> publications;

}
