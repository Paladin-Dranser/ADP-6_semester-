package by.bsac.library;

import java.util.ArrayList;
import java.util.List;

import by.bsac.library.book.Book;

public class Library {
    private List<Book> listOfBooks = new ArrayList<>();

    public Library() {
        listOfBooks.add(new Book("Diablo"));
        listOfBooks.add(new Book("WarCraft"));
        listOfBooks.add(new Book("Need for Speed"));
    }

    public List<Book> getListOfBooks() {
        return listOfBooks;
    }
}
