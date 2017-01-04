package nyc.c4q.leighdouglas.ufeed.book_card;

import java.io.Serializable;

/**
 * Created by shannonalexander-navarro on 11/5/16.
 */
public class Book implements Serializable {

    private Long _id;
    String title;
    String author;
    boolean didRead;
    String notes;

    public Book() {
    }

    public Book(String title, String author, boolean didRead, String notes) {

        this.title = title;
        this.author = author;
        this.didRead = didRead;
        this.notes = notes;
    }

    public Long get_id() {
        return _id;
    }
    public void set_id(Long _id) {
        this._id = _id;
    }

    public String getTitle() {
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

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDidRead(boolean didRead) {
        this.didRead = didRead;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
