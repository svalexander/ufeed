package nyc.c4q.leighdouglas.ufeed.grateful_card;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import nyc.c4q.leighdouglas.ufeed.R;

public class GratitudeMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gratitude_main);

        if (savedInstanceState == null) {
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().add(R.id.activity_gratitude_main, new GratitudeFragment()).commit();
        }


    }
}
