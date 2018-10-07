package at.se.fhcampus.parkma2;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.awt.font.TextAttribute;

import at.se.fhcampus.parkma2.models.ParkingLot;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "parkma.db";
    public static final int DATABASE_VERSION = 1;
    private static DatabaseHelper ref;

    private static final String TEXT_TYPE = " TEXT";
    private static final String INT_TYPE = " INTEGER";
    private static String test= null;


    public static final String CREATE_TABLE_PARKINGLOT =
            "CREATE TABLE "+ ParkinglotContract.ParkinglotEntry.TABLE_NAME + "("
                    + ParkinglotContract.ParkinglotEntry.COLUMN_NAME_PARKINGLOT_ID + INT_TYPE + " ,"
                    + ParkinglotContract.ParkinglotEntry.COLUMN_NAME_PARKINGLOT_STATE + TEXT_TYPE +  ");";

    public static final String DROP_TABLE_PARKINGLOT =
            "DROP TABLE IF EXISTS "
                    + ParkinglotContract.ParkinglotEntry.TABLE_NAME;


    public DatabaseHelper (Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.d("Database Operations", "Database created...");
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(CREATE_TABLE_PARKINGLOT);

        Log.d("Database Operations", "Table created...");

    }

    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL(DROP_TABLE_PARKINGLOT);

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

}
