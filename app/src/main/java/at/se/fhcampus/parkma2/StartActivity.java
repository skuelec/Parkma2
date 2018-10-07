package at.se.fhcampus.parkma2;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.drawable.AnimationDrawable;
import android.widget.RelativeLayout;

import java.lang.reflect.Array;
import java.util.ArrayList;

import at.se.fhcampus.parkma2.controller.ParkingLotController;
import at.se.fhcampus.parkma2.models.ParkingLot;
import at.se.fhcampus.parkma2.models.User;

public class StartActivity extends AppCompatActivity {

    AnimationDrawable animationDrawable;
    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        //Delete DB
        getApplicationContext().deleteDatabase(DatabaseHelper.DATABASE_NAME);

        DatabaseHelper databaseHelper = DatabaseHelper.getInstance(getApplicationContext());

        SQLiteDatabase db = databaseHelper.getWritableDatabase();

        final ArrayList<ParkingLot> parkingLots = new ArrayList<ParkingLot>();

        relativeLayout = (RelativeLayout)findViewById(R.id.relativeLayout);

        animationDrawable =(AnimationDrawable)relativeLayout.getBackground();
        animationDrawable.setEnterFadeDuration(5000);
        animationDrawable.setExitFadeDuration(2000);

        animationDrawable.start();

        ContentValues values = new ContentValues();

        /**
         * generate the parkinglots
         */
        parkingLots.add(new ParkingLot("1","besetzt"));
        parkingLots.add(new ParkingLot("2","reserviert"));
        parkingLots.add(new ParkingLot("3","frei"));
        parkingLots.add(new ParkingLot("4","frei"));
        parkingLots.add(new ParkingLot("5","frei"));
        parkingLots.add(new ParkingLot("6","frei"));
        parkingLots.add(new ParkingLot("7","frei"));
        parkingLots.add(new ParkingLot("8","frei"));
        parkingLots.add(new ParkingLot("9","frei"));
        parkingLots.add(new ParkingLot("10","frei"));


        /**
         * fill the DB_Parkinglots with the Data in Arraylist
         */
        for (ParkingLot p : parkingLots){

            values.put(ParkinglotContract.ParkinglotEntry.COLUMN_NAME_PARKINGLOT_ID, p.getId());
            values.put(ParkinglotContract.ParkinglotEntry.COLUMN_NAME_PARKINGLOT_STATE, p.getStatus());

            db.insert(ParkinglotContract.ParkinglotEntry.TABLE_NAME,null,values);
        }

        parkingLots.clear();


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                callLogin();
            }
        }, 3000);
    }

    @Override
    protected void onResume(){
        super.onResume();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                callLogin();
            }
        }, 3000);

    }

    private void callLogin(){

        Intent getLoginScreen = new Intent(this, LoginActivity2.class);
        startActivity(getLoginScreen);
    }


}
