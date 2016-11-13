package nyc.c4q.leighdouglas.ufeed;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BookActivity extends AppCompatActivity {

    Button previousButton;
    Button toReadBtn;
    Button doneBtn;
    Button reReadBtn;

    TextView thisBookTitleTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        previousButton = (Button) findViewById(R.id.previous);

        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BookActivity.this, BookRecyclerContent.class);
                startActivity(intent);
            }
        });
        thisBookTitleTV = (TextView) findViewById(R.id.this_book_title);
        thisBookTitleTV.setText(getIntent().getExtras().getString("user book"));


    }

    public void onClick(View v) {

        toReadBtn = (Button) findViewById(R.id.to_read);
        doneBtn = (Button) findViewById(R.id.done);
        reReadBtn = (Button) findViewById(R.id.re_read);

        switch (v.getId()) {

            case R.id.to_read:
                toReadBtn.setBackgroundColor(Color.parseColor("#ff80ff"));
                break;
            case R.id.done:
                doneBtn.setBackgroundColor(Color.parseColor("#ff80ff"));
                break;
            case R.id.re_read:
                reReadBtn.setBackgroundColor(Color.parseColor("#ff80ff"));
                doneBtn.setBackgroundColor(Color.parseColor("#ff80ff"));
                break;
        }
    }
}
