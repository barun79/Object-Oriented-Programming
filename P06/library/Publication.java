package library;

import java.time.LocalDate;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

/**
 * A library resource that can be checked out by a patron.
 *
 * @author             Professor George F. Rice
 * @version            1.0
 * @since              1.0
 * @license.agreement  Gnu General Public License 3.0
 */
public class Publication {
    public static final int LOAN_PERIOD = 14; // days
    
    /**
     * Creates a Publication instance.
     *
     * The year of copyright must be between 1900 and the present.
     *
     * @param title     the name of the library
     * @param author    the principal creator of this resource
     * @param copyright the year in which this publication was released or registered
     * @since              1.0
     */
    public Publication(String title, String author, int copyright) {
        if(copyright < 1900 || copyright > LocalDate.now().getYear())
            throw new IllegalArgumentException("Invalid copyright year : " + copyright);
        this.title = title;
        this.author = author;
        this.copyright = copyright;
    }

    public Publication(BufferedReader br) throws IOException{
        this.title = br.readLine();
        this.author = br.readLine();
        this.copyright = Integer.parseInt(br.readLine());
        if(br.readLine() == "checked in"){
            this.loanedTo = null;
            this.dueDate = null;
        }else{
            this.loanedTo = br.readLine();
            this.dueDate = LocalDate.parse(br.readLine());
        }
    }

    public void save(BufferedWriter bw) throws IOException{
        bw.write(title + '\n');
        bw.write(author + '\n');
        bw.write("" + copyright +'\n' );
        if (loanedTo == null){
            bw.write("checked in \n");
        }else{
            bw.write("checked out\n");
            bw.write(loanedTo + '\n');
            bw.write("" + dueDate + '\n');
        }

    }
    /**
     * Notes the patron who borrowed this publication along with the due date
     *
     * The Patron is a string, with no data validation. This will require a lot
     * of discipline on the part of the libraries to make this field useful.
     *
     * @param patron    the identity of the person borrowing this publication
\     * @since              1.0
     */
    public void checkOut(String patron) {
        loanedTo = patron;
        dueDate = LocalDate.now().plusDays(LOAN_PERIOD);
    }
    /**
     * Notes that this publication has been returned
     *
     * @since              1.0
     */
    public void checkIn() {
        loanedTo = null;
        dueDate = null;
    }
    
    protected String toStringBuilder(String pre, String mid) {
        return pre + " \"" + title + "\" by " + author + ", copyright " + copyright
             + mid 
            + ((loanedTo != null) ? "\n     : loaned to " + loanedTo + " until " + dueDate
                                  : "");
    }
    /**
     * Formats the fields of the publication in human-readable form.
     *
     * @returns     the string representation of the publication
     * @since       1.0
     */
    @Override
    public String toString() {
        return toStringBuilder("Book", "");
    }
    private String title;
    private String author;
    private int copyright;
    private String loanedTo;
    private LocalDate dueDate;

    // Test case
    // public static void main(String args[]){
    //     Publication barun = new Publication("Growth", "Barun Singh", 2000);
    //     Publication arpan = null;
    //     barun.checkOut("Sandesh");
    //     try(BufferedWriter writer = new BufferedWriter(new FileWriter("test_publication.txt")))
    //     {
    //         barun.save(writer);
    //     }
    //     catch(IOException e){
    //         e.printStackTrace(System.err);
    //     }

    //     try(BufferedReader reader = new BufferedReader(new FileReader("test_publication.txt")))
    //     {
    //         arpan = new Publication(reader);
    //     }
    //     catch(IOException e){
    //         e.printStackTrace(System.err);
    //     }

    //     System.out.println(arpan);
    // }
}
