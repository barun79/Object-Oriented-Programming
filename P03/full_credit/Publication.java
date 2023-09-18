import java.time.LocalDate;

public class Publication{
    private String title;
    private String author;
    private int copyright;
    private String loanedto;
    private LocalDate dueDate; 

    public Publication(String title, String author, int copyright){
        this.title = title;
        this.author = author;
        int currentYear = LocalDate.now().getYear();

        if (copyright < 1900 || copyright > currentYear){
            throw new IllegalArgumentException("Invalid copyright year. It should be between 1900 and " + currentYear);
        }
        this.copyright = copyright;
        this.loanedto = null;
        
    }

    public void checkOut(String patron){
        this.loanedto = patron;
        dueDate = LocalDate.now().plusDays(14);
    }

    public void checkin(){
        this.loanedto = null;
        dueDate = null;
    }

    public String toString(){
        String string;
        if (loanedto != null){
            string = title + " by " + author + " , copyright " + copyright + 
                "\n" + "     --> loaned to " + loanedto + " until " + dueDate;     
        } else
        {
            string = title + " by " + author + " , copyright " + copyright;
        }
        return string;
    }


}