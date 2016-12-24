package nyc.c4q.leighdouglas.ufeed.book_models;

/**
 * Created by shannonalexander-navarro on 11/5/16.
 */
public class Book {
    //book object
    static String title;
    String author;
    boolean didRead;
    String notes; // input in an editText that is saved in the shared preferences

    public static String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isDidRead() {
        return didRead;
    }

    public String getNotes() {
        return notes;
    }
}
