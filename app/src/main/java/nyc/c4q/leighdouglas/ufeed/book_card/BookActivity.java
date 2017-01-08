package nyc.c4q.leighdouglas.ufeed.book_card;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import nyc.c4q.leighdouglas.ufeed.MainActivity;
import nyc.c4q.leighdouglas.ufeed.R;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;
import static nyc.c4q.leighdouglas.ufeed.book_card.BookRecyclerContentActivity.bookDatabase;

public class BookActivity extends AppCompatActivity {

    private Button previousButton;
    private Button toReadBtn;
    private Button doneBtn;
    private Button reReadBtn;
    private int readBtnValue;
    private int doneBtnValue;
    private int rereadBtnValue;

    TextView thisBookTitleTV;
    EditText userNotes;
    private String inputNotes;

    TextView savedNotes;
    public static final String SHARED_PREF = "nyc.c4q.user.pref";
    public static final String SHARED_PREF_KEY = "input_notes";
    public static final String TAG = "user book";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        userNotes = (EditText) findViewById(R.id.enter_notes);
        userNotes.setText(inputNotes);

        savedNotes = (TextView) findViewById(R.id.saved_notes);
        if (savedInstanceState != null) {
            userNotes.setText(savedInstanceState.getString("notes"));
        }


        //saves the input text to every instance of the activity
        SharedPreferences prefs = getSharedPreferences(SHARED_PREF, MODE_PRIVATE);
        String restoredText = prefs.getString(getIntent().getExtras().getString(TAG), null);
        if (restoredText != null) {
            savedNotes.setText(prefs.getString(getIntent().getExtras().getString(TAG), "No notes"));
        }

        previousButton = (Button) findViewById(R.id.previous);

        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BookActivity.this, BookRecyclerContentActivity.class);
                startActivity(intent);
            }
        });
        thisBookTitleTV = (TextView) findViewById(R.id.this_book_title);
        thisBookTitleTV.setText(getIntent().getExtras().getString(TAG));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab_save);
        fab.setOnClickListener(new View.OnClickListener() {
            //want to save the editText input and the buttonClick
            @Override
            public void onClick(View v) {

                //TODO: change this so it upgrades the table
                inputNotes = userNotes.getText().toString();

                if ( !inputNotes.isEmpty() ) {

                    savedNotes.setText(inputNotes);

                    SharedPreferences.Editor editor = getSharedPreferences(SHARED_PREF, MODE_PRIVATE).edit();
                    editor.putString(getIntent().getExtras().getString(TAG), inputNotes);
                    editor.apply();
                   // upgradeNotes();
                }

            }
        });

        FloatingActionButton home = (FloatingActionButton) findViewById(R.id.book_home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent homeIntent = new Intent(BookActivity.this, MainActivity.class);
                startActivity(homeIntent);
            }
        });


//        toReadBtn = (Button) findViewById(R.id.to_read);
//        doneBtn = (Button) findViewById(R.id.done);
//        reReadBtn = (Button) findViewById(R.id.re_read);
//
//        toReadBtn.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                toReadBtn.setPressed(true);
//                toReadBtn.setBackgroundResource(R.drawable.button_change);
//                doneBtn.setBackgroundResource(R.drawable.corners);
//                reReadBtn.setBackgroundResource(R.drawable.corners);
//                return true;
//            }
//        });
    }





    public void onClick(View v) {

        toReadBtn = (Button) findViewById(R.id.to_read);
        doneBtn = (Button) findViewById(R.id.done);
        reReadBtn = (Button) findViewById(R.id.re_read);

//        toReadBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                toReadBtn.setPressed(true);
//                toReadBtn.setBackgroundResource(R.drawable.button_change);
//                doneBtn.setBackgroundResource(R.drawable.corners);
//                reReadBtn.setBackgroundResource(R.drawable.corners);
//            }
//        });

        readBtnValue = R.drawable.button_change;


        switch (v.getId()) {

            case R.id.to_read:
                toReadBtn.setBackgroundResource(readBtnValue);
                doneBtn.setBackgroundResource(R.drawable.corners);
                reReadBtn.setBackgroundResource(R.drawable.corners);
                break;
            case R.id.done:
                toReadBtn.setBackgroundResource(R.drawable.corners);
                reReadBtn.setBackgroundResource(R.drawable.corners);
                doneBtn.setBackgroundResource(R.drawable.button_change);
                break;
            case R.id.re_read:
                toReadBtn.setBackgroundResource(R.drawable.corners);
                reReadBtn.setBackgroundResource(R.drawable.button_change);
                doneBtn.setBackgroundResource(R.drawable.button_change);
                break;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("notes", userNotes.getText().toString());
      //  savedInstanceState.putBundle("button", toReadBtn);
     //   savedInstanceState.pu
//        toReadBtn = (Button) findViewById(R.id.to_read);
//        doneBtn = (Button) findViewById(R.id.done);
//        reReadBtn = (Button) findViewById(R.id.re_read);


    }

//    ToDO: make sure this works
    private void upgradeNotes(Book book){

        Book mybook = cupboard().withDatabase(bookDatabase).get(book);
        mybook.notes = inputNotes;
//        ContentValues notesValue = new ContentValues(1);
//        notesValue.put("notes", inputNotes);
//        cupboard().withDatabase(bookDatabase).update(Book.class, notesValue, "notes", inputNotes);
        cupboard().withDatabase(bookDatabase).put(mybook);

    }
}
