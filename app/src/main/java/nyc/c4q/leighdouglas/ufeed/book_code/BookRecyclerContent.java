package nyc.c4q.leighdouglas.ufeed.book_code;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import nyc.c4q.leighdouglas.ufeed.R;

public class BookRecyclerContent extends AppCompatActivity {
    BookAdapter adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.book_recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(this)); //determines how content shows up

        Set<String> books = PreferenceManager.getDefaultSharedPreferences(this).getStringSet("book", new HashSet<String>()); //get the books here in bookrecycler
        List booklist = new ArrayList();
        booklist.addAll(books);
        recyclerView.setAdapter(adapter = new BookAdapter(booklist));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BookRecyclerContent.this, AddBookActivity.class);
                startActivity(intent);
            }
        });
    }


}
