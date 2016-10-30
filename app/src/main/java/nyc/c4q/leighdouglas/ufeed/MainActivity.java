package nyc.c4q.leighdouglas.ufeed;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.our_recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(this)); //determines how content shows up
        recyclerView.setAdapter(adapter = new Adapter());
    }
}
