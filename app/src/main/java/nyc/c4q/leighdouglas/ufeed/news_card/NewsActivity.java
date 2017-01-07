package nyc.c4q.leighdouglas.ufeed.news_card;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import nyc.c4q.leighdouglas.ufeed.R;

public class NewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        FragmentManager newsFragment = getSupportFragmentManager();
        newsFragment.beginTransaction().add(R.id.activity_news, new NewsFragment()).commit();

    }
}
