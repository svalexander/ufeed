package nyc.c4q.leighdouglas.ufeed;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class AddBookActivity extends AppCompatActivity {
    EditText titleTV, authorTV;
    Button saveButton;

    String title, author;
    Set<String> set = new LinkedHashSet<>(); //need a set for sharedpres, can't save a list in it
    List<String> books = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        titleTV = (EditText) findViewById(R.id.add_title);
        authorTV = (EditText) findViewById(R.id.add_author);
        saveButton = (Button) findViewById(R.id.add);

        //this line adds all of the books added in the Onclick to the set so it appears when the activity is created
        set = PreferenceManager.getDefaultSharedPreferences(AddBookActivity.this).getStringSet("books", set);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                title = titleTV.getText().toString(); //getting text input by user
                books.add(title);
                set.addAll(books);

                for (String book : set) {
                    Log.d("DEBUG", book);
                }

                //this must be here, it adds the book when you click the plus sign. w/o this here nothing appears
                PreferenceManager.getDefaultSharedPreferences(AddBookActivity.this).edit().putStringSet("book", set).apply();
                Intent intent = new Intent(AddBookActivity.this, BookRecyclerContent.class);
                startActivity(intent);
            }
        });


    }

}
