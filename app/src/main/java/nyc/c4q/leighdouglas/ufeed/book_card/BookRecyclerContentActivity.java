package nyc.c4q.leighdouglas.ufeed.book_card;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import nl.qbusict.cupboard.QueryResultIterable;
import nyc.c4q.leighdouglas.ufeed.R;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

public class BookRecyclerContentActivity extends AppCompatActivity {

    static BookAdapter adapter;
    RecyclerView recyclerView;
    public static SQLiteDatabase bookDatabase;
    List<Book> booklist = new ArrayList();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        BookDatabaseHelper bookdbHelper = BookDatabaseHelper.getInstance(this);
        bookDatabase = bookdbHelper.getWritableDatabase();

        booklist = loadBookDataBase(bookDatabase);

        recyclerView = (RecyclerView) findViewById(R.id.book_recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(this)); //determines how content shows up
        adapter = new BookAdapter(booklist);
        recyclerView.setAdapter(adapter);
      //  Set<String> books = PreferenceManager.getDefaultSharedPreferences(this).getStringSet("book", new HashSet<String>()); //get the books here in bookrecycler
      //  booklist.addAll(books);
      //  recyclerView.setAdapter(adapter = new BookAdapter(booklist));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BookRecyclerContentActivity.this, AddBookActivity.class);
                startActivity(intent);
            }
        });
    }

    private List<Book> loadBookDataBase(SQLiteDatabase database) {
        try {
            QueryResultIterable<Book> iterable = cupboard()
                    .withDatabase(database)
                    .query(Book.class)
                    .query();
            for (Book book : iterable) {
                booklist.add(book);
            }
        } catch (Exception e) {
            Log.i("loadDataBase", "Stacktrace: " + e);
        }

        return booklist;
    }

    public static void removeBook(Book book) {
        cupboard().withDatabase(bookDatabase).delete(book);
    }
}
