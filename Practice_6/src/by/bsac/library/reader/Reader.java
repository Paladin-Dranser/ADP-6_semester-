package by.bsac.library.reader;

import java.util.ArrayList;
import java.util.List;

import by.bsac.library.book.Book;
import by.bsac.library.Library;

public class Reader extends Thread {
    private String name;
    private List<Book> listOfBooks = new ArrayList<>();
    private static List<Book> library = new ArrayList<>();

    public Reader() {
        name = "Unnamed";

        System.out.println("Reader \"" + name + "\" comes!");
    }

    public Reader(String name, List<Book> library) {
        this.name = name;
        Reader.library = library;

        System.out.println("Reader \"" + this.name + "\" comes!");
    }

    private void takeBook(Book book) {
        book.setAvailable(false);
        listOfBooks.add(book);

        System.out.println(name + " takes the book \"" + book.getName() + "\"!");
    }

    private void returnBook(Book book) {
        book.setAvailable(true);
        listOfBooks.remove(book);

        System.out.println(name + " returns the book \"" + book.getName() + "\"!");
    }

    @Override
    public void run() {
        try {
            if (library.get(0).isAvailable()) {
                takeBook(library.get(0));
                Thread.sleep(2000);
                returnBook(library.get(0));
            } else {
                System.out.println("Sorry, " + name + ". " +
                                   library.get(0).getName() + " is not available! Wait!");
                takeBook(library.get(1));
                Thread.sleep(4000);
                takeBook(library.get(0));
            }
        } catch (InterruptedException e) {
            System.err.println(e);
        }
    }
}
