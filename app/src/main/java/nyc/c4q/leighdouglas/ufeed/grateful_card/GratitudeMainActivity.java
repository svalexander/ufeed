package nyc.c4q.leighdouglas.ufeed.grateful_card;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import nl.qbusict.cupboard.QueryResultIterable;
import nyc.c4q.leighdouglas.ufeed.R;
import nyc.c4q.leighdouglas.ufeed.grateful_card.gratitude_model.GratitudeCard;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

public class GratitudeMainActivity extends AppCompatActivity {

    private TextView textView;

    List<GratitudeCard> gratefulList = new ArrayList<>();
    RecyclerView gratitudeRV;
    public static GratitudeCardAdapter gratitudeAdapter;
    public static SQLiteDatabase gratitudeDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gratitude_main);

        GratitudeDatabaseHelper dbHelper = GratitudeDatabaseHelper.getInstance(this);
        gratitudeDatabase = dbHelper.getWritableDatabase();

        gratefulList = loadDataBase(gratitudeDatabase);

        textView = (TextView) findViewById(R.id.promptTV);
        gratitudeRV = (RecyclerView) findViewById(R.id.gratitudeRv);
        gratitudeRV.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        gratitudeAdapter = new GratitudeCardAdapter(gratefulList);
        gratitudeRV.setAdapter(gratitudeAdapter);

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.grat_add_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // if (savedInstanceState == null) {
                FragmentManager fm = getSupportFragmentManager();
                fm.beginTransaction().add(R.id.activity_gratitude_main, new GratitudeFragment()).commit();
                //  }
                fab.setVisibility(View.INVISIBLE);
            }
        });


    }


    private List<GratitudeCard> loadDataBase(SQLiteDatabase database) {
        try {
            QueryResultIterable<GratitudeCard> iterable = cupboard()
                    .withDatabase(database)
                    .query(GratitudeCard.class)
                    .query();
            for (GratitudeCard gratitudeCard : iterable) {
                gratefulList.add(gratitudeCard);
            }
        } catch (Exception e) {
            Log.i("loadDataBase", "Stacktrace: " + e);
        }

        return gratefulList;
    }

    private void removeGratitudeCard(GratitudeCard gratitudeCard) {
        cupboard().withDatabase(gratitudeDatabase).delete(gratitudeCard);
    }


}
