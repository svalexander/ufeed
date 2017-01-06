package nyc.c4q.leighdouglas.ufeed.grateful_card;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import nyc.c4q.leighdouglas.ufeed.grateful_card.gratitude_model.GratitudeCard;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

/**
 * Created by shannonalexander-navarro on 12/23/16.
 */

public class GratitudeDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "gratitude.db";
    private static final int DATABASE_VERSION = 1;


    private static GratitudeDatabaseHelper instance;

    public static synchronized GratitudeDatabaseHelper getInstance(Context context) {

        if (instance == null) {
            instance = new GratitudeDatabaseHelper(context.getApplicationContext());
        }
        return instance;
    }

    private GratitudeDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    static {
        cupboard().register(GratitudeCard.class);
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
