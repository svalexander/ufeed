package nyc.c4q.leighdouglas.ufeed;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AddBookActivity extends AppCompatActivity {
    EditText titleTV, authorTV;
    Button saveButton;

    String title, author;
    Set <String> set = new HashSet<>();
    List <String> books = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        titleTV = (EditText) findViewById(R.id.add_title);
        authorTV = (EditText) findViewById(R.id.add_author);
        saveButton = (Button) findViewById(R.id.add);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                title = titleTV.getText().toString(); //getting text input by user
                //author = authorTV.getText().toString(); //getting text input by user
//                Book book = new Book(title)
                books.add(title);
                set.addAll(books);

                PreferenceManager.getDefaultSharedPreferences(AddBookActivity.this).edit().putStringSet("book", set).commit();
                Intent intent = new Intent(AddBookActivity.this, BookRecyclerContent.class);
                startActivity(intent);
            }
        });




    }

}
