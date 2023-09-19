// Copyright 2023 George F. Rice <https://github.com/prof-rice>
//
// This file is part of the Library Management System and is licensed
// under the terms of the Gnu General Public License version 3 or 
// (at your option) any later version, see <https://www.gnu.org/licenses/>.

package library;

import java.time.LocalDate;
/**
 * Represents a publication in the library.
 */
 public class Publication {
    public static final int LOAN_PERIOD = 14; // days
    /**
     * Constructs a Publication object with the specified title, author, and copyright year.
     *
     * @param title     The title of the publication.
     * @param author    The author of the publication.
     * @param copyright The copyright year of the publication.
     * @throws InvalidRuntimeException if the copyright year is not within the valid range.
     */
    public Publication(String title, String author, int copyright) {
        if(copyright < 1900 || copyright > LocalDate.now().getYear())
            throw new InvalidRuntimeException("Invalid copyright year : " + copyright);
        this.title = title;
        this.author = author;
        this.copyright = copyright;
    }
     /**
     * Checks out the publication to a patron.
     *
     * @param patron The name of the patron checking out the publication.
     */
    public void checkOut(String patron) {
        loanedTo = patron;
        dueDate = LocalDate.now().plusDays(LOAN_PERIOD);
    }
    /**
     * Checks in the publication, marking it as available.
     */
    public void checkIn() {
        loanedTo = null;
        dueDate = null;
    }
/**
     * Creates a formatted string representation of the publication.
     *
     * @param pre The prefix to include in the string.
     * @param mid The middle part to include in the string.
     * @return A formatted string representation of the publication.
     */
    protected String toStringBuilder(String pre, String mid) {
        StringBuilder sb = new StringBuilder();
        sb.append(pre + " \"" + title + "\" by " + author + ", copyright " + copyright);

        if (!mid.isEmpty()) {
            sb.append(" runtime " + mid );
        }

        if (loanedTo != null) {
            sb.append("\n  : loaned to " + loanedTo + " until " + dueDate);
        }

        return sb.toString();
    }
/**
     * Returns a string representation of the publication.
     *
     * @return A string containing the title, author, and copyright information.
     */
    @Override
    public String toString() {
        return toStringBuilder("Book","");
    }
    private String title;
    private String author;
    private int copyright;
    private String loanedTo;
    private LocalDate dueDate;
}
