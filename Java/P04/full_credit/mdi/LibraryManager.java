// Copyright 2023 Barun Singh <https://github.com/barun79/>
//
// This file is part of the Library Management System and is licensed
// under the terms of the Gnu General Public License version 3 or 
// (at your option) any later version, see <https://www.gnu.org/licenses/>.

package mdi;

import library.InvalidRuntimeException;
import library.Library;
import library.Publication;
import library.Video;
/**
 * Manages the Library Management System application.
 */
class LibraryManager {
     /**
     * The main entry point of the Library Management System application.
     *
     * @param args The command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        try {
            Library library = new Library("The Library at Alexandria (Texas)");
            library.addPublication(new Publication("The Cat in the Hat", "Dr. Suess", 2000));
            library.addPublication(new Publication("The Firm", "John Grisham", 1992)); 
            library.addPublication(new Publication("Foundation", "Isaac Asimov", 1951));
            library.addPublication(new Video("Citizen Kane", "Orson Welles", 1977, 23));
            library.addPublication(new Video("Star Wars", "George Lucas", 1977, 121 ));
            library.addPublication(new Video("Seven Samurai", "Akira Kurosawa", 1954,207));
            System.out.println(library);
            int selection = Integer.parseInt(System.console().readLine("\nWhich book to check out? "));
            String patron = System.console().readLine("Who are you? ");
            library.checkOut(selection, patron);
            System.out.println(library);
        } catch(Exception e) {
            System.err.println("Unable to check out a publication\n" + e);
        }
    }
}
