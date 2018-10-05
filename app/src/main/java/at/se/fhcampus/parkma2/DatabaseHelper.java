package at.se.fhcampus.parkma2;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import at.se.fhcampus.parkma2.models.ParkingLot;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "parkma_db";
    public static final int DATABASE_VERSION = 1;
    private static DatabaseHelper ref;


    public static final String CREATE_TABLE = "create table "+ ParkinglotContract.ParkinglotEntry.TABLE_NAME+
            "("+ ParkinglotContract.ParkinglotEntry.Parkinglot_ID+" number,"+ ParkinglotContract.ParkinglotEntry.Parkplatznummer+"
            + ParkinglotContract.ParkinglotEntry.Status+ "text);";

    public static final String DROP_TABLE = "drop table if exists "+ ParkinglotContract.ParkinglotEntry.TABLE_NAME;

    public DatabaseHelper (Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.d("Database Operations", "Database created...");
    }

    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(CREATE_TABLE);
        Log.d("Database Operations", "Table created...");

    }

    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL(DROP_TABLE);
        onCreate(sqLiteDatabase);

    }

    //Singleton Pattern
    public static synchronized DatabaseHelper getInstance(Context context)
    {
        if (ref == null) {

            ref = new DatabaseHelper(context.getApplicationContext());
        }
        return ref;
    }


    public void addParkplatz(int id, int parkplatznummer, String status, SQLiteDatabase database) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(ParkinglotContract.ParkinglotEntry.Parkinglot_ID,id);
        contentValues.put(ParkinglotContract.ParkinglotEntry.Parkplatznummer, parkplatznummer);
        contentValues.put(ParkinglotContract.ParkinglotEntry.Status, status);

        database.insert(ParkinglotContract.ParkinglotEntry.TABLE_NAME, null, contentValues);
        Log.d("Database Operations", "One Raw inserted...");

    }
}
