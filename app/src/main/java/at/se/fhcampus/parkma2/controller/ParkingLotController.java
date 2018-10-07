package at.se.fhcampus.parkma2.controller;


import android.app.Application;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

import at.se.fhcampus.parkma2.DatabaseHelper;
import at.se.fhcampus.parkma2.ParkinglotContract;
import at.se.fhcampus.parkma2.models.ParkingLot;

public class ParkingLotController{

    private final ArrayList<ParkingLot> parkingLots = new ArrayList<ParkingLot>();

    private final ArrayList<ParkingLot> databseEntries = new ArrayList<ParkingLot>();


    public static ParkingLotController parkingLotController;


//    public ParkingLotController(){
//        populateData();
//    }

    public ParkingLotController(SQLiteDatabase db){
        populateFromDB(db);
    }

    public ArrayList<ParkingLot> getParkingLots() {
        return parkingLots;
    }

    public ArrayList<ParkingLot> getDatabaseEntries() {return databseEntries;}


    private void populateData(){

        parkingLots.add(new ParkingLot("1","frei"));
        parkingLots.add(new ParkingLot("2","frei"));
        parkingLots.add(new ParkingLot("3","frei"));
        parkingLots.add(new ParkingLot("4","besetzt"));
        parkingLots.add(new ParkingLot("5","frei"));
        parkingLots.add(new ParkingLot("6","frei"));
        parkingLots.add(new ParkingLot("7","frei"));
    }



    private void populateFromDB(SQLiteDatabase db){

        String[] projection = {
                ParkinglotContract.ParkinglotEntry.COLUMN_NAME_PARKINGLOT_ID,
                ParkinglotContract.ParkinglotEntry.COLUMN_NAME_PARKINGLOT_STATE,
        };


        Cursor c = db.query(
                ParkinglotContract.ParkinglotEntry.TABLE_NAME,
                projection, null,
                null,
                null,
                null,
                null
        );

        c.moveToFirst();

        while(!c.isAfterLast()){

            ParkingLot parkingLot = new ParkingLot();

            parkingLot.setId(c.getString(c.getColumnIndexOrThrow(ParkinglotContract.ParkinglotEntry.COLUMN_NAME_PARKINGLOT_ID)));
            parkingLot.setStatus(c.getString(c.getColumnIndexOrThrow(ParkinglotContract.ParkinglotEntry.COLUMN_NAME_PARKINGLOT_STATE)));

            databseEntries.add(parkingLot);

            c.moveToNext();
        }
        c.close();
    }

}
