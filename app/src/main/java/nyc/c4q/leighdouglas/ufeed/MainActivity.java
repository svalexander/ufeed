package nyc.c4q.leighdouglas.ufeed;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //private RecyclerView recyclerView;
    BookAdapter adapter;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.book_recycler_view);
//
//        recyclerView.setLayoutManager(new LinearLayoutManager(this)); //determines how content shows up
//        recyclerView.setAdapter(adapter = new BookAdapter());

        textView = (TextView) findViewById(R.id.tvid);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BookRecyclerContent.class);
                startActivity(intent);

            }
        });

       // initializeAdapter();
    }

//    private void initializeAdapter() {
//      BookAdapter adapter = new BookAdapter(/*cards?*/);
//        recyclerView.setAdapter(adapter);
//    }

}
