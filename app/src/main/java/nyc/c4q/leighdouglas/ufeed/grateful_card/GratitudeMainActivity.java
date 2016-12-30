package nyc.c4q.leighdouglas.ufeed.grateful_card;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.leighdouglas.ufeed.R;
import nyc.c4q.leighdouglas.ufeed.grateful_card.gratitude_model.GratitudeCard;

public class GratitudeMainActivity extends AppCompatActivity {

    private TextView textView;

    List<GratitudeCard> gratefulList = new ArrayList<>();
    RecyclerView gratitudeRV;
    GratitudeCardAdapter gratitudeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gratitude_main);


//        if (savedInstanceState == null) {
//            FragmentManager fm = getSupportFragmentManager();
//            fm.beginTransaction().add(R.id.activity_gratitude_main, new GratitudeFragment()).commit();
//        }

        textView = (TextView) findViewById(R.id.promptTV);
        gratitudeRV = (RecyclerView) findViewById(R.id.gratitudeRv);
        gratitudeRV.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        gratitudeAdapter = new GratitudeCardAdapter(gratefulList);
        gratitudeRV.setAdapter(gratitudeAdapter);
    }


}
