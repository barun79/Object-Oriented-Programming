// Copyright 2023 George F. Rice <https://github.com/prof-rice>
//
// This file is part of the Library Management System and is licensed
// under the terms of the Gnu General Public License version 3 or 
// (at your option) any later version, see <https://www.gnu.org/licenses/>.

package library;
import java.util.ArrayList;
/**
 * Represents a library that holds publications.
 */
public class Library {
    /**
     * Constructs a Library object with the specified name.
     *
     * @param name The name of the library.
     */
    public Library(String name) {
        this.name = name;
        this.publications = new ArrayList<>(); // = new ArrayList<>() may be in field
    }
    /**
     * Adds a publication to the library's collection.
     *
     * @param publication The publication to be added.
     */
    public void addPublication(Publication publication) {
        publications.add(publication);
    }
    /**
     * Checks out a publication from the library's collection.
     *
     * @param publicationIndex The index of the publication to check out.
     * @param patron           The name of the patron checking out the publication.
     */
    public void checkOut(int publicationIndex, String patron) {
        publications.get(publicationIndex).checkOut(patron);
    }
    /**
     * Returns a string representation of the library and its publications.
     *
     * @return A string containing the library name and list of publications.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(name + "\n\n");
        for(int i=0; i<publications.size(); ++i)
            sb.append("" + i + ") " + publications.get(i).toString() + "\n");
        return sb.toString();
    }
    private String name;
    private ArrayList<Publication> publications; // = new ArrayList<>(); // also permissible
}
