package nyc.c4q.leighdouglas.ufeed.book_card;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import nyc.c4q.leighdouglas.ufeed.MainActivity;
import nyc.c4q.leighdouglas.ufeed.R;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

public class AddBookActivity extends AppCompatActivity {

    EditText titleET, authorET;
    Button saveButton;
    String title, author;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        titleET = (EditText) findViewById(R.id.add_title);
        authorET = (EditText) findViewById(R.id.add_author);
        saveButton = (Button) findViewById(R.id.add);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                title = titleET.getText().toString(); //getting text input by user
                author = authorET.getText().toString();
                String noNotes = "no current notes";
                boolean notRead = false;

                addUserBook(new Book(title, author, notRead, noNotes));
                refreshUsersBooks();

                Intent intent = new Intent(AddBookActivity.this, BookRecyclerContentActivity.class);
                startActivity(intent);
            }
        });


        FloatingActionButton home = (FloatingActionButton) findViewById(R.id.add_book_home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddBookActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void addUserBook(Book book) {

        cupboard().withDatabase(BookRecyclerContentActivity.bookDatabase).put(book);

    }
    public static void refreshUsersBooks() {
        BookRecyclerContentActivity.adapter.notifyDataSetChanged();
    }

}
