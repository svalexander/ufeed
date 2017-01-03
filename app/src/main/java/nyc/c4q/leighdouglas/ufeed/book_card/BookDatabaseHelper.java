package nyc.c4q.leighdouglas.ufeed.book_card;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

/**
 * Created by shannonalexander-navarro on 1/2/17.
 */

public class BookDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "book.db";
    private static final int DATABASE_VERSION = 1;

    private static BookDatabaseHelper instance;

    public static synchronized BookDatabaseHelper getInstance(Context context) {

        if (instance == null) {
            instance = new BookDatabaseHelper(context.getApplicationContext());
        }
        return instance;
    }

    private BookDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    static {
        cupboard().register(Book.class);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        cupboard().withDatabase(db).createTables();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        cupboard().withDatabase(db).upgradeTables();
    }
}
