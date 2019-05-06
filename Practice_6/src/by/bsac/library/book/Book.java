package by.bsac.library.book;

public class Book {
    private String name;
    private boolean available;

    public Book() {
        name = "";
        available = false;
    }

    public Book(String name) {
        this.name = name;
        available = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
