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

    // make your database instance a singleton instance across the entire application's lifecycle.
    private static GratitudeDatabaseHelper instance;

    // the static getInstance() method ensures that only one PostsDatabaseHelper will ever exist at any given time.
    // if the instance object has not been initialized, one will be created. If one has already been created then it
    // will simply be returned.

    public static synchronized GratitudeDatabaseHelper getInstance(Context context) {

        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        if (instance == null) {
            instance = new GratitudeDatabaseHelper(context.getApplicationContext());
        }
        return instance;
    }

    private GratitudeDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    static {
        // register our models
        cupboard().register(GratitudeCard.class);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // this will ensure that all tables are created
        cupboard().withDatabase(db).createTables();
        // add indexes and other database tweaks in this method if you want


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this will upgrade tables, adding columns and new tables.
        // Note that existing columns will not be converted
        cupboard().withDatabase(db).upgradeTables();
        // do migration work if you have an alteration to make to your schema here
    }
}
