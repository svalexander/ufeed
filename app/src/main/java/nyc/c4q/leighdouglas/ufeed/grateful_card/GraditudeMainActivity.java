package nyc.c4q.leighdouglas.ufeed.grateful_card;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import nyc.c4q.leighdouglas.ufeed.R;

public class GraditudeMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graditude_main);

        if (savedInstanceState == null) { //this will protect the state when it's rotated
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().add(R.id.activity_main, new GratitudeFragment()).commit();
        }
    }
}
