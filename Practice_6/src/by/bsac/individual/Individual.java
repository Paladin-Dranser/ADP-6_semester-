package by.bsac.individual;

import by.bsac.library.Library;
import by.bsac.library.reader.Reader;

public class Individual {
    public static void main(String[] args) {
        Library library = new Library();

        Reader antos = new Reader("Antoś", library.getListOfBooks());
        Reader janka = new Reader("Janka", library.getListOfBooks());

        antos.start();
        janka.start();
    }
}
